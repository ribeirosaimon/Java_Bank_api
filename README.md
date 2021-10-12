# Java_Bank_api
Java Bank Jr Api

How to Run:

create DB in Mysql: java_bank

Get all user: http://localhost:8080/api/account/v1
Get one user: http://localhost:8080/api/account/v1/1

Create a new User, send:
{
    "name":"saimon",
    "password":"test1"
}
to: http://localhost:8080/api/account/v1

Delete one user: http://localhost:8080/api/account/v1/1

deposit money to user: http://localhost:8080/api/movement/v1/{ ID }/deposit/{ VALUE }
withdraw: http://localhost:8080/api/movement/v1/{ ID }/withdraw/{ VALUE }

balance limit: -200
