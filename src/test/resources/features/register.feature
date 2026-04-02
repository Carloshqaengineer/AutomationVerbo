# language: es
Feature: Registro
  Como usuario quiero poder crear una cuenta nueva

  Scenario: Validar que la página de registro carga correctamente
    Given el usuario navega al registro
    Then el formulario de registro es visible

  Scenario: Validar registro exitoso con datos válidos
    Given el usuario navega al registro
    When completa el nombre "Carlos"
    And completa el email de registro "nuevo@test.com"
    And completa la contraseña de registro "Password123"
    And confirma la contraseña "Password123"
    And presiona crear cuenta
    Then es redirigido al login

  Scenario: Validar error cuando las contraseñas no coinciden
    Given el usuario navega al registro
    When completa el email de registro "test@test.com"
    And completa la contraseña de registro "Password123"
    And confirma la contraseña "OtraPassword456"
    And presiona crear cuenta
    Then se muestra error "Las contraseñas no coinciden"

  Scenario: Validar error con contraseña menor a 8 caracteres
    Given el usuario navega al registro
    When completa el email de registro "test@test.com"
    And completa la contraseña de registro "abc"
    And confirma la contraseña "abc"
    And presiona crear cuenta
    Then se muestra error "al menos 8 caracteres"

  Scenario: Validar error con formato de email inválido
    Given el usuario navega al registro
    When completa el email de registro "emailinvalido"
    And completa la contraseña de registro "Password123"
    And confirma la contraseña "Password123"
    And presiona crear cuenta
    Then se muestra error "Formato de correo inválido"

  Scenario: Validar que el link de login es visible desde el registro
    Given el usuario navega al registro
    Then el link de iniciar sesión es visible

  Scenario: Validar redirección al login desde el registro
    Given el usuario navega al registro
    When hace clic en el link de iniciar sesión
    Then es redirigido al login
