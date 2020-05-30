package JUnitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstUnitList {

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
        System.out.println("@AfterAll executed once before all test methods in this class");
    }

    @Test
    public void radios() throws InterruptedException {
        List<WebElement> listEle = driver.findElements(By.xpath("//div[@id='radio-btn-example']//input"));
        for (WebElement ele : listEle) {
            ele.click();
            System.out.println("Test executed test1" + ele.isSelected());
            Thread.sleep(5000);
        }
    }

    @Test
    public void checkBox() throws InterruptedException {
        List<WebElement> listEle = driver.findElements(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/legend"));
        for (WebElement ele : listEle) {
            ele.click();
            System.out.println("Test executed test1" + ele.isSelected());
            Thread.sleep(5000);

        }
    }

    @Test
    public void table() throws InterruptedException {
        List<WebElement> listEle = driver.findElements(By.xpath("//table[@class='table-display']//th"));
        for (WebElement ele : listEle) {
            ele.click();
            System.out.println("Test executed test1" + ele.isSelected());
            Thread.sleep(5000);

        }
    }

    @Test
    public void tableExample() {
        List<WebElement> listEle = driver.findElements(By.xpath("//table[@class='table-display']//th"));
        List<WebElement> listAuthor = driver.findElements(By.xpath("//table[@class='table-display']//td[1]"));
        List<WebElement> listCourse = driver.findElements(By.xpath("//table[@class='table-display']//td[2]"));
        List<WebElement> listPrice = driver.findElements(By.xpath("//table[@class='table-display']//td[3]"));

        for (WebElement ele : listEle) {
            System.out.println("Test Header : " + ele.getText());
        }
        for (WebElement ele1 : listAuthor) {
            System.out.println("Test Header :" + ele1.getText());
        }
        for (WebElement ele2 : listCourse) {
            System.out.println("Test Header :" + ele2.getText());
        }
        for (WebElement ele3 : listPrice) {
            System.out.println("Test Header :" + ele3.getText());
        }

        int headSize = listEle.size();
        System.out.println();
        if (headSize > 0) {
            for (WebElement hele : listEle) {
                System.out.println("" + hele.getText());
            }
        } else {
            System.out.println("Header element not found");
        }
        int location = listEle.size();
        System.out.println();
        if (location > 0) {
            for (WebElement locationHele : listEle) {
                System.out.println("" + locationHele.getText());
            }
        } else {
            System.out.println("Header element not found");
        }
    }
}
