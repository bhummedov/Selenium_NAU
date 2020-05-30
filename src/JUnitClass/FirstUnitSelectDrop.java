package JUnitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstUnitSelectDrop {

    static WebDriver driver;
    static String baseUrl;

    @BeforeAll
    public static void setUP() {
        baseUrl = "https://learn.letskodeit.com/p/practice";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Berdi\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll - initiated and navigated to web page");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        System.out.println("@AfterAll - closed browser session");
    }

    @Test
    public void dropSelectEach() throws InterruptedException {
        System.out.println("dropSelectEach - executed test ");
        WebElement dropEle = driver.findElement(By.id("carselect"));
        Select sel = new Select(dropEle);
        sel.selectByValue("honda"); // selects using the text of the option tag element
        Thread.sleep(5000);
        sel.selectByVisibleText("Benz"); // selects using the text of the option tag element
        Thread.sleep(5000);
        sel.selectByIndex(0); // selects using the text of the option index 0
        Thread.sleep(5000);

    }

    @Test
    public void dropSelectAll() throws InterruptedException {
        System.out.println("dropSelectAll - executed test ");
        WebElement dropEle = driver.findElement(By.id("carselect"));
        Select sel = new Select(dropEle);
        List<WebElement> opts = sel.getOptions(); // return a List of WebELement
        for (WebElement ele : opts) {
            System.out.println("Options is:" + ele.getText());
            sel.selectByVisibleText(ele.getText());
            Thread.sleep(5000);

        }
    }

    @Test
    public void test3() {
        System.out.println("@Test3 -executed test");
    }
}