import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class Ejercicio2 {
    public static void main(String[] args) {
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
        dr.manage().window().maximize();

        try {
            dr.get("https://bstackdemo.com/");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shelf-item")));

            int cantidadInicial = dr.findElements(By.cssSelector(".shelf-item")).size();
            System.out.println("Productos iniciales: " + cantidadInicial);

            WebElement samsung = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Samsung')]")));
            samsung.click();

            wait.until(driver -> driver.findElements(By.cssSelector(".shelf-item")).size() < cantidadInicial);

            int cantidadFinal = dr.findElements(By.cssSelector(".shelf-item")).size();
            System.out.println("Productos de samsung: " + cantidadFinal);

            if (cantidadFinal < cantidadInicial) {
                System.out.println("La prueba paso");
            } else {
                System.out.println("La prueba fallo");
            }

        } finally {
            dr.quit();
        }
    }
}