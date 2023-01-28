/* Selenium не может работать с всплывающими окнами в браузере, а также с системными
 окнами в Windows для того, чтобы * передать файл из системного в всплывающее
 окно (Пример, загрузить файл с ПК на YouToube)
Чтобы это сделать, нужно искать в DevTools тег <input type="file".....>
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class InputFile12 {
    public static void main(String[] args) throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        /* Через переменную выполняется js код в браузере */
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("https://studio.youtube.com/");
            Thread.sleep(3000);
            /* Элемент на сайте невидимый. Нужно убрать невидимость. В CSS установить значение
             * display: block, opacity: 1 (непрозрачность), height: 1000px, wigth: 1000px
             * После того как элемент станет видимым с ним можно взаимодействовать методом sendKeys()
             * Вначале переходим у управлению js элементами:
             * */
            By fileInput = By.xpath("//input[@type='file']");
            String filePath = "C:\\Users\\Public\\Videos";

            WebElement element = driver.findElement(fileInput);
            js.executeScript("document.querySelector(input[@type='file']).setAttribute('style'," +
                    " 'opacity: 1', 'height: 1000px', 'wigth: 1000px', 'display: block')");


            element.sendKeys(filePath);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        } finally {
            Thread.sleep(5000);
            driver.quit();
        }


    }
}
