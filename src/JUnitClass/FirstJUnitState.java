package JUnitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Many times, when user navigates to a page, there will be lot of elements but can’t perform interactions
// like sendKeys, click, clear, select as the element might be in disabled condition.
// It is important to determine the element state before performing those operations.
//isEnabled(): Returns Boolean true if element is enabled for performing interactions.
//Syntax: <WebElement Object>.isEnabled()  returns true if element is enabled


public class FirstJUnitState{


        static WebDriver driver;
        static String baseUrl;

        @BeforeAll
        public static void setUP() {
            baseUrl = "https://www.expedia.com/Hotels";
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

        @BeforeEach
        public void clickCheckIn() {
            driver.findElement(By.xpath("//*[@id='hotel-checkin-hlp']")).click();
            System.out.println("@BeforeEach - clicking on check-in");
        }

        @Test
        public void enabledDate() throws InterruptedException {
            Thread.sleep(5000);
            performEnableClick("//button[(@data-day='31' and @data-month='4') or (starts-with(@aria-label,'May 31'))]");
            Thread.sleep(5000);
        }

        @Test
        public void disabledDate() throws InterruptedException {
            Thread.sleep(5000);
            performEnableClick("//button[text()=' 1']/span[text()='May']/parent::button");
            Thread.sleep(5000);
        }

        private void performEnableClick(String locat) {
            WebElement datefield= driver.findElement(By.xpath(locat));
            boolean enabl = datefield.isEnabled();
            if(enabl) {
                datefield.click();
                System.out.println("@disabledDate - clicking on enabled date");
            } else {
                System.out.println("@disabledDate - date field disabled");
            }
        }
    }
