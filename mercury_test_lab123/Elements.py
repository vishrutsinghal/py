__author__ = 'Vishrut Singhal'

#flight booking page
Flight_Xpath = '//a[contains(text(),\'Flights\')]'
Oneway_Xpath = '//input[@value=\'oneway\']'
Passenger_X = '//select[@name=\'passCount\']'
From_X = '//select[@name=\'fromPort\']'
To_X = '//select[@name=\'toPort\']'

#flight authorization page
Class_X = '//input[@type=\'radio\'][@value=\'Business\']'
Continue_X = '//input[@name=\'findFlights\']'
Continue2_X = '//input[@name=\'reserveFlights\']'
Submit2_X = '//input[@name=\'buyFlights\']'

#flight confirmation page
Confirmation_X = '//*[contains(text(),\'itinerary\')]'
BookedNo_X = '//*[contains(text(),\'# 2017\')]'
