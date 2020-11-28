$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CustomerConsole.feature");
formatter.feature({
  "line": 1,
  "name": "My Hp Customer Console",
  "description": "",
  "id": "my-hp-customer-console",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Home Page default login validation",
  "description": "",
  "id": "my-hp-customer-console;home-page-default-login-validation",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User is on My HpGas login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User cracks the security verification successfully",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User login into application with password",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Home page is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Customer console is displayed",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User closes out the browser successfully",
  "keyword": "And "
});
formatter.match({
  "location": "CustomerConsoleStepDefinitions.user_is_on_my_hpgas_login_page()"
});
