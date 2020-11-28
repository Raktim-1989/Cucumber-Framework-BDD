package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import junit.framework.Assert;

import com.qa.base.Base;
import com.qa.pageobjects.CustomerConsolePage;
import com.qa.pageobjects.HomePage;
import com.qa.pageobjects.LoginPage;
import com.qa.pageobjects.SecurityVerificationPage;
import com.qa.testutil.TestUtil;

//Note: Creating pageobjects in pageclass and catch that obejct in testclass (TestNG ) /stepdefinitionclass(cucumber) and then call the respective page class methods 
//@RunWith(Cucumber.class)
public class CustomerConsoleStepDefinitions extends Base{
	static SecurityVerificationPage securitypage;
	static LoginPage loginpage;
	static CustomerConsolePage consolepage;
	static HomePage homepage;
	
	@Given("^User is on My HpGas login page$")
    public void user_is_on_my_hpgas_login_page() {
        initialization();
    	securitypage = new SecurityVerificationPage();        
        
    }
	
    @When("^User cracks the security verification successfully$")
    public void user_cracks_the_security_verification_successfully() {
    	  loginpage = securitypage.onSecurityCheck();
    	  String titlelogin = loginpage.onGetTitleLogin();
    	  Assert.assertEquals(titlelogin, "My HPGas | Login");
        
    }

    @Then("^Home page is displayed$")
    public void home_page_is_displayed() {
        String titlehome =	 consolepage.onGetTitleConsole();
        Assert.assertEquals(titlehome, "My HPGas | Customer Console");
    	
    }

    @And("^User login into application with password$")
    public void user_login_into_application_with_password()  {
     consolepage = loginpage.onLoginsuccess();
        
    }

    @And("^Customer console is displayed$")
    public void customer_console_is_displayed() {
        Boolean flag = consolepage.onCustomerNameVerification();
        Assert.assertTrue(flag);
        consolepage.ongetCustomerDetailsVerification();	
    }
    
    @When("^User clicks on the HP Gas logo from the disclaimer$")
    public void user_clicks_on_the_hp_gas_logo_from_the_disclaimer() {
    	 homepage = consolepage.onClickLogoVerification();       
    }
    
    @And("^User closes out the browser successfully$")
    public void user_closes_out_the_browser_successfully() {
    	driver.quit();
        
    }

    @And("^User verifies the distributor details succesfully$")
    public void user_verifies_the_distributor_details_succesfully(){
    
    	String distcode = consolepage.onDistCodeRetrieval();
    	String distname = consolepage.onDistNameRetrieval();
    	String distcontact = consolepage.onDistContctRetrieval();
    	String distaddress = consolepage.onDistAddrssRetrieval();
    	
    	Assert.assertEquals(distcode, TestUtil.code);
    	Assert.assertEquals(distname, TestUtil.name);
    	Assert.assertEquals(distcontact, TestUtil.contact);
    	Assert.assertEquals(distaddress, TestUtil.address);
    	   	
    }

    @And("^User successfully verifies the customer console disclaimer section$")
    public void user_successfully_verifies_the_customer_console_disclaimer_section() {
    	
    	consolepage.onDisclaimerTxtVerification();
    	
             }
    
    @And("^User successfully comes back into the my hp customer console page$")
    public void user_successfully_comes_back_into_the_my_hp_customer_console_page()  {
       consolepage =  consolepage.onBacktoConsole();
    	
    }

    @Then("^User is succcessfully able to navigate into MyHp home page$")
    public void user_is_succcessfully_able_to_navigate_into_myhp_home_page()  {	
    	consolepage.onHomePageWindowVerification();
    	System.out.println("User is successfully able to navigate into MyHp home page");
            }
    
    @And("^User successfully verifies the title of the home page$")
    public void user_successfully_verifies_the_title_of_the_home_page() {
    	String hometitle = consolepage.onGetTitleHome();
    	Assert.assertEquals(hometitle, "My HPGas | Home");
        
    }


    
    
    
    
    
    
    

}