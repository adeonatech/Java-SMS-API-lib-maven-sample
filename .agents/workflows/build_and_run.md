---
description: Build and Run Maven Sample Project
---

## Steps to build and run the project after updating dependencies

1. **Clean and install the project**

   ```bash
   mvn clean install
   ```

   This will download the updated `SmsAPI` version (1.0.8) and compile the code.

2. **Run the sample application**

   ```bash
   mvn exec:java -Dexec.mainClass=Main
   ```

   Ensure you have the `exec-maven-plugin` configured in `pom.xml`. If not, add the following plugin inside `<build><plugins>`:

   ```xml
   <plugin>
       <groupId>org.codehaus.mojo</groupId>
       <artifactId>exec-maven-plugin</artifactId>
       <version>3.1.0</version>
       <configuration>
           <mainClass>Main</mainClass>
       </configuration>
   </plugin>
   ```

3. **Verify the output**
   - The console should display the SMS send status and the transaction status.
   - If you encounter authentication errors, double‑check your `{YOUR_USERNAME}` and `{YOUR_PASSWORD}` placeholders in `Main.java`.

---

**Tip:** After the upgrade, review the library's release notes for any breaking changes that might require code adjustments.
