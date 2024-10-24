import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GoogleScreenshotTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Configuración de Selenium WebDriver (requiere ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\chocolatey\\bin\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void visitGoogleAndTakeScreenshot() throws IOException {
        // Visitar Google
        driver.get("https://www.google.com");

        // Tomar la captura de pantalla
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("google_screenshot.png");
        Files.copy(srcFile.toPath(), destFile.toPath());

        // Generar PDF con los resultados
        generatePDF("google_screenshot.png", "Google visitado Correctamente");
    }

    private void generatePDF(String imagePath, String message) throws IOException {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            // Añadir el texto al PDF
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText(message);
            contentStream.endText();

            // Cargar la imagen
            PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, document);

            // Establecer la posición de la imagen
            float x = 100; // Posición en X
            float y = 500; // Posición en Y
            float width = 200; // Ancho de la imagen
            float height = (pdImage.getHeight() / (float) pdImage.getWidth()) * width; // Altura proporcionada

            // Dibujar la imagen en el PDF
            contentStream.drawImage(pdImage, x, y, width, height);

            document.save("test_result.pdf");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}