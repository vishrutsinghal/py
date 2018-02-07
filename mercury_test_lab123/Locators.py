__author__ = 'Vishrut Singhal'

class Locators:
    ROBOT_LIBRARY_SCOPE = 'TEST CASE'

#define page related method here to return xpath or to do user operation

    def get_SignOn_xpath(self):
        xpath = "//*[contains(text(),'SIGN-ON')]"
        return(xpath)

    def get_registerLink_xpath(self):
        xpath = "//*[contains(text(),'registration')]"
        return(xpath)

    def get_EnterYourInfo_xpath(self):
        xpath = "//*[contains(text(),'Enter your user info')]"
        return (xpath)

    def get_UserName(self):
        xpath = "//input[ @ name = 'userName']"
        return (xpath)

    def get_Password(self):
        xpath = "xpath=//input[@name='password']"
        return (xpath)

    def get_submit(self):
        xpath = "//input[ @ name = 'login']"
        return (xpath)

    def get_Register(self):
        xpath = "//*[contains(text(),'REGISTER')]"
        return (xpath)

    def RegisterText(self):
        xpath = "//*[contains(text(),'basic information')]"
        return (xpath)

    def FirstName(self):
        xpath = "//input[@name='firstName']"
        return (xpath)

    def LastName(self):
        xpath = "//input[@name='lastName']"
        return (xpath)

    def phone(self):
        xpath = "//input[@name='phone']"
        return (xpath)

    def userID(self):
        xpath = "//input[@name='userName']"
        return (xpath)

    def country(self):
        xpath = "//select[@name='country']"
        return (xpath)

    def userName(self):
        xpath = "//input[@name='email']"
        return (xpath)

    def password(self):
        xpath = "//input[@name='password']"
        return (xpath)

    def confirmPassword(self):
        xpath = "//input[@name='confirmPassword']"
        return (xpath)

    def submit(self):
        xpath = "//input[@name='register']"
        return (xpath)

    def post_Regis_ThankYou(self):
        xpath = "//*[contains(text(),'Thank you for registering')]"
        return (xpath)

    def post_Regis_userID(self):
        xpath = "//*[contains(text(),'Your user name is')]"
        return (xpath)
