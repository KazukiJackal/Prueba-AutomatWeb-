@LoginLinio
Feature: Linio

  Scenario: Login a Linio
    Given estoy en la pagina de login de linio
    When digito mis datos de usuario "kevilew215@yasiok.com" y clave "123456###"
    And hago clic en el botón login
    And valida que la autenticación sea correcta mostrando el nombre "Carlos"
    And se muestra que inicié sesión correctamente
    And hago clic en la opción Mejores Calificados
    And selecciono un producto aleatorio
    And hago clic en el botón añadir al carrito
##17811333