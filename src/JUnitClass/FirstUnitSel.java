package JUnitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstUnitSel {
    static WebDriver driver;
    static String baseUrl;


    @BeforeAll
    public static void setUp() {
        baseUrl = "https://letskodeit.teachable.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Berdi\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll - navigated and initiated to web page");
    }

    @AfterAll
    public static void tearDown() {
        driver.navigate().refresh();
        System.out.println("@AfterAll executed once before all test methods in this class");
    }

    @BeforeEach
    public void init() {
        driver.navigate().refresh();
        System.out.println("@BeforeEach - refreshed the page");
    }

    @AfterEach
    public void done() {
        driver.navigate().refresh();
        System.out.println("@AfterEach - refreshed the page");
    }

    @Test
    public void test1() {
        WebElement logo = driver.findElement(By.cssSelector("a.navbar-brand.header-logo"));
        logo.click();
        driver.findElement(By.cssSelector("a.navbar-brand.header-logo")).click();
        System.out.println("Test clicking directly");
    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(5000);
        WebElement logo = driver.findElement(By.cssSelector("a.navbar-brand.header-logo"));
        logo.click();
        System.out.println("@Test - clicking on WebElement logo");
    }
}
