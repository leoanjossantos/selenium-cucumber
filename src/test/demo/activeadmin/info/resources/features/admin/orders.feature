Feature: Verify filter of the Orders

  As Admin sould can
  to do search for Orders

  Scenario: Search for Total Price "Equals To"
    Given I am in functionality of search of the orders
    When Search for orders:
      | total_price   |       |
      | value         | 20.50 |
      | begin_checked |       |
      | end_checked   |       |
    Then sould see itens in list


  Scenario: Search for Total Price "Greater Than"
    Given I am in functionality of search of the orders
    When Search for orders:
      | total_price   | Greater Than |
      | value         | 20.50        |
      | begin_checked |              |
      | end_checked   |              |
    Then sould see itens in list


  Scenario: Search for Total Price "Less Than"
    Given I am in functionality of search of the orders
    When Search for orders:
      | total_price   | Less Than |
      | value         | 20.50     |
      | begin_checked |           |
      | end_checked   |           |
    Then sould see itens in list


  Scenario: Search informing invalid value
    Given I am in functionality of search of the orders
    When Search for orders:
      | total_price   |      |
      | value         | test |
      | begin_checked |      |
      | end_checked   |      |
    Then sould see itens in list

  Scenario: Search informing begin date less than end date
    Given I am in functionality of search of the orders
    When Search for orders:
      | total_price   |            |
      | value         |            |
      | begin_checked | 2014-08-30 |
      | end_checked   | 2014-08-20 |
    Then should see message "No Orders found"

  Scenario: Verify clear all fields
    Given I am in functionality of search of the orders
    When Search for orders:
      | total_price   |            |
      | value         | 99.99      |
      | begin_checked | 2014-08-30 |
      | end_checked   | 2014-08-20 |
    Then I see all empty fields