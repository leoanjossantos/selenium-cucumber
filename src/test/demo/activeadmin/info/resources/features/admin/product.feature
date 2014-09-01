Feature: Admin system area for products

  In order to do sales
  An Admin must be able
  To manage products


  Scenario: Create Product
    When acesso a funcionalidade de produtos
    And crio o produto:
      | title                 | description         | price | image        |
      | Dark Side of the moon | Album do Pink Floyd | 123   | darkside.jpg |
    Then vejo a mensagem: "Product was successfully created."
    And os dados do novo produto são listados corretamente