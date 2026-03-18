Feature: FizzBuzz game
  A method takes a number and returns text based on divisibility rules

  Scenario Outline: FizzBuzz rules

    Given I have the number <number>
    When  I check the FizzBuzz result
    Then  the result should be "<result>"

    Examples:
      | number | result   |
      | 1      | None     |
      | 2      | None     |
      | 3      | Fizz     |
      | 4      | None     |
      | 5      | Buzz     |
      | 6      | Fizz     |
      | 7      | None     |
      | 9      | Fizz     |
      | 10     | Buzz     |
      | 15     | FizzBuzz |
      | 20     | Buzz     |
      | 30     | FizzBuzz |
      | 33     | Fizz     |
      | 45     | FizzBuzz |
      | 11     | None     |
