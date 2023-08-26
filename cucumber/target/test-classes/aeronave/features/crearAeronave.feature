@Item
Feature: Crear nueva aeronave

  Scenario: Realizando la creacion de aeronave con datos validos
    Given crear aeronave valida
      | matricula  | PRUEBA23                             |
      | keyModelo | de4b96bb-2409-4fcd-9e42-beb5f79e20a7 |


    When se envia una solicitud para la creacion de una aeronave
    Then luego verifique que la respuesta HTTP sea 200
    And se devuelve una identificacion de la aeronave

  Scenario: Realizando la creacion de aeronave con datos invalidos
    Given crear aeronave invalida
      | matricula | PRUEBA |


    When se envia una solicitud para la creacion de una aeronave
    Then luego verifique que la respuesta HTTP sea 400

# Scenario: Perform a failed item creation
#   Given an item with invalid details
#     | KeyCargo | ASD |
#   When request is submitted for item creation
#   Then verify that the Item HTTP response is 500
