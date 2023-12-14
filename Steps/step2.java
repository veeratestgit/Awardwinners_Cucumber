package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.AwardWinnersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.TestBase;
import utilities.ExcelUtility;
import utilities.MyListener;
import utilities.RetryAnalyzer;

@Listeners(MyListener.class)
public class AwardWinnersPageTest extends TestBase {
	
	HomePage hp;
	LoginPage lp;
	AwardWinnersPage ap;
	Logger logger = LogManager.getLogger(AwardWinnersPageTest.class);
	
	//public static int RowNum=1;
	@Given("Given I am on the browser")
	public void start_browser()
	{
		OpenBrowser();
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		ap = new AwardWinnersPage(driver);
	}

	
	@Test(dataProvider="LoginDetails", priority=1,retryAnalyzer=RetryAnalyzer.class)
	public void test_login(String email, String password) throws IOException, InterruptedException
	{
		hp.clickLogin();
		lp.user_login(email,password);
		String uname=lp.get_uname();
		
		//Assert.assertEquals(uname, email);
		Assert.assertNotEquals(uname, "My Account");
		//lp.user_logout();
	}
	@When("I click on login link and login with "vijayvel10301@gmail.com" and "group@123"")
	  @DataProvider(name="LoginDetails") public Object[][] datasupplier() throws
	  EncryptedDocumentException, IOException {
	  Object[] [] input = ExcelUtility.getTestData("Sheet2"); 
	  return input;
	  
	  }
	  
     
	 @Then("Then I click on Award winner section and sort books by discount")
	  public void click_AwardWinner() {
		  logger.info("Testing AwardWinners Page Functionality");
		  hp.clickaward();
		  String expectedTitle = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com"; 
      		  String actualTitle = driver.getTitle();
                  Assert.assertEquals(expectedTitle, actualTitle);
                  System.out.println("Title of the page is: "+actualTitle);
		  ap.sortaward();
	  }
	  
	  @And("I click one the first book")
	  public void click_book() throws InterruptedException {
		  ap.buybook();
		  Assert.assertTrue(ap.logo());
	  }
	  @And("I click on cart to see details and buy")
	  public void buy_book() throws InterruptedException {
		  ap.Cart();
	
	  }
	  @Then("I choose the address for delivery")
	  public void address() throws InterruptedException {
		Assert.assertTrue(ap.logoutvisible());
		ap.Save();
		lp.user_logout();
	  }
	  @And("I close the browser")
		public void close_browser()
		{
			driver.close();
		}
		
}
