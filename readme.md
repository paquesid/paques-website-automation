![1_lidfLkweF-eawRjil35GQw](https://user-images.githubusercontent.com/103411461/176112983-4e53de97-77f0-437f-80ee-788163c05e14.jpeg)

<br>

## **Purpose**

Dalam proses pengembangan sebuah sistem, terkadang terdapat gap antara technical stakeholders dan business stakeholders terkait dengan:

- Pemahaman technical stakeholders (developer) mengenai kebutuhan bisnis dari sistem yang dibangun, dan
- Pemahaman business stakeholders mengenai isu teknis dari business requirements yang diberikan.

BDD memiliki tujuan utama untuk meningkatkan komunikasi dan kolaborasi antara seluruh stakeholders — tim bisnis maupun teknikal — yang terlibat dalam pengembangan sistem. Hal ini dapat membantu memastikan bahwa:

- Fitur-fitur dalam sistem dapat dipahami dengan baik oleh seluruh anggota tim. Komunikasi yang baik dapat menyatukan persepsi stakeholders yang berbeda-beda dalam suatu pemahaman dan ekspektasi yang sama.
- Fitur-fitur dalam sistem dapat memenuhi kebutuhan pengguna dan menghasilkan business value.

<br>

## **Advantages of Implementing BDD**

- **Meningkatkan komunikasi dan kolaborasi** — BDD memungkinkan keseluruhan stakeholders terlibat dan memiliki pemahaman yang sama dalam pengembangan produk, termasuk non-technical stakeholders yang tidak memahami kode pemrograman.

- **Implementasi sistem yang mengutamakan pengguna dan sesuai dengan kebutuhan bisnis** — BDD dapat meminimalisir terbentuknya fitur yang tidak dibutuhkan, karena implementasi sistem mengacu kepada kebutuhan pengguna dalam skenario yang telah dirumuskan oleh seluruh stakeholders.

- **Test report yang mudah dipahami** — Karena ditampilkan bersesuaian dengan skenario dalam feature files.

- **Dapat beradaptasi dengan cepat terhadap perubahan** — BDD dirancang untuk mendukung agile development, yang kini banyak diterapkan dalam lingkungan bisnis yang cepat berubah. Pendekatan BDD memudahkan tim pengembang untuk merespon perubahan secara cepat dengan meminimalisir time waste dan excessive rework.

<br>

## **Concept**

> **Given** — menjelaskan konteks dari skenario

> **When** — menjelaskan tindakan yang dilakukan oleh user

> **Then** — menjelaskan outcome dari tindakan yang dilakukan oleh user

<br>

![1_Pdur5iTRiaiO_WRc-ppyUQ](https://user-images.githubusercontent.com/103411461/176115403-fae1f25a-4c9b-4fd4-849c-9236062d6b65.png)





<br>
<br>

## Installation on Windows

## Guideline
- [Install Git](https://git-scm.com/downloads)
- [Install Java @11.0.14](https://www.oracle.com/java/technologies/downloads/)
- [Install Apache Maven @3.8.5](https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.zip)
- [Install VSCode](https://code.visualstudio.com/download)

## Prerequisite
- Setup env variable `JAVA_HOME` & `MAVEN_HOME`
- Run from terminal `java --version`
- Run from terminal `mvn --version`
- Copy settings.json below in vscode
```
{
    "java.configuration.updateBuildConfiguration": "interactive",
    "cucumberautocomplete.steps": [
        "src/test/java/stepdefinitions/*.java"
    ],
    "cucumberautocomplete.syncfeatures": "src/test/resources/features/*feature",
    "liveServer.settings.port": 5501
}
```

## How to run?
- copy env `cp env/env.sample .env`
- run test `mvn clean verify -Dcucumber.filter.tags="@regression"`

<br>
<br>

## Project Structure
For your convenient please put the file based on the project structure.

```
├── java
|     └── config                                       
|     │      └── Hooks
|     |
|     └── data                        
|     │      └── PDS Data              
|     │      └── PCC Data
|     │      └── PAMEDI Data
│     │
|     └── elements                          # Store Elements ex: *id*, *css*, *xpath*             
|     │      └── PDS WebElement             # Define PDS Element
|     │      └── PCC WebElement             # Define PCC Element
|     │      └── PAMEDI WebElement          # Define PAMEDI Element
│     │
|     └── helper 
|     │      └── Test Base
|     │      └── Test Instrument
|     │      └── Cucumber Page
|     |
|     └── pages
|     |      └── PDS Page
|     |      └── PCC Page
|     |      └── PAMEDI Page
|     |
|     └── stepDefinitions
|     |      └── PDS Steps
|     |      └── PCC Steps
|     |      └── PAMEDI Steps
|     |
|     └── testRunner
|            └── Cucumber Runner
|
|
|
├── resources
|       └── feature  
|               └── PDS feature file         # Scenario Test PDS
|               └── PCC feature file         # Scenario Test PCC
|               └── PAMEDI feature file      # Scenario Test PAMEDI
```