package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class skill13 {

    private static final String SCREENSHOT_DIR = "C:/Users/HP/OneDrive/Pictures/Camera Roll/cgpa.png";

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://newerp.kluniversity.in");
            System.out.println("Opened KLU ERP website.");

            WebElement userInput = driver.findElement(By.id("loginFormUserNameID"));
            WebElement passInput = driver.findElement(By.id("loginFormPasswordID"));

            // ✅ Fixed username and password
            userInput.sendKeys("2300080183");
            passInput.sendKeys("hari1098");
            System.out.println("Entered username and password. Please enter CAPTCHA manually and click Login.");

            // Wait for manual login (CAPTCHA)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loggedIn")));
            System.out.println("Login successful.");

            // Open Profile → View Profile
            WebElement profileMenu = driver.findElement(By.xpath("//a[contains(normalize-space(.),'Profile')]"));
            scrollIntoView(driver, profileMenu);
            profileMenu.click();
            System.out.println("Opened Profile menu.");

            WebElement viewProfile = driver.findElement(By.xpath("//a[contains(normalize-space(.),'View Your Profile')]"));
            scrollIntoView(driver, viewProfile);
            viewProfile.click();
            System.out.println("Opened View Profile page.");

            Thread.sleep(1500);
            takeScreenshot(driver, "KLU_ProfilePage");
            System.out.println("Profile page screenshot saved.");

            // Go back to dashboard
            driver.navigate().back();
            System.out.println("Navigated back to dashboard.");
            Thread.sleep(1000);

            // Open My CGPA page
            WebElement myCgpa = driver.findElement(By.xpath("//span[normalize-space(text())='My CGPA']"));
            scrollIntoView(driver, myCgpa);
            myCgpa.click();
            System.out.println("Opened My CGPA page.");

            Thread.sleep(1500);
            takeScreenshot(driver, "KLU_CGPAPage");
            System.out.println("CGPA page screenshot saved.");

        } catch (Exception e) {
            takeScreenshot(driver, "ExceptionError");
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void takeScreenshot(WebDriver driver, String name) {
        try {
            File dir = new File(SCREENSHOT_DIR);
            if (!dir.exists()) dir.mkdirs();

            File destFile = new File(SCREENSHOT_DIR + name + ".png");
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved/updated at: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
