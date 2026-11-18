# Setup guide (NetBeans + Windows)

## 1. Required software
- JDK 21 (set as the Java platform in NetBeans)
- Apache NetBeans with Maven support
- Apache Maven 3.9+
- MySQL Server 8+
- Apache Tomcat 10.1

Do not use Tomcat 9. This project uses Jakarta Servlet 6.0 (jakarta.*), which requires Tomcat 10.1.

## 2. Clone the repository
In PowerShell:
```powershell
git clone https://github.com/adhishmodi/college-management-system.git
cd college-management-system
```

## 3. Create the database
1. Start MySQL Server.
2. Open MySQL Workbench or the MySQL command line.
3. Run the complete script in database/schema.sql.
4. Copy src/main/resources/db.properties.example to src/main/resources/db.properties.
5. Replace YOUR_MYSQL_PASSWORD with your local MySQL password. The local db.properties file is ignored by Git and should not be committed.

## 4. Open in NetBeans
1. Start NetBeans.
2. Select File → Open Project.
3. Select the cloned college-management-system folder (the folder containing pom.xml).
4. Wait for Maven dependencies to download.
5. Right-click the project and select Clean and Build.
6. Confirm the build creates target/college-management-system.war.

## 5. Configure Tomcat
1. In NetBeans, open Tools → Servers → Add Server.
2. Choose Apache Tomcat or TomEE.
3. Select your Tomcat 10.1 installation directory.
4. Configure the Tomcat username/password if NetBeans requests it.
5. In project Properties → Run, select the Tomcat 10.1 server.
6. Run the project.

If NetBeans does not detect Tomcat, verify CATALINA_HOME points to the actual Tomcat directory and that its bin folder contains startup.bat.

## 6. Sign in
- Admin: admin@example.com / Admin@123
- Student: student@example.com / Student@123

Open http://localhost:8080/college-management-system/.

## 7. Common errors
| Error | What to check |
|---|---|
| Unsupported class file major version | NetBeans/Maven is using a JDK older than 21. |
| package jakarta.servlet does not exist | Maven dependencies did not load, or Servlet API dependency was removed. |
| HTTP 404 | Confirm the WAR context path and Tomcat deployment status. |
| HTTP 500 / database connection error | Start MySQL and verify db.properties, database name, username, and password. |
| javax.servlet not found | Do not mix old Java EE javax.* imports with this Jakarta project. |
| Tomcat startup environment error | Check CATALINA_HOME and CATALINA_BASE point to the actual Tomcat 10.1 folder. |

When an error occurs, copy the complete first error and the root-cause lines from the NetBeans Output window. Fix one root cause at a time.
