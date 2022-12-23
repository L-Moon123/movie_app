Feature: Get a specific film


  Scenario Outline: Get film from DB

    Given a film exists with id <filmID>
    When I request a film's details
    Then the webpage should show the film "<film_title>"
    Examples:
      | filmID | film_title |
      | 2       | ACE GOLDFINGER  |
      | 8       | AIRPORT POLLOCK    |