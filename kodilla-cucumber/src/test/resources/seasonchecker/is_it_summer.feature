Feature: Is it Summer? Everybody likes Summer

  Scenario Outline: Checking if date falls in Summer

    Given today is day <day> of month <month>
    When  I ask whether it's Summer
    Then  I should be told "<answer>"

    Examples:
      | month | day | answer       |
      | 1     | 2   | Nope         |
      | 2     | 10  | Nope         |
      | 5     | 5   | Nope         |
      | 6     | 20  | Yes! Summer! |
      | 6     | 21  | Yes! Summer! |
      | 7     | 15  | Yes! Summer! |
      | 8     | 1   | Yes! Summer! |
      | 8     | 23  | Yes! Summer! |
      | 9     | 23  | Yes! Summer! |
      | 9     | 24  | Yes! Summer! |
      | 12    | 31  | Nope         |
