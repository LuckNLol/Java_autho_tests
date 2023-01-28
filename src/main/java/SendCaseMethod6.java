import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendCaseMethod6 {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\WebDrivers\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.udemy.com/");
        WebElement element0 = driver.findElement(By.xpath("//input[@name='q']"));
        element0.sendKeys("Java", Keys.ENTER);
        Thread.sleep(5000);

        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
            /* Метод позволяет вводить данные в поисковые строки и задавать команды на исполнение */
            element.sendKeys("Java", Keys.LEFT, Keys.LEFT, Keys.DELETE, Keys.RIGHT, Keys.DELETE,
                    " Tony", Keys.ENTER);


        Thread.sleep(5000);
        driver.quit();
    }
}

