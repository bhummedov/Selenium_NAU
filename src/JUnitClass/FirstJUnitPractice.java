package JUnitClass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class FirstJUnitPractice {

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
    public void checkin() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"traveler-selector-hlp\"]/div/ul/li/button")).click();
        System.out.println("@BeforeEach - clicking checkin button");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"traveler-selector-hlp\"]/div/ul/li/div/div/div[1]/div[3]/div[1]/div[4]/button")).click();
        System.out.println("@BeforeEach = clinking plus button");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"traveler-selector-hlp\"]/div/ul/li/div/div/div[1]/div[3]/div[1]/div[4]/button")).click();
        System.out.println("@BeforeEach - clicking plus button ");
        Thread.sleep(5000);
    }

    @Test
    public void enabledTravellers() throws InterruptedException {
        Thread.sleep(5000);
        boolean enabl = driver.findElement(By.xpath("//*[@id=\"traveler-selector-hlp\"]/div/ul/li/div/div/div[1]/div[3]/div[1]/div[2]")).isEnabled();
        System.out.print(enabl);
        WebElement datefield = driver.findElement(By.xpath("//*[@id=\"traveler-selector-hlp\"]/div/ul/li/div/div/div[1]/div[3]/div[1]/div[2]"));
        if (enabl) {
            datefield.click();
            System.out.println(" @enable - clicking on enabled");
        } else {
            System.out.println(" @enable - date field disabled");
        }

        Thread.sleep(5000);

    }

    @Test
    public void disabledChild() throws InterruptedException {
        Thread.sleep(5000);
        WebElement datefield = driver.findElement(By.xpath("//*[@id=\"traveler-selector-hlp\"]/div/ul/li/div/div/div[1]/div[3]/div[2]/label[1]/span"));
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