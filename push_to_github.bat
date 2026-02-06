@echo off
echo ==============================================
echo Pushing project to GitHub...
echo Repo: https://github.com/Priyanshu-Patidar/SpringBootapp_Application.git
echo ==============================================

git init
git add .
git commit -m "Final submission"
git branch -M main

REM Remove origin if it exists to avoid errors
git remote remove origin
git remote add origin https://github.com/Priyanshu-Patidar/SpringBootapp_Application.git

git push -u origin main

echo ==============================================
echo Done! Please check your GitHub repository.
echo ==============================================
pause
