package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.*;
import org.junit.Assert;
import pagefactory.Awardwinnerpage;

public class awardsteps {
	WebDriver driver;
	Awardwinnerpage Ap;
	
	@Given("I navigate to the bookswagon website")
	public void i_navigate_to_the_bookswagon_website()  throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\INDIA\\eclipse-workspace\\Tours\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        Ap=new Awardwinnerpage(driver);
        Ap.navigate("https://www.bookswagon.com/");  
	}

	@When("I click on the award link")
	public void i_click_on_the_award_link() throws InterruptedException  {
	  Ap.clickaward();
	  String expectedTitle = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com"; 
      String actualTitle = driver.getTitle();
      Assert.assertEquals(expectedTitle, actualTitle);
      System.out.println("Title of the page is: "+actualTitle);
	}

	@And("I sort books by discount")
	public void i_sort_books_by_discount() throws InterruptedException {
	    
			Ap.sortaward();
	}

	@And("I click on first book to buy")
	public void i_click_on_first_book_to_buy() throws InterruptedException {
			Ap.selectbook();
	}
	@Then("I click on cart to see details")
	public void i_click_on_cart_to_see_details() throws InterruptedException {
		Ap.cart();
	}
	@And("I click on buy")
	public void i_click_on_buy() throws InterruptedException {
	    Ap.buybook();
	}
	@Then("I login with {string} and {string}")
	public void i_Login(String email,String password) throws InterruptedException {
		Ap.LoginDetails(email,password);
		Assert.assertTrue(Ap.loggedInSuccessfully());
	}
	@And("I click on address save and continue")
	public void I_click_on_address_save_and_continue() throws InterruptedException {
		Ap.save();
	}
	
}
