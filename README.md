# College Management System

A beginner-friendly, professional Java web application for an Advanced Java course.

## Technology
- Java 21
- Jakarta Servlet 6.0 and JSP 3.1
- JDBC and MySQL 8+
- Maven WAR packaging
- Apache Tomcat 10.1
- MVC / three-tier architecture

## Features
- Admin and student authentication
- Secure password hashing (PBKDF2-HMAC-SHA256)
- Session-based login and logout
- Authentication filter
- Admin dashboard
- Student create, view, update, delete, and search
- Server-side validation and prepared SQL statements

## Build and run
1. Install JDK 21, Apache Maven, MySQL 8+, and Tomcat 10.1.
2. Create the database by running `database/schema.sql`.
3. Copy `src/main/resources/db.properties.example` to `src/main/resources/db.properties` and set your local MySQL password.
4. From the project root run `mvn clean package`.
5. Deploy `target/college-management-system.war` to Tomcat 10.1.
6. Open `http://localhost:8080/college-management-system/`.

NetBeans: choose **File → Open Project**, select the cloned project folder, wait for Maven dependencies to load, then use **Clean and Build**. Configure Tomcat 10.1 as the project server.

## Demo accounts
- Admin: `admin@example.com` / `Admin@123`
- Student: `student@example.com` / `Student@123`

Change these demo passwords before using the application outside a local classroom demo.

## Project layout
```
src/main/java/com/college/
  dao/          Database access
  filter/       Authentication and authorization
  model/        Domain models
  servlet/      HTTP controllers
  util/         Database, password, and validation helpers
src/main/resources/
  db.properties
src/main/webapp/
  assets/css/
  WEB-INF/views/
  WEB-INF/web.xml
database/schema.sql
```

## Notes
- The database account needs access only to this application's database.
- Do not commit real production credentials.
- This is an educational project; add HTTPS, CSRF protection, audit logging, and stronger operational controls before production use.
