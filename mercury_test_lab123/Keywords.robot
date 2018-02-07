*** Settings ***
Documentation       Testing MercuryTours Website Keywords
Library             Selenium2Library
Library             BuiltIn
Library             Locators.py
Variables           Variables.py
Variables           Elements.py

*** Keywords ***

Click on Sign-On Link
    ${signOn}=  get_SignOn_xpath
    Click Element  xpath=${signOn}
    Log to console  Clicked on Signon link successfully.

Verify SignOn Page title
    ${WindowTitle}=    Get Title
    Should Be Equal  ${WindowTitle}  Sign-on: Mercury Tours
    Log to console  Navigated to :${WindowTitle}

Check if Registration link is available
    ${a}=  get_registerLink_xpath
    ${b}=  Get Element Attribute  xpath=${a}  href
    Log to console  Href attribute found :${b}

Check header is successfully displaying
    ${a}=  get_EnterYourInfo_xpath
    ${b}=  Get Text  ${a}
    Log to console  ${b}

Enter Invalid UserName
    ${a}=  get_Username
    Input Text    ${a}  ${UserName}
    Log to console  Entered wrong username

Enter Invalid Password
    ${a}=  get_Password
    Input Text  ${a}  ${Password}
    Log to console  Entered wrong password

Click on Submit
    ${a}=  get_submit
    Click Element  ${a}
    Log to console  Clicking on Submit

Click on Register link
    ${a}=  get_Register
    Click Element  ${a}
    Log to console  Clicking on Register Link

Verify Registration Page
    ${a}=  RegisterText
    ${b}=  Get Text  ${a}
    ${WindowTitle}=    Get Title
    Should Be Equal  ${WindowTitle}  Register: Mercury Tours
    Log to console  User Navigated to - ${WindowTitle}
    Log to console  ${b}

Provide user details
    ${FirstName}=  FirstName
    ${LastName}=  LastName
    ${phone}=  phone
    ${userID}=  userID
    ${country}=  country
    ${userName}=  userName
    ${password}=  password
    ${confirmPassword}=  confirmPassword
    Input Text          ${FirstName}           ${U_FirstName}
    Input Text          ${LastName}            ${U_LastName}
    Input Text          ${phone}               ${U_phone}
    Input Text          ${userID}              ${U_userID}
    Click Element       ${country}
    Select From List By Label  ${country}      ${U_country}
    Input Text          ${userName}            ${U_userName}
    Input Text          ${password}            ${U_password}
    Input Text          ${confirmPassword}     ${U_confirmPassword}

    Log to console  Entered FirstName
    Log to console  Entered LastName
    Log to console  Entered Phone
    Log to console  Entered userID
    Log to console  Entered Country
    Log to console  Entered UserName
    Log to console  Entered Password
    Log to console  Entered Confirm Password

Click on submit registration
    ${a}=  submit
    Click Element  ${a}
    Log to console  Submitted Registration

Check Post registration page
    ${a}=  post_Regis_ThankYou
    ${b}=  Get Text  ${a}
    log to console  ${b}
    Element Should Contain  ${a}  ${b}

UserID should be created successfully
    ${a}=  post_Regis_userID
    ${b}=  Get Text  ${a}
    log to console  ${b}
    Element Should Contain  ${a}  ${b}

Goto Flight Booking section
    Click Element  ${Flight_Xpath}
    sleep  2s

Check the Booking Page
    ${WindowTitle}=    Get Title
    Should Be Equal  ${WindowTitle}  Find a Flight: Mercury Tours:
    Log to console  Navigated to :${WindowTitle}

Provide user necessary details and continue
    Click Element                       ${Oneway_Xpath}
    Click Element                       ${Passenger_X}
    Select From List By Label           ${Passenger_X}      1
    Click Element                       ${From_X}
    Select From List By Label           ${From_X}      London
    Click Element                       ${To_X}
    Select From List By Label           ${To_X}      Paris
    Click Element                       ${Class_X}
    Click Element                       ${Continue_X}
    sleep                               2s

Select Available flights and continue
    ${WindowTitle}=    Get Title
    Should Be Equal  ${WindowTitle}  Select a Flight: Mercury Tours
    Log to console  Navigated to :${WindowTitle}
    Click Element                       ${Continue2_X}

Provice payment details and secure booking
    ${WindowTitle}=    Get Title
    Should Be Equal  ${WindowTitle}  Book a Flight: Mercury Tours
    Log to console  Navigated to :${WindowTitle}
    Click Element                       ${Submit2_X}

Check confirmation page and booking ID
    sleep                           2s
    ${WindowTitle}=    Get Title
    Should Be Equal  ${WindowTitle}  Flight Confirmation: Mercury Tours
    Log to console  Navigated to :${WindowTitle}
    ${b}=  Get Text  ${Confirmation_X}
    Log to console  Displaying:${b}
    ${c}=  Get Element Attribute  ${BookedNo_X}  innerText
    Log to console  FlightConfirmationNo:${c}
    Log to console  Flight Booked Successfully
