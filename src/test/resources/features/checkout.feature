Feature: Checkout
  Como usuario quiero completar el proceso de compra

  Scenario: Validar que el checkout carga con el banner de demo
    Given el usuario tiene productos en el carrito y navega al checkout
    Then el banner de demostraciÃ³n es visible en el checkout

  Scenario: Validar que el paso 1 muestra opciones de envÃ­o
    Given el usuario tiene productos en el carrito y navega al checkout
    Then las opciones de envÃ­o a domicilio y retiro en sucursal son visibles

  Scenario: Validar avance al paso 2 con envÃ­o a domicilio
    Given el usuario tiene productos en el carrito y navega al checkout
    When selecciona envÃ­o a domicilio
    And hace clic en continuar
    Then el formulario de datos personales es visible

  Scenario: Validar que el paso 2 requiere nombre
    Given el usuario estÃ¡ en el paso 2 del checkout
    When deja el campo nombre vacÃ­o e intenta continuar
    Then el botÃ³n continuar estÃ¡ deshabilitado

  Scenario: Validar que el paso 2 valida el email
    Given el usuario estÃ¡ en el paso 2 del checkout
    When ingresa un email invÃ¡lido en el checkout
    Then se muestra error de formato de email

  Scenario: Validar avance al paso 3 con datos completos
    Given el usuario estÃ¡ en el paso 2 del checkout con datos vÃ¡lidos
    When hace clic en continuar
    Then el resumen del pedido y mÃ©todos de pago son visibles

  Scenario: Validar que el paso 3 muestra datos de transferencia
    Given el usuario estÃ¡ en el paso 3 del checkout
    When selecciona transferencia bancaria
    Then los datos de CBU son visibles

  Scenario: Validar que el botÃ³n finalizar requiere comprobante en transferencia
    Given el usuario estÃ¡ en el paso 3 con transferencia seleccionada
    When no sube comprobante
    Then el botÃ³n finalizar estÃ¡ deshabilitado

  Scenario: Validar que MercadoPago abre el tutorial modal
    Given el usuario estÃ¡ en el paso 3 del checkout
    When selecciona MercadoPago y hace clic en pagar
    Then el modal tutorial de MercadoPago es visible

  Scenario: Validar que el tutorial de MercadoPago tiene 5 pasos con dots
    Given el modal tutorial de MercadoPago estÃ¡ abierto
    Then se muestran 5 dots de navegaciÃ³n

  Scenario: Validar navegaciÃ³n entre pasos del tutorial de MercadoPago
    Given el modal tutorial de MercadoPago estÃ¡ abierto
    When hace clic en siguiente
    Then avanza al siguiente paso del tutorial

  Scenario: Validar que el modal de MercadoPago se cierra con Entendido
    Given el modal tutorial de MercadoPago estÃ¡ abierto en el Ãºltimo paso
    When hace clic en Entendido
    Then el modal se cierra

  Scenario: Validar que el checkout muestra modal de Ã©xito tras finalizar con transferencia
    Given el usuario completa el checkout con transferencia
    Then el modal de pedido recibido es visible
    And se muestra un nÃºmero de orden

  Scenario: Validar que el botÃ³n atrÃ¡s en paso 2 regresa al paso 1
    Given el usuario estÃ¡ en el paso 2 del checkout
    When hace clic en atrÃ¡s
    Then regresa al paso 1 del checkout

  Scenario: Validar que el botÃ³n volver al carrito desde paso 1 funciona
    Given el usuario tiene productos en el carrito y navega al checkout
    When hace clic en volver al carrito
    Then es redirigido al carrito
