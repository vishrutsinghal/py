*** Settings ***
Documentation       Testing MercuryTours Website Suite1
Library             Selenium2Library
Library             BuiltIn
Library             Locators.py
Library             MercurySuite1.robot
Library             MercurySuite2.robot
Library             MercurySuite3.robot
Resource            Keywords.robot
Resource            Common.robot
Variables           Variables.py
Variables           Elements.py
Force Tags          Suite1

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


