package org.hfu.kkm.test;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hfu.kkm.card.db.Card;
import org.hfu.kkm.card.db.CardService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OldTestAddCards {

	WebDriver driver = null;
	
	@Before
	public void init() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Bruce/Downloads/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);
	}
	
	@Test
    public void testaddCard() throws Exception {
        driver.get("http://localhost:8080/kkm/private/addCard.xhtml");
        Thread.sleep(3000);
        WebElement topic = driver.findElement(By.id("j_idt26:addCardForm:topic"));
        WebElement front = driver.findElement(By.id("j_idt26:addCardForm:front"));
        WebElement back = driver.findElement(By.id("j_idt26:addCardForm:back"));
        WebElement send = driver.findElement(By.name("j_idt26:addCardForm:j_idt36"));
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Date date = new Date();
    	String newTimestamp = dateFormat.format(date);
        topic.sendKeys("automatedTest");
        front.sendKeys(newTimestamp);
        back.sendKeys("timestamp");
        Thread.sleep(3000);
        send.click();
        Thread.sleep(3000);
    }
	
	@After
	public void aftertest() {
	 driver.quit();
	}
}