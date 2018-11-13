# DaniilPavlov
HW 2 Mobile TA

*1.	Setup project that has been discussed in the class. Make sure you can run both tests (native and web) successfully.
    
    All tests run properly.

*2.	For existing native mobile autotest try to use another locator (xpath, classname, ?). Define these locators using
Appium Inspector. Are there any difference with id version?
   
    I added following locators for button "Add contact" by xpath and by class name;
    There are some differences in locator's syntaxis and appium search strategies:
    
    ID - Native element identifier.
    Class name - classname version of locator can not unique define item if we have several elements with similar purpose
    XPath - Search the app XML source using xpath, can be longer and difficult than others types of locators.

*3.	Modify existing tests to run on a real device. What should be changed? 

    All tests run properly on real device.
    “deviceName” capability value should be changed to particular real device name.

*4.	Connect a real device to Appium (describe required actions) and run tests. Are there any difference with run on emulator?
    
    Required actions are:
       - Enable developer options in device preferences (by tapping 7 times on "Build Number" option in
         Preferences > About Phone section after that Developer options become visible)
       - Enter Developer options and allow USB debugging
       - Connect device to the PC with adb drivers for device and android sdk installed and configured
       - Start Appium server
       - Change "deviceName" property to particular real device name in Appium session config and in DriverSetup.class caps of our project.
       - Start running tests
       - Allow debugging session on device if needed
       
    It does not seem there is any difference (except some manual preparations for the real device) for running appium
    session on real device.

*5.	What should be improved/changed in existing test code? Why, for what?
    
    1. Thread.sleep() is bad practice for real-life projects. It blocks our application and stop particular
       thread running with pointless computer resources consumption. So, we should use special methods for delay.

    2. We should use asserts for check actions (it helps to catch a error if we do not have expected result).

    3. We should use comments to describe our actions, because it helps to our сolleagues understand our code.

    4. We need to avoid hardcoded values to ensure better flexibility our code and further code maintenance.
    
    5. It is good practice to follow PO pattern (separate test logic from test data).
    
    6. Also it is better to move driver initialization class from scenarios folder to some other project outside the tests scope.
    
    7. We should use relative path than absolute, that will add possibility to run our test on another device.

    8. Use enums or Json for saving nesessary data.

    9. Use separate file for configuration startups with different types of applications (native, web and hybrid) and devices (it can save us from mistake when we will change configuration).


 

