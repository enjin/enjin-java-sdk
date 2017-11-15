# Enjin-Coin-Java-SDK
Java SDK for Enjin Coin Platform

## Useful commands

| Command                    | Windows Command                                                            | Unix Command                                                           |
| ---------------------------|----------------------------------------------------------------------------|------------------------------------------------------------------------|
| Perform Clean Install      | gradlew.bat clean install -Dsurefire.skip.tests=true                       | gradlew clean install -Dsurefire.skip.tests=true                       |
| Generate Javadoc           | gradlew.bat clean install javadoc  -Dsurefire.skip.tests=true              | gradlew clean install javadoc  -Dsurefire.skip.tests=true              |
| Launch Javadoc             | start chrome.exe base\build\docs\javadoc\index.html                        | start chrome.exe base\build\docs\javadoc\index.html                    |
| Run Clover Analysis        | gradlew.bat clean install test cloverGenerateReport cloverAggregateReports | gradlew clean install test cloverGenerateReport cloverAggregateReports |
| Launch Clover Html Results | start chrome.exe base\build\reports\clover\html\index.html                 | start chrome.exe base\build\reports\clover\html\index.html             |
| Launch Clover Pdf Results  | start chrome.exe base\build\reports\clover\clover.pdf                      | start chrome.exe base\build\reports\clover\clover.pdf                  |
