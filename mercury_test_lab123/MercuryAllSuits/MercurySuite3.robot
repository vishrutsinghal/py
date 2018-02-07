*** Settings ***
Documentation       Testing MercuryTours Website Suite3
Library             Selenium2Library
Library             BuiltIn
Library             Locators.py
Library             MercurySuite1.robot
# Library             MercurySuite2.robot
Library             MercurySuite3.robot
Resource            Keywords.robot
Resource            Common.robot
Variables           Variables.py
Variables           Elements.py
Force Tags          Suite1

*** Test Cases ***



TestCase1: Booking Flight and then SignOff
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
