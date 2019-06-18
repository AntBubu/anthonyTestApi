
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

Confirm you can retrieve all dependencies by running
```
mvn dependency:resolve
```
Ensure that you have the Intellij Cucumber Plugin

Install the **Cucumber for Java** plugin:

From the top left corner select
```concept
IntelliJ IDEA > Preferences > Plugins > Browse repositories >
Search for "Cucumber for Java" > install and restart
```

2. What you'll find

Under the **/Users/*{your_user_name}*/*{your_location}*/anthonyTestApi/src/test/java** you'll find my stepsDefinitions classes and my runner.

Under the **/Users/*{your_user_name}*/*{your_location}*/anthonyTestApi/src/test/resources** you'll find my features files.

3. Reports

One of the great thing about Serenity is its reporting tool. After you ran the tests via IntelliJ (or something else),
navigate to the following path using your finder **/Users/*{your_user_name}*/*{your_location}*/anthonyTestApi/target/site/serenity/index.html**.
Then double click on it to get a nice HTML report on your browser.
