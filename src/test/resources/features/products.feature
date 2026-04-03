Feature: Productos
  Como usuario quiero explorar y filtrar productos

  Scenario: Validar que la pÃ¡gina de productos carga correctamente
    Given el usuario navega a productos
    Then la lista de productos es visible
    And el panel de filtros lateral es visible
    And el selector de ordenamiento es visible

  Scenario: Validar filtro por categorÃ­a Remeras
    Given el usuario navega a productos
    When filtra por categorÃ­a "remeras"
    Then solo se muestran productos de "remeras"

  Scenario: Validar filtro por categorÃ­a Buzos
    Given el usuario navega a productos
    When filtra por categorÃ­a "buzos"
    Then solo se muestran productos de "buzos"

  Scenario: Validar filtro por categorÃ­a Pantalones
    Given el usuario navega a productos
    When filtra por categorÃ­a "pantalones"
    Then solo se muestran productos de "pantalones"

  Scenario: Validar filtro por categorÃ­a Accesorios
    Given el usuario navega a productos
    When filtra por categorÃ­a "accesorios"
    Then solo se muestran productos de "accesorios"

  Scenario: Validar que se muestran todos los productos sin filtro
    Given el usuario navega a productos
    When hace clic en "Todos"
    Then se muestran todos los productos disponibles

  Scenario: Validar que cada producto tiene nombre, precio y botÃ³n agregar
    Given el usuario navega a productos
    Then cada producto muestra nombre precio y botÃ³n agregar al carrito

  Scenario: Validar agregar producto al carrito desde la lista
    Given el usuario navega a productos
    When hace clic en "Agregar al carrito" del primer producto
    Then el badge del carrito muestra al menos 1 Ã­tem

  Scenario: Validar navegaciÃ³n al detalle del producto
    Given el usuario navega a productos
    When hace clic en el nombre del primer producto
    Then es redirigido a la pÃ¡gina de detalle del producto

  Scenario: Validar ordenamiento por menor precio
    Given el usuario navega a productos
    When selecciona ordenar por "price-asc"
    Then los productos se muestran ordenados por precio ascendente
