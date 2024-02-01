# Search Automation Project

Automate Google and Yahoo search pages using Selenium WebDriver, Java, and Cucumber.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
  - [Running Automated Search Tests](#running-Automated-Search-Tests)
  - [Running Specific Tests Using Cucumber Tags](#running-Specific-Tests-Using-Cucumber-Tags)
  - [List of Tags](#list-of-tags)
  - [Running All Test Cases in Parallel](#running-all-test-cases-in-parallel)
  - [Generating and Retrieving Test Reports](#generating-and-retrieving-test-reports)
- [Troubleshooting](#troubleshooting)
  - [No Visible Action during Test Execution](#no-visible-action-during-test-execution)
  - 
- [Dependencies and Plugins](#dependencies-and-plugins)
- [Configuration](#configuration)
- [License](#license)

## Project Overview

This project utilizes Selenium WebDriver in Java to automate searches on Google and Yahoo search pages. It is designed to demonstrate how to perform automated browser interactions using a BDD (Behavior-Driven Development) approach with Cucumber.

## Features

- Automated Google search
- Automated Yahoo search
- BDD test scenarios with Cucumber
- Easy-to-understand project structure

## Getting Started

Follow these steps to set up the project locally:

1. **Open a Command Prompt or Git Bash:**

   You can use the default Command Prompt on Windows or Git Bash if you have it installed. You can find Git Bash in the Start menu after installing Git.
      
2. **Navigate to the Directory Where You Want to Clone the Project:**

   Use the cd command to navigate to the directory where you want to clone the Git project. For example:
   ```bash
   cd path\to\desired\directory
3. **Clone the Repository:**

   Use the git clone command to clone the repository.
   ```bash
    git clone https://github.com/sabinasattarova/SearchEngineDemo.git
    cd search-automation
4. **Navigate to the Cloned Project Directory:**
   ```bash
   cd project-directory
   
## Usage
### Running Automated Search Tests
1. **To run the automated search tests, use the following Maven command:**
   ```bash
   mvn test
   
### Running Specific Tests Using Cucumber Tags
2. **To run certain test script or one US at a time use tags in CukesRunner.java in the tags = " " option**

### List of Tags
| User Story | User Story Tag | Test Scenarios  |
|------------| --------------- | ---------------- |
| US01       | @us01          | @ts01, @ts02     |
| US02       | @us02          | @ts03, @ts04     |
| US03       | @us03          | @ts05, @ts06     |
 
        
 Example command to run tests for US01:

        mvn test -Dcucumber.filter.tags="@us01"

### Running All Test Cases in Parallel
3. **For running all test cases in parallel, follow these steps:**

![img.png](img.png)
- Click on the Maven logo (M) on the right corner of your IDE.
- Unfold the "SearchEngine" tab.
- Double-click on the "test" goal.

4. **Alternatively, you can run tests in parallel through the CukesRunner.java class.**


### Generating and Retrieving Test Reports
Test reports can be generated after running the tests. To access the reports:

- After running tests, navigate to the `target` directory.
- Locate the cucumber-reports folder.
- Locate the cucumber-report named `(cucumber-report.html)` and open in a web browser to view the results.
- The report provides detailed information about test execution, including scenarios passed, failed, screenshots of 
  failed tests, total number of passed and failed, OS, JDK version, duration of execution time, last ran time.

![img_2.png](img_2.png)


## Troubleshooting

If you encounter issues while running the tests, consider the following troubleshooting tips:

### Common Error Messages
**No Visible Action during Test Execution**

If your tests are running, but you don't see any action happening, check the following features:

- **Dry Run Setting:**
    - If `dryRun` is set to `true` in your Cucumber configuration, no actual browser interaction occurs. Make sure it is set to `false` for real test execution.

- **Headless Chrome Setting:**
    - If you have specified `headless-chrome` in the `configuration.properties` file, try changing it to `"chrome"`, `"firefox"` for a visible browser window.

Example:
```properties
    # configuration.properties
    browser=chrome
    # or
    browser=firefox
```

### Known Issues





## Dependencies and Plugins

### Dependencies

| Library            | Author          | Version |
| ------------------ | --------------- | ------- |
| WebDriverManager   | Bonigarcia       | 5.5.3   |
| Selenium-Java      | Selenium        | 4.17.0  |
| Cucumber-JUnit     | Cucumber        | 7.3.2   |
| Cucumber-Java      | Cucumber        | 7.3.2   |

### Plugins

| Plugin                | Author                  | Version       |
| --------------------  | ----------------------- | ------------- |
| Reporting Plugin      | Cucumber                | 7.3.0         |
| Maven Surefire Plugin  | Apache Maven Plugins    | 3.0.0-M5      |



## Configuration

**The primary configuration is managed through the `configuration.properties` file.** This file contains key-value pairs 
that 
control various aspects of the project. Users can locate and modify this file to adjust settings.


| Setting       | Value                      | Comment                                                                   |
|---------------| -------------------------- |---------------------------------------------------------------------------|
| browser       | chrome                     | Specifies the browser for Selenium WebDriver.                             |
| environment   | qa1                        | Defines the environment to be tested.                                     |
| google        | [https://www.google.com/](https://www.google.com/)  | URL for the Google search page.                                           |
| yahoo         | [https://www.yahoo.com/](https://www.yahoo.com/)    | URL for the Yahoo search page.                                            |
| searchEngine | google                     | Configures the default search engine for US01 and US02 (google or yahoo). |






