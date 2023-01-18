package ModalWindows;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

/* Суть задания: Создать дискриптор для переключения окно в браузере.
Открыть вкладку в браузере -> Переключиться на следующую вкладку -> Закрыть вторую вкладку и
вернуться снова на первую.

Дескриптор — это атрибут объекта со связанным поведением (англ. binding behavior),
т.е. такой, чьё поведение при доступе переопределяется методами протокола дескриптора.
Эти методы:__ get__, __ set__ и__ delete__. Если хотя бы один из этих методов определён для объекта,
то он становится дескриптором. Стандартное поведение при доступе к атрибутам — это получение,
установка и удаление атрибута из словаря объекта.
*/

public class ModalWindiws11 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\WebDrivers\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        JavascriptExecutor js = (JavascriptExecutor) driver;

       try {
            driver.get("http://127.0.0.1:5500/Домашка%20HTML/MarshalCourse.html");
            Thread.sleep(3000);

            /* Для получения дескриптора (Handle) окна, обращаемся к драйверу окна */
            String window1 = driver.getWindowHandle();

            /* Открываем новое окно (ВКЛАДКУ В БРАУЗЕРЕ) через js */
            js.executeScript("window.open()");
            /* Команда позволяет плучить состояние при ктором открыты все текущие окна в браузере */
            Set<String> currentWindows = driver.getWindowHandles();
            Thread.sleep(2000);

            String window2 = null;

            for(String window : currentWindows) {
                if(!window.equals(window1)) {
                    window2 = window;
                    break;
                }
            };
            /* Созданы две переменные window 1 и 2, в каждом из которых хранится дескриптор своего окна  */

           /* Переключаемся на окно 2, для работы с ним */
           driver.switchTo().window(window2);
           driver.get("http://Google.com");
           Thread.sleep(2000);
           /* Предположим мы хотим закрыть окно и переключиться на первое */
           driver.close(); // закрыть вкладку 2
           driver.switchTo().window(window1);
           Thread.sleep(2000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            //Thread.sleep(2000);
            driver.quit();
        }

        System.out.println("Build completed successfully:)!!");
    }
}

