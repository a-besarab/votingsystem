[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ba7049ca4b6b4fb08a8623195f389714)](https://www.codacy.com/app/a-besarab/votingsystem?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=a-besarab/votingsystem&amp;utm_campaign=Badge_Grade)

##Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) without frontend.

The task is:

Build a voting system for deciding where to have lunch.
* 2 types of users: admin and regular users
* Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
* Menu changes each day (admins do the updates)
* Users can vote on which restaurant they want to have lunch at
* Only one vote counted per user
* If user votes again the same day:
  * If it is before 11:00 we assume that he changed his mind.
  * If it is after 11:00 then it is too late, vote can't be changed
Each restaurant provides new menu each day.

##User commands:
 #### Profile commands:
  * GET (Get current profile)
  <pre> http://localhost:8080/users</pre>
  * DELETE (Delete current profile)
  <pre> http://localhost:8080/users</pre>
  * PUT (Update current profile)
  <pre>http://localhost:8080/users
  {
     "name": "ModUser",
     "email": "modemailuser@yandex.ru",
     "password": "password"
  }  </pre>
#### Restaurant commands:
  * GET (Get restaurants with today menu)
  <pre> http://localhost:8080/restaurants/today</pre>
  * GET (Get restaurant by id = 100002)
  <pre> http://localhost:8080/restaurants/100002</pre>
#### Vote commands:
  * GET (Show personal today vote)
  <pre> http://localhost:8080/votes</pre>
  * POST (Vote for the restaurant by id = 100002)
  <pre> http://localhost:8080/votes/100002</pre>

##Admin commands:
####Profile commands:
  * GET (Get all profiles)
    <pre> http://localhost:8080/admin/users</pre>
  * GET (Get profile by id = 100001)
    <pre> http://localhost:8080/admin/users/100001</pre>
  * DELETE (Delete profile by id = 100001)
    <pre> http://localhost:8080/admin/users/100001</pre>
  * PUT (Update profile with id = 100001)
    <pre> http://localhost:8080/admin/users
    {
       "id": 100001,
       "name": "UpdatedAdmin",
       "email": "admin@gmail.com",
       "password": "admin"
    }</pre>
  * POST (Create new profile)
    <pre> http://localhost:8080/admin/users
    {
    "name": "NewUser",
    "email": "newuser@gmail.com",
    "password": "password"
    }</pre>
####Dish commands:
  * GET (Get all dishes by restaurant id = 100002)
    <pre> http://localhost:8080/admin/restaurants/100002/dishes</pre>
  * GET (Get dish by restaurant id = 100002 and dish id = 100006)
    <pre> http://localhost:8080/admin/restaurants/100002/dishes/100006</pre>
  * GET (Get today dish by restaurant id = 100002)
    <pre> http://localhost:8080/admin/restaurants/100002/dishes/today</pre>
  * DELETE (Delete dish from restaurant id =100002 by id = 100006)
    <pre> http://localhost:8080/admin/restaurants/100002/dishes/100006</pre>
  * PUT (Update dish from restaurant id =100002 by id = 100006)
    <pre> http://localhost:8080/admin/restaurants/100002/dishes/100006
    {
    "name": "Updated dish",
    "price": 336,
    "date": "2019-05-16"
    }</pre>
  * POST (Create new dish restaurant id = 100002)
    <pre> http://localhost:8080/admin/restaurants/100002/dishes
    {
    "name": "New dish",
    "price": 555,
    "date": "2019-05-16"
    }</pre>
####Restaurant commands:
  * GET (Get all restaurants)
    <pre> http://localhost:8080/admin/restaurants</pre>
  * GET (Get by id = 100002)
    <pre> http://localhost:8080/admin/restaurants/100002</pre>
  * GET (Get restaurants with today dishes)
    <pre> http://localhost:8080/admin/restaurants/today</pre>
  * DELETE (Delete restaurant by id = 100002)
    <pre> http://localhost:8080/admin/restaurants/100002</pre>
  * PUT (Update restaurant by id = 100002)
    <pre> http://localhost:8080/admin/restaurants/100002
    {
       "name": "Updated restaurant",
       "phone": "9999999",
       "address": "updated address"
    }</pre>
  * POST (Create new restaurant)
    <pre> http://localhost:8080/admin/restaurants
    {
       "name": "New restaurant",
       "phone": "88888888",
       "address": "new address"
    }</pre>  
####Vote commands
  * GET (Get all votes)
    <pre> http://localhost:8080/admin/votes</pre>
  * GET (Get vote by id = 100022)
    <pre> http://localhost:8080/admin/votes/100022</pre>
  * GET (Get all today votes)
    <pre> http://localhost:8080/admin/votes/today</pre>
  * DELETE (Delete vote by id = 100022)
    <pre> http://localhost:8080/admin/vote/100022</pre>