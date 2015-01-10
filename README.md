![Logo](http://img401.imageshack.us/img401/6918/admincmdlogobig.png)

Unleash the power of Sponge!

Informations
------------
* Blog : http://www.admincmd.com
* Wiki : http://wiki.admincmd.com
* Issues: http://bug.admincmd.com
* License : [GPLv2](https://www.gnu.org/licenses/gpl-2.0.html)

Description
------------
AdminCMD is a powerful plug-in that brings you commands that give you total control over your server. 
Now we decided to remake it completely for the new [Sponge API](https://www.spongepowered.org).
Featuring the most widely used commands in server management such as: inventory management, 
banishment of bad players, limitation to teleporting, setting spawn and home way points, and much, much more! 
Blockface approved and rated as one of the best plug-in by server owners.

This project is using [Gradle](http://www.gradle.org)

Developer Informations
------------
Every developer of the AdminCMD team is able to create branches and merge it into master. Once the development of a feature has started, the developer creates a new branch named after the feature. Once a feature is finished, the branch becomes merged to the master branch to prevent commit conflicts.
Everybody who is not from the developer team, can make pull requests to the main branch and we will review them and maybe merge them.

To clone: 

```
git clone https://github.com/AdminCMD/AdminCMD-Rebirth.git
```

To create a new branch, go to [Github](https://github.com/AdminCMD/AdminCMD-Rebirth), click on branch master and create a new branch.


To switch to a branch
````
git pull origin BRANCHNAME
git checkout BRANCHNAME
````

To merge the master branch to a branch:
```
git pull origin master
git checkout BRANCHNAME
git merge master
```

To merge a branch to the master branch:
```
git pull origin master
git checkout master
git merge BRANCHNAME
```

Commit  Structure
------------
If you make a commit, use the tags below in your commit. For example:
```
[MOD] Change the way how players get stored in the database
```

So always prefix your commit message with one of these tags:

1. [MOD] : You have modified something in the existing code
2. [ADD] : You've added something new to the code
3. [FIX] : Fixed a problem/bug
4. [OPTIMIZATION] : Some optimization done in the code
5. [DEV] : Something only related to development
6. [DEBUG] : Related to help the debugging.
7. [IGNORE] : Related to the .gitignore file

If you have already commited something, but want to add another commit, 
just type ```git commit -amend```
BUT: Only use this if you did not push already. If you pushed already, you need to make a new commit.

Developers
------------
* [Belphemur](https://github.com/Belphemur/)
* [TheJeterLP](https://github.com/TheJeterLP/)
* [BossLetsPlays](https://github.com/BossLetsPlays/)
* [Jkmalan](https://github.com/jkmalan/)

Thanks to
------------
* The whole [RedThirdDivision](http://redthirddivision.com) for helping us out!
* [Lathanael](https://github.com/Lathanael) for helping so much out on the Bukkit version!

Used IDEs
------------
* [NetBeans](https://netbeans.org) (used by TheJeterLP)
  * [Gradle Plugin](http://plugins.netbeans.org/plugin/44510/gradle-support)
* [IntelliJ](https://www.jetbrains.com/idea/) (used by Belphemur)
  * Build-in Gradle support
* [Eclipse](https://eclipse.org) (used by BossLetsPlays and Jkmalan)
  * [Gradle Plugin](http://marketplace.eclipse.org/content/gradle-integration-eclipse-44)


