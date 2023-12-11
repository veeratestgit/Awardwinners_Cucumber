Feature: Award Winners Test

Scenario: Perform Award Page Operations
    Given I navigate to the bookswagon website
    When I click on the award link
    And I sort books by discount
    And I click on first book to buy
    Then I click on cart to see details
    And I click on buy
    Then I login with "vijayvel10301@gmail.com" and "group@123"
    And  I click on address save and continue
