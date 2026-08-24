import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
        dr.manage().window().maximize();


        try {
            dr.get("https://bstackdemo.com/");

            List<WebElement> productos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".shelf-item")));
            int cantidadInicial = productos.size();
            System.out.println("Cantidad inicial de productos: " + cantidadInicial);

            WebElement samsung = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Samsung')]")));

            if (!samsung.isSelected()) {
                samsung.click();
            }

            if (samsung.isSelected()) {
                System.out.println("Samsung quedó seleccionado correctamente.");
            } else {
                System.out.println("Samsung NO quedó seleccionado.");
            }

            wait.until(driver -> {
                List<WebElement> productosActualizados = driver.findElements(By.cssSelector(".shelf-item"));
                return productosActualizados.size() < cantidadInicial;
            });

            List<WebElement> productosFiltrados = dr.findElements(By.cssSelector(".shelf-item"));
            int cantidadFinal = productosFiltrados.size();
            System.out.println("Cantidad final de productos: " + cantidadFinal);

            System.out.println("Productos Samsung:");

            for (WebElement producto : productosFiltrados) {
                System.out.println(producto.getText());
            }

            if (cantidadFinal < cantidadInicial) {
                System.out.println("prueba exitosa");
            } else {
                System.out.println("prueba fallida");
            }

        } finally {
        }
    }
}