package ModalWindows;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;


/* Модальные окна - это информационные/предупреждающие окна появляющиеся поверх Web страницы, могут содержать
* элементы управления: кнопки, поля. Разбираем практику работы в Selenium с модальными окнами
* модальные окна это Alert
*/

public class ModalWindiws10 {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\WebDrivers\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

       try {
            driver.get("http://127.0.0.1:5500/Домашка%20HTML/MarshalCourse.html");
            Thread.sleep(3000);

            WebElement element1 = driver.findElement(By.id("a"));
            WebElement element2 = driver.findElement(By.id("b"));
            WebElement element3 = driver.findElement(By.id("c"));
// Элемент 1
            element1.click(); // Кликаем на элемент 1
            Alert alert = wait.until(alertIsPresent()); // Ждем пока появится Alert.
           Thread.sleep(3000);
            alert.accept(); // принимаем Alert. Нажимается кнопка "ОК"

// Элемент 2.1
            element2.click(); // Кликаем на элемент 2
            Alert prompt = wait.until(alertIsPresent()); //Дожидаемся появления поля "PROMPT"
           Thread.sleep(1000);
            prompt.sendKeys("Super!!!"); // Вносим данные в поле
           Thread.sleep(1000);
            prompt.accept(); // Нажимается кнопка "ОК"
//2.2
            Alert alert2 = wait.until(alertIsPresent()); //Переход к окно Alert
            Thread.sleep(2000); // Задержка 2сек
            alert2.accept(); // Нажимается кнопка "ОК"

// Элемент 3
            element3.click();
            Alert alert3 = wait.until(alertIsPresent());
           Thread.sleep(3000);
            alert3.dismiss();  // Нажимается кнопка "Отмена"

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            //Thread.sleep(2000);
            driver.quit();
        }

        System.out.println("Build completed successfully:)!!");
    }
}

