Feature: Registro
  Como usuario quiero poder crear una cuenta nueva

  Scenario: Validar que la pÃ¡gina de registro carga correctamente
    Given el usuario navega al registro
    Then el formulario de registro es visible

  Scenario: Validar registro exitoso con datos vÃ¡lidos
    Given el usuario navega al registro
    When completa el nombre "Carlos"
    And completa el email de registro "nuevo@test.com"
    And completa la contraseÃ±a de registro "Password123"
    And confirma la contraseÃ±a "Password123"
    And presiona crear cuenta
    Then es redirigido al login

  Scenario: Validar error cuando las contraseÃ±as no coinciden
    Given el usuario navega al registro
    When completa el email de registro "test@test.com"
    And completa la contraseÃ±a de registro "Password123"
    And confirma la contraseÃ±a "OtraPassword456"
    And presiona crear cuenta
    Then se muestra error "Las contraseÃ±as no coinciden"

  Scenario: Validar error con contraseÃ±a menor a 8 caracteres
    Given el usuario navega al registro
    When completa el email de registro "test@test.com"
    And completa la contraseÃ±a de registro "abc"
    And confirma la contraseÃ±a "abc"
    And presiona crear cuenta
    Then se muestra error "al menos 8 caracteres"

  Scenario: Validar error con formato de email invÃ¡lido
    Given el usuario navega al registro
    When completa el email de registro "emailinvalido"
    And completa la contraseÃ±a de registro "Password123"
    And confirma la contraseÃ±a "Password123"
    And presiona crear cuenta
    Then se muestra error "Formato de correo invÃ¡lido"

  Scenario: Validar que el link de login es visible desde el registro
    Given el usuario navega al registro
    Then el link de iniciar sesiÃ³n es visible

  Scenario: Validar redirecciÃ³n al login desde el registro
    Given el usuario navega al registro
    When hace clic en el link de iniciar sesiÃ³n
    Then es redirigido al login
