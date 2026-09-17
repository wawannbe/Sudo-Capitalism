# Sudo Capitalism

A little game that started as a school project.

The code was originally written (by me) in a homebrew language from my university as a project.
I then translated it into Java, but it wasn't that good.

This is now the second iteration of the game in Java.

The game is using [LibGDX](https://libgdx.com/) to run.

## Project structure

```
.
├── assets
│   ├── assets.txt
│   ├── atlas
│   ├── libgdx.png
│   └── ui
│       ├── buttons.atlas
│       ├── buttons.json
│       ├── buttons.png
│       ├── font.fnt
│       ├── font-list.fnt
│       ├── font-subtitle.fnt
│       ├── font-window.fnt
│       ├── uiskin.atlas
│       ├── uiskin.json
│       └── uiskin.png
├── build
│   └── reports
│       └── problems
│           └── problems-report.html
├── build.gradle
├── core
│   ├── build
│   │   ├── classes
│   │   │   └── java
│   │   │       └── main
│   │   │           └── com
│   │   │               └── sudocapitalism
│   │   │                   ├── Main.class
│   │   │                   └── ui
│   │   │                       ├── MainScreen$1.class
│   │   │                       ├── MainScreen$2.class
│   │   │                       ├── MainScreen$3.class
│   │   │                       ├── MainScreen.class
│   │   │                       ├── OptionsScreen.class
│   │   │                       ├── SaveLoadScreen$1.class
│   │   │                       ├── SaveLoadScreen$2.class
│   │   │                       ├── SaveLoadScreen$3.class
│   │   │                       └── SaveLoadScreen.class
│   │   ├── generated
│   │   │   └── sources
│   │   │       ├── annotationProcessor
│   │   │       │   └── java
│   │   │       │       └── main
│   │   │       └── headers
│   │   │           └── java
│   │   │               └── main
│   │   ├── libs
│   │   │   └── core-1.0.0.jar
│   │   └── tmp
│   │       ├── compileJava
│   │       │   ├── compileTransaction
│   │       │   │   ├── backup-dir
│   │       │   │   └── stash-dir
│   │       │   │       ├── Main.class.uniqueId0
│   │       │   │       ├── SaveLoadScreen$1.class.uniqueId4
│   │       │   │       ├── SaveLoadScreen$2.class.uniqueId2
│   │       │   │       ├── SaveLoadScreen$3.class.uniqueId3
│   │       │   │       └── SaveLoadScreen.class.uniqueId1
│   │       │   └── previous-compilation-data.bin
│   │       └── jar
│   │           └── MANIFEST.MF
│   ├── build.gradle
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── sudocapitalism
│                       ├── Main.java
│                       └── ui
│                           ├── MainScreen.java
│                           ├── OptionsScreen.java
│                           └── SaveLoadScreen.java
├── gradle
│   ├── gradle-daemon-jvm.properties
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradle.properties
├── gradlew
├── gradlew.bat
├── LICENSE
├── lwjgl3
│   ├── build
│   │   ├── classes
│   │   │   └── java
│   │   │       └── main
│   │   │           └── com
│   │   │               └── sudocapitalism
│   │   │                   └── lwjgl3
│   │   │                       ├── Lwjgl3Launcher.class
│   │   │                       └── StartupHelper.class
│   │   ├── generated
│   │   │   └── sources
│   │   │       ├── annotationProcessor
│   │   │       │   └── java
│   │   │       │       └── main
│   │   │       └── headers
│   │   │           └── java
│   │   │               └── main
│   │   ├── resources
│   │   │   └── main
│   │   │       ├── assets.txt
│   │   │       ├── atlas
│   │   │       ├── libgdx128.png
│   │   │       ├── libgdx16.png
│   │   │       ├── libgdx32.png
│   │   │       ├── libgdx64.png
│   │   │       ├── libgdx.png
│   │   │       └── ui
│   │   │           ├── buttons.atlas
│   │   │           ├── buttons.json
│   │   │           ├── buttons.png
│   │   │           ├── font.fnt
│   │   │           ├── font-list.fnt
│   │   │           ├── font-subtitle.fnt
│   │   │           ├── font-window.fnt
│   │   │           ├── uiskin.atlas
│   │   │           ├── uiskin.json
│   │   │           └── uiskin.png
│   │   └── tmp
│   │       └── compileJava
│   │           └── previous-compilation-data.bin
│   ├── build.gradle
│   ├── icons
│   │   ├── logo.icns
│   │   ├── logo.ico
│   │   └── logo.png
│   ├── nativeimage.gradle
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── sudocapitalism
│           │           └── lwjgl3
│           │               ├── Lwjgl3Launcher.java
│           │               └── StartupHelper.java
│           └── resources
│               ├── libgdx128.png
│               ├── libgdx16.png
│               ├── libgdx32.png
│               └── libgdx64.png
├── README.md
└── settings.gradle
```

## Class diagram

```mermaid
classDiagram

class Game {
    <<Abstract>>
}

class Screen {
    <<interface>>
}

class Main {
+create() void
+getScreenList() ArrayList<Screen>
+setScreen(Screen) void
}

class MainScreen {
-Main main
-Stage stage
+show() void
+render(float delta) void
+resize(int width, int height) void
+pause() void
+resume() void
+hide() void
+dispose() void
}

class SaveLoadScreen {
-Main main
-Stage stage
+show() void
+render(float delta) void
+resize(int width, int height) void
+pause() void
+resume() void
+hide() void
+dispose() void
}

class OptionsScreen {
-Main main
-Stage stage
+show() void
+render(float delta) void
+resize(int width, int height) void
+pause() void
+resume() void
+hide() void
+dispose() void
}

Main --|> Game
Main --> "*" Screen : screenList
MainScreen ..|> Screen
SaveLoadScreen ..|> Screen 
OptionsScreen ..|> Screen

```

## Changelog

**v0.0.1**

- A `MainScreen` class has been created to display a proper home screen.
- A `SaveLoadScreen`  class has been created to display the ability to load or start a new game.
- The game can be exited properly.

**v0.0.1**

- Modified the `Lwjgl3Launcher.java` to remove unnecessary comments.

**Initial commit**

- The game can be run, for now it is just displaying the [LibGDX](https://libgdx.com/) logo.

## Licences

[![License: AGPL v3](https://img.shields.io/badge/License-AGPL_v3-blue.svg)](https://www.gnu.org/licenses/agpl-3.0)
[![License: CC BY-NC 4.0](https://licensebuttons.net/l/by-nc/4.0/80x15.png)](https://creativecommons.org/licenses/by-nc/4.0/)

The code is under the AGPL v3 license.
All the assets of the game are under the CC BY-NC license.
