Feature: Get a specific actor


  Scenario Outline: Get actor from DB

    Given an actor exists with id <actorID>
    When I request an actors details
    Then the webpage should show the actors "<firstname>" and "<lastname>"
    Examples:
      | actorID | firstname | lastname |
      | 1       | PENELOPE  | GUINESS  |
      | 5       | JOHNNY    | LOLLOBRIGIDA |