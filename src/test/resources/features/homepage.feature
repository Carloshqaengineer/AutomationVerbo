# language: es
Feature: Homepage
  Como usuario quiero ver la página principal correctamente

  Scenario: Validar que el homepage carga correctamente
    Given el usuario navega al homepage
    Then el título hero "Fe que se lleva" es visible
    And la sección "Productos Destacados" es visible
    And la sección "Explora por Categorías" es visible

  Scenario: Validar que el logo VERBO es visible con firma
    Given el usuario navega al homepage
    Then el logo "VERBO" es visible en el header
    And la firma "by Carlos Hernando" es visible

  Scenario: Validar que el banner promocional rota
    Given el usuario navega al homepage
    Then el banner con código "MIPRIMERVERBO" es visible en el header

  Scenario: Validar navegación al catálogo desde el CTA del hero
    Given el usuario navega al homepage
    When hace clic en "Ver colección"
    Then es redirigido a la página de productos

  Scenario: Validar navegación a Remeras desde el header
    Given el usuario navega al homepage
    When hace clic en "Remeras" en el nav
    Then es redirigido a productos filtrados por "remeras"

  Scenario: Validar navegación a Buzos desde el header
    Given el usuario navega al homepage
    When hace clic en "Buzos" en el nav
    Then es redirigido a productos filtrados por "buzos"

  Scenario: Validar navegación a Pantalones desde el header
    Given el usuario navega al homepage
    When hace clic en "Pantalones" en el nav
    Then es redirigido a productos filtrados por "pantalones"

  Scenario: Validar navegación a Accesorios desde el header
    Given el usuario navega al homepage
    When hace clic en "Accesorios" en el nav
    Then es redirigido a productos filtrados por "accesorios"

  Scenario: Validar navegación a categoría Remeras desde la sección de categorías
    Given el usuario navega al homepage
    When hace clic en la categoría "Remeras"
    Then es redirigido a productos filtrados por "remeras"

  Scenario: Validar que el ícono del carrito está visible en el header
    Given el usuario navega al homepage
    Then el ícono del carrito es visible en el header
