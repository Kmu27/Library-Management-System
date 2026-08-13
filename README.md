# Library Management System

A simple Java console application for managing books and library members.

## Features

- Add new books
- Add new members
- View all books and members
- Search for books and members by ID
- Borrow books
- Return books
- Prevent duplicate book and member IDs
- Validate user input
- Save books and members to files
- Load saved data when the application starts
- Preserve book availability status

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- File Handling
- Exception Handling
- Git
- GitHub

## Project Structure

```text
src/
├── Main.java
├── Book.java
├── Member.java
├── Library.java
└── FileManager.java
```

- `Main.java` - Runs the application and handles the user menu and input.
- `Book.java` - Represents a book and its availability status.
- `Member.java` - Represents a library member.
- `Library.java` - Manages books, members, borrowing, returning, and searching.
- `FileManager.java` - Saves and loads books and members from files.

## How to Run

1. Clone the repository.
2. Open a terminal inside the project folder.
3. Compile the Java files:

```bash
javac -d bin src/*.java
```

4. Run the application:

```bash
java -cp bin Main
```

## Future Improvements

- Add due dates for borrowed books
- Track which member borrowed each book
- Add a graphical user interface (GUI)
- Use a database instead of text files

## Author

Created as a Java learning project to practice OOP, file handling, input validation, and Git/GitHub.git status