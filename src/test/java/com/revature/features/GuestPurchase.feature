Feature: Guest visited the flipcart website
  Scenario Outline: Phone purchase
    Given User is in the flipcart website
    When User search for the "<productName>"
    When User search for the required "<memorySize>"
    When User select the product
    When User add product to the cart
    When User select place the order
    Then Order should be reflected in the users my orders

    Examples:
      | productName     | memorySize |
      | APPLE iPhone 14 | 128 GB ROM |