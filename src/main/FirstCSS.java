package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstCSS{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Berdi\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();

        driver1.get("https://www.bankofamerica.com/");

        driver1.findElement(By.cssSelector("#NAV_BUSINESS_ADVANTAGE")).click();
    }
}
