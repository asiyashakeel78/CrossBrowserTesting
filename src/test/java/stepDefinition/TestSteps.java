	package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import basePage.BasePage;
import factory.LoginPageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Screenshot;


	public class TestSteps {	
		public WebDriver driver;
		private LoginPageFactory loginPage;
		
	   @Given("user is on the log in page for {string}")
	  	    public void user_is_on_the_log_in_page_for_browser(String browser) {
	        driver = BasePage.getDriver(browser);
	        driver.get("https://practicetestautomation.com/practice-test-login/");
	        loginPage = new LoginPageFactory(driver); // calling constructor
	    }
	    
	    @When("user enters valid username and password")
	    public void user_enters_valid_username_and_password() throws InterruptedException {
	        loginPage.enterUsername("student");
	        loginPage.enterPassword("Password123");
	        Thread.sleep(3000);
	    }
	    
	    @When("user click on the login button")
		    public void user_clicks_on_the_login_button() throws InterruptedException {
	        loginPage.clicklogin();
	        Thread.sleep(3000);
	    }
	    
	    @Then("user is navigated to the dashboard")
	    public void user_is_navigated_to_the_dashboard() {
	        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
	        String actualUrl = loginPage.getUrl();
	        
	        try {
	            Assert.assertEquals(actualUrl, expectedUrl, "User is not on the expected login page URL.");
	        } catch (AssertionError e) {
	            Screenshot.takeScreenshot(driver, "screenshots/failure-screenshot.png");
	            throw e;  // throw to allow Cucumber to handle the failure
	        } finally {
	            driver.quit();
	        }
	    }
	}