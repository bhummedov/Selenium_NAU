package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstEdge {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver","C:\\Users\\Berdi\\Desktop\\Selenium\\edgedriver_win64\\msedgedriver.exe");
        System.out.println("Driver location is: "+System.getProperty("webdriver.edge.driver"));
        WebDriver driver1 = new EdgeDriver();
        driver1.get("https://amazon.com");
    }
}
