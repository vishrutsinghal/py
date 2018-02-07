*** Settings ***
Documentation       Testing MercuryTours Website
Library             Selenium2Library
Library             BuiltIn

*** Variables ***
${URL}              http://newtours.demoaut.com/
${title}            Welcome: Mercury Tours
${timeout}          3s
${UserName}         Aditya
${Password}         Test123

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

*** Keywords ***
Open Mercury Website in Chrome and Maximize
    Open Browser  url=${URL}  browser=chrome
    Maximize Browser Window
    #Log  Browser is Maximized
    Log to console  Browser is Maximized

Verify the Home page title
    Title Should Be  ${title}
    Log to console  Home Page Title Verified

Click on Sign-On Link
    Click Element  xpath=//*[contains(text(),'SIGN-ON')]
    Log to console  Clicked on Signon link successfully.

Verify SignOn Page title
    ${WindowTitle}=    Get Title
    Should Be Equal  ${WindowTitle}  Sign-on: Mercury Tours
    Log to console  Navigated to :${WindowTitle}

Check if Registration link is available
    ${b}=  Get Element Attribute  xpath=//*[contains(text(),'registration')]  href
    Log to console  Href attribute found :${b}

Check header is successfully displaying
    ${b}=  Get Text  //*[contains(text(),'Enter your user info')]
    Log to console  ${b}

Enter Invalid UserName
    Input Text    //input[ @ name = 'userName']  ${UserName}
    Log to console  Entered wrong username

Enter Invalid Password
    Input Text  //input[@name='password']  ${Password}
    Log to console  Entered wrong password

Click on Submit
    Click Element  //input[ @ name = 'login']
    Log to console  Clicking on Submit
