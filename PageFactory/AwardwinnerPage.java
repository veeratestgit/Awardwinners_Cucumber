package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Awardwinnerpage {
	public static WebDriver driver=null;
	@FindBy(xpath="//input[@id='ctl00_cpBody_ShoppingCart_lvCart_savecontinue']")
	WebElement save;
	@FindBy(xpath="//input[@id=\"ctl00_cpBody_lvCustomerAdd_ctrl0_btnUseAddress\"]")
	WebElement Address;
	
		@FindBy(xpath="//div[@id='listpromoproduct']/div[1]/div/a/img")
		WebElement book;
		
		@FindBy(xpath="//div[@id='ctl00_phBody_ProductDetail_divAddtoCart']/input")
		WebElement buy;
		
		@FindBy(xpath="//span[@class='itemcount']/label[@id='ctl00_lblTotalCartItems']")
		WebElement cart;
		
		@FindBy(xpath="//input[@value='Buy']")
		WebElement buy1;
		
		@FindBy(xpath="//input[@id='ctl00_phBody_SignIn_txtEmail']")
		WebElement email_box;
		
		@FindBy(xpath="//input[@id='ctl00_phBody_SignIn_txtPassword']")
		WebElement password_box;
		
		@FindBy(xpath="//a[@id='ctl00_phBody_SignIn_btnLogin']")
		WebElement button;
		
		@FindBy(xpath="//li[@id='ctl00_liAW']/a")
		WebElement award;
		
		@FindBy(xpath="//select[@id='ddlSort']")
		WebElement sort;
		
		@FindBy(xpath="//select[@id='ddlSort']/option[4]")
		WebElement Discount;
		
		
		
		public Awardwinnerpage(WebDriver driver) {
			this.driver=driver;	
			PageFactory.initElements(driver,this);
		}
		public void	navigate(String url) {
			driver.get(url);
		}
		
		public void	clickaward() throws InterruptedException {
				Thread.sleep(1500);
				award.click();
			}
			public void sortaward() throws InterruptedException {
				Thread.sleep(3000);
				sort.click();
				Discount.click();
			}
	
		public void selectbook() throws InterruptedException
		{
			Thread.sleep(3000);
			book.click();
			buy.click();
		}
		public void cart() throws InterruptedException {
			Thread.sleep(1500);
			cart.click();
		}
		public void buybook() throws InterruptedException {
			Thread.sleep(1500);
			buy1.click();	
		}
		public void LoginDetails(String email,String password) throws InterruptedException {
			Thread.sleep(5000);
			email_box.sendKeys(email);
			password_box.sendKeys(password);
			button.click();
		}
		public void save() throws InterruptedException {
			Thread.sleep(1500);
			Address.click();
			Thread.sleep(1500);
			save.click();	
		}
		public boolean loggedInSuccessfully() { 
		    WebElement welcomeMessage = driver.findElement(By.xpath("//a[@id='ctl00_lnkbtnLogout']"));
		    return welcomeMessage.isDisplayed();
		}

}
