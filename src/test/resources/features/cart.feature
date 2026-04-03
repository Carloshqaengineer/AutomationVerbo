Feature: Carrito de Compras
  Como usuario quiero gestionar mi carrito de compras

  Scenario: Validar que el carrito vacÃ­o muestra mensaje correcto
    Given el usuario navega al carrito
    Then se muestra el mensaje de carrito vacÃ­o
    And el botÃ³n explorar productos es visible

  Scenario: Validar que el carrito muestra productos agregados
    Given el usuario agrega un producto al carrito
    When navega al carrito
    Then el producto aparece en el carrito

  Scenario: Validar que se puede aumentar la cantidad de un producto
    Given el usuario tiene un producto en el carrito
    When hace clic en el botÃ³n aumentar cantidad
    Then la cantidad del producto aumenta en 1

  Scenario: Validar que se puede disminuir la cantidad de un producto
    Given el usuario tiene un producto en el carrito con cantidad 2
    When hace clic en el botÃ³n disminuir cantidad
    Then la cantidad del producto disminuye en 1

  Scenario: Validar que se puede eliminar un producto del carrito
    Given el usuario tiene un producto en el carrito
    When hace clic en eliminar producto
    Then el producto es removido del carrito

  Scenario: Validar que el total se calcula correctamente
    Given el usuario tiene productos en el carrito
    Then el total mostrado es correcto

  Scenario: Validar que el botÃ³n vaciar carrito funciona
    Given el usuario tiene productos en el carrito
    When hace clic en vaciar carrito
    Then el carrito queda vacÃ­o

  Scenario: Validar que el botÃ³n proceder al pago redirige al checkout
    Given el usuario tiene un producto en el carrito
    When hace clic en proceder al pago
    Then es redirigido al checkout

  Scenario: Validar que el badge del carrito muestra la cantidad correcta
    Given el usuario agrega 2 productos al carrito
    Then el badge del carrito muestra 2

  Scenario: Validar que el carrito persiste al recargar la pÃ¡gina
    Given el usuario tiene un producto en el carrito
    When recarga la pÃ¡gina del carrito
    Then el producto sigue en el carrito
