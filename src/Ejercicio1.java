import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;


public class Ejercicio1 {
    public static void main(String[] args){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(4));
        dr.manage().window().maximize();

        try {
            dr.get("https://www.selenium.dev/selenium/web/web-form.html");
            WebElement nombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-text-id")));
            WebElement pss = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-password")));
            WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-textarea")));
            WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-select")));

            nombre.sendKeys("Felipe");
            pss.sendKeys("felipe123");
            textarea.sendKeys("Soy programador");


            Select Listadrop = new Select(dropdown);
            Listadrop.selectByVisibleText("Two");
            String opcionSeleccionada = Listadrop.getFirstSelectedOption().getText();


            System.out.println("El texto seleccionado fue: " + opcionSeleccionada);

            WebElement casilla = dr.findElement(By.id("my-check-2"));

            if (!casilla.isSelected()) {
                casilla.click();
            }

            WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            boton.click();

            WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

            String men = mensaje.getText();

            if (men.contains("Received!")){
                System.out.println("La prueba paso");
            }else{
                System.out.println("La prueba fallo");
            }
        }finally {
            dr.quit();
        }
    }
}
