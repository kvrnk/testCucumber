$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/feature/personal");
formatter.feature({
  "name": "Personal Test",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@all"
    }
  ]
});
formatter.scenario({
  "name": "role of admin",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@all"
    }
  ]
});
formatter.step({
  "name": "Login page under administrator rights",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.login_page_under_administrator_rights()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "We check the form and add the user",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.we_check_the_form_and_add_the_user()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"id\",\"selector\":\"btnAdd\"}\n  (Session info: chrome\u003d71.0.3578.98)\n  (Driver info: chromedriver\u003d2.45.615291 (ec3682e3c9061c10f26ea9e5cdcf3c53f3f74387),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 287 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.0.1\u0027, revision: \u00271969d75\u0027, time: \u00272016-10-18 09:49:13 -0700\u0027\nSystem info: host: \u0027DESKTOP-LAURGUS\u0027, ip: \u0027192.168.100.4\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_171\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, timeouts\u003d{implicit\u003d0, pageLoad\u003d300000, script\u003d30000}, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:30173}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003dignore, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.45.615291 (ec3682e3c9061c10f26ea9e5cdcf3c53f3f74387), userDataDir\u003dC:\\Users\\veron\\AppData\\Local\\Temp\\scoped_dir11908_31362}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, strictFileInteractability\u003dfalse, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d71.0.3578.98, browserConnectionEnabled\u003dfalse, proxy\u003d{}, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 7cbb37220f3a6ca9ddc7e6b9891da055\n*** Element info: {Using\u003did, value\u003dbtnAdd}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:216)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:168)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:635)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:368)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:417)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:218)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:360)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy15.click(Unknown Source)\r\n\tat pages.UserManagementPage.clickButtonAdd(UserManagementPage.java:81)\r\n\tat pages.UserManagementPage.toFormAddUser(UserManagementPage.java:88)\r\n\tat steps.Steps.we_check_the_form_and_add_the_user(Steps.java:67)\r\n\tat ✽.We check the form and add the user(src/test/feature/personal:6)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Delete 3 Job Titles",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.delete_Job_Titles(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Add candidate",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.add_candidate()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Check Dashboard",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.check_Dashboard()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Check personal details of any sales",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.check_personal_details_of_any_sales()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Logged off from the page",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.logged_off_from_the_page()"
});
formatter.result({
  "status": "skipped"
});
});