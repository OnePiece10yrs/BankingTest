package BankingPkg;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

public class NewAccount {

	WebDriver dr = driverUtil.getDriver();
	
	public void newAccount(){
		
		System.out.println("\n------Starting New Account tests -----");
		
		try{
		
		//System.out.println("curr url = " + dr.getCurrentUrl());
		System.out.println(dr.getTitle());
		//verify Customer id
		
		try{
			WebDriverWait wait = new WebDriverWait(dr, 10);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("cusid")));
			na_CusId();
		}catch(Exception e){
			System.out.println("still fail to find userid");
		}
		
		
		//verify initial deposit
		na_iniDeposit();
		
		}catch(NullPointerException e){
			System.out.println("null value error: " + e.getMessage());
			
		}catch(Exception e){
			System.out.println("error: " + e.getMessage());
			
		}
		System.out.println("------End New Account tests -----");
		dr.navigate().back();
	}
	
	private void na_CusId(){
		
		
		
		//empty - TAB
		dr.findElement(By.name("cusid")).sendKeys(Keys.TAB);
		WebElement cusId = dr.findElement(By.name("cusid"));
		
		WebElement msg = dr.findElement(By.id("message14"));
		if(msg.getText().equalsIgnoreCase("Customer ID is required")){
			System.out.println("NA1 PASS");
		}else{
			System.out.println("NA1 FAIL");
		}
		cusId.clear();
		
		//numeric only
		dr.findElement(By.name("cusid")).sendKeys("1234Acc");		
		msg = dr.findElement(By.id("message14"));
		if(msg.getText().equalsIgnoreCase("Characters are not allowed")){
			System.out.println("NA2 PASS: 1234Acc");
		}else{
			System.out.println("NA2 FAIL: 1234Acc");
		}
		cusId.clear();
		
		//numeric only
		dr.findElement(By.name("cusid")).sendKeys("Acc123");		
		msg = dr.findElement(By.id("message14"));
		if(msg.getText().equalsIgnoreCase("Characters are not allowed")){
			System.out.println("NA2 PASS: Acc123");
		}else{
			System.out.println("NA2 FAIL: Acc123");
		}
		cusId.clear();

		//special char
		dr.findElement(By.name("cusid")).sendKeys("!@#");		
		msg = dr.findElement(By.id("message14"));
		if(msg.getText().equalsIgnoreCase("Special characters are not allowed")){
			System.out.println("NA3 PASS: !@#");
		}else{
			System.out.println("NA3 FAIL: !@#");
		}
		cusId.clear();
		
		//no space
		dr.findElement(By.name("cusid")).sendKeys(Keys.SPACE);		
		msg = dr.findElement(By.id("message14"));
		if(msg.getText().equalsIgnoreCase("First character cannot have space")){
			System.out.println("NA5 PASS");
		}else{
			System.out.println("NA5 FAIL");
		}
		cusId.clear();
		
		
	}
	
	private void na_iniDeposit(){
	
		//empty - TAB
		dr.findElement(By.name("inideposit")).sendKeys(Keys.TAB);
		WebElement deposit = dr.findElement(By.name("inideposit"));
		
		WebElement msg = dr.findElement(By.id("message19"));
		if(msg.getText().equalsIgnoreCase("Initial Deposit must not be blank")){
			System.out.println("NA6 PASS");
		}else{
			System.out.println("NA6 FAIL");
		}
		deposit.clear();
		
		//numeric only
		dr.findElement(By.name("inideposit")).sendKeys("1234Acc");		
		msg = dr.findElement(By.id("message19"));
		if(msg.getText().equalsIgnoreCase("Characters are not allowed")){
			System.out.println("NA7 PASS: 1234Acc");
		}else{
			System.out.println("NA7 FAIL: 1234Acc");
		}
		deposit.clear();
		
		//numeric only
		dr.findElement(By.name("inideposit")).sendKeys("Acc123");		
		msg = dr.findElement(By.id("message19"));
		if(msg.getText().equalsIgnoreCase("Characters are not allowed")){
			System.out.println("NA7 PASS: Acc123");
		}else{
			System.out.println("NA7 FAIL: Acc123");
		}
		deposit.clear();

		//special char
		dr.findElement(By.name("inideposit")).sendKeys("!@#");		
		msg = dr.findElement(By.id("message19"));
		if(msg.getText().equalsIgnoreCase("Special characters are not allowed")){
			System.out.println("NA8 PASS: !@#");
		}else{
			System.out.println("NA8 FAIL: !@#");
		}
		deposit.clear();
		
		//no space at all
		dr.findElement(By.name("inideposit")).sendKeys("123 12");		
		msg = dr.findElement(By.id("message19"));
		if(msg.getText().equalsIgnoreCase("Special characters are not allowed")){
			System.out.println("NA9 PASS: 123 12");
		}else{
			System.out.println("NA9 FAIL: 123 12");
		}
		deposit.clear();
		
			
		//no space
		dr.findElement(By.name("inideposit")).sendKeys(Keys.SPACE);		
		msg = dr.findElement(By.id("message19"));
		if(msg.getText().equalsIgnoreCase("First character cannot have space")){
			System.out.println("NA10 PASS");
		}else{
			System.out.println("NA10 FAIL");
		}
		deposit.clear();

	}
}
