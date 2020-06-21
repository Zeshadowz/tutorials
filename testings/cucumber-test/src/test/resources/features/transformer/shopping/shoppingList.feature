Feature: Shopping List
  Background: The List
    Given the following shopping list:
    """shopping_list
    milk
    bread
    coffee
    soap
    """

    Scenario: Count the grocery
      When i count the groceries in the list
      Then i should have 4 items
