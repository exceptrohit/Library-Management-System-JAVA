# Library-Management-System-JAVA
**DBMS** project using **Java** Swing GUI and **MYSQL** database. <br />
A library management system is a software application that keeps track of the library's records. It comprises information such as the number of books available in the library, the number of books issued, the number of books returned or renewed, and late fine charge records, among other things.
Library Management Systems  assists in the maintenance of a database that is used to enter new books and track books borrowed by members, track return requests generated by members as well as their due dates. It also relieves the librarian's manual record-keeping burden. 

# UML class diagram
![](Output%20Images/class_diagram.png)

## Actors:
The actors include the following: 
* Admin / Librarian 
* User / Student 

## Features

- Login screen calls two different dashboards for both **Admin** and **Student**
- New student registration can be done using Register button
- Admin/librarian can **Issue**, **Return** or **Add Book**
- Admin can view of all issued and available books through respective JTables 
- Admin has information of Return Requests made by students  
- Student/User can view his/her issued books (book name,book Id, Fine, Due Date)
- Student can make return request as well as cancel the request.
- Student can change his/her Password

## Additional Funtionalities

**Admin Dashboard** provides these additional functionalities :

- Displaying all books available to be issued in a Table
- Table has functionality of row selection for Book Id and Student ID on click using JTable row selection listener
- Table has highlighted rows representing return requests generated by recipient.
 
**Student Dashboard** provides these additional functionalities :
- Displaying all books issued by the student with informations such as Book Id, Fine, Due Date,etc.
- Table has functionality of row selection for Book Id on click using JTable row selection listener
- Table has highlighted rows representing return requests generated by recipient. 

### Default Login Credentials as Admin
| UserID  | Password |
| ------------- | ------------- |
| admin  | **null**  |

For admin Login just type 'admin' as username (Leave password blank)

### Some Login Credentials as student
| UserID  | Password |
| ------------- | ------------- |
| 1  | a |
| 2  | b |
| 6  | pass2021 |


###  Login Screen:

![](Output%20Images/login.jpg)

###  Register new student

![](Output%20Images/register.jpg)


### User Login 
![](Output%20Images/student.jpg)

### Change Password
![](Output%20Images/changepass.jpg)

###  Admin 
![](Output%20Images/admin.jpg)

### Return: Admin 
![](Output%20Images/return.jpg)

### Issue: Admin 
![](Output%20Images/issue.jpg)

### Add Book: Admin 
![](Output%20Images/addbook.jpg)

Copyright © 2021 Rohit Ranjan 
