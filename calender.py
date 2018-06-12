from selenium.webdriver.support.select import Select
import math

month_dict = {
	"1": "January",
	"2": "Feburary",
	"3": "March",
	"4": "April",
	"5": "May",
	"6": "June",
	"7": "July",
	"8": "August",
	"9": "September",
	"10": "October",
	"11": "November",
	"12": "December"
}

locators = {
	"calender_date" : "//div[contains(@class, 'uiInput')][.//label[contains(@class, 'uiLable')][.//span[text()='{}'][..//div[contains(@class, 'form-element')]]]]//input",
	"select_year" : "slds-select picklist__label",
	"prev_month":	"navLink prevMonth",
	"next_month": "navLink nextMonth",
	"current_month": "monthYear"
}

def calender_input (date_string):
	year, month, date = date_string.split("-")
	print (year, month, date)

	select_year = Select(self.selenium.find_element_by_class_name(locators["select_year"])
	select_year.select_by_visible_text(year)
	get_current_month = self.selenium.find_element_by_class_name(locators["current_month"]).text
	for num, name in month_dict:
		if name == get_current_month:
			month_value = month_dict[num]
			result = month - num
			if result > 0:
				for _ in range(result):
					self.selenium.find_element_by_class_name(locators["nextMonth"]).click()
			elif result < 0:
				for _ in range(abs(result)):
					self.selenium.find_element_by_class_name(locators["prev_month"]).click()
			else:
				self.selenium.find_element_by_class_name(locators["current_month"]).click()
	# dates_rows = self.selenium.find_elements_by_xpath("//*[@id="1290:0"]/div/div[2]/table/tbody")
	# for date_cols in dates_rows:
		date_col = self.selenium.find_elements_by_xpath("//*[@id="5407:0"]/div/div[2]/table/tbody/tr/td")
		for date_cell in date_col:
			if date_cell.text == date:
				date_cell.click()

		


	# if month_dict[month] is get_current_month:
	# 	print ("same")
	# elif month_dict[month] > get_current_month:
	# 	print ("do greater")




calender_input("2018-5-8")
print (locators["select_year"])

# "//div[contains(@class, 'uiInput')][.//label[contains(@class, 'uiLable')][.//span[text()='{}'][..//div[contains(@class, 'form-element')]]]]//input"

