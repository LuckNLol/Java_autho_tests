package PageObject14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/* Паттерн - архитектурный стить для выстраивания кода, чтобы он был понятным, логичным
* производительным
* Паттерн Page Object - идея в том, чтобы написанный код вынести на разные уровни абстракции.
* Код строится оз Объектов и каждый объект находится на отдельной Странице.
* */

public class PageObjeсt {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        try {
            driver.get("http://127.0.0.1:5500/Домашка%20HTML/MarshalCourse.html");
            Thread.sleep(3000);

            LoginPage lp = new LoginPage();
            lp.loggin("admin", "admin");


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //Thread.sleep(2000);
            driver.quit();
        }
        System.out.println("Build completed successfully:)!!");
    }

}
