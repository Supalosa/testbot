# Testbot

Template SC2 bot using ocraft-s2client.

## Setup
It's recommended to look at https://github.com/ocraft/ocraft-s2client before attempting to set up this bot.

This project is built with Gradle. To set up development on this bot, import this project as a Gradle project to IntelliJ.
It will pull in all dependencies that are required.

Modify the `settings.gradle`, and `build.gradle` (`group`)

## Execution
To run the bot against the Blizzard AI, simply run the main method in the `src/main/java/com/supalosa/Main.java` class.

## Deploying to Ladder
Modify `LadderBots.json` appropriately, by setting the name and race of your bot.

Then run the following:

    ./gradlew buildZip

The output, which can be installed on the ladder, will appear in `build/distributions/` as a zip file.