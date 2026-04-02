# VERBO — Automatización con Selenium + Cucumber + Java

Proyecto de automatización funcional para el ecommerce VERBO.

## Tecnologías
- Java 11
- Selenium 4
- Cucumber 7
- JUnit 5
- WebDriverManager
- Maven

## Estructura
```
src/test/
├── java/
│   ├── pages/          # Page Objects
│   │   ├── HomePage.java
│   │   ├── LoginPage.java
│   │   ├── RegisterPage.java
│   │   ├── ProductsPage.java
│   │   ├── ProductDetailPage.java
│   │   ├── CartPage.java
│   │   └── CheckoutPage.java
│   ├── steps/          # Step Definitions
│   │   ├── HomeSteps.java
│   │   ├── LoginSteps.java
│   │   ├── RegisterSteps.java
│   │   ├── ProductSteps.java
│   │   ├── CartSteps.java
│   │   ├── CheckoutSteps.java
│   │   └── Hooks.java
│   ├── runners/
│   │   └── TestRunner.java
│   └── utils/
│       ├── DriverManager.java
│       └── SeleniumUtils.java
└── resources/
    └── features/       # Archivos Gherkin
        ├── homepage.feature
        ├── login.feature
        ├── register.feature
        ├── products.feature
        ├── product_detail.feature
        ├── cart.feature
        └── checkout.feature
```

## Requisitos previos
- Java 11+
- Maven 3.8+
- Google Chrome instalado

## Cómo ejecutar

### Todos los tests
```bash
mvn test
```

### Un feature específico
```bash
mvn test -Dcucumber.filter.tags="@login"
```

## Reportes
Después de ejecutar, el reporte HTML se genera en:
```
target/cucumber-reports/report.html
```

## Configuración
La URL base está en `src/test/java/utils/DriverManager.java`:
```java
public static final String BASE_URL = "http://localhost:3000";
```
Cambiala por la URL de Netlify para correr contra producción.
