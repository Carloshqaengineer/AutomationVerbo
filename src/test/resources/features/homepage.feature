Feature: Homepage
  Como usuario quiero ver la pÃ¡gina principal correctamente

  Scenario: Validar que el homepage carga correctamente
    Given el usuario navega al homepage
    Then el tÃ­tulo hero "Fe que se lleva" es visible
    And la secciÃ³n "Productos Destacados" es visible
    And la secciÃ³n "Explora por CategorÃ­as" es visible

  Scenario: Validar que el logo VERBO es visible con firma
    Given el usuario navega al homepage
    Then el logo "VERBO" es visible en el header
    And la firma "by Carlos Hernando" es visible

  Scenario: Validar que el banner promocional rota
    Given el usuario navega al homepage
    Then el banner con cÃ³digo "MIPRIMERVERBO" es visible en el header

  Scenario: Validar navegaciÃ³n al catÃ¡logo desde el CTA del hero
    Given el usuario navega al homepage
    When hace clic en "Ver colecciÃ³n"
    Then es redirigido a la pÃ¡gina de productos

  Scenario: Validar navegaciÃ³n a Remeras desde el header
    Given el usuario navega al homepage
    When hace clic en "Remeras" en el nav
    Then es redirigido a productos filtrados por "remeras"

  Scenario: Validar navegaciÃ³n a Buzos desde el header
    Given el usuario navega al homepage
    When hace clic en "Buzos" en el nav
    Then es redirigido a productos filtrados por "buzos"

  Scenario: Validar navegaciÃ³n a Pantalones desde el header
    Given el usuario navega al homepage
    When hace clic en "Pantalones" en el nav
    Then es redirigido a productos filtrados por "pantalones"

  Scenario: Validar navegaciÃ³n a Accesorios desde el header
    Given el usuario navega al homepage
    When hace clic en "Accesorios" en el nav
    Then es redirigido a productos filtrados por "accesorios"

  Scenario: Validar navegaciÃ³n a categorÃ­a Remeras desde la secciÃ³n de categorÃ­as
    Given el usuario navega al homepage
    When hace clic en la categorÃ­a "Remeras"
    Then es redirigido a productos filtrados por "remeras"

  Scenario: Validar que el Ã­cono del carrito estÃ¡ visible en el header
    Given el usuario navega al homepage
    Then el Ã­cono del carrito es visible en el header
