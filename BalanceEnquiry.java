package BankingPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BalanceEnquiry {

	public void getBalance(){
		
		System.out.println("\n------Starting Balance Enquiry tests -----");
		
		
		//print out page title
		System.out.println(dr.getTitle());
		
		//verify account num
		try{
			WebDriverWait wait = new WebDriverWait(dr, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("accountno")));
			beAccNum();
		}catch(Exception e){
			System.out.println("No element error: " + e.getMessage());
		}
		
		System.out.println("------ End Balance Enquiry tests -----");
		dr.navigate().back();
	}
	
	private void beAccNum(){
		
		//empty - TAB
		dr.findElement(By.name("accountno")).sendKeys(Keys.TAB);
		WebElement accNo = dr.findElement(By.name("accountno"));
		
		WebElement msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Account Number must not be blank")){
			System.out.println("BE1 PASS");
		}else{
			System.out.println("BE1 FAIL");
		}
		accNo.clear();
		
		//numeric only
		dr.findElement(By.name("accountno")).sendKeys("1234Acc");		
		msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Characters are not allowed")){
			System.out.println("BE2 PASS: 1234Acc");
		}else{
			System.out.println("BE2 FAIL: 1234Acc");
		}
		accNo.clear();
		
		//numeric only
		dr.findElement(By.name("accountno")).sendKeys("Acc123");		
		msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Characters are not allowed")){
			System.out.println("BE2 PASS: Acc123");
		}else{
			System.out.println("BE2 FAIL: Acc123");
		}
		accNo.clear();

		//special char
		dr.findElement(By.name("accountno")).sendKeys("!@#");		
		msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Special characters are not allowed")){
			System.out.println("BE3 PASS: !@#");
		}else{
			System.out.println("BE3 FAIL: !@#");
		}
		accNo.clear();
		
	}
	WebDriver dr = driverUtil.getDriver();
}
