package com.admincmd.core.util.configuration.file;

import com.admincmd.core.util.configuration.Configuration;
import com.admincmd.core.util.configuration.InvalidConfigurationException;
import com.admincmd.core.util.configuration.MemoryConfiguration;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public abstract class FileConfiguration extends MemoryConfiguration {
    
    public FileConfiguration() {
        super();
    }

    public FileConfiguration(Configuration defaults) {
        super(defaults);
    }

    public void save(File file) throws IOException {
        file.mkdirs();

        String data = saveToString();

        Writer writer = new OutputStreamWriter(new FileOutputStream(file), Charset.defaultCharset());

        try {
            writer.write(data);
        } finally {
            writer.close();
        }
    }

    public void save(String file) throws IOException {
        save(new File(file));
    }

    public abstract String saveToString();

    public void load(File file) throws FileNotFoundException, IOException, InvalidConfigurationException {
        final FileInputStream stream = new FileInputStream(file);

        load(new InputStreamReader(stream, Charset.defaultCharset()));
    }

    public void load(Reader reader) throws IOException, InvalidConfigurationException {
        BufferedReader input = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);

        StringBuilder builder = new StringBuilder();

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
    public void load(String file) throws FileNotFoundException, IOException, InvalidConfigurationException {
        load(new File(file));
    }

    public abstract void loadFromString(String contents) throws InvalidConfigurationException;

    protected abstract String buildHeader();

    @Override
    public FileConfigurationOptions options() {
        if (options == null) {
            options = new FileConfigurationOptions(this);
        }

        return (FileConfigurationOptions) options;
    }
}