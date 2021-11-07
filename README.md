## **Test project**

#### Goals
Automation project UI, API test

#### Requirements
* `java 1.15`
* `junit 4.11`
* `maven 3.8`

#### Instructions
* `git clone repository`

#### Run tests
On MacOS

``mvn clean test``

#### SETUP:
1. Install ‘Homebrew’ (Package Manager for macOS)
* `Open https://brew.sh`
* `Copy /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"`
* `Paste the link in ‘Terminal’ and execute`
* `Check that 'Homebrew' is installed. Execute brew -version`
2. Install JDK (Java Development Kit) via 'Homebrew'
* `Paste 'brew cask install java’ in ’Terminal’ and execute`
* `If you use macOS Catalina or higher version and have problem with security, execute brew cask reinstall java --no-quarantine`
* `Check that java is installed. Execute java -version`
3. Install Intellij idea
* `Open https://www.jetbrains.com/idea/download/#section=mac`
* `Download ‘Community’ version`
* `Install on your computer`
4. Install Maven via Homebrew brew install maven
* `Verify that Maven was installed mvn -version`