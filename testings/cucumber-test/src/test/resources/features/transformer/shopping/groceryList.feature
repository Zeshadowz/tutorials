Feature: Grocery List

  Background: The shop store
    Given the following groceries:
      | name | price |
      | milk | 9 |
      | bread | 7 |
      | soap | 2 |
      | whisky | 8 |
      | water | 5 |

    Scenario: The menu
      When i check the price of the milk
      Then i become 9
