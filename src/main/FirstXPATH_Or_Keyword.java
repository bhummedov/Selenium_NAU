package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstXPATH_Or_Keyword {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Berdi\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();

        driver1.get("https://www.bankofamerica.com/");

        driver1.findElement(By.xpath("//span[text()='Get started' " +
                "or text()='Click to get started' " +
                "or text()='Open'" +
                " or text()='See options' " +
                "or text()='Click to see options'" +
                " or text()='Learn more' " +
                "or text()='Continue'" +
                " or text()='Click to open']")).click();
    }
}
