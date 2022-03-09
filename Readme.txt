Product List Automation

Case Study: Product List Automation

Problem Statement: 

Automate Search functionality and validate total benches of Online shopping Website. 

Display the different types of Furniture.
Validate the industrial benches.
Suggested site: pepperfry.com, however you are free to choose any other legitimate shopping site.

Detailed Description: 

⦁	Launch any browser as per the user input ex: Chrome/Firefox.
⦁	Open the online shopping website ex: https://www.pepperfry.com/.
⦁	Validate the text “Online Furniture Shopping Store” in the title.
⦁	Select “Furniture” and click on “Benches”.
⦁	Display the total benches with respect to its category and count.
⦁	Check whether “Industrial Benches” are more than one.
⦁	Close the browser.

Key Automation Scope:

⦁	Handling multiple browsers Chrome/Firefox
⦁	Using appropriate synchronization technique
⦁	Locating elements precisely
⦁	Exception handling
⦁	Handling dropdown list



Changes In Description:
⦁	in Step < Select “Furniture” and click on “Benches”.
	> In live website Benches option is not in the Furniture 	submenu. 
	Actual order is Furniture -> Seatings -> Benches 
  

Other Notes :-

1. This miniproject can execute TestCases on diffrent browsers

⦁	Steps to configure test execution for diferent browsers:

1. Check if there is Browser executable(web driver file) is in drivers folder.if not paste webdriver of the respective browser with special care of installed version of browser in your computer.

2. Change the name of the browser  variable in 	config.properties file  Located into the resources 	folder.
