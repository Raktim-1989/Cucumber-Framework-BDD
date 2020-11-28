package stepdefinitions;

import com.qa.base.Base;
import com.qa.pageobjects.CustomerConsolePage;
import com.qa.pageobjects.MechanicServicePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class MechanicServiceStepDefinitions extends Base {
	
	public MechanicServicePage mechanicpage;
	public CustomerConsolePage consolepage;
	
    @When("^User clicks on the mechanic service link$")
    public void user_clicks_on_the_mechanic_service_link() {
    	
    	 //mechanicpage = new MechanicServicePage();
    	mechanicpage = consolepage.onClickMechanicLink();     
    }

    @Then("^User navigates into mechanic service page$")
    public void user_navigates_into_mechanic_service_page()  {
        Boolean flag  = mechanicpage.onMechanicLinkVerification();
        Assert.assertTrue(flag);
    }

    @And("^User verifies the mechanic service link to raise a request$")
    public void user_verifies_the_mechanic_service_link_to_raise_a_request() {
        consolepage = new CustomerConsolePage();
    	Boolean flag = consolepage.onMechanicLinkVerification();
         Assert.assertTrue(flag);
    	
    }

    @And("^User verifies the title of the mechanic service page$")
    public void user_verifies_the_title_of_the_mechanic_service_page()  {
      String title =   mechanicpage.onGetTitleMechanicServiceVerification();
      Assert.assertEquals(title, "My HPGas | Mechanic Service");
    	
    }

    @And("^User successfully comes back into the Customer Console page by switching the window$")
    public void user_successfully_comes_back_into_the_customer_console_page_by_switching_the_window() 
    {
        mechanicpage.onGetBackToConsoleVerification(); 	
    	
    }

	
	
	
	

}
