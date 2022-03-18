Feature: Insider Test Case

  @chrome
  Scenario: Apply New Position
    Given user is on homepage
    When user accepts all cookies
    And user clicks More menu in Navigation Bar
    Then user should see categories
    When user selects "Careers"
    Then user should see Careers page is opened
    And user should see location section is opened
    And user should see life at Insider section is opened
    And user should see teams section is opened
    When user clicks see all teams button
    And user selects Quality Assurance
    Then user should see Quality Assurance Careers page
    When user clicks see all QA jobs
    Then user should see Open Position Page
    When user filters job by location "Istanbul, Turkey"
    And user filters jobs by department "Quality Assurance"
    Then user should see location filter are selected
    And user should see department filter are selected
    And user should see open positions
    And user should see locations of open positions are same with filter
    And user should see department of open positions are same with filter
    And user should see apply now buttons
    When user clicks 1. position apply now button
    Then user should see new Application redirect page



