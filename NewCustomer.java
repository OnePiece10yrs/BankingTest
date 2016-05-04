package BankingPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NewCustomer {
	
	WebDriver dr = driverUtil.getDriver();
	public void AddCusomer() {
		
		
		try{
					
			//verify in new account page
			
			System.out.println("\n------Starting New Customer tests -----");
			
			
			//System.out.println("Curr page: " + dr.getCurrentUrl());
			
			
					
			//verify name field		
			ncName();
				
			//verify address field
			ncAddr();
			
			//verify city field
			ncCity();
			
			//verify state field
			ncState();
			
			//verify Pin
			ncPin();
			
			//verify phone field
			ncPhone();
			
			//verify email field
			ncEmail();
			
			//verify all field labels
			ncFieldLbl();
		
		}catch(NoSuchWindowException e){
			System.out.println("NC exception: " + e.getMessage());
			//hasQuit(dr);
		}catch(Exception e){
			System.out.println("NC exception: No such window. Re-check url ");
			//hasQuit(dr);
		}
	
		System.out.println("------End New Customer tests -----");
		dr.navigate().back();
	}
	
	//name field 
	private void ncName(){
		
		//empty name -tab
		//Tab, Return, Enter
		dr.findElement(By.name("name")).sendKeys(Keys.TAB);
		WebElement cusNm = dr.findElement(By.name("name"));
		
		WebElement msg = dr.findElement(By.id("message"));
		if(msg.getText().equalsIgnoreCase("Customer name must not be blank")){
			System.out.println("NC1 PASS");
		}else{
			System.out.println("NC1 Fail");
		}
		cusNm.clear();
		
		//numeric
		dr.findElement(By.name("name")).sendKeys("1234");
		msg = dr.findElement(By.id("message"));
		if(msg.getText().equalsIgnoreCase("Numbers are not allowed")){
			System.out.println("NC2 PASS");
		}else{
			System.out.println("NC2 Fail");
		}
		/*
		if(cusNm.getAttribute("value").matches(".*\\d+.*")){
			System.out.println("name contains numeric char");
		}
		System.out.println("name = " + cusNm.getAttribute("value"));
		*/
		cusNm.clear();
		
		//special char
		dr.findElement(By.name("name")).sendKeys("name!@#!@#");
		msg = dr.findElement(By.id("message"));
		if(msg.getText().equalsIgnoreCase("Special characters are not allowed")){
			System.out.println("NC3 PASS");
		}else{
			System.out.println("NC3 Fail");
		}
		
		cusNm.clear();
		
		//1st char blank
		dr.findElement(By.name("name")).sendKeys(" test");
		msg = dr.findElement(By.id("message"));
		if(msg.getText().equalsIgnoreCase("First character can not have space")){
				System.out.println("NC4 PASS");
		}else{
				System.out.println("NC4 Fail");
		}
				
		cusNm.clear();		
		
	}
	
	//verify address
	private void ncAddr(){
		dr.findElement(By.name("addr")).sendKeys(Keys.TAB);
		WebElement cusAddr = dr.findElement(By.name("addr"));
		
		WebElement msg = dr.findElement(By.id("message3"));
		if(msg.getText().equalsIgnoreCase("ADDRESS cannot be empty")){
			System.out.println("NC5 PASS");
		}else{
			System.out.println("NC5 Fail");
		}
		cusAddr.clear();
		
		//1st char blank space
		dr.findElement(By.name("addr")).sendKeys(" test");	
		msg = dr.findElement(By.id("message3"));
		if(msg.getText().equalsIgnoreCase("First character can not have space")){
			System.out.println("NC6 PASS");
		}else{
			System.out.println("NC6 Fail");
		}
		cusAddr.clear();
	}
	
	//name field 
	private void ncCity(){
			
		//empty name -tab
			//Tab, Return, Enter
		dr.findElement(By.name("city")).sendKeys(Keys.TAB);
		WebElement cusCity = dr.findElement(By.name("city"));
			
		WebElement msg = dr.findElement(By.id("message4"));
		String msgTxt = msg.getText();
		if(msgTxt.equalsIgnoreCase("City Field must not be blank")){
			System.out.println("NC8 PASS");
		}else{
			System.out.println("NC8 Fail");
			System.out.println("msg= " + msgTxt);
		}
		cusCity.clear();
			
		//numeric
		dr.findElement(By.name("city")).sendKeys("1234");
		msg = dr.findElement(By.id("message4"));
		msgTxt = msg.getText();
		if(msgTxt.equalsIgnoreCase("Numbers are not allowed")){
			System.out.println("NC9 PASS");
		}else{
			System.out.println("NC9 Fail");
		}
		cusCity.clear();
			
		//special char
		dr.findElement(By.name("city")).sendKeys("City!@#!@#");
		msg = dr.findElement(By.id("message4"));
		msgTxt = msg.getText();
		if(msgTxt.equalsIgnoreCase("Special characters are not allowed")){
			System.out.println("NC10 PASS");
		}else{
			System.out.println("NC10 Fail");
		}
			
		cusCity.clear();
			
		//1st char blank
		dr.findElement(By.name("city")).sendKeys(" test");
		msg = dr.findElement(By.id("message4"));
		msgTxt = msg.getText();
		if(msgTxt.equalsIgnoreCase("First character can not have space")){
				System.out.println("NC11 PASS");
		}else{
				System.out.println("NC11 Fail");
		}
					
		cusCity.clear();		
			
	}
	
	// verify state field
	private void ncState(){
		//empty - TAB
		dr.findElement(By.name("state")).sendKeys(Keys.TAB);
		WebElement cusPin = dr.findElement(By.name("state"));
			
		WebElement msg = dr.findElement(By.id("message5"));
		if(msg.getText().equalsIgnoreCase("State must not be blank")){
			System.out.println("NC12 PASS");
		}else{
			System.out.println("NC12 Fail");
		}
		cusPin.clear();
		
	}
	
	// verify Pin field
	private void ncPin(){
		//empty - TAB
		dr.findElement(By.name("pinno")).sendKeys(Keys.TAB);
		WebElement cusPin = dr.findElement(By.name("pinno"));
			
		WebElement msg = dr.findElement(By.id("message6"));
		if(msg.getText().equalsIgnoreCase("PIN code must not be blank")){
			System.out.println("NC17 PASS");
		}else{
			System.out.println("NC17 Fail");
		}
		cusPin.clear();
			
	}
	
	// verify phone field
	private void ncPhone(){
		//empty - TAB
		dr.findElement(By.name("telephoneno")).sendKeys(Keys.TAB);
		WebElement cusEmail = dr.findElement(By.name("telephoneno"));
			
		WebElement msg = dr.findElement(By.id("message7"));
		if(msg.getText().equalsIgnoreCase("Mobile no must not be blank")){
			System.out.println("NC22 PASS");
		}else{
			System.out.println("NC22 Fail");
		}
		cusEmail.clear();
		
		dr.findElement(By.name("telephoneno")).sendKeys("123 123");
		msg = dr.findElement(By.id("message7"));
		if(msg.getText().equalsIgnoreCase("Telephone cannot have be space")){
			System.out.println("NC24 PASS");
		}else{
			System.out.println("NC24 Fail");
		}
			
	}
		
	
	// verify Email field
	private void ncEmail(){
		//empty - TAB
		dr.findElement(By.name("emailid")).sendKeys(Keys.TAB);
		WebElement cusEmail = dr.findElement(By.name("emailid"));
			
		WebElement msg = dr.findElement(By.id("message9"));
		if(msg.getText().equalsIgnoreCase("Email-ID must not be blank")){
			System.out.println("NC26 PASS");
		}else{
			System.out.println("NC26 Fail");
		}
		cusEmail.clear();
		
		//incorrect format
		dr.findElement(By.name("emailid")).sendKeys("guru99@gmail");
		
		msg = dr.findElement(By.id("message9"));
		if(msg.getText().equalsIgnoreCase("Email-ID is not valid")){
			System.out.println("NC27 PASS email=guru99@gmail " );
		}else{
			System.out.println("NC27 Fail email=guru99@gmail ");
		}
		cusEmail.clear();
			
		
		dr.findElement(By.name("emailid")).sendKeys("guru99@");
		
		msg = dr.findElement(By.id("message9"));
		if(msg.getText().equalsIgnoreCase("Email-ID is not valid")){
			System.out.println("NC27 PASS email=guru99@ " );
		}else{
			System.out.println("NC27 Fail email=guru99@ ");
		}
		cusEmail.clear();

		dr.findElement(By.name("emailid")).sendKeys("guru99");
		
		msg = dr.findElement(By.id("message9"));
		if(msg.getText().equalsIgnoreCase("Email-ID is not valid")){
			System.out.println("NC27 PASS email=guru99 " );
		}else{
			System.out.println("NC27 Fail email=guru99 ");
		}
		cusEmail.clear();

		dr.findElement(By.name("emailid")).sendKeys("guru99@gmail.");
		
		msg = dr.findElement(By.id("message9"));
		if(msg.getText().equalsIgnoreCase("Email-ID is not valid")){
			System.out.println("NC27 PASS email=guru99@gmail. " );
		}else{
			System.out.println("NC27 Fail email=guru99@gmail. ");
		}
		cusEmail.clear();

		dr.findElement(By.name("emailid")).sendKeys("guru99gmail.com");
		
		msg = dr.findElement(By.id("message9"));
		if(msg.getText().equalsIgnoreCase("Email-ID is not valid")){
			System.out.println("NC27 PASS email=guru99gmail.com " );
		}else{
			System.out.println("NC27 Fail email=guru99gmail.com ");
		}
		cusEmail.clear();

		//no space
		dr.findElement(By.name("emailid")).sendKeys("guru99 gmail");
		
		msg = dr.findElement(By.id("message9"));
		if(msg.getText().equalsIgnoreCase("Email-ID is not valid")){
			System.out.println("NC29 PASS email=guru99 gmail " );
		}else{
			System.out.println("NC29 Fail email=guru99 gmail ");
		}
		cusEmail.clear();
	}
	
	// verify all field labels
	private void ncFieldLbl(){
				
	}
	
	/*
	public static void hasQuit(WebDriver driver){
		if(((RemoteWebDriver) driver).getSessionId() != null)
				driver.close();
		
	}
	*/

}
