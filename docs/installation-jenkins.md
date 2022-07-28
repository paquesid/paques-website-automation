## Installation Jenkins

<br>

## Software requirements
- Java
- Web browser
- OS Linux

<br>

## Jenkins requires Java in order to run

```
sudo apt update
```

```
sudo apt install openjdk-11-jre
```

```
java -version
```

<br>

## Install Jenkins

```
curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo tee \
  /usr/share/keyrings/jenkins-keyring.asc > /dev/null
```

```
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
  https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
```

```
sudo apt-get update
```

```
sudo apt-get install jenkins
```