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
│   │   │                   ├── character
│   │   │                   │   ├── Genre.class
│   │   │                   │   ├── Person.class
│   │   │                   │   ├── Player.class
│   │   │                   │   └── worker
│   │   │                   │       ├── InventoryManager.class
│   │   │                   │       ├── MarketingManager.class
│   │   │                   │       ├── ProductionManager.class
│   │   │                   │       └── Worker.class
│   │   │                   ├── company
│   │   │                   │   └── Company.class
│   │   │                   ├── gameState
│   │   │                   │   ├── Economy
│   │   │                   │   │   └── Economy.class
│   │   │                   │   ├── GameState.class
│   │   │                   │   ├── GameStateListener.class
│   │   │                   │   └── Reputation
│   │   │                   │       └── Reputation.class
│   │   │                   ├── item
│   │   │                   │   ├── consumable
│   │   │                   │   │   ├── Consumable.class
│   │   │                   │   │   └── ConsumableType.class
│   │   │                   │   ├── Effect.class
│   │   │                   │   └── Item.class
│   │   │                   ├── Main.class
│   │   │                   └── ui
│   │   │                       ├── game
│   │   │                       │   ├── DebugScreen.class
│   │   │                       │   └── GameScreen.class
│   │   │                       └── menu
│   │   │                           ├── LoadScreen$1.class
│   │   │                           ├── LoadScreen$2.class
│   │   │                           ├── LoadScreen$3.class
│   │   │                           ├── LoadScreen.class
│   │   │                           ├── MainScreen$1.class
│   │   │                           ├── MainScreen$2.class
│   │   │                           ├── MainScreen$3.class
│   │   │                           ├── MainScreen.class
│   │   │                           ├── NewGameScreen$1.class
│   │   │                           ├── NewGameScreen$2.class
│   │   │                           ├── NewGameScreen.class
│   │   │                           └── OptionsScreen.class
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
│   │       │   │       ├── DebugScreen.class.uniqueId1
│   │       │   │       ├── GameScreen.class.uniqueId9
│   │       │   │       ├── LoadScreen$1.class.uniqueId11
│   │       │   │       ├── LoadScreen$2.class.uniqueId13
│   │       │   │       ├── LoadScreen$3.class.uniqueId0
│   │       │   │       ├── LoadScreen.class.uniqueId2
│   │       │   │       ├── Main.class.uniqueId8
│   │       │   │       ├── MainScreen$1.class.uniqueId6
│   │       │   │       ├── MainScreen$2.class.uniqueId10
│   │       │   │       ├── MainScreen$3.class.uniqueId14
│   │       │   │       ├── MainScreen.class.uniqueId12
│   │       │   │       ├── NewGameScreen$1.class.uniqueId5
│   │       │   │       ├── NewGameScreen$2.class.uniqueId3
│   │       │   │       ├── NewGameScreen.class.uniqueId4
│   │       │   │       └── OptionsScreen.class.uniqueId7
│   │       │   └── previous-compilation-data.bin
│   │       └── jar
│   │           └── MANIFEST.MF
│   ├── build.gradle
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── sudocapitalism
│                       ├── character
│                       │   ├── Genre.java
│                       │   ├── Person.java
│                       │   ├── Player.java
│                       │   └── worker
│                       │       ├── InventoryManager.java
│                       │       ├── MarketingManager.java
│                       │       ├── ProductionManager.java
│                       │       └── Worker.java
│                       ├── company
│                       │   └── Company.java
│                       ├── gameState
│                       │   ├── Economy
│                       │   │   └── Economy.java
│                       │   ├── GameState.java
│                       │   ├── GameStateListener.java
│                       │   └── Reputation
│                       │       └── Reputation.java
│                       ├── item
│                       │   ├── consumable
│                       │   │   ├── Consumable.java
│                       │   │   └── ConsumableType.java
│                       │   ├── Effect.java
│                       │   ├── equipment
│                       │   │   ├── clothing
│                       │   │   └── tool
│                       │   └── Item.java
│                       ├── Main.java
│                       └── ui
│                           ├── game
│                           │   ├── DebugScreen.java
│                           │   └── GameScreen.java
│                           └── menu
│                               ├── LoadScreen.java
│                               ├── MainScreen.java
│                               ├── NewGameScreen.java
│                               └── OptionsScreen.java
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
        -double efficiency
        
        +Worker(String, String, int, Genre)
        +Worker(Person person)
        
        +getEfficiency() double
        +increaseEfficiency(double) void
        +decreaseEfficiency(double) void
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

**v0.1.2**

- Workers now have a pseudo randomized efficiency assigned on creation.
- The efficiency can be increased and decreased at a given rate.

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
