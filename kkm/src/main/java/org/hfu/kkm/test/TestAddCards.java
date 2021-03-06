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

public class TestAddCards {

	WebDriver driver = null;
	String timestamp;
	
	@Before
	public void init() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Bruce/Downloads/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);
	}
	
	@Test
    public void testaddCard() throws Exception {
        timestamp = TestAddCardsUI.testAddCard(driver);
        System.out.println(timestamp);
    }
	
	/*@Test
    public void testFindAddedCard() throws Exception {
        String selectedTimestamp = TestAddCardsUI.testFindAddedCard(driver);
        System.out.println(selectedTimestamp);
        //System.out.println("created timestamp: "+timestamp +" timestamp in db: "+selectedTimestamp);
        //assertTrue(timestamp.equals(lastElementInDB));
    }*/
	
	@After
	public void aftertest() {
	 driver.quit();
	 /*List <Card > list = new CardEJB().getAll();
     Card c = list.get(list.size()-1);
     System.out.println(c.getFront());*/
	}
}
