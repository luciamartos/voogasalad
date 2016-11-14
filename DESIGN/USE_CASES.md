USE_CASES.md
=====


### Game Authoring Environment
* User wants to drag and drop players, monsters, blocks onto level
* User wants to define total height, total width, and viewable window size of level
* User wants to click an entity and change its settings related to that entity
* User wants to set reactions from preset settings, but be able to edit them
* User wants to set images for certain entities
* User wants images to change upon event related to entity settings
* User wants to set general player button presses as events attached to several entities
* User wants to set multiple heros and different controls for each
* User wants to build not only levels but menus and splash screens
* User wants to set background of levels


### Game Data
* User saves a game. They press the save button and the instance of the world is passed to a save method where all of the sprites within the world are serialized into a XML.
* User loads a past game. The press the load button and select the XML file from where to get past game data. The world is constructed through decoding many serialized sprites and is set up to resume playing.
* User sets the image of a new character. This should update the file path of that character to point to that path of the image. This will allow the game_player to show the image of the character.
* User creates an enemy that jumps and spits fire: This should create a general sprite. The user will the click the box indicating the enemy can jump at which point the sprite will become a an instance of a jumping sprite. After clicking has projectile and projectile is fired the sprite will also implement the interfaces for has projectile and use fire as its image. 
* User creates a breakable block: This creates an instance of terrain, more specifically the dynamic block subclass. This will then implement an interface allowing it to be breakable, and the user will have to design where exactly the block is breakable.
* User changes the projectile speed of a character’s ball throwing ability: Sprite already has a projectile attributes, and it will call a method to update speed of projectile. 
* User adds an item in into the game after loading a previous setup. The item is added to the world and when the game is later saved, the item is included
* User includes power up hidden inside block: Give a boolean to the block that identifies it as containing a power up. The user would also have to specify which type, but the sprite object would contain a power-up which is it’s own class as well containing it’s own attributes. The appearance of the power up would be defined in the collision handling of the block.
* User changes a block to be breakable. The boolean value of the block is altered to represent the change. If the player ever interacts with the block, it will act correctly.
* User wants to code an end boss. They are able to choose what the superpower of the enemy is and decides to create a duplicating enemy that creates another version of itself every time interval.


### Game Engine
* Game Engine is fed a blank XML file -> The XMLParser will check for that, and then it will create DefineBehaviors based on the default behaviors that the Game Engine has defined
* Game Engine is fed a erroneous XML -> The XMLParser will print something in the console so we are aware there is an error in the file, but the parser will see the error and continue reading through the file implementing the rest of the specified behaviours (if any). The user should not be able to create an erroneous XML file (it must be an internal mistake).
* The user builds the space bar to have the ability to kill all enemies -> The XML file would reflect this and the DefineBehaviors class would update the KeyBehavior class to interact with the EnemyState class when the space bar is clicked.
* The user sets the winning and losing condition to be the same -> XML parsing should read these conditions and notice there is a problem is should stack the error and send it to the Game Player who can then display it on the screen. 
* No key is pressed -> the update method should still have to be called and this will call for an update of the obstacle state, enemy state, win lose state and sprite state. This should then calculate the new information for everything (eg sprite moves forward) and send it back to the game player. 
* A sprite moves forward and collides with an enemy which triggers a losing condition -> The SpriteBehavior class moves the Sprite forward; then, the Collision class recognizes (based on information from the SpriteState and the EnemyState class) that they are colliding.  This enables the LosingCondition class to recognize that the user has lost.  This will update LosingState, which the front end (the Game Player module) will receive and subsequently let the user know.
* A sprite moves forward to the end of the stage which triggers a winning condition -> The SpriteBehavior class moves the sprite forward; then the WinningCondition class is triggered by the end of the stage which results in WinningState being updated. The Game Player module picks this up and lets the user know.
*  A sprite moves forward and collects a powerup -> The SpriteBehavior class moves the Sprite forward; then the Collision class recognizes that the Sprite and the powerup item are colliding. This updates the SpriteBehavior and KeyBehavior classes to reflect the nature of the powerup that was collected.
* A sprite tries to move outside the game bounds -> The SpriteBehavior class that moves the sprite prevents the sprite from updating if it were to go out of bounds with the requested move.
*  The user builds the space bar to have the ability to shoot a projectile from the player sprite (used in defeating enemies)-> The XML file parser would reflect this and the DefineBehaviors class would update the SpriteBehavior and KeyBahvior classes to allow for this action. The Collision class would then check for collisions between the projectile and enemy sprites to update the EnemyState class should a bullet hit the enemy character. 


### Game Player
* User clicks that they want to play a game, they click an unformatted file. The GUI displays an alert. 
* User clicks that they want to play a game, they choose a game that they last ended on the third level, the game engine recognizes that and the front end displays the correct background, sprites, and heads up display. As the game progresses, we get the updated data from the game engine and display it on the screen.
* User clicks that they want to play an already uploaded game that requires two different screens. The frontend recognizes this input from the game engine and generates a split screen from javafx aesthetic for the user. The game information is updated from the game engine and displayed on the front. 
* User clicks the restart button, a new file of the current game is sent to the game engine and the display is updated accordingly.
* The user clicks the main menu button, and they are sent back to the menu where they have the option of loading a new file or choosing one of the existing games that are loaded.
* The user clicks that they want to change their preferences for the current game. They are taken to another screen with the current preferences and options to change them, where the front sends that data to the game engine.
* The user clicks that they want to save their progress, the current game state is saved in the resource file corresponding to the game state for that user. Upon loading that game again, we parse the resource file for the most recent level and load that one from game engine.
* The user beats the current high score for the game. The final score is saved using the Preferences class/package pairing for that game and user’s information. The next time the game is loaded for any other user, they can see that the high score is updated.
* The user reaches the case that determines the end of the game, or the user dies. The user is taken to the ending screen for that game, where they have options of restarting that game or going back to the main menu.
* The user decides to clear their high score and their game progress. The high score is set to 0 (or whatever the current game mandates, maybe it’s time set to 00:00) and the default level to be loaded is set to the first level.


