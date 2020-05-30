package JUnitClass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstUnitSelectMulty {

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
    public void amultyDeSelectEach() throws InterruptedException {
        System.out.println("dropSelectEach - executed test ");
        WebElement dropEle = driver.findElement(By.id("multiple-select-example"));
        Select sel = new Select(dropEle);
        sel.deselectByValue("orange"); // selects using the value of attribute of the option tag element
        Thread.sleep(5000);
        sel.deselectByVisibleText("Apple"); // selects using the text of the option tag element
        Thread.sleep(5000);
        sel.deselectByIndex(2); // selects using the text of the option index 0
        Thread.sleep(5000);

    }

    @Test
    public void cmultySelectAll() throws InterruptedException {
        System.out.println("dropSelectAll - executed test ");
        WebElement multyEle = driver.findElement(By.id("carselect"));
        Select sel = new Select(multyEle);
        List<WebElement> opts = sel.getOptions(); // return a List of WebELement of all option tags inside select
        for (WebElement ele : opts) {
            System.out.println("Options is:" + ele.getText()); // get visible text of the element
            sel.selectByVisibleText(ele.getText());
            Thread.sleep(5000);

        }

        for (WebElement ele : opts) {
            System.out.println("Options is:" + ele.getText()); // get visible text of the element
            sel.selectByVisibleText(ele.getText());
            Thread.sleep(5000);

        }
    }

    @Test
    public void cmultyGetSelected() throws InterruptedException {
        System.out.println("dropSelectAll - executed test ");
        WebElement multyEle = driver.findElement(By.id("multiple-select-example"));
        Select sel = new Select(multyEle);
        List<WebElement> opts = sel.getOptions(); // return a List of WebELement of all option tags inside select
        for (WebElement ele : opts) {
            System.out.println("Options is:" + ele.getText()); // get visible text of the element
            sel.selectByVisibleText(ele.getText());
            Thread.sleep(5000);

        }
        sel.deselectByIndex(1); // deselcting Orange option
        List<WebElement> selOPts = sel.getAllSelectedOptions();
        for (WebElement ele : selOPts) {
            System.out.println("Options is:" + ele.getText()); // get visible text of the element


        }
        sel.deselectAll();
        Thread.sleep(500);
        selOPts=sel.getAllSelectedOptions();
        System.out.println("Selected option count:" +selOPts.size());
        System.out.println("isMultiple:" + sel.isMultiple());
    }
}
