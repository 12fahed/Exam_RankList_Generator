@echo off
echo.
echo ========================================
echo  MHT-CET Merit List Generator - GUI
echo ========================================
echo.
echo Compiling Java files...
javac *.java

if %ERRORLEVEL% EQU 0 (
    echo.
    echo Compilation successful!
    echo.
    echo Starting the application...
    echo.
    java MHTCETGuiApp
) else (
    echo.
    echo Compilation failed! Please check the error messages above.
    echo.
    pause
)
