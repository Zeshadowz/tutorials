Feature: Calculator

  Scenario: Simple
    Given the two number 12 and 13
    When i add them
    Then the result muss be 25


    Scenario Outline: Outline Calculator
      Given the two number <num1> and <num2>
      When i add them
      Then the result muss be <result>

      Examples:
      | num1 | num2 | result |
      | 10 | 10 | 20 |
      | -3 | 5 | 2 |
      | -10 | -13 | -23 |
