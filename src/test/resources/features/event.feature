@Event
Feature: Event
  As a user i want to purchase event ticket

  @GoEvent
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

#  @Login
#  Scenario Outline: As a user i can login via login button in Event category page
#    Given User is already in event ticket page
#    When User click Log in button
#    Then User redirected to login page
#    When User input "<email>" to email field
#    And User click log in button
#    Then User should see password field
#    When User input "<password>" to password field
#    And User click log in
#    Then User redirected to Event product page
#
#    Examples:
#      | email                          | password   |
#      | realfranklinrichards@gmail.com | @ndr0n3T10 |

  @Sort
  Scenario Outline: As a user i can sort event ticket
    Given User is already in event ticket page
    When User sort event by "<sortBy>"
    Then User should see "<ticket>" on event ticket page

    Examples:
      | sortBy           | ticket               |
      | Terdekat         | IBL TOKOPEDIA        |
      | Terpopuler       | NICHKHUN             |
      | Harga Terendah   | Batam Light Festival |
      | Harga Tertinggi  | Liverpool FC         |
      | Rating Tertinggi | Pandora Nightmare    |
      | Baru Ditambahkan | BRI LIGA 1           |

#  @Purchase
#  Scenario: As a user i can buy one of the event ticket
#    Given User is already in event ticket page
#    When User sort Event ticket by "Terdekat"
#    Then User should see Event Terdekat
#    When User click Pandora Nightmare Festival 2024
#    Then User redirected to Ticket Detail Page
#    When User click log in
#    Then User redirected to login page
#    When User input email to email field
#    And User click log in button
#    Then User should see password field
#    When User input password to password field
#    And User click log in
#    Then User redirected back to Ticket Detail Page