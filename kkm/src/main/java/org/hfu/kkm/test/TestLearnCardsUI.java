package org.hfu.kkm.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestLearnCardsUI {
	
    public static void testFlipCardAndNextCard(WebDriver driver) throws Exception {
        driver.get("http://localhost:8080/kkm/private/learnCard.xhtml");
        Thread.sleep(3000);
        
        Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.id("learnCardForm:flip-container"));
		Thread.sleep(3000);
		
		action.moveToElement(we).build().perform();
        Thread.sleep(3000);
    }
    
    public static String getOldCard(WebDriver driver) throws Exception {
		WebElement we = driver.findElement(By.id("learnCardForm:card-front"));
		String oldCardBack = we.getText();
        Thread.sleep(3000);
        return oldCardBack;
    }
    
    public static String getNextCard(WebDriver driver) throws Exception {
        driver.findElement(By.id("learnCardForm:j_idt40:button-easy")).click();
        Thread.sleep(3000);
        
        WebElement we2 = driver.findElement(By.id("learnCardForm:card-front"));
        String newCardBack = we2.getText();
        Thread.sleep(3000);
        return newCardBack;
    }
}
