package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstFirefox{
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Berdi\\Desktop\\Selenium\\geckodriver\\geckodriver.exe");
        System.out.println("Driver location is:"+System.getProperty("webdriver.gecko.driver"));
        WebDriver driver = new FirefoxDriver();
        driver.get("https://amazon.com");
    }
}
