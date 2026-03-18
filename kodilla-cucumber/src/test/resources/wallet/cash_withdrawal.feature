Feature: Cash Withdrawal

  Scenario Outline: Successful withdrawal from a wallet
    Given I have deposited $<deposit> in my wallet
    When I request $<withdrawal>
    Then $<withdrawal> should be dispensed
    And the balance of my wallet should be $<remaining>

    Examples:
      | deposit | withdrawal | remaining |
      | 200     | 30         | 170       |
      | 500     | 500        | 0         |
      | 1000    | 1          | 999       |
      | 100     | 50         | 50        |
