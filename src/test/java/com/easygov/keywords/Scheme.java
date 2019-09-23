package com.easygov.keywords;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.easygov.automation.getpageobjects.GetPage;

import cucumber.api.DataTable;

public class Scheme extends GetPage {
	WebElement edit;
	WebElement edit1;
	WebElement edit2;
	WebElement edit3;
	String story = "Tell us your story";
	String congrats ="Congratulations! You are Eligible for";

	public Scheme(WebDriver driver) {
		super(driver, "Scheme");
	}

	public List<WebElement> listOfLang() {
		List<WebElement> langname = elements("langlist");
		return langname;
	}
	
	public List<WebElement> listOfState() {
		List<WebElement> statename = elements("statelist");
		return statename;
	}
	
	public List<WebElement> listOfDistrict() {
		List<WebElement> districtname = elements("districtlist");
		return districtname;
	}
	
	public List<WebElement> listOfScheme() {
		List<WebElement> schemename = elements("schemelist");
		return schemename;
	}
	
	public List<WebElement> listOfCategory() {
		List<WebElement> categoryname = elements("categorylist");
		return categoryname;
	}
	
	public List<WebElement> listOfEligibility() {
		List<WebElement> elbbtn = elements("eligibilitylist");
		return elbbtn;
	}
	
	public List<WebElement> listOfGender() {
		List<WebElement> gender = elements("genderlist");
		return gender;
	}
	
	public List<WebElement> listOfDomicile() {
		List<WebElement> domicile = elements("domicilelist");
		return domicile;
	}
	
	public List<WebElement> listOfreason() {
		List<WebElement> abled = elements("reasonlist");
		return abled;
	}
	
	public List<WebElement> listOfabled() {
		List<WebElement> abled = elements("abled");
		return abled;
	}
	
	
	public String getStoryMessage() {
		return element("story").getText();
	}
	
	public boolean verifyUserStartSurvey() {
		hardWait(3);
		return getStoryMessage().contains(story);
	}
	
	public String getCongratsMessage() {
		return element("congrats").getText();
	}
	
	public boolean verifyCongratsMessage() {
		hardWait(3);
     return getCongratsMessage().contains(congrats);
		
	}
	
	
	public boolean verifyLangExists(String lang) {

		boolean status = false;
		for (WebElement we : listOfLang()) {
			if (we.getText().contains(lang)) {
				status = true;
				edit = we;
				break;
				
			}
		}
		return status;
	}
	
	public boolean verifyStateExists(String state) {

		boolean status = false;
		for (WebElement we : listOfState()) {
			if (we.getText().contains(state)) {
				status = true;
				edit1 = we;
				break;
				
			}
		}
		return status;
	}
	
	
	public void selectLang(){
		edit.click();
	}
	
	public void selectState(){
		edit1.click();
	}
	
	public boolean verifyDistrictExists(String district) {

		boolean status = false;
		for (WebElement we : listOfDistrict()) {
			if (we.getText().contains(district)) {
				status = true;
				edit2 = we;
				break;
				
			}
		}
		return status;
	}
	
	public void selectDistrict(){
		edit2.click();
	}
	
	public boolean verifyCategoryExists(String category) {

		boolean status = false;
		for (WebElement we : listOfCategory()) {
			if (we.getText().contains(category)) {
				status = true;
				edit3 = we;
				break;
				
			}
		}
		return status;
	}
	
	public void selectCategory(){
		edit3.click();
	}
	
	public void browsescheme() {
		hardWait(2);
		element("browsescheme").click();
	}
	
	public boolean verifySchemeExists(String schemename) throws InterruptedException {

		hardWait(1);
		boolean status = false;

		for (int i = 0; i < listOfScheme().size(); i++) {
			if (listOfScheme().get(i).getText().contains(schemename)) {
				listOfEligibility().get(i).click();
				status = true;
				break;
			}
		}
		return status;
	}
	
	public void enterCredentials(String contact, String password) {
		hardWait(2);
		element("phonnmbr").sendKeys(contact);
		element("password").sendKeys(password);
		element("signinbtn").click();
	}
	
	public void applyForMyself() {
		element("myself").click();
		element("nextbtn").click();
	}
	
	public boolean selectGender(String gender) {
        element("q1").click();
		boolean status = false;
		for (WebElement we : listOfGender()) {
			if (we.getText().contains(gender)) {
				status = true;
				edit3 = we;
				edit3.click();
				break;
				
			}
		}
		return status;
	}
	
