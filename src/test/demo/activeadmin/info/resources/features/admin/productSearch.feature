Feature: Admin system area search products

  As admin should
  find products

  Scenario: Search for title
    Given I am in functionality of search of the products
    When informing the datas the product:
      | title                | Metaprogramming Ruby: Program Like the Ruby Pros |
      | description          |                                                  |
      | author               |                                                  |
      | price                |                                                  |
      | value                |                                                  |
      | begin_date_available |                                                  |
      | end_date_available   |                                                  |
      | image_file_name      |                                                  |
      | begin_created        |                                                  |
      | end_created          |                                                  |
      | begin_update         |                                                  |
      | end_update           |                                                  |
    Then should see the product in list

  Scenario: Search for description
    Given I am in functionality of search of the products
    When informing the datas the product:
      | title                |                     |
      | description          | Album do Pink Floyd |
      | author               |                     |
      | price                |                     |
      | value                |                     |
      | begin_date_available |                     |
      | end_date_available   |                     |
      | image_file_name      |                     |
      | begin_created        |                     |
      | end_created          |                     |
      | begin_update         |                     |
      | end_update           |                     |
    Then should see the product in list

  Scenario: Search for author
    Given I am in functionality of search of the products
    When informing the datas the product:
      | title                |                |
      | description          |                |
      | author               | Paolo Perrotta |
      | price                |                |
      | value                |                |
      | begin_date_available |                |
      | end_date_available   |                |
      | image_file_name      |                |
      | begin_created        |                |
      | end_created          |                |
      | begin_update         |                |
      | end_update           |                |
    Then should see the product in list

  Scenario: Search for Price Equal To = 28.2
    Given I am in functionality of search of the products
    When informing the datas the product:
      | title                |      |
      | description          |      |
      | author               |      |
      | price                |      |
      | value                | 28.2 |
      | begin_date_available |      |
      | end_date_available   |      |
      | image_file_name      |      |
      | begin_created        |      |
      | end_created          |      |
      | begin_update         |      |
      | end_update           |      |
    Then should see the product in list

  Scenario: Search for Price Greater than =
    Given I am in functionality of search of the products
    When informing the datas the product:
      | title                |              |
      | description          |              |
      | author               |              |
      | price                | Greater than |
      | value                | 28.2         |
      | begin_date_available |              |
      | end_date_available   |              |
      | image_file_name      |              |
      | begin_created        |              |
      | end_created          |              |
      | begin_update         |              |
      | end_update           |              |
    Then should see the product in list

  Scenario: Search for Price Less than
    Given I am in functionality of search of the products
    When informing the datas the product:
      | title                |           |
      | description          |           |
      | author               |           |
      | price                | Less than |
      | value                | 28.2      |
      | begin_date_available |           |
      | end_date_available   |           |
      | image_file_name      |           |
      | begin_created        |           |
      | end_created          |           |
      | begin_update         |           |
      | end_update           |           |
    Then should see the product in list


  Scenario: Search for Date Begin Available less than Date End Available
    Given I am in functionality of search of the products
    When informing the datas the product:
      | title                |            |
      | description          |            |
      | author               |            |
      | price                |            |
      | value                |            |
      | begin_date_available | 2014-08-30 |
      | end_date_available   | 2014-08-10 |
      | image_file_name      |            |
      | begin_created        |            |
      | end_created          |            |
      | begin_update         |            |
      | end_update           |            |
    Then Should see the message for search product:"No Products found"

  Scenario: Search for image file name
    Given I am in functionality of search of the products
    When informing the datas the product:
      | title                |                                                |
      | description          |                                                |
      | author               |                                                |
      | price                |                                                |
      | value                |                                                |
      | begin_date_available |                                                |
      | end_date_available   |                                                |
      | image_file_name      | beginning-ruby-from-novice-to-professional.jpg |
      | begin_created        |                                                |
      | end_created          |                                                |
      | begin_update         |                                                |
      | end_update           |                                                |
    Then should see the product in list

  Scenario: Search for Date Begin Created less than Date End Created
    Given I am in functionality of search of the products
    When informing the datas the product:
      | title                |            |
      | description          |            |
      | author               |            |
      | price                |            |
      | value                |            |
      | begin_date_available |            |
      | end_date_available   |            |
      | image_file_name      |            |
      | begin_created        | 2014-08-30 |
      | end_created          | 2014-08-10 |
      | begin_update         |            |
      | end_update           |            |
    Then Should see the message for search product:"No Products found"

  Scenario: Search for Date Begin Created less than Date End Created
    Given I am in functionality of search of the products
    When informing the datas the product:
      | title                |            |
      | description          |            |
      | author               |            |
      | price                |            |
      | value                |            |
      | begin_date_available |            |
      | end_date_available   |            |
      | image_file_name      |            |
      | begin_created        |            |
      | end_created          |            |
      | begin_update         | 2014-08-30 |
      | end_update           | 2014-08-10 |
    Then Should see the message for search product:"No Products found"

  Scenario: Verify fields of search are empty
    Given I am in functionality of search of the products
    When informing the datas the product:
      | title                | The Well-Grounded Rubyist                      |
      | description          | na                                             |
      | author               | David A. Black                                 |
      | price                | Greater than                                   |
      | value                | 98.98                                          |
      | begin_date_available | 2014-08-10                                     |
      | end_date_available   | 2014-08-30                                     |
      | image_file_name      | beginning-ruby-from-novice-to-professional.jpg |
      | begin_created        | 2014-07-10                                     |
      | end_created          | 2014-07-20                                     |
      | begin_update         | 2014-08-10                                     |
      | end_update           | 2014-08-30                                     |
    And Clear the fields of the products search
    Then Should see the empty fields