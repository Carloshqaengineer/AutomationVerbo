# language: es
Feature: Productos
  Como usuario quiero explorar y filtrar productos

  Scenario: Validar que la página de productos carga correctamente
    Given el usuario navega a productos
    Then la lista de productos es visible
    And el panel de filtros lateral es visible
    And el selector de ordenamiento es visible

  Scenario: Validar filtro por categoría Remeras
    Given el usuario navega a productos
    When filtra por categoría "remeras"
    Then solo se muestran productos de "remeras"

  Scenario: Validar filtro por categoría Buzos
    Given el usuario navega a productos
    When filtra por categoría "buzos"
    Then solo se muestran productos de "buzos"

  Scenario: Validar filtro por categoría Pantalones
    Given el usuario navega a productos
    When filtra por categoría "pantalones"
    Then solo se muestran productos de "pantalones"

  Scenario: Validar filtro por categoría Accesorios
    Given el usuario navega a productos
    When filtra por categoría "accesorios"
    Then solo se muestran productos de "accesorios"

  Scenario: Validar que se muestran todos los productos sin filtro
    Given el usuario navega a productos
    When hace clic en "Todos"
    Then se muestran todos los productos disponibles

  Scenario: Validar que cada producto tiene nombre, precio y botón agregar
    Given el usuario navega a productos
    Then cada producto muestra nombre precio y botón agregar al carrito

  Scenario: Validar agregar producto al carrito desde la lista
    Given el usuario navega a productos
    When hace clic en "Agregar al carrito" del primer producto
    Then el badge del carrito muestra al menos 1 ítem

  Scenario: Validar navegación al detalle del producto
    Given el usuario navega a productos
    When hace clic en el nombre del primer producto
    Then es redirigido a la página de detalle del producto

  Scenario: Validar ordenamiento por menor precio
    Given el usuario navega a productos
    When selecciona ordenar por "price-asc"
    Then los productos se muestran ordenados por precio ascendente
