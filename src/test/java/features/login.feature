Feature:Book cart application demo

    Scenario:Login should be success

        Given User should navigate to the application
        And user should enter the username as "standard_user"
        And User should enter the password as "secret_sauce"
        And User should click the login button
        Then login should be success

    Scenario:Login should be fail

        Given User should navigate to the application
        And user should enter the username as "failuser"
        And User should enter the password as "failpass"
        And User should click the login button
        But login should be fail
