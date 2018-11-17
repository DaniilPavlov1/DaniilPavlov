# DaniilPavlov
HW 4 Mobile TA

   1.	Add support of appPackage and appActivity parameters for Android devices
   (reading from a .properties file and then setting in the    DesiredCapabilities). Locally
   installed Appium DT has no need in these parameters, but for Appium server of Minsk Mobile Farm it’s mandatory.

    Done, corresponding fields and its initializations are added.

   a.	Or try to use autoLaunch capability with app as before. Does this approach work?

    No, this approach doesn’t work. Server returns the following error: {
    The desired capabilities must include either an app, appPackage or browserName
    }

   2.	Change settings to run web test on a certain iOS device on Mobile Test Farm. Run test with your changes. Did test pass?

    Settings were changed. Tests passed.

   3.	Change settings to run native test on a certain/random Android device on Mobile Test Farm. Run test with your changes. Did test pass?

    Test passed.

  4.	What’s wrong with our code? How to fix/improve it? Implement your suggestions.

    1. We should store our properties as objects in .json format.
       This decision granted for us easily reuse predefined configs for test devices.

    2. We should make our tests be prepared for CI (Jenkins) so I've made testng .xml configs
       for running our tests by Maven by CMD, examples of commands:
       {
        for native tests:
        mvn clean test -DsuiteXmlFile=/appium/spb_farm_android_nexus5s_native.xml

        for web tests:
        mvn clean test -DsuiteXmlFile=/appium/spb_farm_android_nexus5s_web.xml
    }

    3. We should replace (where possible) all hardcoded values to Enums or constants.

