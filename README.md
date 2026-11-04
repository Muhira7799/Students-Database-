# Students Database – Java JDBC

A Java console application that connects to a MySQL database, runs several queries on a `students` table, and inserts a new student record.

## Features

- Connects to a MySQL database using JDBC
- Displays all students whose last name (`LName`) starts with **J**
- Displays all countries starting with **R**
- Displays all information for the student with ID **2012**
- Displays all students enrolled in the **IT** course
- Inserts a new student record (`2026, Jolie, Java, Rwanda`)

## Requirements

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) (JDBC driver)

## Database Setup

The program expects a database named `University` with a `students` table containing the columns `Id`, `LName`, `Course`, and `Country`:

```sql
CREATE DATABASE University;
USE University;

CREATE TABLE students (
    Id INT PRIMARY KEY,
    LName VARCHAR(50),
    Course VARCHAR(50),
    Country VARCHAR(50)
);

INSERT INTO students (Id, LName, Course, Country) VALUES
(2010, 'James', 'IT',   'Rwanda'),
(2011, 'Smith', 'Math', 'Kenya'),
(2012, 'Jean',  'IT',   'Uganda'),
(2013, 'Ruth',  'Law',  'Rwanda');
```

## Configuration

The connection settings are set in `Students.java`:

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/University",
    "root",
    ""
);
```

Change the URL, username, and password to match your MySQL setup.

## Getting Started

### Compile

```bash
javac Students.java
```

### Run

Include the MySQL Connector/J jar on the classpath (replace the jar name with your version):

```bash
# Windows
java -cp ".;mysql-connector-j-8.x.x.jar" Students

# Linux / macOS
java -cp ".:mysql-connector-j-8.x.x.jar" Students
```

## Sample Output

Using the sample data above:

```
Names starting with J:
2010 James IT Rwanda
2012 Jean IT Uganda
Countries starting with R:
Rwanda
Rwanda
Student with ID 2012:
2012 Jean IT Uganda
IT students:
2010 James IT Rwanda
2012 Jean IT Uganda
Student inserted successfully
```

## Queries Used

| Task | SQL |
|------|-----|
| Last names starting with J | `SELECT * FROM students WHERE LName LIKE 'J%'` |
| Countries starting with R | `SELECT * FROM students WHERE Country LIKE 'R%'` |
| Student with ID 2012 | `SELECT * FROM students WHERE Id = 2012` |
| IT students | `SELECT * FROM students WHERE Course = 'IT'` |
| Add a student | `INSERT INTO students (Id, LName, Course, Country) VALUES (2026, 'Jolie', 'Java', 'Rwanda')` |

## Notes

- The insert uses a fixed ID (`2026`). If `Id` is a primary key, running the program a second time will fail with a duplicate entry error, which the program prints as a message.
- The "countries starting with R" query lists a country once per matching student, so duplicates can appear.

## Possible Improvements

- Use `PreparedStatement` instead of `Statement` to prevent SQL injection
- Use `SELECT DISTINCT Country` to avoid duplicate countries
- Use try-with-resources to close connections automatically
- Move the repeated printing code into a helper method
- Store database credentials in a config file or environment variables

## Project Structure

```
.
├── Students.java
└── README.md
```

## Author

Your Name – [GitHub](https://github.com/<your-username>)
