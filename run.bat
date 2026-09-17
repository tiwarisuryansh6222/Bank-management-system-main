@echo off
echo ============================================
echo    Bank Management System - Run Script
echo ============================================

IF NOT EXIST "out" (
    echo [ERROR] Compiled files not found. Please run compile.bat first.
    pause
    exit /b 1
)

echo Launching Bank Management System...
java -cp "out;mysql-connector-java-8.0.28.jar;jcalendar-tz-1.3.3-4.jar" bank.management.system.login
