# This project is a (mainly) Java Servlet MVC web application that allows users to sign up as students or landlords and provides different views and user-specific functionalities based on their roles. 

## Technologies
- Java Servlet MVC, Web API
- Languages: Java, HTML, CSS, JavaScript, SQL
- OOP, Design Pattern
- Database Cloud Service
- Apache Tomcat Server
- Workspace: Eclipse, MySQL, Visual Studio Code, Google's tools, GitHub, Diagram.net

## Main features
- Show rooms from database
- Log in, Log out, Sign up
- Show room's details with map
- Search and filter rooms
- User filter

### Student:
- Add room to wish-list
- Send inspection request

### Landlord:
- Upload, update, delete room
- Receive inspection request via email
- View inspection history

## Design
- UI/UX design inspired by free template Hotelier 
- Database design normalization to 3NF

## Instalation
- Eclipse https://www.eclipse.org/downloads/
- Apache Tomcat Version 8.5 https://tomcat.apache.org/download-80.cgi

# Project Demonstration: 

### Register: 
- User can sign up as student or landlord
- User will be verified if it has been existed
- Password will be encrypted
![](https://github.com/JPhan1106/Hommie/blob/main/Register.jpg)
### Log in: 
- User role will be checked to be directed to a propriate view
![](https://github.com/JPhan1106/Hommie/blob/main/login.jpg)

### Student's view:
#### Homepage
![](https://github.com/JPhan1106/Hommie/blob/main/homepage%20-%20student%20and%20guest.jpg)
#### Search and filter rooms, view room list after search
![](https://github.com/JPhan1106/Hommie/blob/main/Search.jpg)
![](https://github.com/JPhan1106/Hommie/blob/main/Room%20List.jpg)
#### View details of each room with map and send inspection request to landlord
![](https://github.com/JPhan1106/Hommie/blob/main/room%20details.jpg)
![](https://github.com/JPhan1106/Hommie/blob/main/Inspection%20sent%20success.jpg)
#### Add favourite rooms to wishlist and view wishlist
![](https://github.com/JPhan1106/Hommie/blob/main/wishlist.jpg)
![](https://github.com/JPhan1106/Hommie/blob/main/add%20to%20wishlist.jpg)

### Guest's view: 
- Looks similar to Student's view, however, if they wish to send inspection request or add rooms to wishlist, they will have to login as student. 

### Landlord's view: 
#### Homepage
![](https://github.com/JPhan1106/Hommie/blob/main/homepage%20-%20landlord.jpg)
#### Create room
![](https://github.com/JPhan1106/Hommie/blob/main/Create%20room.jpg)
#### View all room list, available room list and rented room list 
![](https://github.com/JPhan1106/Hommie/blob/main/Landlord's%20listings%20.jpg)
#### View available room's details and functions including: Update, Check inspection history, Make room occupied, Delete
![](https://github.com/JPhan1106/Hommie/blob/main/Available%20room's%20details.jpg)
#### Update room
![](https://github.com/JPhan1106/Hommie/blob/main/Update%20room.jpg)
#### Delete room
![](https://github.com/JPhan1106/Hommie/blob/main/Delete%20Room.jpg)
#### Check inspection history: When a student sends a message or inspection request, the landlord receives an email notification. Additionally, the message or inspection request is saved in the inspection history and displayed in chronological order with the latest time displayed first.
![](https://github.com/JPhan1106/Hommie/blob/main/Inspection%20request%20history.jpg)
#### View rented room's details and make it available
![](https://github.com/JPhan1106/Hommie/blob/main/Rented%20room's%20details.jpg)


