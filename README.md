
Preamble:
I started this project by cloning a Serenity tutorial repositery and used it as a base for my Test. Credits to John Ferguson Smart
for creating a starter project with all libraries needed for Serenity and Rest Assured.
I also copied some of the instruction from our current Proteus automated project in this little guide. There were well written
and helpful, it would be sad not to use them


1. How to install and run my little API tests
```
Go to the location of your choice
git clone https://github.com/AntBubu/anthonyTestApi
cd anthonyTestApi
```

* The dependencies are all available in Maven Central or Bintray. By default, Maven will download all dependencies from
Maven Central. **Please note**, on Jenkins, Maven has been configured to download from Bintray as the jdbc4 library is not available
in Maven Central.
* Maven needs to be told to download from Bintray. To do this, locate your settings.xml which is normally located in

```
{YOUR_PATH_TO_MAVEN}/conf/settings.xml
```

Locate the ```<mirrors>``` section in settings.xml and add a new mirror

```
<mirror>
    <id>bintray</id>
    <name>bintray</name>
    <url>http://jcenter.bintray.com</url>
    <mirrorOf>central</mirrorOf>
</mirror>
```

2. Confirm you can retrieve all dependencies by running
```
mvn dependency:resolve
```

