Feature: Display balance

  Scenario Outline: User checks the balance of their wallet
    Given there is $<balance> in my wallet
    When I check the balance of my wallet
    Then I should see that the balance is $<balance>

    Examples:
      | balance |
      | 100     |
      | 0       |
      | 999     |
