*** Settings ***
Documentation       Testing MercuryTours Website
Library             Selenium2Library
Library             BuiltIn
Library             Locators.py
Resource            Keywords.robot
Resource            Common.robot
Variables           Variables.py
Variables           Elements.py

*** Test Cases ***
TestCase1: Login Invalid Credentials
    [Documentation]  This is to verify invalid login Mercury Tours Home Page
    [Tags]  smoke
    [Setup]
        Open Mercury Website in Chrome and Maximize
        Verify the Home page title
        Click on Sign-On Link
        Verify SignOn Page title
        Check if Registration link is available
        Check header is successfully displaying
        Enter Invalid UserName
        Enter Invalid Password
        Click on Submit
        sleep  ${timeout}
    [Teardown]  Close Browser

TestCase2: User Registration in Mercury Website
    [Documentation]  This is to verify the Registration flow in Mercury Home Page
    [Tags]  sanity
    [Setup]
        Open Mercury Website in Chrome and Maximize
        Verify the Home page title
        Click on Register link
        Verify Registration Page
        sleep  ${timeout}
        Provide user details
        sleep  ${timeout}
        Click on submit registration
        Check Post registration page
        UserID should be created successfully
     [Teardown]  Close Browser

TestCase3: Booking Flight and then SignOff
    [Documentation]  This is to verify the flight booking flow in Mercury Home Page after Registration
    [Tags]  Regression
    [Setup]
        Open Mercury Website in Chrome and Maximize
        Verify the Home page title
        Click on Register link
        sleep  ${timeout}
        Provide user details
        sleep  ${timeout}
        Click on submit registration
        Goto Flight Booking section
        Check the Booking Page
        Provide user necessary details and continue
        Select Available flights and continue
        Provice payment details and secure booking
        Check confirmation page and booking ID
     [Teardown]  Close Browser
