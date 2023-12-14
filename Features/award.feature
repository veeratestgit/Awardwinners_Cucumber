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

Feature: Award Winners Functionality Test

Scenario: Perform Award winner Page Operations
     Given I am on the browser
     When I click on login link and login with "vijayvel10301@gmail.com" and "group@123"
     Then I click on Award winner section and sort books by discount
     And I click one the first book
     And I click on cart to see details and buy
     Then I choose the address for delivery
