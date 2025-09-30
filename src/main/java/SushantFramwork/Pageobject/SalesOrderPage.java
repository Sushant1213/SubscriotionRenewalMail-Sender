package SushantFramwork.Pageobject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderPage {
WebDriver driver;
	public SalesOrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='7-1']/span[2]")
	WebElement openPanel;
	
	@FindBy(xpath="//*[@id='DNDataGridTable']/thead/tr[2]/th[4]/input")
	WebElement Sendorderfilter;
	
	@FindBy(xpath="//*[@id='DNDataGridTable']/thead/tr[2]/th[7]/input")
	WebElement ordersold;
	
	@FindBy(xpath="//*[@id='DNDataGridTable']/thead/tr[2]/th[8]/input")
	WebElement orderbetal;
	
	
	@FindBy(xpath="//*[@id='DNDataGridTable']/thead/tr[2]/th[11]/input")
	WebElement mailfiter;
	
	
	@FindBy(xpath="//*[@id='DNDataGridTable']/thead/tr[2]/th[13]/input")
	WebElement datesend;
	
	@FindBy(xpath="//th[(@class='column IsText dt-body-center text-left sorting' and @data-displayname='Ordrenummer')]")
	WebElement arrangeOrder;
	
	@FindBy(xpath="//tr[@role='row' and (@class='odd' or @class='even')]")
	List<WebElement> orderCheck;
	
	//driver.findElement(By.xpath("//*[@id='7-1']/span[2]")).click();
	//driver.findElement(By.xpath("//*[@id=\"DNDataGridTable\"]/thead/tr[2]/th[4]/input")).sendKeys("04004002");
	
	//driver.findElement(By.xpath("//*[@id=\"DNDataGridTable\"]/thead/tr[2]/th[7]/input")).sendKeys("Solgt");
	// changes made by sushant for not getting the failed order loaded
	
	// Search by transactionstatus                  
	//driver.findElement(By.xpath("//*[@id=\"DNDataGridTable\"]/thead/tr[2]/th[8]/input")).sendKeys("Betalt");
	//driver.findElement(By.xpath("//*[@id=\"DNDataGridTable\"]/thead/tr[2]/th[11]/input")).sendKeys("@");
	//driver.findElement(By.xpath("//*[@id=\"DNDataGridTable\"]/thead/tr[2]/th[13]/input")).sendKeys(dateFormat);
	String dateFormat = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());

	public void applyfilters(String orderid) throws InterruptedException
	
	{
		openPanel.click();
		Sendorderfilter.sendKeys(orderid);
		Thread.sleep(2000);
		ordersold.sendKeys("Solgt");
		Thread.sleep(2000);
		orderbetal.sendKeys("Betalt");
		mailfiter.sendKeys("@");
		Thread.sleep(2000);
		datesend.sendKeys(dateFormat);
		arrangeOrder.click();
		Thread.sleep(4000);
		
	}
	
	public SendOrdermailPage checkforOrder()
	{
		if (orderCheck.size() == 0)
		{
		   System.out.println("No orders present for the current date :"+dateFormat);
		    driver.close();
		    
		 }
		return new SendOrdermailPage(driver);
		
	}

}
