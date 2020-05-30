package JUnitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstUnitCalendar {

    static WebDriver driver;
    static String baseUrl;


    @BeforeAll
    public static void setUp() {
        baseUrl = "https://www.expedia.com/Hotels";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Berdi\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll - navigated and initiated to web page");
    }


    @AfterAll
    public static void tearDown() {
        driver.quit();
        System.out.println("@AfterAll executed once before all test methods in this class");
    }

    @BeforeEach
    public void init() {
        driver.findElement(By.xpath("//*[@id='hotel-checkin-hlp']"));
        System.out.println("@BeforeEach clicking checkin ");
    }

    @Test
    public void test1() {
        List<WebElement> dateEle = driver.findElements(By.xpath("//div[@class='datepicker-cal-month']//button"));
        for (WebElement ele : dateEle) {
            boolean enabl = ele.isEnabled();
            String dateVal = ele.getText();
            WebElement spanEle = ele.findElement(By.tagName("span"));
            String monthVal = spanEle.getText();
            if (enabl) {
                System.out.println("Date is enabled :" + monthVal + dateVal);
            } else {
                System.out.println("Date is disabled :" + monthVal + dateVal);
            }
        }
    }
}