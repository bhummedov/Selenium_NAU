package JUnitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstUnitAttribute {

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
        System.out.println("@AfterAll executed once before all test methods in this class");
    }

    @Test
    public void test(){
    WebElement openTab = driver.findElement(By.xpath("//a[@id='opentab']"));
        System.out.println("Test class name is :"+openTab.getAttribute("class"));
        System.out.println("Test id name is :"+openTab.getAttribute("id"));
        System.out.println("Test href name is :"+openTab.getAttribute("href"));
        System.out.println("Test target name is :"+openTab.getAttribute("target"));
    }
    @Test
    public void test2(){
        WebElement tagExample =driver.findElement(By.xpath("//*[text()]='Switch Tab Example']"));
        System.out.println("Test executed :" +tagExample.getTagName());
    }
    @Test
    public void test3() throws InterruptedException{
        List<WebElement> listEle = driver.findElements(By.xpath("div[@id='radio-btn-example']//input"));
        for (WebElement ele: listEle){
            ele.click();
            System.out.println("Radio button selected is: "+ele.getAttribute("value"));
            System.out.println("radio button isSelected :" +ele.isSelected());
            Thread.sleep(5000);
        }
    }
}
