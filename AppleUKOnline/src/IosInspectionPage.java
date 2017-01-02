import org.openqa.selenium.By;


public class IosInspectionPage {

	public  void InspectionPage() throws InterruptedException {
		// TODO Auto-generated method stub
		
		BrowserDriver driver1 = new BrowserDriver ();
		
		//Inspection Page
		driver1.driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelColor_ctl01_RdBxMasterModelColor']")).click();			
		Thread.sleep(10000);
		driver1.driver.findElement(By.xpath("//li[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LiSizeId']")).click();
		Thread.sleep(10000);				
		driver1.driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl00_yes")).click();
		Thread.sleep(2000);
		driver1.driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl01_yes")).click();
		Thread.sleep(2000);
		driver1.driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl02_yes")).click();
		Thread.sleep(2000);
		driver1.driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl03_yes")).click();
		Thread.sleep(2000);
		driver1.driver.findElement(By.id("ctl00_ContentPlaceHolder1_repCustomerTypeSelection_ctl04_yes")).click();
		Thread.sleep(10000);
		driver1.driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']")).click();
		Thread.sleep(10000);
		
		
		

	}

}
