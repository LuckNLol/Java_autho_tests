import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/* Разбираем ожидание исчезновения элемента после просмотра и перед тем как загрузится новый элемент
* (!) Важная практика ожиданния исчезновения элемента. Помогает избежать возникновения ошибок потери времени
*  */
public class WaitOfDisappearanse9 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\WebDrivers\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));

       try {
            driver.get("https://pagination.js.org");
            Thread.sleep(2000);
            /* Забрать список из WEB элементов и страниц на странице */
            List<WebElement> lists = driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));
            List<WebElement> pages = driver.findElements(By.xpath("//div[@class='paginationjs-pages']/ul/li"));

            /* Берём текст пятого элемента из списка на странице 1 */
            String text = lists.get(4).getText();
            System.out.println(text);

            /* Кликаем на страницу 6 */
            pages.get(5).click();

            /* (!!!!) Ждем пока пропадет элемент 5 на странице 1 */
            wait.until(ExpectedConditions.stalenessOf(lists.get(4)));

            /* В list хранится старая информация, нужно перезаписать новую уже на странице 6 */
            lists = driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));

            /* Берём текст из пятого элемента на странице 6 */
            text = lists.get(4).getText();
            System.out.println(text);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }


    }
}

