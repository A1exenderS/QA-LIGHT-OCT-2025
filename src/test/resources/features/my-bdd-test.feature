Feature: test my api + db setup

  Scenario: store random people to DB
    Given I request 3 random people from API
    When I store those people in DB
    Then Then DB has 3 more entries