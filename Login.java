package BankingPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	public static void main(String[] args){
		
		String loginUrl = driverUtil.demoUrl;
		WebDriver driver = driverUtil.getDriver();
		
		driver.get(loginUrl);
		
		//login & password
		driver.findElement(By.name("uid")).sendKeys("mylogin");
		driver.findElement(By.name("password")).sendKeys("passwd");
		driver.findElement(By.xpath("//input[@name='uid']")).submit();
		
		startTests();
		
			
		System.exit(0);
	}
	
	static private void startTests(){
		
		WebDriver driver = driverUtil.getDriver();
		
		//new account
				
		driver.findElement(By.linkText("New Customer")).click();
		NewCustomer nc = new NewCustomer();
		nc.AddCusomer();	
		
		//new account
	
		driver.findElement(By.linkText("New Account")).click();
		NewAccount na = new NewAccount();
		na.newAccount();
		
		//customize statement
		driver.findElement(By.linkText("Customised Statement")).click();
		DetailStatement ds = new DetailStatement();
		ds.getStatement();
		
		//balance Enquiry
		driver.findElement(By.linkText("Balance Enquiry")).click();
		BalanceEnquiry balance = new BalanceEnquiry();
		balance.getBalance();
		
	}
}
