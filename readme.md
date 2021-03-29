# Project Title

Terzo - Task Management can able to create, update, delete, get, list and get the status.

## Getting Started

1. Download the eclipse or any IDE
2. Download and Setup the lombok jar in eclipse
3. Import the project as maven
4. Download the postman
5. connect the postgres database
6. Execute the below query in db
	create table task(id serial PRIMARY KEY,
				  name VARCHAR(100) NOT NULL, 
				  userid VARCHAR(100) NOT NULL, 
				  start_date VARCHAR(100) NOT NULL,
				  completion_date VARCHAR(100) NOT NULL, 
				  status VARCHAR(100) NOT NULL
				  );
7. Below APIs are how to execute in postman


### Add Task: POST CALL

URL : http://localhost:8080/task/user

Input:

{
    "task": [
        {
            "name": "sample",
            "user": "sample@gmail.com",
            "startDate": "2019",
            "completionDate": "2020",
            "status": "in_progress"
        }
    ]
}

output:
{
    "message": "user added successfully"
}

b. Update Task: PUT CALL
===========================
URL : http://localhost:8080/task/user
Sample Input: 
{
    "task": [
        {
            "name": "sample",
            "user": "sample@gmail.com",
            "startDate": "2019",
            "completionDate": "2020",
            "status": "started"
        }
    ]
}
output:
{
    "message": "user updated successfully"
}

c. Get Task: GET CALL
=====================
URL : http://localhost:8080/task/user?name=sample@gmail.com
output:
{
    "task": [
        {
            "name": "sample",
            "user": "sample@gmail.com",
            "startDate": "2019",
            "completionDate": "2020",
            "status": "started"
        }
    ]
}

d. Get list of Task: GET CALL
=============================
URL : http://localhost:8080/task/users
output:
{
    "task": [
        {
            "name": "sample",
            "user": "sample@gmail.com",
            "startDate": "2019",
            "completionDate": "2020",
            "status": "started"
        },
        {
            "name": "sample2",
            "user": "sample2@gmail.com",
            "startDate": "2019",
            "completionDate": "2020",
            "status": "in-progress"
        }
    ]
}




e. Delete Task: DELETE CALL
===========================
URL : http://localhost:8080/task/user/mani@gmail.com
output:
{
    "message": "User is removed from db successfully"
}

f. Get Status: GET CALL
======================= 
URL : http://localhost:8080/task/status
sample output:
{
    "review": 2,
    "completed": 2,
    "yet_to_start": 0,
    "in_progress": 2
}

## swagger url
http://localhost:8080/swagger-ui.html

