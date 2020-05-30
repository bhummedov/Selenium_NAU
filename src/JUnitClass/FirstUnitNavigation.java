package JUnitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//User needs to perform navigation actions in order to test different page level functionalities,
// like whether navigation forward, backward,whether page title matches the requirement,
// whether navigation urls are forming properly.


public class FirstUnitNavigation {
    static WebDriver driver;
    static String baseUrl;
    static String currentUrl;
    static String pageTitle;

    @BeforeEach
    public void setUp1() {
        baseUrl = "https://www.na.edu";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Berdi\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @Test
    public void navigation_Back_Forward() throws InterruptedException {
        System.out.println("Current page title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        Thread.sleep(5000);
        driver.navigate().to("https://www.na.edu/request-information/");
        System.out.println("Current URL after navigate.to: " + driver.getCurrentUrl());
        Thread.sleep(5000);
        driver.navigate().back();
        System.out.println("Current URL after navigate.back: " + driver.getCurrentUrl());
        Thread.sleep(5000);
        driver.navigate().forward();
        System.out.println("Current URL after navigate.forward: " + driver.getCurrentUrl());
        Thread.sleep(5000);
        driver.navigate().back();
        System.out.println("Current URL after navigate.back: " + driver.getCurrentUrl());
        driver.navigate().refresh();
        System.out.println("Current URL after navigate.refresh: " + driver.getCurrentUrl());
    }
    @AfterEach
    void done() {
        driver.quit();
        System.out.println("Closed browser session");
    }
}