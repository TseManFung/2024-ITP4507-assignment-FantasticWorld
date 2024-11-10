@echo off
echo Press d to delete all class files...
echo Press c to compile and run Main.java...
echo Press r to run Main.java

set /p choice="Enter your choice: "

if /i "%choice%"=="d" (
    echo Deleting all class files...
    del /s /q *.class
) else if /i "%choice%"=="c" (
    echo Compiling Java files...
    javac *.java
    javac ./FantasticWorld/*.java
    echo Press any key to run the program...
    pause
    java Main
) else if /i "%choice%"=="r" (
    java Main
) else (
    echo Invalid choice.
)

pause
