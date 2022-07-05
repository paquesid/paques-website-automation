## Installation on Windows

## Guideline
- [Install Git](https://git-scm.com/downloads)
- [Install Java 11.0.14](https://www.oracle.com/java/technologies/downloads/)
- [Install Apache Maven 3.8.5](https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.zip)
- [Install VS-Code](https://code.visualstudio.com/download)

## Prerequisite
- Setup env variable `JAVA_HOME` & `MAVEN_HOME`
- Run from terminal `java --version`
- Run from terminal `mvn --version`

## How to run?
- copy env `cp env/env.sample .env`
- run test `mvn clean verify -Dcucumber.filter.tags="@regression"`