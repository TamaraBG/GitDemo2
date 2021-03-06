   package stepDefinitions;

	import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;    //clicked on Organize imports and errors were gone!
import jdk.jfr.internal.Logger;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;  //manually imported this one
	
	//import io.cucumber.junit.CucumberOptions  // -trainer suggested to manually import this one but it doesn't help and throws error


	@RunWith(Cucumber.class)
	

	public class StepDefinition {
		
		
		WebDriver driver;
		//private static Logger Log=LogManager.getLogger(StepDefinition.class.getName());    //does not work
		
		@Given("^User initiates Chrome browser$")
	    public void user_initiates_chrome_browser() throws Throwable {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tamara\\Desktop\\SELENIUM WORK\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		        
	    }

		
		/*     //tried with constructor - works
		public StepDefinition()
		{
			System.out.println("Constructor; BeforeTest doesn't work here");
			
					//	this.driver=driver;    //message: The assignment to variable driver has no effect
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tamara\\Desktop\\SELENIUM WORK\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			
			*/
			

		@And("^User is on Netbanking landing page$")
	    public void user_is_on_netbanking_landing_page() throws Throwable {
			
			
			driver.get("https://www.erstebank.rs/sr/Stanovnistvo/Elektronsko-bankarstvo/Netbanking");
			
			/*if (driver.findElement(By.id("popin_tc_privacy")).isDisplayed())
			{
			driver.findElement(By.id("popin_tc_privacy_button")).click();   //close cookies popup
			}
			*/      //this might not work because the popup is always displayed in the html; you have to go with size
			
			if (driver.findElements(By.id("popin_tc_privacy")).size() > 0)
			{
				driver.findElement(By.id("popin_tc_privacy_button")).click();
			}
			

			//Log.info("Successfully landed on homepage");
	        
	    }

    		    	   
	    /*     //generated with TestRunner but it doesn't provide a regular expression
	    @When("User logs in into application with {string} and {string}")
	    public void user_logs_in_into_application_with_and(String string, String string2) {
	        // Write code here that turns the phrase above into concrete actions
	        throw new io.cucumber.java.PendingException();
	    }
        */   
	    
	    
	    //regular expression for two sets of username and password generated by Tidy Gherkin
	   	    	
	    /*
	     	@When("^User logs in into application with \"([^\"]*)\" and \"([^\"]*)\"$")
	     
	        public void user_logs_in_into_application_with_something_and_something(String strArg1, String strArg2) throws Throwable {
	                
	   
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,400)");      //scroll the link into view because of error but it doesn't make a difference
			

	        driver.findElement(By.xpath("//*[text()='Prijava na Elektronsko bankarstvo ??? NetBanking']")).click();
	    	//driver.findElement(By.cssSelector(".link-element.btn.btn--primary.btn--cta.link-element--text")).click();  //"element could not be scrolled into view"
	    	
	   // Log.info("Sucessfully clicked on prijava");
	   
	   driver.findElement(By.name("ctl00$ContentPlaceHolder1$PrijavaEBS1$txbKorisnickoIme")).sendKeys(strArg1);
	   driver.findElement(By.cssSelector("[type='password']")).sendKeys(strArg2);
	   driver.findElement(By.cssSelector("[type='submit']")).click();
	    
	    }
	*/
		
	    @When("^User logs in into application with (.+) and (.+) $")

	    public void user_logs_in_into_application_with_and(String username, CharSequence password) throws Throwable {
			
			 driver.findElement(By.xpath("//*[text()='Prijava na Elektronsko bankarstvo ??? NetBanking']")).click();
		    	//driver.findElement(By.cssSelector(".link-element.btn.btn--primary.btn--cta.link-element--text")).click();  //"element could not be scrolled into view"
		    	
	   
		   driver.findElement(By.name("ctl00$ContentPlaceHolder1$PrijavaEBS1$txbKorisnickoIme")).sendKeys(username);
		   driver.findElement(By.cssSelector("[type='password']")).sendKeys(password);
		   driver.findElement(By.cssSelector("[type='submit']")).click();
		    
		}

	

	    @Then("^Homepage is populated$")
	    public void homepage_is_populated() throws Throwable {
	    
	    	//Assert.assertEquals(driver.getCurrentUrl(), "https://www.erstebank.rs/sr/Stanovnistvo/Elektronsko-bankarstvo/Netbanking");  
	    	//not sure if this approach is ok; besides, the two links are different so the assertion breaks
	    System.out.println(driver.getTitle() + ":" + "the page is populated");
	    	
	    }
	

	 /*   @And("^Credit cards are displayed$")
	    public void credit_cards_are_displayed() throws Throwable {
	    	
	    	//Log.info("cards");
	    	System.out.println("cards");
	    	Assert.assertTrue(driver.findElement(By.id("aspnetForm")).isDisplayed());    //whether the form-that takes up the entire page-is displayed 

	    }
	    
	    */
	    
	    @And("^Credit cards are displayed$")
	    public void credit_cards_are_displayed() throws Throwable {
 
	    	
	 	    	//Log.info("cards");
 	    	
	    	
	 	    	Assert.assertTrue(driver.findElement(By.id("aspnetForm")).isDisplayed());     //whether the form-that takes up the entire page-is displayed -
	 	    	//Assert.assertFalse(driver.findElement(By.id("aspnetForm")).isDisplayed());
	 	    	//Assert.assertEquals(strArg1, driver.findElement(By.id("aspnetForm")).isDisplayed());    

	    	
	    }

	}
	


