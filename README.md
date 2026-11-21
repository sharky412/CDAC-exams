# CDAC Lab Exams (2024)

My solved answers to the CDAC lab exams from 2024. Each folder or file is a separate exam, covering SQL, data structures, C++, core Java with JDBC, a React + Express web app, and ASP.NET Core MVC.

![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)
![C++](https://img.shields.io/badge/C%2B%2B-00599C?logo=cplusplus&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)
![Node.js](https://img.shields.io/badge/Node.js-339933?logo=nodedotjs&logoColor=white)
![Express](https://img.shields.io/badge/Express-000000?logo=express&logoColor=white)
![React](https://img.shields.io/badge/React-18-61DAFB?logo=react&logoColor=black)
![.NET](https://img.shields.io/badge/.NET-8.0-512BD4?logo=dotnet&logoColor=white)
![C#](https://img.shields.io/badge/C%23-239120?logo=csharp&logoColor=white)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## What's inside

| Path | Exam | Description |
| --- | --- | --- |
| `DBT.sql` | Database Technologies | MySQL queries on `OS` and `Mobile` tables (create, insert, joins and subqueries), with result output |
| `DS-240344220075/Main.java` | Data Structures | Menu-driven product catalogue using a circular doubly linked list: add, display all, find by ID, delete first, edit name |
| `q1.cpp` | C++ | Menu-driven shop billing program: list products, add customers and products, purchase and checkout |
| `exam_83998/` | Core Java | Console app using JDBC and MySQL with DAO and entity classes for users and bank accounts (add user, add/display/delete/search accounts) |
| `MERN Application/` | Web programming | Express + `mysql2` back end (`/user/register`, `/user/search`) and a React front end with Home, Register and Search pages |
| `dotnet 240344220085/ExamApp/` | .NET | ASP.NET Core MVC app (.NET 8, `Microsoft.Data.SqlClient`) with user CRUD and login views, plus a book listing |

## Getting started

```bash
git clone https://github.com/sharky412/CDAC-exams.git
cd CDAC-exams
```

**SQL:** run the statements in `DBT.sql` in a MySQL client.

**Data structures (Java):**

```bash
cd DS-240344220075
javac -d . Main.java
java exam.Main
```

**C++:**

```bash
g++ q1.cpp -o q1 && ./q1
```

**Core Java + JDBC:** import `exam_83998/` into Eclipse, add the MySQL Connector/J driver, set your database details in `src/com/util/Db.java`, and run `test.tester`.

**React + Express app:** the back end needs a MySQL database with a `Customer_TB` table; set your connection details in `backend/db.js`.

```bash
# back end (port 4002)
cd "MERN Application/backend"
npm install express cors mysql2
node server.js

# front end
cd "MERN Application/frontend"
npm install
npm start
```

**ASP.NET Core MVC:** open `dotnet 240344220085/ExamApp/ExamApp.sln` in Visual Studio, point the SQL Server connection in `Models/` to your instance, then run:

```bash
cd "dotnet 240344220085/ExamApp"
dotnet run
```

## License

Released under the [MIT License](LICENSE).
