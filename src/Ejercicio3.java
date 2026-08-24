import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Ejercicio3 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {

            driver.get("https://www.automationexercise.com/products");

            WebElement buscador = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));

            buscador.sendKeys("jeans");

            WebElement botonBuscar = driver.findElement(By.id("submit_search"));
            botonBuscar.click();

            wt.until(ExpectedConditions.visibilityOfElementLocated(By.className("productinfo")));

            List<WebElement> productos = driver.findElements(By.className("productinfo"));

            int cantidad = productos.size();

            System.out.println("Cantidad de productos encontrados: " + cantidad);

            if (cantidad > 0) {
                System.out.println("Se encontraron productos");
                System.out.println("Prueba exitosa");
            } else {
                System.out.println("No se encontraron productos");
                System.out.println("Prueba fallida");
            }

        } finally {
            driver.quit();
        }
    }
}