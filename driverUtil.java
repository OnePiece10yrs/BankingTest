package BankingPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverUtil {

	//V1
	//static String ncUrl = "http://demo.guru99.com/V1/html/addcustomerpage.php";
		
	//V2
	//static String demoUrl = "http://demo.guru99.com/V2/";
	
	//V4
	static String demoUrl = "http://demo.guru99.com/V4/";
	//manager
	//http://demo.guru99.com/V4/manager/Managerhomepage.php
	

	static WebDriver driver;
	static String ncUrl; //new customer
	static String naUrl; //new account
	static String csUrl; //customized statement
	static String msUrl; //mini statement
	static String beUrl; //balance enquiry
	
	static void setBrowser(String b){
		if(b.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
			System.out.println("set to firefox");
		}else if(b.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "c:\\Program Files\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("set to chrome");
		}
	}
	
	static WebDriver getDriver(){
		return driver;
	}
	
	//all get/set urls for future concurrency process
	static String getNcUrl(){
		return ncUrl;
	}
	
	static void setNcUrl(String nclink){
		ncUrl = nclink;
	}
	
	static void setNaUrl(String nalink){
		naUrl = nalink;
	}
	
	static String getNaUrl(){
		return naUrl;
	}
	
	static void setCsUrl(String cslink){
		csUrl = cslink;
	}
	
	static String getCsUrl(){
		return csUrl;
	}

	static void setBeUrl(String beLink){
		beUrl = beLink;
	}
	
	static String getBeUrl(){
		return beUrl;
	}
}
