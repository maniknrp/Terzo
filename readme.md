# Project Title

Terzo - Task Management can able to create, update, delete, get, list and get the status of all tasks

## Getting Started

1. Download the eclipse or any IDE
2. Download and Setup the lombok jar in eclipse
3. Import the project as maven
4. Download the postman
5. setup the postgres database
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
            "startDate": "2019-29-03",
            "completionDate": "2020-29-03",
            "status": "in_progress"
        }
    ]
}

output:

{
    "message": "user added successfully"
}

### Update Task: PUT CALL

URL : http://localhost:8080/task/user

Input: 

{
    "task": [
        {
            "name": "sample",
            "user": "sample@gmail.com",
            "startDate": "2019-29-03",
            "completionDate": "2020-29-03",
            "status": "started"
        }
    ]
}

output:

{
    "message": "user updated successfully"
}

### Get Task: GET CALL

URL : http://localhost:8080/task/user?name=sample@gmail.com

output:

{
    "task": [
        {
            "name": "sample",
            "user": "sample@gmail.com",
            "startDate": "2019-29-03",
            "completionDate": "2020-29-03",
            "status": "started"
        }
    ]
}

### Get list of Task: GET CALL

URL : http://localhost:8080/task/users

output:

{
    "task": [
        {
            "name": "sample",
            "user": "sample@gmail.com",
            "startDate": "2019-29-03",
            "completionDate": "2020-29-03",
            "status": "started"
        },
        {
            "name": "sample2",
            "user": "sample2@gmail.com",
            "startDate": "2019-29-03",
            "completionDate": "2020-29-03",
            "status": "in-progress"
        }
    ]
}


### Delete Task: DELETE CALL

URL : http://localhost:8080/task/user/mani@gmail.com

output:

{
    "message": "User is removed from db successfully"
}

### Get Status: GET CALL

http://localhost:8080/task/all?status=completed&assignee=venkat@gmail.com

output:

{
    "task": [
        {
            "name": "venkat",
            "user": "venkat@gmail.com",
            "startDate": "2019-29-03",
            "completionDate": "2019-30-03",
            "status": "completed"
        }
    ]
}

## swagger url
http://localhost:8080/swagger-ui.html

