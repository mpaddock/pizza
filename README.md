# Pizza Toppings API
Provides an API for submission of a user's topping preferences and retrieval of a count of submitted toppings.

# Getting Started

You can launch the application by running:

	$ ./gradlew bootRun

## Available Endpoints
     GET /toppings/available
Returns the list of toppings available for submission.

     POST /toppings
Submit a user's topping preferences.
Body format: `
{"email":"test@test.com", "toppings": ["PEPPERONI"]}
`

     GET /toppings/submitted
Returns a map of submitted toppings to the number of unique users requesting that topping.

     GET /toppings/optimal
Returns a list of optimal toppings for any given pizza.

