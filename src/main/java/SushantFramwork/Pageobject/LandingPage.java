package SushantFramwork.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="UserIdEntry")
	WebElement userid;
	
	@FindBy(id="PasswordEntry")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginbtn;
	
	@FindBy(id="btnconcurrentuserlogin")
	WebElement validationClick;
	
	@FindBy(id="txtFilterMenu")
	WebElement textfilter;
	
	@FindBy(id="myInput")
	WebElement input;
	
	@FindBy(xpath="//div[@for='400']")
	WebElement shopselect;
	
	@FindBy(id="btnLoginWithshop")
	WebElement filalLogin;
	
	
	
	
	
	public SalesOrderPage actionclass(String user,String pass) 
	{
		userid.sendKeys(user);
		password.sendKeys(pass);
		loginbtn.click();
		try {
			validationClick.click();	
			textfilter.sendKeys("salgsordre");
	        }
		
		catch(Exception v)
		{
			input.sendKeys("400");
			shopselect.click();
			filalLogin.click();
			//driver.findElement(By.id("btnLoginWithprofile")).click();
			textfilter.sendKeys("salgsordre");
			
		}
		return new SalesOrderPage(driver);
			
	}
	
	
	public void goTo (String url)
	{
		driver.get(url);
		
	}
	

}
