package org.hfu.kkm.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class OldTestLearnCards {
	WebDriver driver = null;
	
	@Before
	public void init() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Bruce/Downloads/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);
	}
	
	@Test
    public void testFlipCardAndNextCard() throws Exception {
        driver.get("http://localhost:8080/kkm/private/learnCard.xhtml");
        Thread.sleep(3000);
        
        Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.id("learnCardForm:card-front"));
		Thread.sleep(3000);
		
		action.moveToElement(we).build().perform();
		String oldCardBack = we.getText();
        Thread.sleep(3000);
        
        driver.findElement(By.name("learnCardForm:j_idt40:button-easy")).click();
        Thread.sleep(3000);
        
        WebElement we2 = driver.findElement(By.id("learnCardForm:card-front"));
        String newCardBack = we2.getText();
        
        System.out.println("Back 1: "+newCardBack+"\nBack 2: "+oldCardBack);
        assertTrue(!newCardBack.equals(oldCardBack));
        
        //assertTrue((driver.findElement(By.id("learnCardForm:j_idt37")).isDisplayed()));
        
        Thread.sleep(3000);
    }
	
	@After
	public void aftertest() {
	 driver.quit(); 
	}
}