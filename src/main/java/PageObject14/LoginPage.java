package PageObject14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    WebDriver driver = new ChromeDriver();

    WebElement loginInput = driver.findElement(By.id("login"));
    WebElement pswInput = driver.findElement(By.id("psw"));
    WebElement enter = driver.findElement(By.id("enter"));

    public void loggin(String login, String psw){
        loginInput.sendKeys(login);
        pswInput.sendKeys(psw);
        enter.click();
    }

}
