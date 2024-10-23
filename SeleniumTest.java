import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Configurar WebDriverManager para Chrome
        WebDriverManager.chromedriver().setup();

        // Configurar opciones de Chrome (modo headless)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1200");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Inicializar el WebDriver con Chrome
        driver = new ChromeDriver(options);
    }

    @Test
    public void testGooglePage() {
        // Navegar a Google
        driver.get("https://www.google.com");

        // Verificar el título de la página
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Google"));

        // Tomar captura de pantalla
        takeScreenshot("screenshot-java.png");
    }

    public void takeScreenshot(String fileName) {
        // Tomar la captura de pantalla
        File screenshot = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
        
        try {
            // Guardar la captura de pantalla en el archivo especificado
            Files.copy(screenshot.toPath(), new File(fileName).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        // Cerrar el navegador
        if (driver != null) {
            driver.quit();
        }
    }
}