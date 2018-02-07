*** Settings ***
Documentation       Testing MercuryTours Website Suite2
Library             Selenium2Library
Library             BuiltIn
Library             Locators.py
Resource            Keywords.robot
Resource            Common.robot
Variables           Variables.py
Variables           Elements.py
Force Tags          Suite1

*** Test Cases ***


TestCase1: User Registration in Mercury Website
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


