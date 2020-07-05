Feature: Store

  Background: The products store
    Given the store with the following products:
      | name   | price | quantity |
      | milk   | 0.79  | 10       |
      | water  | 0.15  | 33       |
      | bread  | 1.29  | 15       |
      | soap   | 2.49  | 16       |
      | coffee | 2.19  | 21       |
      | Beer   | 0.89  | 55       |
      | whisky | 29.99 | 4        |
      | wine   | 5.99  | 5        |
      | cheese | 1.29  | 12       |

  Scenario: Count item in the list:
    And I have the following shopping list:
    """shopping_list
    milk
    bread
    coffee
    """
    When I count items
    Then it should be 3

