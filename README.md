# To Do List Application

## Overview

Using Intellij and Gradle, you will create a GUI-based desktop application to allow a user to manage multiple "todo"-type lists.

For [Part 1] of the assignment, the focus should have been on the design elements: **UML Class Diagrams, GUI Mock-Ups,** and **pseudocode**.

Now that the design is complete, [Part 2] of this assignment will focus on the implementation elements: **production and test code**. During this process, you *will* discover problems with your initial design. When these discoveries are made, you will need to go back and refine your initial design to address the problems. These changes must be included in the final submission.

## Directions

Your application **shall** satisfy the following requirements:

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
    
You **shall** use a `.gitignore` file to ensure your `.gradle` and `build` folders are not stored within Git.
- Your repository should contain the following files and directories (with all expected subdirectories and files)

~~~
/.idea/
/uml/
/gradle/
/src/
/.gitignore
/build.gradle
/gradlew
/gradlew.bat
/settings.gradle
~~~

You **shall** place your code within a package named `ucf.assignments`

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

Your application and unit tests **shall** be completely implemented and run without errors on the grader's machine

### Submission
You will submit a link to your GitHub page. Please ensure that your repository is private until 12 hours after the due date, at which point you may make it public. 
If the repository cannot be accessed, or if the provided link is invalid, you will receive a 0 - *please double-check your submission once it has been made*

Last submissions will receive a 0 according to the syllabus.

**NOTE**: All design artifacts from [Part 1] should be included in t [Part 2], except where they have been updated to reflect changes in your design.

### Grading Criteria
Point will be allocated according to the below rubric. Full points will only be awarded if your implementation is:
- based on your design
- satisfies the requirements
- passes your test cases
- abides by the rules of clean code as outlined in the module notes

Elements that are entirely missing or woefully incomplete will receive no credit

Scores will be deducted in the event of incomplete submissions or failure to follow directions

#### Bonus Credit
If your application allows the user to sort the list by the due date, you will earn 1 extra point for the test and 1 extra point for the implementation

### Rubric

- [x] [2 points] GitHub project has correct name
- [x] [2 points] GitHub project structure is correct
    - The correct folders are present or ignored as per assignment directions
    - Source code is within the correct package
- [x] UML Class diagram reflects a well planned design
    - [10 Points] Full credit will be given only if each class has a single responsibility, as evidenced by the attribute and method modifiers
    - [5 Points] Partial credit will be given if classes relate to multiple distinct responsibilities
    - [0 Points] No credit will be given if there are only one or two classes
- [x] GUI reflects a well planned design
    - [10 Points] Full credit will be given only if each required behavior is accessible from the GUI and the overall layout reflects the guidelines and practices as described by Microsoft or Mac
    - [5 Points] Partial credit will be given for a GUI that is difficult to use and/or navigate
    - [0 Points] No credit will be given if the GUI fails to support the application requirements
- [x] [10 Points] Application implementation reflects a well planned design and follows the "clean code" guidelines described in the course notes and the book Clean Code
    - [5 Points] Partial credit will be given if your code is hard to read, hard to understand, hard to follow, or yield incorrect results
    - [0 Points] No credit will be given if your application is incomplete or does not run on the grader's machine
- [x] [10 Points] Each required behavior has an associated JUnit test, and those tests pass when run against the solution 
    - [5 Points] Partial credit will be given if any tests are missing or fail when they are run
    - [0 Points] No credit will be given if all tests are missing or if all tests fail when they are run
- [x] [6 Points] Application design has been updated to reflect any changes in the requirements
- [x] [5 points] Provided user guide either from within the application or as a readme.md file on GitHub
