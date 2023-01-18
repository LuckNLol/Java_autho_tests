import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsMethod7 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\WebDrivers\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

 //       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000); /* Задержка выполнени на прогрузу сайта */

            WebElement element1 = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));

            Actions actions = new Actions(driver);

            /* ВАРИАНТ 1(пошаговый): навести курсор на элемент 1, захватить и удержать, переместить курсор к элементу 2,
            отпустить "кнопку", собрать сборку, выполнить  */
//            actions.moveToElement(element1).clickAndHold().moveToElement(element2).release().build().perform();

            /* ВАРИАНТ 2(упрощенный): */
//            actions.dragAndDrop(element1, element2).perform();

            /* ВАРИАНТ 3(перемещение объекта путём смещения по координатным осям) */
//            actions.dragAndDropBy(element1, 100, 100).perform();

            /* Задержка перед выполнением действия */
            actions.pause(7000).dragAndDrop(element1, element2).perform();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(10000); // Задержка, чтобы увидеть действия
            driver.quit(); /* Закрываем приложение после завершения всех операций(!!) */
        }
    }
}

