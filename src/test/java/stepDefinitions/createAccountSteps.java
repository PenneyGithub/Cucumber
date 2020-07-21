package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.*;

public class createAccountSteps {
	
	public WebDriver driver;
	public LoginPage log;
	
	@Given("^customer starts JCPenney session$")
	public void customer_starts_JCPenney_session() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver_2.42.exe");
		driver= new ChromeDriver();
		log = new LoginPage(driver);
	}

	@Then("^customer creates new account with \"([^\"]*)\" and \"([^\"]*)\" for checkout$")
	public void customer_creates_new_account_with_and_for_checkout(String arg1, String arg2) throws Throwable {

		driver.get("https://www.jcpenney.com");
		log.accountToolTip.click();
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-automation-id='create_account_button']")));
		
		//login.btnCreateAccount.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@automationid='at-email-input']")));
		log.emailInput.sendKeys(arg1);
	//	logger.info("Enter email");
		log.passwordInput.sendKeys(arg2);
	//	logger.info("Enter password");
		log.btnSign.click();
	//	logger.info("Click on Sign in Button");
		
		
		if(driver.getTitle().toLowerCase().contains("jcpenney")) {
			
			Assert.assertTrue(true);
		//	logger.info("Page title is displayed");
		}
		
		else {
		//	capturescreen(driver, "login");
			Assert.assertTrue(false);
		//	logger.info("Page title not displayed");
		}
		
	}

	@Then("^customer closes the current browser session$")
	public void customer_closes_the_current_browser_session() {
	    
		driver.quit();
	}

}
