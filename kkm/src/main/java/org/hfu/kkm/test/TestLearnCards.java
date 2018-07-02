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

public class TestLearnCards {
	WebDriver driver = null;
	
	@Before
	public void init() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Bruce/Downloads/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);
	}
	
	@Test
    public void testFlipCardAndNextCard() throws Exception {
		TestLearnCardsUI.testFlipCardAndNextCard(driver);
        String oldCardBack = TestLearnCardsUI.getOldCard(driver);
        String newCardBack = TestLearnCardsUI.getNextCard(driver);
        
        System.out.println("Back 1: "+newCardBack);
        System.out.println("Back 2: "+oldCardBack);
        assertTrue(!newCardBack.equals(oldCardBack));
    }
	
	@After
	public void aftertest() {
	 driver.quit(); 
	}
}
