import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.sql.Driver;

public class LoginAutomation {
    public static WebDriver driver;
    public static void main(String[] args){

        driver = new ChromeDriver();

//        Se obtiene el sitio web que se va a testear
        driver.get("https://practicetestautomation.com/practice-test-login/");

//        Se seleccionan los elementos a los que vamos a asignarle el texto
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");

//        Se selecciona el elemento del boton submit
//        y ejecutando un evento click enviamos lo ingresado en los inputs
        driver.findElement(By.id("submit")).click();

//        Capturamos el texto para verificar que el login fue exitoso
        String SuccesfullText = driver.findElement(By.className("post-title")).getText();

        if (SuccesfullText.equals("Logged In Successfully")){
            driver.findElement(By.className("wp-block-button__link")).click();
            System.out.println("Se inició sesión exitosamente");
        }else {
            System.out.println("No se pudo iniciar sesión");
        }
//        Capturamos el texto para verificar que regresó a la página de login
        String LoginPage = driver.findElement(By.tagName("h2")).getText();

        if (LoginPage.contentEquals("Test login")) {
            System.out.println("Regresó a la login page");
        } else {
            System.out.println("No se pudo regresar a la login page");
        }

//        Cerramos el proceso
        driver.quit();

    }
}
