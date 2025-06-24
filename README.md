# Automation: API & UI Testing Final Project

[cite_start]**Project Submission Deadline**: July 4th

## Project Goal
[cite_start]This project requires students to complete a hands-on automation project that combines API testing and UI testing.

### Components:
* [cite_start]**API Testing**: Using REST-assured with `https://jsonplaceholder.typicode.com`
* [cite_start]**UI Testing**: Using Selenium, Cucumber, and Gherkin with `https://www.saucedemo.com`
* [cite_start]**Test Execution**: All tests must be run via IntelliJ IDEA.
* [cite_start]**Scenario Definition**: Write readable test scenarios using Gherkin syntax.
* [cite_start]**Results Analysis**: Analyze test results via the console or simple result logs.

## Project Structure

### 1) API Testing (REST-assured)
* [cite_start]**Source**: `https://jsonplaceholder.typicode.com`
* [cite_start]**Goal**: Implement test cases for endpoints using GET, POST, PUT, and DELETE.

#### Tasks:
* [cite_start]Test `GET /posts` and verify the status code is 200 and the response contains at least 100 posts.
* [cite_start]Test `GET /posts/1` and verify that `userId` equals 1.
* [cite_start]Test `POST /posts` and verify status code 201 and the correct response body.
* [cite_start]Test `PUT /posts/1` and confirm that the `title` field is updated.
* [cite_start]Test `DELETE /posts/1` and ensure the status code is 200 or 204.
* [cite_start]Write at least 5 test cases using JUnit or TestNG.
* [cite_start]Use proper assertions to validate status codes and JSON fields.

### 2) UI Testing (Selenium + Cucumber + Gherkin)
* [cite_start]**Source**: `https://www.saucedemo.com`
* [cite_start]**Goal**: Test login functionality, adding items to the cart, and logout.

#### Tasks:
[cite_start]Use Selenium WebDriver to automate the following:
* [cite_start]Successful login with valid credentials (`standard_user` / `secret_sauce`)
* [cite_start]Failed login and error message validation
* [cite_start]Add product to cart
* [cite_start]Verify product appears in cart
* [cite_start]Logout functionality
* [cite_start]Follow Cucumber and Gherkin syntax for scenario definitions.
* [cite_start]Create `.feature` files for each functionality (e.g., `login.feature`, `cart.feature`).
* [cite_start]Maintain Page Object Model structure and reusable classes.

**Example Feature File**:
```gherkin
Feature: Login Functionality
  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid username and password
    Then User should be redirected to the products page