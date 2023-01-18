import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetAttribute3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\WebDrivers\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.avito.ru/all/avtomobili");

        WebElement element = driver.findElement(By.xpath("(//a[text()='Мотоциклы и мототехника'])[1]"));
        String parameter = element.getAttribute("href"); /*Свойство атрибута, которое мы хотим получить
        из вкладки "Properties" в DevTools */
        element.click();
        System.out.println("В качестве параметра выбран: " + parameter);

        Thread.sleep(5000);
        driver.quit();
    }
}
