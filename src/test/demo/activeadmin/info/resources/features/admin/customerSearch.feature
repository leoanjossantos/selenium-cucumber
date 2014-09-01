Feature: As admin I can manage customer

  In order to do sales
  As Admin must be able
  To manage customer


  Scenario: Search invalid email
    Given I am functionality of the customer search
    When Search for:
      | username   | leosantos          |
      | email      | leoanjossantos.com |
      | begin_date |                    |
      | end_date   |                    |
    Then Should see the message: "No Customers found"


  Scenario: Search first date greater than last date
    Given I am functionality of the customer search
    When Search for:
      | username   |            |
      | email      |            |
      | begin_date | 2014-08-20 |
      | end_date   | 2014-08-10 |
    Then Should see the message: "No Customers found"


  Scenario: Search with all fields filled
    Given I am functionality of the customer search
    When Search for:
      | username   | leosantos             |
      | email      | leoanjossantos@tw.com |
      | begin_date | date today            |
      | end_date   | date today            |
    Then I must see the customer in list
      | username   | leosantos             |
      | email      | leoanjossantos@tw.com |
      | begin_date | date today            |
      | end_date   | date today            |


  Scenario: Verify the button Clear Filters
    Given I am functionality of the customer search
    When fill the fieldes:
      | username   | leosantos             |
      | email      | leoanjossantos@tw.com |
      | begin_date | 2014-08-20            |
      | end_date   | 2014-08-20            |
    And clear the fields
    Then The fields are empty

