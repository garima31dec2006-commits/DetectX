# GUVI AI Fraud Detection System — Personal README

## 1. What this project is

This is a Java web application that demonstrates fraud-risk detection for transactions. A user can submit transaction details and receive a risk-related result. An admin can review transaction summaries and flagged cases, add review notes, mark cases as reviewed, and explore detection thresholds and algorithm management where available.

**Important limitation:** The demonstration model uses synthetic sample data. Its risk scores depend on the current model, input fields, and configured rules. It has not been validated for real financial decisions and is not ready for production banking use.

## 2. Tools required

The setup guide specifies:

- Windows 10 or 11
- JDK 17 or newer (the project author tested with JDK 26)
- Apache Maven 3.9.x
- Apache Tomcat 10.1.x
- A web browser
- Internet access for installing tools and downloading Maven dependencies

## 3. Project setup

1. Extract the **latest ZIP** of the project to a simple folder, for example:
   `C:\GUVI\guvi-ai-fraud-detection`
2. Open that folder in VS Code.
3. Check that `pom.xml` is directly inside the project folder.
4. Open PowerShell and check that Java and Maven are available:

   ```powershell
   java -version
   mvn -version
   ```

If a command is not recognized, install/configure the relevant tool and add its `bin` folder to `PATH`. `JAVA_HOME` should point to the JDK installation folder itself, not its `bin` folder.

Example for the current PowerShell session (replace the example path with your real JDK path):

```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-XX"
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
```

Maven must also be installed and its `bin` folder added to `PATH`.

## 4. Build the application

In PowerShell, move to the project folder. Change the path to match where you extracted it:

```powershell
cd "C:\GUVI\guvi-ai-fraud-detection"
mvn clean package
```

Wait for Maven to finish. Continue only if the output ends with `BUILD SUCCESS`. If the build fails, read the first relevant compiler/error message and resolve it before deploying.

After a successful build, the expected WAR file is:

```text
target\ai-fraud-detection.war
```

## 5. Deploy and run with Tomcat

1. Stop Tomcat if it is already running.
2. Copy `target\ai-fraud-detection.war` into Tomcat's `webapps` folder.
3. If an older deployment exists, stop Tomcat and remove the old `webapps\ai-fraud-detection.war` file and `webapps\ai-fraud-detection` folder.
4. Start Tomcat from its `bin` folder. In PowerShell, use your actual Tomcat path:

   ```powershell
   cd "C:\path\to\apache-tomcat-10.1.x\bin"
   .\startup.bat
   ```

To stop Tomcat:

```powershell
.\shutdown.bat
```

If startup fails, check the Tomcat `logs` folder.

## 6. Open the web application

On the same computer where Tomcat is running, open:

`http://localhost:8080/ai-fraud-detection/`

### Demo login credentials

| Role | Username | Password |
|---|---|---|
| User | `user` | `user123` |
| Admin | `admin` | `admin123` |

These are demonstration credentials only, not secure production credentials.

## 7. How to test the demo

1. Log in as `user`.
2. Submit a small transaction, such as ₹500 using UPI and a normal location.
3. Submit a higher-risk example, such as ₹75,000 with a payment method requiring verification and a high-risk location.
4. Log out and log in as `admin`.
5. Check the transaction summary and flagged cases.
6. Add a review note and select **Mark reviewed** to test case review.
7. Explore detection thresholds and algorithm management, if available.

The examples are for testing only. The output can vary based on the model, input fields, and configured rules.

## 8. Troubleshooting notes

- **`mvn` is not recognized:** Maven may be missing from `PATH`, or PowerShell may have been opened before `PATH` was updated.
- **`JAVA_HOME` is missing or invalid:** Set it to the JDK installation folder, then reopen PowerShell or update it in the current terminal.
- **`BUILD FAILURE`:** Confirm that you extracted the latest ZIP and are running the command in the folder containing `pom.xml`. Inspect the first relevant compiler error.
- **HTTP 404:** Confirm that the WAR is in Tomcat's `webapps` folder and that the URL includes `/ai-fraud-detection/`. Check Tomcat logs.
- **HTTP 500:** Check Tomcat logs for the Java exception. Confirm the app was built with the correct dependencies and deployed to Tomcat 10.1.x.
- **Port 8080 is already in use:** Stop the other service using port 8080 or configure Tomcat to use another port.
- **Login fails:** Confirm that the freshly built WAR was deployed and that you are using the demo credentials above.

## 9. Important source/build reminders

The setup guide specifically warns that an older ZIP may not include later fixes to `TransactionDao.java` and `AdminServlet.java`. Use the newest ZIP from the successfully built project folder.

Before sharing or rebuilding, the project owner should verify that:

- `TransactionDao.java` includes the `setting(...)` read method and `updateSetting(...)` write method.
- `AdminServlet.java` calls `updateSetting(...)` when saving thresholds.
- `mvn clean package` completes with `BUILD SUCCESS`.

Do not include passwords beyond the documented demo credentials, private keys, personal data, or real transaction data in a shared project archive.

## 10. Limitations and security

This is a local demonstration project. Before any real-world use, it would need security hardening, validation using appropriate real-world data, monitoring, and expert review. Do not use its predictions to make real financial decisions.

---

**Personal note:** Keep this file in the root of the project, next to `pom.xml`, so the setup and run instructions are easy to find later.
