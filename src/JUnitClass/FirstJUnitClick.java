package JUnitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class FirstJUnitClick {

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
    public void checkin() {
        driver.findElement(By.xpath("//*[@id='hotel-checkin-hlp']")).click();
        System.out.println("@BeforeEach - clicking checkin button");

    }

    @Test
    public void enable() throws InterruptedException {
        Thread.sleep(5000);
        WebElement datefield = driver.findElement(By.xpath("//button[(@data-day='31' and @data-month='4') or (starts-with(@aria-label,'May 31'))]"));
        boolean enabl = datefield.isEnabled();
        if (enabl) {
            datefield.click();
            System.out.println(" @enable - clicking on enabled");
        } else {
            System.out.println(" @enable - date field disabled");
        }

        Thread.sleep(5000);

    }

    @Test
    public void disable() throws InterruptedException {
        Thread.sleep(5000);
        WebElement datefield = driver.findElement(By.xpath("//button[text()=' 1']/span[text()='May']/parent::button"));
        boolean enabl = datefield.isEnabled();
        if (enabl) {
            datefield.click();
            System.out.println(" @enable - clicking on enabled");
        } else {
            System.out.println(" @enable - date field disabled");
        }

        Thread.sleep(5000);

    }

    private void performEnabledClick(String locat) {
        WebElement datefield = driver.findElement(By.xpath(locat));
        boolean enabl = datefield.isEnabled();
        if (enabl) {
            datefield.click();
            System.out.println(" @enable - clicking on enabled");
        } else {
            System.out.println(" @enable - date field disabled");
        }
    }
}