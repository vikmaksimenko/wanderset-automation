Feature: Sign In

  Scenario: Top Menu "SHOP" validations
    Given navigate to "https://wanderset.com"
    When  hoover "shop" top menu
    Then  submenu item "All footwear" should be visible
    And   "All footwear" submenu items should be links
    And   "All footwear" submenu should have 6 items
