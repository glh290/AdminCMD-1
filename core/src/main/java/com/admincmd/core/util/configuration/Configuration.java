/*
 * This file is part of AdminCMD-Rebirth
 * Copyright (C) 2014 AdminCMD Team
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package com.admincmd.core.util.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.parser.ParserException;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.scanner.ScannerException;

import com.admincmd.core.util.configuration.unicode.UnicodeReader;
import com.admincmd.core.util.configuration.unicode.UnicodeUtil;
import com.admincmd.core.util.exceptions.InvalidConfigurationException;
import com.admincmd.core.util.loggers.ACLogger;
import org.yaml.snakeyaml.constructor.Constructor;

public final class Configuration extends ConfigurationSection {

    protected static final String COMMENT_PREFIX = "#";
    protected static final String BLANK_CONFIG = "{}\n";
    private final DumperOptions yamlOptions = new DumperOptions();
    private final Representer yamlRepresenter = new Representer();
    private final Yaml yaml;
    private Configuration defaults;
    private ConfigurationOptions options;
    private File file;
    private boolean corrupted = false;

    public Configuration() {
        yamlOptions.setIndent(options().indent());
        yamlOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        yamlRepresenter.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        yaml = new Yaml(new Constructor(), yamlRepresenter, yamlOptions);
    }

    public Configuration(final Configuration defaults) {
        this();
        this.defaults = defaults;
    }

    public void addDefault(final String path, final Object value) {
        if (path == null) {
            throw new IllegalArgumentException("Path may not be null");
        }
        if (defaults == null) {
            defaults = new Configuration();
        }
        defaults.set(path, value);
    }

    public void addDefaults(final Configuration defaults) {
        if (defaults == null) {
            throw new IllegalArgumentException("Defaults may not be null");
        }
        addDefaults(defaults.getValues(true));
    }

    public void addDefaults(final Map<String, Object> defaults) {
        if (defaults == null) {
            throw new IllegalArgumentException("Defaults may not be null");
        }
        for (final Map.Entry<String, Object> entry : defaults.entrySet()) {
            addDefault(entry.getKey(), entry.getValue());
        }
    }

    public Configuration getDefaults() {
        return defaults;
    }

    public ConfigurationSection getParent() {
        return null;
    }

    public void setDefaults(final Configuration defaults) {
        if (defaults == null) {
            throw new IllegalArgumentException("Defaults may not be null");
        }
        this.defaults = defaults;
    }

    public void load(final File file) throws FileNotFoundException, IOException,
            InvalidConfigurationException {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        this.file = file;
        try {
            load(new FileInputStream(this.file));
        } catch (final IllegalArgumentException e) {
            ACLogger.severe("Problem with File : " + this.file);
            ACLogger.severe(e.getLocalizedMessage(), e);
        }
    }

    public void load(final InputStream stream) throws IOException, InvalidConfigurationException {
        if (stream == null) {
            throw new IllegalArgumentException("Stream cannot be null");
        }
        final StringBuilder builder = new StringBuilder();
        final BufferedReader input = new BufferedReader(new UnicodeReader(stream, "UTF-8"));
        try {
            String line;
            while ((line = input.readLine()) != null) {
                builder.append(line);
                builder.append('\n');
            }
        } finally {
            input.close();
        }
        loadFromString(builder.toString());
    }

    public void load(final String file) throws FileNotFoundException, IOException,
            InvalidConfigurationException {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        load(new File(file));
    }

    public void save(final File file) throws IOException {
        if (corrupted) {
            return;
        }
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        if ((file.getParentFile() != null) && !file.getParentFile().exists()) {
            file.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        UnicodeUtil.saveUTF8File(file, saveToString(), false);
    }

    public void save(final String file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        save(new File(file));
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Configuration)) {
            return false;
        }
        final Configuration other = (Configuration) obj;
        if (file == null) {
            if (other.file != null) {
                return false;
            }
        } else if (!file.equals(other.file)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((file == null) ? 0 : file.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ExFileConfiguration [file=" + file + "]";
    }

    public static Configuration loadConfiguration(final File file) {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        final Configuration config = new Configuration();
        try {
            config.load(file);
        } catch (final FileNotFoundException ex) {
        } catch (final IOException ex) {
            // Bukkit.getLogger().log(Level.SEVERE, "Cannot load " + file, ex);
        } catch (final InvalidConfigurationException ex) {
			// DebugLog.INSTANCE.log(Level.SEVERE, "Config file " + file + " isn't valid! ",
            // ex.getCause().getCause());
            if (ex.getCause() instanceof YAMLException) {
                ACLogger.severe("Config file " + file + " isn't valid! " + ex.getCause());
            } else if ((ex.getCause() == null) || (ex.getCause() instanceof ClassCastException)) {
                ACLogger.severe("Config file " + file + " isn't valid!");
            } else {
                ACLogger.severe("Cannot load " + file + ": " + ex.getCause().getClass(), ex);
            }
        }
        return config;
    }

    protected String buildHeader() {
        final String header = options().header();
        if (options().copyHeader()) {
            final Configuration def = getDefaults();
            if ((def != null) && (def instanceof Configuration)) {
                final Configuration filedefaults = (Configuration) def;
                final String defaultsHeader = filedefaults.buildHeader();
                if ((defaultsHeader != null) && (defaultsHeader.length() > 0)) {
                    return defaultsHeader;
                }
            }
        }
        if (header == null) {
            return "";
        }
        final StringBuilder builder = new StringBuilder();
        final String[] lines = header.split("\r?\n", -1);
        boolean startedHeader = false;
        for (int i = lines.length - 1; i >= 0; i--) {
            builder.insert(0, "\n");
            if ((startedHeader) || (lines[i].length() != 0)) {
                builder.insert(0, lines[i]);
                builder.insert(0, COMMENT_PREFIX);
                startedHeader = true;
            }
        }
        return builder.toString();
    }

    protected void convertMapsToSections(final Map<Object, Object> input,
            final ConfigurationSection section) {
        for (final Map.Entry<Object, Object> entry : input.entrySet()) {
            final String key = entry.getKey().toString();
            final Object value = entry.getValue();
            if (value instanceof Map<?, ?>) {
                convertMapsToSections((Map<Object, Object>) value, section.createSection(key));
            } else {
                section.set(key, value);
            }
        }
    }

    public void loadFromString(String contents) throws InvalidConfigurationException {
        lock.lock();
        try {
            if (contents == null) {
                throw new IllegalArgumentException("Contents cannot be null");
            }
            Map<Object, Object> input = null;
            contents = contents.replaceAll("\uFFFD", "?").replaceAll("\t", " ");
            try {
                input = (Map<Object, Object>) yaml.load(contents);
            } catch (final ScannerException e) {
                if (e.getContextMark() == null) {
                    ACLogger.severe("File : " + file
                            + "\n You have to correct the error manualy in the file.", e);
                    corrupted = true;
                    return;
                }
                removeLineFromFile(e.getContextMark().getLine());
                ACLogger.info("File : " + file + "\n" + e.toString() + "\nLINE "
                        + (e.getContextMark().getLine() + 1) + " DELETED");
                try {
                    load(file);
                } catch (final FileNotFoundException e1) {
                } catch (final IOException e1) {
                }
            } catch (final ParserException e) {
                ACLogger.severe("File : " + file
                        + "\n You have to correct the error manualy in the file.", e);
                corrupted = true;
                return;
            } catch (final Throwable ex) {
                corrupted = true;
                throw new InvalidConfigurationException(
                        "Specified contents is not a valid Configuration", ex);
            }
            final int size = (input == null) ? 0 : input.size();
            final Map<String, Object> result = new LinkedHashMap<String, Object>(size);
            if (size > 0) {
                for (final Map.Entry<Object, Object> entry : input.entrySet()) {
                    result.put(entry.getKey().toString(), entry.getValue());
                }
            }
            final String header = parseHeader(contents);
            if (header.length() > 0) {
                options().header(header);
            }
            if (input != null) {
                convertMapsToSections(input, this);
            }
            corrupted = false;
        } finally {
            lock.unlock();
        }
    }

    public ConfigurationOptions options() {
        if (options == null) {
            options = new ConfigurationOptions(this);
        }
        return (ConfigurationOptions) options;
    }

    protected String parseHeader(final String input) {
        final String[] lines = input.split("\r?\n", -1);
        final StringBuilder result = new StringBuilder();
        boolean readingHeader = true;
        for (int i = 0; (i < lines.length) && (readingHeader); i++) {
            final String line = lines[i];
            if (line.startsWith(COMMENT_PREFIX)) {
                if (i > 0) {
                    result.append("\n");
                }
                if (line.length() > COMMENT_PREFIX.length()) {
                    result.append(line.substring(COMMENT_PREFIX.length()));
                }
            } else if (line.length() == 0) {
                result.append("\n");
            } else {
                readingHeader = false;
            }
        }
        return result.toString();
    }

    /**
     * Reload the configuration file.
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws InvalidConfigurationException
     */
    public void reload() throws FileNotFoundException, IOException, InvalidConfigurationException {
        load(file);
    }

    private void removeLineFromFile(final int lineToRemove) {
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            final File inFile = file;
            // Construct the new file that will later be renamed to the original filename.
            final File tempFile = File.createTempFile(file.getName(), null);
            br = new BufferedReader(new UnicodeReader(new FileInputStream(file), "UTF-8"));
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(tempFile), "UTF-8"));
            String line = null;
			// Read from the original file and write to the new
            // unless content matches data to be removed.
            int i = 0;
            while ((line = br.readLine()) != null) {
                try {
                    if (i == lineToRemove) {
                        continue;
                    }
                    pw.println(line);
                } finally {
                    i++;
                }
            }
            pw.flush();
            pw.close();
            br.close();
            // Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) {
                System.out.println("Could not rename file");
            }
        } catch (final FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (final IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (final IOException e) {
            }
        }
    }

    public void save() throws IOException {
        save(file);
        // DebugLog.INSTANCE.info("Saving file : " + file);
    }

    public String saveToString() {
        lock.lock();
        String header = "";
        String dump = "";
        try {
            header = buildHeader();
            dump = yaml.dump(getValues(false));
            if (dump.equals(BLANK_CONFIG)) {
                dump = "";
            }
        } finally {
            lock.unlock();
        }
        return header + dump;
    }

}
