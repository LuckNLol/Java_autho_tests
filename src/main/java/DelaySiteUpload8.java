import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DelaySiteUpload8 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\WebDrivers\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            driver.get("https://www.wildberries.ru");
            Thread.sleep(5000); /* Задержка 5сек. для прогрузки страницы сайта */
            WebElement element = driver.findElement(By.xpath("//input[@class='search-catalog__input j-wba-header-item']"));
            element.sendKeys("кроссовки new balance мужские", Keys.ENTER);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            Thread.sleep(5000);
            driver.quit();
        }


    }
}

