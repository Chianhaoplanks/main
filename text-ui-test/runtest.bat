@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
REM del ACTUAL.TXT

REM compile the code into the bin folder
REM javac  -cp ..\src -Xlint:none -d ..\src\main\java\tasks\*.java
REM javac  -cp ..\src -Xlint:none -d ..\src\main\java\commands\*.java
javac  -cp ..\src -Xlint:none -d ..\bin ..\src\main\java\*.java ..\src\main\java\commands\*.java ..\src\main\java\tasks\*.java ..\src\main\java\controlpanel\*.java

IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0


REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin controlpanel.Duke < input.txt > ACTUAL.txt

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT