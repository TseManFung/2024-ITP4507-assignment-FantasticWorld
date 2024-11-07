@echo off
echo "Press r to remove all class files..."
echo "Press c to compile..."

set /p choice="Enter your choice: "

if /i "%choice%"=="r" (
    echo Removing all class files...
    del /s /q *.class
) else if /i "%choice%"=="c" (
    echo Compiling Java files...
    javac *.java
    javac ./FantasticWorld/*.java
    echo "Press any key to run the program..."
    pause
    java Main
) else (
    echo Invalid choice.
)

pause
