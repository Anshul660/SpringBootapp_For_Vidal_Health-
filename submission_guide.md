# Project Submission Guide

Follow these steps exactly to submit your project according to the requirements.

## 1. Generate the JAR File
Currently, your `target` folder does NOT contain the JAR file needed for submission. You must build it.
1. Open your terminal in `C:\Users\Asus\Downloads\test1`.
2. Run this command to build the JAR:
   ```cmd
   mvnw.cmd clean package
   ```
   *(Note: If `mvnw.cmd` fails locally like before, use `java -cp .mvn/wrapper/maven-wrapper.jar "-Dmaven.multiModuleProjectDirectory=." org.apache.maven.wrapper.MavenWrapperMain clean package`)*
3. **Verify**: Check that a file named `automation-0.0.1-SNAPSHOT.jar` appears in the `target` folder.

## 2. Prepare for GitHub
You need to upload your code to GitHub.

### A. Initialize Git (If not already done)
Run these commands in your terminal:
```cmd
git init
git add .
git commit -m "Final submission for Webhook Challenge"
```

### B. Push to GitHub
1. Go to [GitHub.com](https://github.com) and sign in.
2. Click **New** (or the **+** icon) to create a new repository.
   - **Repository name**: `test1-automation` (or similar).
   - **Public/Private**: Select **Public** (Requirement: "Public GitHub repo").
   - **Do NOT** initialize with README, .gitignore, or License.
3. Copy the URL of your new repository.
4. Run these commands in your terminal:
   ```cmd
   git branch -M main
   git remote add origin <YOUR_REPO_URL>
   git push -u origin main
   ```

## 3. Upload the JAR File (Crucial Step)
The requirements ask for a "Final JAR output" and a "Public JAR file link". The best way to do this on GitHub is using **Releases**.

1. On your GitHub repository page, click **Releases** (on the right sidebar) > **Create a new release**.
2. **Tag version**: `v1.0`.
3. **Release title**: `Final Submission`.
4. **Attach binaries**: Drag and drop the `target/automation-0.0.1-SNAPSHOT.jar` file from your computer into the upload box.
5. Click **Publish release**.

## 4. Get the Links for Submission
You need two specific links:

1.  **Public GitHub Repo Link**:
    - URL: `https://github.com/YourUsername/test1-automation`
2.  **Public JAR File Link (RAW downloadable)**:
    - Go to your new **Release** page.
    - Right-click the `automation-0.0.1-SNAPSHOT.jar` asset you uploaded.
    - Select **Copy link address**.

## 5. Fill the Form
1. Open the form: [https://forms.office.com/r/bDts9GjetN](https://forms.office.com/r/bDts9GjetN)
2. Fill in your details.
3. Paste the **GitHub Repo Link**.
4. Paste the **Public JAR Link**.
5. Submit!
