Feature: This feature contains all the scenarios related to booking ticket
  Scenario: Search for tickets between pune to hyderabad and print airline details
    Given Launch the site "https://www.ixigo.com"
    Then Verify the booking page
    And Enter From – "PNQ - Pune" , To – "HYD - Hyderabad" , Departure – "01/11/2020" , Return – "05/11/2020" , Travelers - "2"
    And Click on search button
    Then Verify the result page
    And Validate filter option for Stops, departure and Airlines – Select Non-Stop in Stops filter option
    Then Print the list of airlines details having fare < 5000