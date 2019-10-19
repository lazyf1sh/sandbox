package com.github.lazyf1sh.sandbox.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBasicExample {

    public static void main(String args[]) {
        System.setProperty("webdriver.gecko.driver", "C:\\1\\apps\\geckodriver-v0.25.0-win64\\geckodriver.exe");

        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://ya.ru/");

        WebElement element = webDriver.findElement(By.className("checkbox-label"));
        String text = element.getText();

        System.out.println(text);
        webDriver.quit();
    }

}
