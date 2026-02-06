@echo off
setlocal

set MAVEN_PROJECTBASEDIR=%~dp0
set MAVEN_JAR_DIR=%MAVEN_PROJECTBASEDIR%\.mvn\wrapper

if not exist "%MAVEN_JAR_DIR%\maven-wrapper.jar" (
    echo Error: Maven wrapper jar not found.
    exit /b 1
)

java -classpath "%MAVEN_JAR_DIR%\maven-wrapper.jar" "-Dmaven.multiModuleProjectDirectory=%MAVEN_PROJECTBASEDIR%" org.apache.maven.wrapper.MavenWrapperMain %*

endlocal
