#!/bin/bash
echo "============================================"
echo "   Bank Management System - Compile & Run"
echo "============================================"

# Create output directory
mkdir -p out

echo "Compiling Java source files..."

javac -cp ".:mysql-connector-java-8.0.28.jar:jcalendar-tz-1.3.3-4.jar" \
      -sourcepath src \
      -d out \
      src/bank/management/system/login.java \
      src/bank/management/system/signup.java \
      src/bank/management/system/signup2.java \
      src/bank/management/system/signup3.java \
      src/bank/management/system/welcome.java \
      src/bank/management/system/deposit.java \
      src/bank/management/system/withdrawal.java \
      src/bank/management/system/mini.java \
      src/bank/management/system/pinchange.java \
      src/bank/management/system/dbcon.java

if [ $? -ne 0 ]; then
    echo ""
    echo "[ERROR] Compilation failed. Make sure JDK is installed."
    exit 1
fi

# Copy icon resources
cp -r src/icon out/

echo ""
echo "[SUCCESS] Compilation complete. Launching application..."
java -cp "out:mysql-connector-java-8.0.28.jar:jcalendar-tz-1.3.3-4.jar" bank.management.system.login
