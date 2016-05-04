package BankingPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailStatement {
	
	public void getStatement(){
		
		System.out.println("\n------Starting Customized statement tests -----");
		try{	
			
			//System.out.println("Curr page: " + dr.getCurrentUrl());
			
			
			//print title
			System.out.println(dr.getTitle());
			//verify account num
			csAccNum();
			
			//verify number of transaction
			csNumTranx();
		}catch(NullPointerException e){
			System.out.println("null value error: " + e.getMessage());
		
		}catch(Exception e){
			System.out.println("error: " + e.getMessage());
		
		}
		System.out.println("------End Customized statement tests -----");
		dr.navigate().back();
	}

	private void csAccNum(){
		
		//empty - TAB
		dr.findElement(By.name("accountno")).sendKeys(Keys.TAB);
		WebElement accNo = dr.findElement(By.name("accountno"));
		
		WebElement msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Account Number must not be blank")){
			System.out.println("CS1 PASS");
		}else{
			System.out.println("CS1 FAIL");
		}
		accNo.clear();
		
		//numeric only
		dr.findElement(By.name("accountno")).sendKeys("1234Acc");		
		msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Characters are not allowed")){
			System.out.println("CS2 PASS: 1234Acc");
		}else{
			System.out.println("CS2 FAIL: 1234Acc");
		}
		accNo.clear();
		
		//numeric only
		dr.findElement(By.name("accountno")).sendKeys("Acc123");		
		msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Characters are not allowed")){
			System.out.println("CS2 PASS: Acc123");
		}else{
			System.out.println("CS2 FAIL: Acc123");
		}
		accNo.clear();

		//special char
		dr.findElement(By.name("accountno")).sendKeys("!@#");		
		msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Special characters are not allowed")){
			System.out.println("CS3 PASS: !@#");
		}else{
			System.out.println("CS3 FAIL: !@#");
		}
		accNo.clear();
		
		//no blank space 
		dr.findElement(By.name("accountno")).sendKeys("123 12");		
		msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Characters are not allowedd")){
			System.out.println("CS4 PASS: 123 12");
		}else{
			System.out.println("CS4 FAIL: 123 12");
		}
		accNo.clear();
		
		//1st char space
		dr.findElement(By.name("accountno")).sendKeys(Keys.SPACE);		
		msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Characters are not allowed")){
			System.out.println("CS5 PASS");
		}else{
			System.out.println("CS5 FAIL");
		}
		accNo.clear();
	
	}
	
	private void csNumTranx(){
		
		//numeric only
		dr.findElement(By.name("numtransaction")).sendKeys("Acc123");
		WebElement numTranx = dr.findElement(By.name("numtransaction"));
		WebElement msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Characters are not allowed")){
			System.out.println("CS12 PASS: Acc123");
		}else{
			System.out.println("CS12 FAIL: Acc123");
		}
		numTranx.clear();

		//special char
		dr.findElement(By.name("numtransaction")).sendKeys("!@#");		
		msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Special characters are not allowed")){
			System.out.println("CS13 PASS: !@#");
		}else{
			System.out.println("CS13 FAIL: !@#");
		}
		numTranx.clear();
		
		//no blank space 
		dr.findElement(By.name("numtransaction")).sendKeys("123 12");		
		msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Characters are not allowedd")){
			System.out.println("CS14 PASS: 123 12");
		}else{
			System.out.println("CS14 FAIL: 123 12");
		}
		numTranx.clear();
		
		//1st char space
		dr.findElement(By.name("numtransaction")).sendKeys(Keys.SPACE);		
		msg = dr.findElement(By.id("message2"));
		if(msg.getText().equalsIgnoreCase("Characters are not allowed")){
			System.out.println("CS15 PASS");
		}else{
			System.out.println("CS15 FAIL");
		}
		numTranx.clear();

		
	}
	WebDriver dr = driverUtil.getDriver();
}
