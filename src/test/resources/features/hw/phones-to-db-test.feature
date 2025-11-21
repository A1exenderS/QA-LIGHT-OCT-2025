Feature: collect device data and store it into the database

  Scenario: Collect and save hovered phone card data
    Given the user opens the Allo main page
    When the user searches for "Samsung"
    Then at least 3 search results should be displayed
    When the user hovers the first 3 product cards
    Then the system saves each hovered item into the Phones database table
