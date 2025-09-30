package SushantFramwork.Basic;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import SushantFramwork.Pageobject.LandingPage;
import SushantFramwork.Pageobject.SalesOrderPage;
import SushantFramwork.Pageobject.SendOrdermailPage;

public class SubscritionrenewalMail {
	
	
	@Test
	public void mailSubscription() throws InterruptedException
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		LandingPage landpage=new LandingPage(driver);
		landpage.goTo("https://web.datanova.com/FrolandiaWebERP");
		//landpage.actionclass("1001", "1000");
		SalesOrderPage sales=landpage.actionclass("1001", "1000");
	    sales.applyfilters("04004002");
		SendOrdermailPage sendmail=sales.checkforOrder();
		//=new SendOrdermailPage(driver);
		sendmail.sendOrdermail();
	    
	    
		
		
		List<WebElement> odd = driver.findElements(By.xpath("//*[@id='DNDataGridTable']/tbody/tr"));
		System.out.println(driver.findElements(By.xpath("//*[@id='DNDataGridTable']/tbody/tr")).size());
		for(int i=1;i<=odd.size();i++)
		//for(WebElement rows:odd)
		{
		Actions a=new Actions(driver);
		WebElement ordertot = driver.findElement(By.xpath("//table[@id='DNDataGridTable']/tbody/tr["+i+"]"));
		//WebElement ordertot = driver.findElement(By.xpath("//*[@id='DNDataGridTable']/tbody/tr[" + rows + "]"));
		Thread.sleep(5000);
		a.moveToElement(ordertot).doubleClick().perform();
		a.moveToElement(ordertot).doubleClick().build().perform();
		Thread.sleep(4000);
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(40));
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"order-number\"]")));
		a.moveToElement(driver.findElement(By.cssSelector(".function-context-menu.btn.dnicon_multi-key"))).doubleClick().build().perform();
		driver.findElement(By.xpath("//li[@class='context-menu-item']/span[text()='Send ordrebekreftelse']")).click();
		//driver.findElement(By.id("EmailId")).clear();
		Thread.sleep(2000);
		//driver.findElement(By.id("EmailId")).sendKeys("sushant.kumar@datanova.co.in");
		//driver.findElement(By.id("MobileNumber")).clear();
		driver.findElement(By.id("btnresendMailbutton")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"dnMessageModal\"]/div/div/div[3]/div/section[3]/button")).click();
		Thread.sleep(12000);
	   // driver.findElement(By.xpath("//button[@class=\"btn btn-ok dnm-ok dnm-not-acceptance\" and @style=\"display: block;\"]")).click();
		WebDriverWait b= new WebDriverWait(driver,Duration.ofSeconds(30));
		b.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dnm-text")));
		 driver.findElement(By.xpath("//*[@id=\"dnMessageModal\"]/div/div/div[3]/div/section[2]/button")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"emailresenddiv\"]/div/div/div[3]/button[2]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[@class=\"anchorHeaderLink\" and @data-ajax-success=\"changePartialSuccess('TableViewLi')\" ]")).click();
		Thread.sleep(8000);
		System.out.println(driver.findElement(By.xpath("//*[@id='DNDataGridTable']/tbody/tr["+i +"]/td[4]")).getText());
		
		}
		//}
		System.out.println("Mail to All " +odd.size()+ " orders available on the page are sent successfully");
		Thread.sleep(2000);
		driver.quit();
	}

	

}
