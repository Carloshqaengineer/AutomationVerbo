Feature: Login
  Como usuario quiero poder iniciar sesiÃ³n en el sistema

  Scenario: Validar que la pÃ¡gina de login carga correctamente
    Given el usuario navega al login
    Then el formulario de login es visible

  Scenario: Validar login con credenciales vÃ¡lidas
    Given el usuario navega al login
    When ingresa el email "usuario@test.com"
    And ingresa la contraseÃ±a "password123"
    And presiona el botÃ³n de ingresar
    Then es redirigido al homepage

  Scenario: Validar error con contraseÃ±a incorrecta
    Given el usuario navega al login
    When ingresa el email "usuario@test.com"
    And ingresa la contraseÃ±a "wrongpassword"
    And presiona el botÃ³n de ingresar
    Then se muestra un mensaje de error en el login

  Scenario: Validar error con email no registrado
    Given el usuario navega al login
    When ingresa el email "noexiste@test.com"
    And ingresa la contraseÃ±a "cualquiera123"
    And presiona el botÃ³n de ingresar
    Then se muestra un mensaje de error en el login

  Scenario: Validar que el campo email vacÃ­o muestra validaciÃ³n
    Given el usuario navega al login
    When deja el campo email vacÃ­o
    And ingresa la contraseÃ±a "password123"
    And presiona el botÃ³n de ingresar
    Then el formulario no se envÃ­a

  Scenario: Validar que el campo contraseÃ±a vacÃ­o muestra validaciÃ³n
    Given el usuario navega al login
    When ingresa el email "usuario@test.com"
    And deja el campo contraseÃ±a vacÃ­o
    And presiona el botÃ³n de ingresar
    Then el formulario no se envÃ­a

  Scenario: Validar formato de email invÃ¡lido
    Given el usuario navega al login
    When ingresa el email "emailsinformato"
    And ingresa la contraseÃ±a "password123"
    And presiona el botÃ³n de ingresar
    Then el formulario no se envÃ­a

  Scenario: Validar que el link de registro es visible
    Given el usuario navega al login
    Then el link de registro es visible

  Scenario: Validar redirecciÃ³n al registro desde el login
    Given el usuario navega al login
    When hace clic en el link de registro
    Then es redirigido a la pÃ¡gina de registro

  Scenario: Validar que la contraseÃ±a se muestra oculta
    Given el usuario navega al login
    When ingresa la contraseÃ±a "mipassword"
    Then el campo contraseÃ±a es de tipo password
