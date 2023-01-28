import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

/* Assert (проверка) помогает нам проверять условия теста и принимать решения когда тест провален
или выполнен. Тест считается выполненным только если завершается без вызова какого-либо исключения
 */

public class Asserts13 {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        try {
            driver.get("http://127.0.0.1:5500/Домашка%20HTML/MarshalCourse.html");
            Thread.sleep(3000);

            String title = driver.getTitle();
            System.out.println(title);

            Assert.assertEquals(title, "Window"); /* Сравнение фактического и ожидаемого резульатата
             при несовпадении выбрасывается ислкючение (expected [Window] but found [Windows]) */

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //Thread.sleep(2000);
            driver.quit();
        }
        System.out.println("Build completed successfully:)!!");
    }
}

