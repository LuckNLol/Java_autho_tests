import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class CssStyleCheckElements5 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\WebDrivers\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://devby.io/");

        WebElement element = driver.findElement(By.xpath("//a[text()='Компании']"));
        String parameter = element.getCssValue("transition"); /* Поиск CSS элемента */
                System.out.println("В качестве параметра выбран: " + parameter);
                element.click();

        Thread.sleep(5000);
        driver.quit();
    }
}

