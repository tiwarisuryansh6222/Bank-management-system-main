@echo off
echo ============================================
echo    Bank Management System - Compile Script
echo ============================================

REM Create output directory
if not exist "out" mkdir out

echo Compiling Java source files...

javac -cp ".;mysql-connector-java-8.0.28.jar;jcalendar-tz-1.3.3-4.jar" ^
      -sourcepath src ^
      -d out ^
      src/bank/management/system/login.java ^
      src/bank/management/system/signup.java ^
      src/bank/management/system/signup2.java ^
      src/bank/management/system/signup3.java ^
      src/bank/management/system/welcome.java ^
      src/bank/management/system/deposit.java ^
      src/bank/management/system/withdrawal.java ^
      src/bank/management/system/mini.java ^
      src/bank/management/system/pinchange.java ^
      src/bank/management/system/dbcon.java

IF %ERRORLEVEL% NEQ 0 (
    echo.
    echo [ERROR] Compilation failed. Make sure JDK is installed and JAVA_HOME is set.
    pause
    exit /b 1
)

REM Copy icon resources to output directory
xcopy /E /I /Q "src\icon" "out\icon" >nul 2>&1

echo.
echo [SUCCESS] Compilation complete. Run run.bat to launch the application.
