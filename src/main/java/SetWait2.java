import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SetWait2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\chromedriver\\chromedriver.exe"); // 1. указать путь до драйвера на жестком диске
        WebDriver driver = new ChromeDriver(); //2. создать новый драйвер

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); /*7. Неявное ожидание (5сек) отклика
        перед тем, как элемент(ы) появится на странице, без указания конкретного элемента*/

//        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
//               .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='Google']")))); /*8. Явное ожидание определенного
//        события (появления элемента с XPath 'Google' на странице  */

        driver.get("https://google.com"); //4. Получить страницу по адресу

        Thread.sleep(5000);
        driver.quit();

    }
}