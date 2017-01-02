import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.record.formula.functions.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AppleUKOnline {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
				
		BrowserDriver driver1 = new BrowserDriver ();
			
		driver1.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.driver.get("https://qa-appleonline.mpxltd.co.uk");
		driver1.driver.manage().window().maximize();
		System.out.println(driver1.driver.getTitle());
		
		WebDriverWait wait = new WebDriverWait(driver1.driver, 5);
		
		ExcelReader IMEIexcel = new ExcelReader ("D:\\Selenium\\WebDriver\\IMEI.xlsx");
		
		XSSFWorkbook IMEIworkbook = new XSSFWorkbook("D:\\Selenium\\WebDriver\\IMEI.xlsx");
		
		XSSFSheet IMEISheet = IMEIworkbook.getSheet("IOS IMEI");
		
		int rowCount = Math.min(2, IMEISheet.getFirstRowNum())-Math.max(3, IMEISheet.getLastRowNum());
		
		int rowStart = Math.min(2, 2);
	    int rowEnd = Math.max(2, 4);
	   
	    boolean existFromLoop = false;
	    
	    WebDriver driver = new FirefoxDriver ();
	    
		for (int i = rowStart; i <= rowEnd; i++)
		 {	
			    XSSFRow row = IMEISheet.getRow(i);	
			    
			    driver1.driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtIMEIVal")).sendKeys(IMEIexcel. getCellData("IOS IMEI", "IMEI", i));
		 
		        Thread.sleep(1000);	
		        
		        driver1.driver.findElement(By.id("ctl00_ContentPlaceHolder1_imeiValidate")).click();	
		        
		        Thread.sleep(10000);		        
		        
		        //System.out.println(IMEIexcel. getCellData("Sheet1", "IMEI", i)+ "Is not Valied IMEI");//+" "+driver1.driver.getCurrentUrl()
		        
		        //Thread.sleep(10000);
		        
		        if (driver1.driver.getCurrentUrl().equals("https://qa-appleonline.mpxltd.co.uk/"))
		        	{
		        		Thread.sleep(1000);
		        		
		        		
		        		
		        if(driver1.driver.findElement(By.xpath("//*[@id='txtSearchValidation']")) != null)
		        	{
		        		
		        		
		        		//System.out.println("Error On Apple Renew Page");
			        	Thread.sleep(3000);
			        	
			        	System.out.println(IMEIexcel. getCellData("IOS IMEI", "IMEI", i)+ "       " + "Reason :  "+ driver1.driver.findElement(By.id("errorMsg")).getText());
			        	
			        	driver1.driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtIMEIVal")).clear();
			        	 
			        	
		        	 } 
		        }   
		         			else{
		         				System.out.println(IMEIexcel. getCellData("IOS IMEI", "IMEI", i)+ "       Reason :  Is Valied IMEI.");
		         				System.out.println();
		         				//i= rowCount+1;
		         				existFromLoop = true;
		         				break;
		        }		        	  
		     
		}
	   	
		if (!existFromLoop){
			return;
		}
		driver1.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(10000);
		
		//Inspection Page
		
		//driver1.driver.findElement(By.xpath("//h4[contains(text(),Apple)]")) != null
		
		WebElement Color = driver1.driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_errorSpecification']"));
		WebElement Capacity = driver1.driver.findElement(By.xpath("//li[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LiSizeId']"));
				
		if (Color.getText().contains("Please select colour and capacity")){
			
			System.out.println("Insert in If Condition");
			
			driver1.driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_rptModelColor_ctl01_RdBxMasterModelColor']")).click();			
			Thread.sleep(10000);
			driver1.driver.findElement(By.xpath("//li[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LiSizeId']")).click();
			Thread.sleep(10000);
			
		} else  {
			
			System.out.println("Insert in to else condition");
			driver1.driver.findElement(By.xpath("//li[@id='ctl00_ContentPlaceHolder1_rptModelSize_ctl00_LiSizeId']")).click();
			Thread.sleep(10000);
	
		}	
		
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
		
		WebElement ExtraCheckBox = driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-datacard']/div[2]/div/label/span"));
		
				if (ExtraCheckBox.isDisplayed()){
					
					System.out.println("If Condition");
					
					driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-quality']/div[2]/div/label")).click();
					Thread.sleep(2000);
					driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-sim']/div[2]/div/label")).click();
					Thread.sleep(1000);
					driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-datawiped']/div[2]/div/label")).click();
					Thread.sleep(1000);
					driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-fullycharged']/div[2]/div/label")).click();
					Thread.sleep(2000);
					driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-datacard']/div[2]/div/label")).click();	
				}else {
					
					System.out.println("Else Condition");
					driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-quality']/div[2]/div/label")).click();
					Thread.sleep(2000);
					driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-sim']/div[2]/div/label")).click();
					Thread.sleep(1000);
					driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-datawiped']/div[2]/div/label")).click();
					Thread.sleep(1000);
					driver1.driver.findElement(By.xpath("//*[@id='deviceCheck-fullycharged']/div[2]/div/label")).click();
					Thread.sleep(2000);
				
				}
				
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
		Thread.sleep(2000);
		
	
	     }
	}
		 
