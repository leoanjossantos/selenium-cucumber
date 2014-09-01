Feature: As admin I can manage customer

  In order to do sales
  As Admin must be able
  To manage customer

#  Background: Criar usuario
#    Given I create new customer:
#      | username      | leosantos             |
#      | email         | leoanjossantos@tw.com |
#      | password_hash | 1234                  |
#      | password_salt | 1234                  |


  Scenario: Register customer
    Given I am functionality from customer registration
    When I create new customer:
      | username      | leosantos             |
      | email         | leoanjossantos@tw.com |
      | password_hash | 1234                  |
      | password_salt | 1234                  |
    Then I must see the customer registration


  Scenario: Access with customer registered
    Given I am functionality from customer registration
    When eu logar com os dados:
      | email                 | password |
      | leoanjossantos@tw.com | 1234     |
    Then sould see message of the welcomes "Welcome leosantos!"