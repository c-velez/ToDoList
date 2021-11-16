# To Do List Application

## Overview

The purpose of this application is to allow a user to create an itemized To Do List of at least 100 unique items. The application will allow a user to add an item with a description, a due date, and a completion status. The user will be able to edit the item description, date, and completion status. Additionally, the user will be able to save their list and open it from with in the application.

## Directions

The application **shall** satisfy the following requirements:

### Application Requirements
- [x] Rqmt 1: The application shall manage a single list of items
    - [x] The list shall have the capacity to store at least 100 unique items
- [x] Rqmt 13: A user shall be able to save the list (and all of its items) to external storage
  - [x] JUnit Test
- [x] Rqmt 14: A user shall be able to load a list (and all of its items) from external storage
  - [x] JUnit Test

### Item Requirements
- [x] Rqmt 2: An item shall have a description
  - [x] A description shall be between 1 and 256 characters in length
- [x] Rqmt 3: An item shall have a due date
  - [x] A due date shall be a valid date within the Gregorian Calendar
  - [x] A due date shall be displayed to users in the format: YYY-MM-DD
  
- [x] Rqmt 7: A user shall be able to edit the description of an item within the list
  - [x] JUnit Test
- [x] Rqmt 8: A user shall be able to edit the due date of an item within the list
  - [x] JUnit Test
- [x] Rqmt 9: A user shall be able to mark an item in the list as either complete or incomplete
  - [x] JUnit Test

### List Requirements
- [x] Rqmt 4: A user shall be able to add a new item to the list
  - [x] JUnit Test
- [x] Rqmt 5: A user shall be able to remove an item from the list
  - [x] JUnit Test
- [x] Rqmt 6: A user shall be able to clear a list of all items
  - [x] JUnit Test

### Display Requirements
- [x] Rqmt 10: A user shall be able to display all existing items in the list
  - [x] JUnit Test
- [x] Rqmt 11: A user shall be able to display only incomplete items in the list
  - [x] JUnit Test
- [x] Rqmt 12: A user shall be able to display only completed items in the list
  - [x] JUnit Test
  
### User Experience Requirements
- [x] Rqmt 15: The application shall provide a help screen with direction on how to use the applications
    - [x] The help screen shall describe how execute each behavioral requirement provided by the application (e.g. add an item, remove an item, edit an item, etc)
    - [x] The help screen shall include a dedication to "Rey"
    - [x] As an alternative to creating a new window in the application, this help information can be provided in a markdown file called `readme.md` on your GitHub repository for this project.
    
You **shall** create a Class Diagram for your application using PlantUML. This diagram must be pushed to your Git repository along with your Java code.
- Each class within your diagram must list the attributes and methods defined within that class.
- You must store your *.puml files in a `uml` folder at the root level of your project

You **shall** create your application Graphical User Interface (GUI) using SceneBuilder and store the associated *.fxml files within your projects `resources` folder.

You **shall** include pseudocode in each of your methods
- This pseudocode will help you determine where and how your code should be broken up into classes and methods. If you have a comment describing what multiple statements accomplish, those statements probably need to be extracted into a method. If you find that your class has multiple methods which form subgroups that each do something completely different, you probably need to extract one of those subgroups into a new class.

You **shall** follow good programming practices, as outlines in the course notes for Module 2.
- You must decompose your solution into multiple classes, each of which will possess a single responsibility and will contain a series of highly cohesive methods (with each method having a single responsibility). You will receive no credit if your entire solution is within the `ucf.assignments.main` method.

You **shall** write your Java code in accordance with either the Oracle or Google Java coding standard.

You **shall** use JUnit5 to incorporate automated unit testing into your solutions
- You must create a unit test for each behavior specified in the application requirements
- You must include pseudocode in each test
