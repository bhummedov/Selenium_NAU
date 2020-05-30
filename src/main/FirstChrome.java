package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstChrome {
    public static void main(String[] args) {
        //psvm and do ctrl+space
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Berdi\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        System.out.println("driver location is:"+System.getProperty("webdriver.chrome.driver"));
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://amazon.com");
    }
}
