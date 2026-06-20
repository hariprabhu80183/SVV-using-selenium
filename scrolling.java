package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class scrolling {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.amazon.in/");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

            try {
                WebElement continueButton = wait.until(
                        ExpectedConditions.elementToBeClickable(By.id("nav-main"))
                );
            } catch (Exception e) {
                System.out.println("No shopping popup to handle.");
            }

            String pageTitle = driver.getTitle();
            System.out.println("Title: " + pageTitle);

            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
            );
            searchBox.sendKeys("iphones");

            driver.findElement(By.id("nav-search-submit-button")).click();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0,3000);");
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,-2000);");

            Thread.sleep(4000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}