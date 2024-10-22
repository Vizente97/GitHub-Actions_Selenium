import pytest
from selenium import webdriver

@pytest.fixture(scope="module")
def driver():
    # Configuración inicial (similar a @BeforeClass en TestNG)
    driver = webdriver.Chrome()
    yield driver
    # Finalización (similar a @AfterClass en TestNG)
    driver.quit()

def test_example(driver):
    # Prueba simple con Selenium
    driver.get("https://www.google.com")
    
    # Toma de captura de pantalla
    driver.save_screenshot('screenshot.png')
