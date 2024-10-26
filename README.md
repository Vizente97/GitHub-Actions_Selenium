# Proyecto de Automatización de Pruebas con Selenium

Este proyecto demuestra cómo ejecutar pruebas automatizadas con Selenium en múltiples entornos de desarrollo: Python 3.x, Java 8 (usando Maven y Gradle), e integra GitHub Actions para la ejecución continua de estas pruebas en un entorno de integración continua (CI).

## Requisitos Previos

- **Java Development Kit (JDK 8)**: Para las pruebas en Java.
- **Python 3.x**: Para las pruebas en Python.
- **Maven**: Para administrar dependencias y ejecutar pruebas en Java con Maven.
- **Gradle**: Para administrar dependencias y ejecutar pruebas en Java con Gradle.
- **GitHub Repository**: Asegúrate de tener un repositorio de GitHub para configurar GitHub Actions.

---

## Estructura del Proyecto

- `src/test/java`: Contiene las pruebas de Selenium para Java.
- `src/test/resources`: Archivos de recursos o configuración adicionales.
- `tests`: Contiene las pruebas de Selenium para Python.
- `.github/workflows`: Archivos YAML de configuración de GitHub Actions.

---

## Configuración de Dependencias

### Python

1. Instala las dependencias necesarias con el siguiente comando:

    ```bash
    pip install -r requirements.txt
    ```

   - **Nota**: Asegúrate de tener `selenium` en `requirements.txt`.

### Java (Maven)

1. Asegúrate de tener el archivo `pom.xml` configurado con la dependencia de Selenium:

    ```xml
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>
    ```

### Java (Gradle)

1. Asegúrate de tener el archivo `build.gradle` con la dependencia de Selenium:

    ```groovy
    dependencies {
        implementation 'org.seleniumhq.selenium:selenium-java:3.141.59'
    }
    ```

---

## Ejecutar las Pruebas Localmente

### Python

```bash
pytest tests/
```

### Java Maven

```bash
mvn test
```

### Java Gradle

```bash
gradle test
```
