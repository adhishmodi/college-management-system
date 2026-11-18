# Advanced Java syllabus-to-feature mapping

This project demonstrates core Advanced Java topics without adding large frameworks.

| Advanced Java concept | Where it appears | How to explain it in viva |
|---|---|---|
| Servlet | servlet/ | Receives HTTP requests, calls application logic, and selects a response. |
| JSP | WEB-INF/views/ | Renders dynamic HTML on the server. |
| MVC | Model, servlet controllers, JSP views | Separates data, request handling, and presentation. |
| JDBC | dao/ and DBConnection | Connects Java code to MySQL and executes SQL. |
| PreparedStatement | DAO classes | Parameterizes SQL values and helps prevent SQL injection. |
| Session management | LoginServlet, LogoutServlet, AuthFilter | Keeps a user authenticated across multiple HTTP requests. |
| Cookies | Servlet container session cookie | The browser stores the session identifier; the server stores session data. |
| Servlet Filter | AuthFilter | Checks authentication before protected requests reach controllers. |
| CRUD | StudentDAO and StudentServlet | Creates, reads, updates, and deletes student records. |
| Exception handling | DAO and servlet layers | Handles database and request failures without exposing SQL to the user. |
| Validation | StudentServlet | Checks required values, email format, and semester range on the server. |
| Password security | PasswordUtil | Uses salted PBKDF2-HMAC-SHA256 hashes rather than storing plain-text passwords. |
| Maven | pom.xml | Manages dependencies and builds the WAR artifact. |
| Deployment | WAR on Tomcat 10.1 | Runs the web application in a servlet container. |

## Deliberate scope boundaries
The first runnable version does not include Spring, Hibernate, JSF, JavaMail, or a Swing desktop client. Those technologies would increase setup and viva complexity without being necessary for the agreed core project. Additional modules can be added after the first version builds and runs reliably.
