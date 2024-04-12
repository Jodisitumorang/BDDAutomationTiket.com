@Event
Feature: Event
  As a user i want to purchase event ticket

  Scenario: As a user i can go to event ticket category by event button
    Given User is already in tiket.com website
    When User click Event button
    Then User redirected to Event product page

  @Filter
  Scenario Outline: As a user i can filter event ticket
    Given User is already in event ticket page
    When User filter event by "<filter>"
    Then User should see "<ticket>" on event ticket page

    Examples:
      | filter   | ticket        |
      | Seminar  | MARKETEERS    |
      | Konser   | TREASURE      |
      | Horor    | Pandora       |
      | Komedi   |               |
      | Olahraga | IBL TOKOPEDIA |
      | Pameran  | BLACK BOX     |