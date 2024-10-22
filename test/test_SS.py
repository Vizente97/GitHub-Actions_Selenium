import pytest
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from webdriver_manager.core.utils import ChromeType
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service

@pytest.fixture(scope="module")
def driver():
    # Configuración inicial (similar a @BeforeClass en TestNG)
    chrome_service = Service(ChromeDriverManager(chrome_type=ChromeType.CHROMIUM).install())
    chrome_options = Options()
    options = [
        "--headless",
        "--disable-gpu",
        "--window-size=1920,1200",
        "--ignore-certificate-errors",
        "--disable-extensions",
        "--no-sandbox",
        "--disable-dev-shm-usage"
    ]
    for option in options:
        chrome_options.add_argument(option)

    driver = webdriver.Chrome(service=chrome_service, options=chrome_options)
    yield driver
    # Finalización (similar a @AfterClass en TestNG)
    driver.quit()

def test_example(driver):
    # Prueba simple con Selenium
    driver.get("https://www.google.com")

    # Toma de captura de pantalla
    driver.save_screenshot('screenshot.png')
