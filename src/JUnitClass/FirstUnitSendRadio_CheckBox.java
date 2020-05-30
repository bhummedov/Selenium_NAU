package JUnitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Note – Radio buttons need not always be round buttons.
// It’s the type attribute that tells if the element is a radio button
//Note – Radio buttons need not always be round buttons.
// It’s the type attribute that tells if the element is a radio button


public class FirstUnitSendRadio_CheckBox {
    static WebDriver driver;
    static String baseUrl;

    boolean benzSelected;
    boolean bmwSelected;
    boolean hondaSelected;

    @BeforeAll
    public static void setUp() {
        baseUrl = "https://letskodeit.teachable.com/p/practice";
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
        System.out.println("@BeforeEach - refreshed the page");
    }

    @AfterEach
    public void done() {
        // driver.navigate().refresh();
        System.out.println("@AfterEach - refreshed the page");
    }

    @Test
    public void radio_checkBox() throws InterruptedException {
        WebElement bmwRadioBtn = driver.findElement(By.id("bmwradio"));
        bmwRadioBtn.click();
        Thread.sleep(5000);
        WebElement benzRadioBtn = driver.findElement(By.id("benzradio"));
        benzRadioBtn.click();
        Thread.sleep(5000);
        WebElement hondaRadioBtn = driver.findElement(By.id("hondaradio"));
        hondaRadioBtn.click();
        Thread.sleep(5000);
        WebElement bmwCheckBox = driver.findElement(By.id("bmwcheck"));
        bmwCheckBox.click();
        Thread.sleep(5000);
        WebElement benzCheckBox = driver.findElement(By.id("benzcheck"));
        benzCheckBox.click();
        Thread.sleep(5000);
        WebElement hondaCheckBox = driver.findElement(By.id("hondacheck"));
        hondaCheckBox.click();
        Thread.sleep(5000);
        System.out.println("BMW Radio Button isSelected: " + bmwRadioBtn.isSelected());
        System.out.println("Benz Radio Button isSelected: " + benzRadioBtn.isSelected());
        System.out.println("BMW Checkbox isSelected: " + bmwCheckBox.isSelected());
        System.out.println("Benz Checkbox isSelected: " + benzCheckBox.isSelected());
    }
}
