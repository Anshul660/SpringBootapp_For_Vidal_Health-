@echo off
echo Running project with corrected Maven Wrapper command...
java -cp .mvn/wrapper/maven-wrapper.jar "-Dmaven.multiModuleProjectDirectory=." org.apache.maven.wrapper.MavenWrapperMain spring-boot:run
pause
