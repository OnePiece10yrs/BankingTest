package BankingPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {

	//@Parameters({"myLogin","myPasswd"})
	public static void main(String[] args){
		/*
		String loginUrl = driverUtil.demoUrl;
		WebDriver driver = driverUtil.getDriver();
		
		driver.get(loginUrl);
		
		//login & password
		
		driver.findElement(By.name("uid")).sendKeys("mngr35982");
		driver.findElement(By.name("password")).sendKeys("EjunetA");
		driver.findElement(By.xpath("//input[@name='uid']")).submit();
		*/
		
		startTests();
		
			
		System.exit(0);
	}

@BeforeTest
@Parameters("browser")
public void setBrowser(String browser){
	driverUtil.setBrowser(browser);
}

@Test	
@Parameters({"myLogin","myPasswd"})	
public void verLogin(String myLogin, String myPasswd){
	
	String loginUrl = driverUtil.demoUrl;
	WebDriver driver = driverUtil.getDriver();
	
	driver.get(loginUrl);
	
	driver.findElement(By.name("uid")).sendKeys(myLogin);
	driver.findElement(By.name("password")).sendKeys(myPasswd);
	driver.findElement(By.xpath("//input[@name='uid']")).submit();
	
	startTests();
}

@Parameters({"item","valKey"})	
	static private void startTests(){
		
		WebDriver driver = driverUtil.getDriver();
		
		//new customer			
		driver.findElement(By.linkText("New Customer")).click();
		NewCustomer nc = new NewCustomer();
		nc.AddCusomer();	
		
		//new account
		driver.findElement(By.linkText("New Account")).click();
		NewAccount na = new NewAccount();
		na.newAccount();
	
		//edit account
		/*
		driver.findElement(By.linkText("Edit Account"));
		EditAccount ea = new EditAccount();
		ea.editAccount(item, valKey);
		*/
		
		//customize statement
		driver.findElement(By.linkText("Customised Statement")).click();
		DetailStatement ds = new DetailStatement();
		ds.getStatement();
		
		//balance Enquiry
		driver.findElement(By.linkText("Balance Enquiry")).click();
		BalanceEnquiry balance = new BalanceEnquiry();
		balance.getBalance();
		
	}

@AfterTest
	public void cleanUp(){
		WebDriver driver = driverUtil.getDriver();
		driver.quit();
	}

@AfterSuite
	public void testsEnd(){
		System.exit(0);
	}

}
