package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.MyAccount;
import pageObjects.UserRegistration;
import pageObjects.YourStore;
import resources.Base;
import utilities.DataProviderUtility;

public class RegistrationTest extends Base {

	public WebDriver driver;
	public Properties prop;
	YourStore yourStorePage;
	UserRegistration registration;
	
	@BeforeMethod
	public void getDriverInstance() {
		driver = getDriverObject();
		prop = getPropertiesObject();
		yourStorePage=new YourStore(driver);
		
	}
	
	@Test(dataProvider="data")
	public void doUserRegistration(String fname, String lname, String email, String phone, String pwd, String conPwd) throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		registration=yourStorePage.clickOnMyAccount().clickOnRegister();
		registration.getFirstName().sendKeys(fname);
		registration.getlastName().sendKeys(lname);
		registration.getEmail().sendKeys(email);
		registration.getTelephone().sendKeys(phone);
		registration.getPassword().sendKeys(pwd);
		registration.getConfirmPassword().sendKeys(conPwd);
		registration.getPrivacyBtn().click();
		Thread.sleep(5000);
		registration.clickOnContinue();
		String s=driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]")).getText();
		//Assert.assertEquals(s,"Your Account Has Been Created!");
		//Thread.sleep(5000);
	}
	
	@AfterMethod
	public void closure() {
		driver.close();
	}
	
	@DataProvider(name="data")
	public Object[][] testData()
	{
		return DataProviderUtility.provideData("userRegistration");
	}
	
	
}
