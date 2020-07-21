Feature: Login

Scenario: MCYODA-7317_C&C_Regression_Registered

	Given customer starts JCPenney session
	Then customer creates new account with "GitTestJCP@example.com" and "Automation006" for checkout

	Then customer closes the current browser session
	
