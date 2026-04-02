# language: es
Feature: Detalle de Producto
  Como usuario quiero ver el detalle completo de un producto

  Scenario: Validar que la página de detalle carga correctamente
    Given el usuario navega al detalle del producto 1
    Then el nombre del producto es visible
    And el precio del producto es visible
    And la imagen principal es visible
    And el botón agregar al carrito es visible

  Scenario: Validar selección de color en producto
    Given el usuario navega al detalle del producto 1
    When selecciona el color "Negro"
    Then el color "Negro" queda seleccionado

  Scenario: Validar selección de talla en producto de ropa
    Given el usuario navega al detalle del producto 1
    When selecciona la talla "M"
    Then la talla "M" queda seleccionada

  Scenario: Validar agregar al carrito desde el detalle
    Given el usuario navega al detalle del producto 1
    When hace clic en agregar al carrito
    Then el badge del carrito se actualiza

  Scenario: Validar que el botón volver funciona
    Given el usuario navega al detalle del producto 1
    When hace clic en volver
    Then regresa a la página anterior

  Scenario: Validar que la imagen principal es visible
    Given el usuario navega al detalle del producto 1
    Then la imagen principal del producto es visible

  Scenario: Validar que la categoría del producto es visible
    Given el usuario navega al detalle del producto 1
    Then la categoría del producto es visible en el detalle
