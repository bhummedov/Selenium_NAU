package JUnitClass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//This code clicks on the Login button

public class FirstClickTest{
    String baseURL;
    WebDriver driver;
    @BeforeEach
    void init() {
        baseURL = "https://learn.letskodeit.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Berdi\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        System.out.println("Navigated to given URL");
    }
    @Test
    void test1() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
        Thread.sleep(5000);
        System.out.println("@Test – clicked on the element.");
    }
    @AfterEach
    void done() {
        driver.quit();
        System.out.println("Closed browser session");
    }
}

