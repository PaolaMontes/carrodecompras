#Author: paolamontest@gmail.com


Feature: Compra producto con descuento
  Yo como usuaria deseo realizar la compra de un producto con el 20 de descuento

  @tag1
  Scenario Outline: Realizar compra exitosa
    Given Navego a la pagina
    And Ingreso mi <usuario> y <contraseña>
    When  Realizo la compra y doy click en comprar
    Then El sistema me presenta el  mensaje de Exito 
    
    Examples: 
      | usuario  | contraseña |
      | paolamontest@gmail.com |GJvAG0OFYedoENzDuvrBhQ==| 