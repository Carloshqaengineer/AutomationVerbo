# language: es
Feature: Checkout
  Como usuario quiero completar el proceso de compra

  Scenario: Validar que el checkout carga con el banner de demo
    Given el usuario tiene productos en el carrito y navega al checkout
    Then el banner de demostración es visible en el checkout

  Scenario: Validar que el paso 1 muestra opciones de envío
    Given el usuario tiene productos en el carrito y navega al checkout
    Then las opciones de envío a domicilio y retiro en sucursal son visibles

  Scenario: Validar avance al paso 2 con envío a domicilio
    Given el usuario tiene productos en el carrito y navega al checkout
    When selecciona envío a domicilio
    And hace clic en continuar
    Then el formulario de datos personales es visible

  Scenario: Validar que el paso 2 requiere nombre
    Given el usuario está en el paso 2 del checkout
    When deja el campo nombre vacío e intenta continuar
    Then el botón continuar está deshabilitado

  Scenario: Validar que el paso 2 valida el email
    Given el usuario está en el paso 2 del checkout
    When ingresa un email inválido en el checkout
    Then se muestra error de formato de email

  Scenario: Validar avance al paso 3 con datos completos
    Given el usuario está en el paso 2 del checkout con datos válidos
    When hace clic en continuar
    Then el resumen del pedido y métodos de pago son visibles

  Scenario: Validar que el paso 3 muestra datos de transferencia
    Given el usuario está en el paso 3 del checkout
    When selecciona transferencia bancaria
    Then los datos de CBU son visibles

  Scenario: Validar que el botón finalizar requiere comprobante en transferencia
    Given el usuario está en el paso 3 con transferencia seleccionada
    When no sube comprobante
    Then el botón finalizar está deshabilitado

  Scenario: Validar que MercadoPago abre el tutorial modal
    Given el usuario está en el paso 3 del checkout
    When selecciona MercadoPago y hace clic en pagar
    Then el modal tutorial de MercadoPago es visible

  Scenario: Validar que el tutorial de MercadoPago tiene 5 pasos con dots
    Given el modal tutorial de MercadoPago está abierto
    Then se muestran 5 dots de navegación

  Scenario: Validar navegación entre pasos del tutorial de MercadoPago
    Given el modal tutorial de MercadoPago está abierto
    When hace clic en siguiente
    Then avanza al siguiente paso del tutorial

  Scenario: Validar que el modal de MercadoPago se cierra con Entendido
    Given el modal tutorial de MercadoPago está abierto en el último paso
    When hace clic en Entendido
    Then el modal se cierra

  Scenario: Validar que el checkout muestra modal de éxito tras finalizar con transferencia
    Given el usuario completa el checkout con transferencia
    Then el modal de pedido recibido es visible
    And se muestra un número de orden

  Scenario: Validar que el botón atrás en paso 2 regresa al paso 1
    Given el usuario está en el paso 2 del checkout
    When hace clic en atrás
    Then regresa al paso 1 del checkout

  Scenario: Validar que el botón volver al carrito desde paso 1 funciona
    Given el usuario tiene productos en el carrito y navega al checkout
    When hace clic en volver al carrito
    Then es redirigido al carrito
