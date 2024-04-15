## VISUAL TESTING ##

## **Project Description :**

This repository houses a comprehensive automation testing suite for https://todomvc.com/examples/react/dist/ , built using Java,Percy, Maven, and Junit. The suite aims to streamline the testing process by automating repetitive tasks and ensuring the website meet the desired standards.

 ## **Features :**

-**Maven**: Manages project dependencies and facilitates easy project setup and configuration.

-**JUNIT**: Implements JUNIT for efficient test case management and execution.

-**GitHub Actions Workflow**: Incorporates GitHub Actions to automate the build and execution process, ensuring seamless integration into the development workflow.

-**Percy**: Percy is versatile, catering to projects of all sizes and complexities. It seamlessly integrates with popular CI/CD tools, supports various testing frameworks and languages, and provides a side-by-side comparison of changes for easy approval or rejection.

-**Ashot**: AShot is a powerful Java library for taking screenshots in Selenium WebDriver tests. It provides capabilities for capturing full-page screenshots, comparing images, and detecting visual differences between images.

## **Project Structure :**

the project structure is given below:
![Screenshot (40)](https://github.com/12gargi/Visual-Testing/assets/97431292/986d1afb-534c-4e00-b640-05bbe57beebc)


## **Getting Started :**


To get started with the project, follow these steps:


**Clone the Repository:**

git clone:  https://github.com/12gargi/Visual-Testing.git

**Install Dependencies :**  i) npm install @percy/cli,
ii) npm install @percy/selenium-webdriver

**Execute Tests:**           npx percy exec -- mvn clean test -Dtest="appTests.AppTest,tests.CompareImage1,tests.CompareUsingWebDrivers,tests.TestCase,tests.WebElementScreenshot"



