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
        +gameState GameState
        +uiSkin Skin
        -backgroundColor Color
        -screenList Map~String, Screen~
        
        +getBackgroundColor() Color
        +getScreenList() Map~String, Screen~
        +create() void
    }

    class MainScreen {
        -Main main
        -Stage stage
        
        +MainScreen(Main)
        
        +show() void
        +render(float) void
        +resize(int, int) void
        +pause() void
        +resume() void
        +hide() void
        +dispose() void
    }

    class LoadScreen {
        -Main main
        -Stage stage
        
        +LoadScreen(Main)
        
        +show() void
        +render(float) void
        +resize(int, int) void
        +pause() void
        +resume() void
        +hide() void
        +dispose() void
    }

    class OptionsScreen {
        -Main main
        -Stage stage
        
        +OptionsScreen(Main)
        
        +show() void
        +render(float) void
        +resize(int, int) void
        +pause() void
        +resume() void
        +hide() void
        +dispose() void
    }
    
    class DebugScreen {
        -main Main
        -gameState GameState
        -stage Stage
        
        +DebugScreen(Main, GameState)
        
        +show() void
        +render(float) void
        +resize(int, int) void
        +pause() void
        +resume() void
        +hide() void
        +dispose() void
    }

    class GameScreen {
        -main Main
        -gameState GameState
        -stage Stage

        +GameScreen(Main, GameState)
        
        +show() void
        +render(float) void
        +resize(int, int) void
        +pause() void
        +resume() void
        +hide() void
        +dispose() void
    }

    class NewGameScreen {
        -main Main
        -gameState GameState
        -stage Stage

        +NewGameScreen(Main, GameState)

        +show() void
        +render(float) void
        +resize(int, int) void
        +pause() void
        +resume() void
        +hide() void
        +dispose() void
    }

    class Genre {
        FEMALE
        MALE
        UNSET
    }

    class Person {
        # String firstName
        # String lastName
        # int age
        # Genre genre
        +Person(String, String, int, Genre)
        +getFirstName() String
        +getLastName() String
        +getAge() int
        +getGenre() Genre
    }

    class Player {
        +Player(String, String, Genre)
        +Player()
        +setFirstName(String) void
        +setLastName(String) void
        +setGenre(Genre) void
    }
    
    class Worker {
        +Worker(String, String, int, Genre)
        +Worker(Person person)
    }

    class Company {
        -double money
        -String name
        -ArrayList<Worker> employees
        
        +Company()

        +getName() String
        +setName(String) void
        +getMoney() double
        +addMoney(double) void
        +spendMoney(double) void
        +getEmployees() ArrayList<Worker>
        +hire(Person) void
        +fire(Worker) void
    }

    class Economy {
        +Economy(Company) void
        +getPlayerCompany() Company
    }

    class Reputation {
        +Reputation(Company) void
        +getPlayerCompany() Company
    }
    
    class GameStateListener {
        <<interface>>
        +updateMoney(GameState) void
    }

    class GameState {
        private ArrayList~GameStateListener~ listeners
        private final Economy economy
        private final Reputation reputation
        private final Company playerCompany
        private final Player player
        +GameState()
        +addListener(GameStateListener) void
        +removeListener(GameStateListener) void
        +getPlayer() Player
        +getPlayerCompany() Company
        +notifyMoneyChanged() void
        +addMoney(double) void
    }

    class ConsumableType {
        FOOD
        DRINK
    }

    class Item {
        #name String
        #description String
        +Item(String, String)
        +Item(String)
        +getName() String
        +getDescription() String
    }

    class Consumable {
        +Consumable(String, String, ConsumableType, Effect) void
        +Consumable(String, ConsumableType, Effect) void
        +getConsumableType() ConsumableType
        +getEffect() Effect
    }
    
    class Effect {}

    Main --|> Game
    
    Main --> "*" Screen : -screenList
    Screen <|.. MainScreen
    Screen <|.. LoadScreen
    Screen <|.. OptionsScreen
    Screen <|.. DebugScreen
    Screen <|.. GameScreen
    Screen <|.. NewGameScreen
    
    Genre --> "1" Person :  #genre
    Player <|-- Person
    Worker <|-- Person

    Company "1" <-- Reputation : -playerCompany
    Company "1" <-- Economy : -playerCompany

    GameStateListener --> "*" GameState : -listeners
    GameState --> "1" Economy : -economy
    GameState --> "1" Reputation : -reputation
    GameState --> "1" Company : -playerCompany
    GameState --> "1" Player : -player
    
    Main --> GameState : -gameState

    Item <|-- Consumable
    Consumable --> "1" ConsumableType : #consumableType
    Consumable --> "1" Effect : #effect
```

## Changelog

**v0.1.1**

- The `Company` class received new methods to handle a basic gameplay
- Javadoc added to the `Worker` class.

**v0.1.0**

- A `DebugScreen` has been added when starting a new game to check if the backend is running properly 
- A `GameScreen` has been added to be the screen that handles the game in the future.
- A `GameState` class has been implemented to handle the backend and the game loop, helped by the `GameStateListener` class.
- The `MainScreen` and `LoadScreen` have been updated.
- A `NewGameScreen` has been added when pressing on new game to init `GameState`.
- An empty `OptionsScreen` has been created to handle settings in the future.
- The backend is being implemented with classes such as `Person`, `Economy`...

**v0.0.1**

- A `MainScreen` class has been created to display a proper home screen.
- A `LoadScreen`  class has been created to display the ability to load or start a new game.
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
