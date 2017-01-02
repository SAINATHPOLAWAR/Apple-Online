import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class IosSerachPage{

	public void iosSearchpage () throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		BrowserDriver driver1 = new BrowserDriver ();
		
		driver1.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.driver.get("https://qa-appleonline.mpxltd.co.uk");
		//driver1.driver.manage().window().maximize();
		System.out.println(driver1.driver.getTitle());
		
		ExcelReader IMEIexcel = new ExcelReader ("D:\\Selenium\\WebDriver\\IMEI.xlsx");
		
		XSSFWorkbook IMEIworkbook = new XSSFWorkbook("D:\\Selenium\\WebDriver\\IMEI.xlsx");
		
		XSSFSheet IMEISheet = IMEIworkbook.getSheet("Sheet1");
		
		int rowCount = Math.min(2, IMEISheet.getFirstRowNum())-Math.max(3, IMEISheet.getLastRowNum());
		
		int rowStart = Math.min(2, 2);
	    int rowEnd = Math.max(2, 4);
	   
	    boolean existFromLoop = false;
		
		Thread.sleep(2000);	
		
		 for (int i = rowStart; i <= rowEnd; i++)
		 {	
			    XSSFRow row = IMEISheet.getRow(i);	
			    
			    driver1.driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtIMEIVal")).sendKeys(IMEIexcel. getCellData("Sheet1", "IMEI", i));
		 
		        Thread.sleep(1000);		       	 
		        driver1.driver.findElement(By.id("ctl00_ContentPlaceHolder1_imeiValidate")).click();		        
		        Thread.sleep(10000);		        
		        
		        //System.out.println(IMEIexcel. getCellData("Sheet1", "IMEI", i)+ "Is not Valied IMEI");//+" "+driver1.driver.getCurrentUrl()
		        
		        Thread.sleep(10000);
		        
		        if (driver1.driver.getCurrentUrl().equals("https://qa-appleonline.mpxltd.co.uk/"))
		        	{
		        		Thread.sleep(1000);
		        		WebElement Validation = driver1.driver.findElement(By.xpath("//*[@id='errorMsg']"));
		        if(driver1.driver.findElement(By.xpath("//*[@id='txtSearchValidation']")) != null)
		        	{
		        		
		        		
		        		System.out.println("Error On Apple Renew Page");
			        	Thread.sleep(3000);
			        	System.out.println(IMEIexcel. getCellData("Sheet1", "IMEI", i)+ "       " + "Reason :  "+ driver1.driver.findElement(By.id("errorMsg")).getText());
			        	//System.out.println(driver1.driver.findElement(By.id("errorMsg")).getText());
			        	driver1.driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtIMEIVal")).clear();
			        	 
			        	 /*
				        	element.sendKeys(IMEIexcel. getCellData("Sheet1", "IMEI", i++));
				        	Thread.sleep(2000);
				        	driver1.driver.findElement(By.id("ctl00_ContentPlaceHolder1_imeiValidate")).click();
				        	Thread.sleep(2000);
				        	System.out.println("end of IF Condition");	*/
		        	 } 
		        }   
		         			else{
		         				System.out.println(IMEIexcel. getCellData("Sheet1", "IMEI", i)+ "     Is Valied IMEI");
		         				System.out.println();
		         				//i= rowCount+1;
		         				existFromLoop = true;
		         				break;
		        }		        	  
		     
		}
	   	
		if (!existFromLoop){
			return;
		}
		//Inspection Page
				/*driver1.driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelColor_ctl01_RdBxMasterModelColor']")).click();			
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
				
				//valuation Page
				driver1.driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_LnkBtnProceed']")).click();
				Thread.sleep(10000);
				
				//Confirm Page
				driver1.driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_CustomerInfo1_EmailAddress']")).sendKeys("sainath@veridic.in");
				Thread.sleep(3000);
				driver1.driver.findElement(By.xpath("//*[@id='CustomerDetails_view']")).click();
				Thread.sleep(5000);
				driver1.driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_CustomerInfo1_txtPassword']")).sendKeys("abo55tivUl");
				Thread.sleep(1000);
				driver1.driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_CustomerInfo1_btnLogin']")).click();
				Thread.sleep(2000);
				driver1.driver.findElement(By.xpath("//*[@id='Envelop']")).click();
				Thread.sleep(2000);
				driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-quality']/div[2]/div/label")).click();
				Thread.sleep(2000);
				driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-sim']/div[2]/div/label")).click();
				Thread.sleep(1000);
				driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-datawiped']/div[2]/div/label")).click();
				Thread.sleep(1000);
				driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-fullycharged']/div[2]/div/label")).click();
				Thread.sleep(1000);
				driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-datacard']/div[2]/div/label")).click();
				Thread.sleep(2000);
				driver1.driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_CustomerInfo1_btnOrderConfirm']")).click();
				Thread.sleep(2000);
				//Term and Conditions
				driver1.driver.findElement(By.xpath("//*[@id='Terms_and_conditions2_dialog']/div[2]/div/div[3]/button[2]")).click();
				Thread.sleep(2000);
				driver1.driver.findElement(By.id("ctl00_ContentPlaceHolder1_Envelope1_lnkGoMyAccount")).click();
				Thread.sleep(5000);
				driver1.driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_OrderTrackingReapeater_ctl02_hypViewOrderDetails']")).click();
				Thread.sleep(2000);
				//SSP
				driver1.driver.findElement(By.xpath("//*[@id='lblOrderHistory']/a/div[2]")).click();
				Thread.sleep(2000);
				driver1.driver.findElement(By.xpath("//*[@id='CancelPopUp']")).click();
				Thread.sleep(2000);
				driver1.driver.findElement(By.xpath("//*[@id='btnDeviceShipped_no']")).click();
				Thread.sleep(2000);
				driver1.driver.findElement(By.xpath("//*[@id='Btn_DeviceShipped_yes']")).click();
				Thread.sleep(2000);*/
		
	}
	

}
