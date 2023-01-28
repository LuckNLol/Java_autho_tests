// 3. подтягивается автоматически
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenXpath1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\chromedriver\\chromedriver.exe");
        /* 1. указать путь до драйвера на жестком диске*/
        WebDriver driver = new ChromeDriver(); //2. создать новый драйвер

        driver.get("https://google.com"); //4. Получить страницу по адресу
        Thread.sleep(5000);

        WebElement input = driver.findElement(By.xpath("//input[@aria-label='Найти']")); /* 5. Поиск одного
        элемента на странице*/

        //WebElement inputs = driver.findElements(By.cssSelector()); // 6. Поиск много элементов на странице


        input.click(); // 7. нажать в выбранном поле

        driver.quit(); // 8. Выход

    }
}