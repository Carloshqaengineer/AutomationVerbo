# language: es
Feature: Login
  Como usuario quiero poder iniciar sesión en el sistema

  Scenario: Validar que la página de login carga correctamente
    Given el usuario navega al login
    Then el formulario de login es visible

  Scenario: Validar login con credenciales válidas
    Given el usuario navega al login
    When ingresa el email "usuario@test.com"
    And ingresa la contraseña "password123"
    And presiona el botón de ingresar
    Then es redirigido al homepage

  Scenario: Validar error con contraseña incorrecta
    Given el usuario navega al login
    When ingresa el email "usuario@test.com"
    And ingresa la contraseña "wrongpassword"
    And presiona el botón de ingresar
    Then se muestra un mensaje de error en el login

  Scenario: Validar error con email no registrado
    Given el usuario navega al login
    When ingresa el email "noexiste@test.com"
    And ingresa la contraseña "cualquiera123"
    And presiona el botón de ingresar
    Then se muestra un mensaje de error en el login

  Scenario: Validar que el campo email vacío muestra validación
    Given el usuario navega al login
    When deja el campo email vacío
    And ingresa la contraseña "password123"
    And presiona el botón de ingresar
    Then el formulario no se envía

  Scenario: Validar que el campo contraseña vacío muestra validación
    Given el usuario navega al login
    When ingresa el email "usuario@test.com"
    And deja el campo contraseña vacío
    And presiona el botón de ingresar
    Then el formulario no se envía

  Scenario: Validar formato de email inválido
    Given el usuario navega al login
    When ingresa el email "emailsinformato"
    And ingresa la contraseña "password123"
    And presiona el botón de ingresar
    Then el formulario no se envía

  Scenario: Validar que el link de registro es visible
    Given el usuario navega al login
    Then el link de registro es visible

  Scenario: Validar redirección al registro desde el login
    Given el usuario navega al login
    When hace clic en el link de registro
    Then es redirigido a la página de registro

  Scenario: Validar que la contraseña se muestra oculta
    Given el usuario navega al login
    When ingresa la contraseña "mipassword"
    Then el campo contraseña es de tipo password
