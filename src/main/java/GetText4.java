import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class GetText4 {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\WebDrivers\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.avito.ru/all/lichnye_veschi?cd=1");

        WebElement element = driver.findElement(By.cssSelector(".page-title-count-wQ7pG"));
        String par = element.getAttribute("innerHTML");
        String parameter = element.getText();
        System.out.println("В качестве параметра выбран: " + par + "; " + parameter);

        Thread.sleep(5000);
        driver.quit();
    }
}
