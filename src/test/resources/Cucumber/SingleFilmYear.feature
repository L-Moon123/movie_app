Feature: Get a specific film release year


  Scenario Outline: Get film year from DB

    Given a film exists with the id <filmID>
    When I request a film year
    Then the webpage should show the film release year <release_year>
    Examples:
      | filmID | release_year |
      | 12       | 2006  |
      | 1005     | 1999  |
