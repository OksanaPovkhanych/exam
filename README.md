# Steps for opening project

Inside this project Test Project with selenium tests that checking google search.

To run the test install following tools:
- Install JDK by the link https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html.
- Download https://www.jetbrains.com/idea/ and install Intellij IDEA.
- Download https://chromedriver.storage.googleapis.com/index.html?path=2.46/ and copy file to the directory C:\Windows\System32
- Import project to the Intellij IDEA.

To run the project via command line go to the directory where pom.xml is situated and run following command to run all search tests "mvn test -Dtest=GoogleSearchTests" or "mvn test -DsuiteXmlFile=search-tests.xml" to run selected tests.

