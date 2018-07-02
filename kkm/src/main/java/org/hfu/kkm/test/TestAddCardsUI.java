package org.hfu.kkm.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestAddCardsUI {
	
    public static String testAddCard(WebDriver driver) throws Exception {
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
        
        topic.clear();
        front.clear();
        back.clear();
        Thread.sleep(3000);
        
        return newTimestamp;
    }
    
    public static String testFindAddedCard(WebDriver driver) throws Exception {
        driver.get("http://localhost:8080/kkm/private/editCard.xhtml");
        Thread.sleep(3000);
        
        WebElement lastSiteButton = driver.findElements(By.className("ui-icon-seek-end")).get(0);
        List<WebElement> frontList = driver.findElements(By.className("ui-cell-editor-output"));
        
        lastSiteButton.click();
        Thread.sleep(3000);
        System.out.println("size: "+frontList.size()+" text: "+frontList.get(0));
        /*for(WebElement e : frontList) {
        	  System.out.println(e.getText());
        }*/
        
        String timestamp = frontList.get(frontList.size()-3).getText();
        System.out.println("timestamp: "+timestamp);
        Thread.sleep(3000);
        return timestamp;
    }
}