	public void selectDOB(String dob) {
		hardWait(1);
WebElement name=driver.findElement(By.id("295"));
//((JavascriptExecutor)driver).executeAsyncScript("arguments[0].value='8/18/1992'",name); 
JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
myExecutor.executeScript("arguments[0].value='8/18/1992';", name);
	}
	
	public boolean selectDomicile(String domicile) {
		element("q3").click();
		boolean status = false;
		for (WebElement we : listOfDomicile()) {
			if (we.getText().contains(domicile)) {
				status = true;
				edit3 = we;
				edit3.click();
				hardWait(1);
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				//WebElement name1=driver.findElement(By.xpath(".//*[@id='714Menu']/div/div[2]/span"));
				//((JavascriptExecutor)driver)
			    //  .executeScript("arguments[0].click();", name1);
				break;	
			}
		}
		return status;
	}
	
	public boolean selectAbled(String abled) {
		WebElement name1=driver.findElement(By.xpath(".//*[@id='714Menu']/div/div[2]/span"));
         name1.click();
	   
		
		boolean status = false;
		for (WebElement we : listOfabled()) {
			if (we.getText().contains(abled)) {
				status = true;
				edit3 = we;
				edit3.click();
				hardWait(1);
				element("nextbtn").click();
				hardWait(1);
				
				break;	
			}
		}
		return status;
	}
	
	public boolean isAble() {
		boolean elementDisplayed = false;

	    try {
	    	driver.manage().timeouts().implicitlyWait(1200, TimeUnit.MILLISECONDS);
	    	WebElement ele = driver.findElement(By.cssSelector(".schemes-search-bar"));
	        ele.isDisplayed();
	        elementDisplayed = true;
	        System.out.println("You are eligible");
	    } catch(Exception e) {
	        elementDisplayed = false;
	    }

	    return elementDisplayed;
	}
	
	
	public void checkElgb() {
		WebElement element = driver.findElement(By.cssSelector(".md-cell--7"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element); 
		element.click();
	}
	
	public boolean selectReason() {
        element("elq1").click();
		boolean status = false;
		for (WebElement we : listOfreason()) {
			if (we.getText().contains("Deserted")) {
				status = true;
				edit3 = we;
				edit3.click();
				hardWait(1);
				break;
			}
		}
		return status;
	}
	public boolean destitute() {
		element("elq2").click();
		element("nextbtn").click();
		hardWait(1);
		
		boolean elementDisplayed = false;

	    try {
	    	driver.manage().timeouts().implicitlyWait(1200, TimeUnit.MILLISECONDS);
	    	WebElement ele = driver.findElement(By.cssSelector(".circle-position>p"));
	        ele.isDisplayed();
	        elementDisplayed = true;
	        System.out.println("You are eligible");
	    } catch(Exception e) {
	        elementDisplayed = false;
	    }

	    return elementDisplayed;
}
	
   public boolean apply() {
	   element("apply").click();
	   hardWait(1);
	   boolean elementDisplayed = false;
	   try {
	    	driver.manage().timeouts().implicitlyWait(1200, TimeUnit.MILLISECONDS);
	    	WebElement ele = driver.findElement(By.cssSelector(".apply-online-document-bg>h4"));
	        ele.isDisplayed();
	        elementDisplayed = true;
	        System.out.println("You are on Application page");
	    } catch(Exception e) {
	        elementDisplayed = false;
	    }
	    return elementDisplayed;
	   
   }
   
   public void clickLogOut() {
	   element("dropdown").click();
	   element("logout").click();
	   hardWait(2);
	   
   }
   
   public boolean signOut() {
	   Alert alert = driver.switchTo().alert();		
       alert.accept();	  
       hardWait(2);
       boolean elementDisplayed = false;
	   try {
	    	driver.manage().timeouts().implicitlyWait(1200, TimeUnit.MILLISECONDS);
	    	WebElement ele = driver.findElement(By.cssSelector(".nav-link"));
	        ele.isDisplayed();
	        elementDisplayed = true;
	        System.out.println("You have logged out, now you are on Easygov Homepage");
	    } catch(Exception e) {
	        elementDisplayed = false;
	    }
	    return elementDisplayed;
	   
   }
       
         
       
   }
   
   