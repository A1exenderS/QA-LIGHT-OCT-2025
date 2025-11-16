Feature: test my api + db setup

  Scenario: store random people to DB
    Given I store database row count as "initial_row_count"
    Given I request 3 random people from API as "random_group_1"
    When I store "random_group_1" in DB and new entries count is "new_entries_count"
    Then DB "initial_row_count" has "new_entries_count" more rows