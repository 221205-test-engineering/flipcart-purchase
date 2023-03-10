Feature: Guest visited the flipcart website
  Scenario: Phone purchase
    Given User is in the flipcart website
    When User search for the product name with memory size
    When User select the product
    When User add product to the cart
#    When User select place the order
#    Then Order should be reflected in the users my orders
