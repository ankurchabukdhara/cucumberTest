Feature: Test API using Cucumber and RestAssured

  @HappyFlow
  
  Scenario: Create a link using POST
    Given the URI is up and running
    When I do a POST on the URI using the payload for creating new link
    Then API returns the result with status code as 200
    And new link is created successully.
    
    
  Scenario Outline: Get All data using group Id
    Given the URI is up and running
    When I do a Get on the URI using a "<guid>"
    Then API returns the result with status code as 200
    And all data is fethced

    Examples: 
      | guid |
      |6ads34ra12j|

  Scenario Outline: Get All data using group Id in sorted order
    Given the URI is up and running
    When I do a Get on the URI using a "<guid>" and sort it using parameter
    Then API returns the result with status code as 200
    And all data is fethced in sorted order

    Examples: 
      | guid |
      |6ads34ra12j|

 # @NegativeFLow
 # Scenario Outline: Cannot Get data using group Id
 #   Given the URI is up and running
 #   When I do a Get on the URI using a "<guid>"
 #   Then API returns the result with status code as 403
 #   And all data is fethced.

 #   Examples: 
  #    | guid        |
 #     | 8ad56edc981 |
