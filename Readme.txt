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

⦁ Steps to configure test execution for diferent browsers:

1. Check if there is Browser executable(web driver file) is in drivers folder.if not paste webdriver of the respective browser with special care of installed version of browser in your computer.

2. Change the name of the browser  variable in 	config.properties file  Located into the resources folder.
			1. firefox = Mozila firefox
			2. edge    = Microsoft Edge
			3. chrome  = Google Chrome browser

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Class and Methods Definitions 

Class DriverSetup
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
WebDriver driverSetup()            desc:  Read browser name from and config.properties file and create a static 'driver' instant of the WebDriver type.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Class WriteOutputFile
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
static  void   write()                    desc:  shift the printstream to the Output.txt file 
static void    writeOnConsole()           desc:  Shift the printstream to the console.
static  void   printOutputTxtfile()       desc:  Print all content of the Output file on console 
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Class ReadPropertiesFile
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Properties readPropertiesFile()    desc: Return properties object after reading properties file Located in resources/config.properties
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Class ScreenShot
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
static void takeFullScreenShot (Webdriver , String )  desc: Take full window screenshot and store it into the Screenshots folder with name passed in as string concatination withthe timestamp at the end
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


Class BenchesPage
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void driverSetup()              desc: create a static 'driver' instant of the WebDriver type.
void closeBrowser()             desc: close browser kill driver instant.
void openUrl(String)            desc: open url according to the name which is mapped in the properties file 
void validateTitle(String)      desc: verify title of the dom tha contain particular String which passed into the function print pass and fail accordingly.
void hoverOnFurniture()         desc:  hover on the furniture 
void hoverOnSeating()           desc:  hover on the Seating 
void clickOnBenches()           desc:  click on the benches option
void veirfyBenchesPage()        desc:   verify benches page by valdating subtitle benches in the DOM
void displayBenchesCategory()   desc:  print all dispaly category of the benches asvailable on console.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


Class IndustrialBenchesTest  
-extends BenchesPage
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void verifyCountIdustrailBenches()   desc: this method verify where industrial benches is more than one.
- also contain a main method that can be used to execute test case.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
