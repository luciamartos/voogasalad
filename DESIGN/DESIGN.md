DESIGN.md
=====
### Introduction


The primary design goals on our project is to be able to make a game authorizing environment that provides all the data that is required to run a multitude of scrolling platformer games. The objective for our group was to code frameworks to run/design a game that was flexible enough to host many different games under the genre of a scrolling platform. We want our game to be most flexible in terms of being able to translate any kinds of stats, sprites, levels, etc. that the user wants to raw data (at least for the first sprint this is where we plan to focus most of our efforts). 
The primary architecture of the design is that ideally we will stick to the API that we provided. The things that are closed are the methods that we have put into our API. However, we want our project to be open to modification. Therefore, we are always willing to add elements to our API. I think that our API is most flexible in that it might not have to be modified a ton to add new things. Because we kept the classes to play the game general enough (ie Sprite to account for all objects moving in the foreground of the game and in the Game Engine using behaviors to define interactions), all we should need to modify to add new features is the game authorizing environment and that actually data that is fed into the game. 
The game genre that we chose was a scrolling platform game. This game genre has unique features, like we will need to support moving all other objects but the “player sprite”. This complicates the movement of each object, because in most scrolling platform games (ie Mario), the “background” moves and the player stays in the center of the “screen” so we need to do movement calculations in relation to the background sprites rather than the actual player. We will definitely need an animation loop / timeline which many games (like strategy games) do not need. This adds a level of complication because the animation loop needs to seamlessly connect the front-end and the back-end, but that proves difficult to do and still have a clean design. We also need to consider having an infinite animation (if the game is like Doodle Jump). 
The design is really broken up into Game Player, Game Engine, Game Authoring Environment, and Game Data. The Game Authoring Environment allows the user to input all the data which is then serialized and stored by Game Data. This data is fed to the Game Engine that does most of the logic behind the game, but this logic proves difficult to make because it must be kept general enough to account for many different data sets, and then the game player section displays the game engine’s logic. 


### Overview
There are 4 modules: Game Player, Game Engine, Game Authoring Environment, and Game Data.  Game Authoring Environment allows the author to choose the interaction between game entities (sprites). It also allows the author to change the behavior and settings of game entities. Finally, the user should be able to load & save all of the settings modified by the game authorizing environment.  Game Data provides the framework for the Sprites that Game Authoring Environment uses.  Game Data will contain a Game class with stages, which will in turn have sprites.  Sprites contain properties such as speed, direction facing, the image file, collision behavior, etc.  This information will be passed through Game Player and then to Game Engine.  Game Engine will be in charge of updating the states of the Sprites, enemies, and winning/losing conditions based on the behaviors specified in the XML file that Game Data has given us.  It will create classes such as SpriteBehavior and EnemyBehavior based on the XML information; then, an UpdateStates class will use this behavior to update the SpriteState classes.  Game Player will take information from Game Engine’s State classes to display the game on the screen.



### User Interface


The first menu is a login page with a textbox field for the UserName and a textbox field for a password and a button. When that button is clicked the next menu is a menu with two buttons: Create a Game or Play a Game. When that button is clicked, if the user clicks the Play a Game button then they are directed to a menu with a button to upload a new XML game and a combobox to choose an existing game and a play button. When a user loses the game, the highscores for that game will be displayed. 





### Design Details


*GameData:*

The Game Data will be stored and serialized to an XML file in a Class structure beneath a `Game` class. This `Game` class will have a List of `Stage`s. Each `Stage` will have a List of `Sprite`s active on that stage as well as other defining characteristics of that `Stage` including a path to a background image, a map of KeyCodes to what should happen when a key is pressed in that Stage, and dimensions of the Stage. A `Sprite` will represent any visible object on the Stage including characters, items, terrains, projectiles, etc. with relevant fields stored. The Authoring Environment will be able to use these defined classes to build a `Game` that has `Stage`s and `Sprites`. The `Game` itself can easily be serialized to an XML file in a specific location andwith a specific name using `Game`’s `saveGameAs(String filePath, String fileName)` method. This saves the `Game` and all of its states to an XML file that the Game Engine can load. Once the Game Engine has this class hierarchy structure under the `Game`, the Engine can work from here to manipulate anything about the game without changing the XML directly.


*GameAuthor:*


At a high level, the author environment will be broken up by model view controller (MVC). We will interact with the game data framework to construct the serializable game directly. The GUI (View) communicates with the current game state construction through the controller built from a set of Functional Units (FU’s)  that handle the actual editing of the game (model). Thus each view module can have access to purpose built interfaces of these FU’s that the controller is composed of. The game framework will be extended to be observable, as well as have a set of purpose built interfaces for viewing piecemeal state of the game (such that the view is representative of the current level of game construction).


The view code follows directly from the UI below, but a key observation is that many of the same view modules will be seen in different ways. For example, the entity editor will be viewable both from a dedicated sub window of the tabbed author environment, but should also be seen as a pop up window by clicking directly on an entity in the level editor.


The controller code will be broken up into functional units. These FU’s will handle construction of specific components within the game, and function as the same level of indirection that the controller provides in MVC but broken up by decomposition and logically grouped by composition within the controller. These functional interfaces (as well as the controller code in general) allow the controller to follow the open closed principle as much as possible, but trades requiring a great deal of implemented FU’s. 


One extension that could be added is to run a level or the entire game within the editor as a test build. This could be implemented as a toolbar button that launches the currently built game to test in a new window (by saving the current construct, disabling the author window until the player closes, and running the game player behind the veil of a javafx object).  


As a module, the game author only interacts with the data framework for the actual constructing of the game. Following from the Hollywood principle (“Don’t call us, we’ll call you”) the author environment has no need for a “public” API. We never need to be called by any other module, and we have full autonomy to edit and construct the game using the data modules framework. That said, we should keep our abstraction consistent through the use of many interfaces as crystallized as possible using the Dependency Inversion principle (“Concrete should depend upon abstractions”). This will allow us a consistent internal API that will allow future developers to extend effectively.




*GameEngine:*

The Game Engine serves to set up all the rules of the game given specific behaviors which are passed to it through an XML file.  The Game Player passes in an XML file, which it received from Game Data, to the Game Engine’s XMLParsing class.  This class then calls DefineBehaviors, which creates instances of KeyBehavior, CollisionChecking, SpriteBehavior, ObstacleBehavior, and EnemyBehavior, WinBehavior, and LoseBehavior based on the data in the XML file.  The Game Player section of the project then continuously uses the Game Engine’s update() method in Main to call an UpdateStates class.  This class interacts with KeyBehavior, CollisionChecking, SpriteBehavior, ObstacleBehavior, and EnemyBehavior, WinBehavior, and LoseBehavior, which were defined by either a default or the XML file, to update EnemyState, ObstacleState, SpriteState, WinState, and LoseState.  Then, the information about the EnemyState, ObstacleState, and SpriteState is given back to the Game Player section which uses it to update the GUI.  We might have to deal with the player updating the Sprite, enemy, or obstacle states from within Game Player.  Then, we would need to extend some functionality for UpdateStates to take information from Game Player and update the SpriteState, EnemyState, and ObstacleState in the backend accordingly.


*GamePlayer:*

The Game Player will have factories to create all the different types of GUI elements that might be needed in different types of games. The Sprite GUI will be flexible enough to implement the Sprite as an Image or as a Shape. The Background can either be a solid color or an Image. The buttons, labels, and images in the Heads Up Display will all be interchangeable depending on what data is passed up from the Game Engine / Game Data. The front-end display should be flexible enough to account for however many screens the user wants. We will also be able to have a user profile that keeps track of user highscores and has an icon that is accessed by a UserName login and password. There will also be a game loop that controls the animation of the screen. It will have to call a method from Game Data and it will also update the current display. The entire game display will also be resizable with the size of the Stage.






### Example Games


Iron Pants (like Flappy Bird):


Iron Pants is a game similar to Flappy Bird. It is a scrolling platformer with obstacles coming from the bottom and top of the screen, and you have to pass your character in between the obstacles. The difference from flappy bird is that the character is also weighted down, so you fall much faster than you go up, and rather than jumping you are flying continuously. 


The actual authoring of this game would be the same as flappy bird. You would have to drag and drop the pipes from the top and bottom of the screen, and you could also control the size of the pipes. Additionally you would add a hero character, and there would be a default preset for it’s speed although this could be altered. Every hero has defined movements built in with the arrow keys. Since every single sprite has a speed, there would simply be a setter for changing either image or speed for example. Additionally there would be a game preset for increasing the weight of the character, that way we would not have to actually change the definition of gravity. The dragging and dropping and stat specifications would occur in the authoring environment, but the actual characteristics would be defined and saved in the data back end. The physics for the game would automatically be built in the game engine (the user would have to select that they want a game in which gravity does exist). The way we actually manage moving to the side will be by moving the stage. For now the user could define the stage for as long as they wanted, and whenever the user hit the “end” of the stage it would cycle back to the start of the stage like a torus. In the game engine, we would define the scoring as well. In terms of scoring, there would be objective flags that the user could place. That is, every time the hero passes one of these flags (in terms of x or y position depending on the flag type chosen) the game engine will be in charge of incrementing a score. The score as you go will be sent to player, where it will be displayed on the screen itself. Additionally, once the collision dying condition has been met as defined by the game engine, scores and other necessary screens would be displayed by the player. In this case the game only has one level, so there is no need to save progress or transition through levels.


Mario:


In terms of building a mario game, the authoring environment functions the same as in every other game, but there are most likely more options as to what type of sprites you can put down (here we define a sprite to be any object you can place on the screen including characters and terrain for example). 


When authoring the game, there will be a finite number of available types of terrain, enemies etc. that you can place. For enemies for example you can put a static enemies, enemies that jump, enemies that shoot projectiles, enemies that move side to side, enemies that do multiple of the above behaviors. You can drag and drop all of these while also specifying the attributes with check boxes. For terrain there is a similar structure where you can specify static terrain, brakable terrain, terrain with a power up, moving terrain etc. Powerups will also be there own type of object. Using these attributes you define enemies such as goombas, plants, turtle, and axe-throwing turtles. 


The actual definition of these would be in the backend where a combination of inheritance, interfaces, and composition would allow for the different types of sprites and the wide variety of attributes. 


When playing mario you essentially run along a finite stage, interacting with enemies by either killing them or avoiding them while collecting coins and powerups until you get to the flag at the end. All the components would be placed using the authoring environment including a victory flag. The game engine would define the gravity and interactions (collisions) of these different objects. For example it would handle what happens when the hero character hits a goomba on top versus hit’s it from the side. Additionally it would define the ending conditions of the game and the gravity or other physics principles involved in moving the characters and firing projectiles. The different engines within the game engine itself would define all of these. Lastly, the player data such as score, lives, coins collected, or time played would be kept track of and displayed by the player.


The major differences between this game and iron pants, is that there is mobile terrain, moving enemies, and a winning state as well as multiple levels. The mobile terrain will be defined in the back end, and there are a set number of ways in which the terrain can move, but the user will be able to select from any of these types. The enemies are characters just like the main character in iron pants, but in this case they will also have attributes such as shooting projectiles with a powerup (technically this could be defined in iron pants as well but there is no need for the user to select that preset because there are no enemies to kill). The winning state is just another aspect handled by the game engine. A winning flag is a defined object that you can place, and the engine handles the collision between the winning flag and the object, thus allowing the “end of a level.” There will be multiple stages predefined, so upon hitting a winning condition the next stage will automatically be loaded. Thus overall our design functions in the same manner, it is just reliant on the user to define more of the necessary objects, but these are available when creating all games. 




Doodle Jump: 


Doodle Jump is a game in which a character jumps on platforms, moving vertically up the screen infinitely. As you get higher there are fewer and fewer platforms, and you also encounter enemies which can hurt you. You can shoot the enemies and destroy them or avoid them. Additionally there are moving platforms as well breakable platforms, and the ultimate goal is to get the highest score you can moving upward. 


As in the other games the authoring environment the drag and drop of the blocks is defined already. There is already an available selection of behaviors and appearances for the user to select from, so all possible parts are available in doodle jump. The big difference here is the stage itself. Unlike the last two, this stage is scrolling vertically rather than horizontally. In this case, there will just already be an option that let’s you select a horizontal or vertical stage, so you need only select the vertical stage. These different types of stages will be defined in the authoring environment. In this case you would create a hero that can shoot projectiles in the vertical directions (once again available through projectiles). Another thing unique to this game is the fact that you can go off the screen on the side and come out on the other side. This will be handled in the game engine. In the authoring environment the stage would be chose to be toroidal, and the game engine would actual handle the implementation of that. These two aspects make the game different than mario. Additionally gravity only affects the character and nothing else, so the game engine will have its physics engine only apply to selected objects or certain objects would be given specs that counteract gravity. Ultimately in this game, the level and end conditions of the game would be the same as Iron pants and the interactions would be the same as mario. There is a unique aspect in that you can jump through platforms from the bottom and only hit them on the top, but this simply changes the definition of the collision in the game engine as it must take into account an intersection between hero and block as well the direction in which the hero is moving.


One last thing that might be more relevant in this game is health. Unlike in mario, the different enemies don’t always die in one hit. As a result, the health component that is part of the sprite classes in data will be taken into account, and the managing of the health is done is handled in the engine. Lastly, as always score information and history will be managed and displayed by the player.


### Design Considerations


*Game Data:*

One of the bigger considerations our team had was how the Sprite hierarchy would be set up. Sprite incompasses all things on the game display and range from Projectiles, to Terrain, to the Hero and Enemies. We wrestled with two main ideas, Sprite being an interface and Sprite being a abstract class. We ended up liking the setup with the abstract class more due to the physical structure it brought to the class hierarchy tree. 


Another thought that emerged was how to deal with the different times users will save. They are going to save the levels they make as well as save their progress in their levels. We thought about if these saves should be dealt with differently or not and decided that it would be best if they did as all that is changing is the states of the objects, which can be easily dealt with with serialization. 


*Game Engine:*

One trade off we discussed was whether or not we should interact with both Game Data and Game Player.  The pros of interacting with both would be that we need to get information from the XML file that represents the game that the user created, as well as send information to Game Player to update the GUI.  However, we decided to only have the Game Engine interact with Game Player because it was relatively easy for the Game Player module to acquire the XML file from Game Data.  In this way, we only need to interact with one module, which reduces complexity of the program and reduces risk of different areas causing conflicts with the Game Engine.  Also, because Game Player can easily access the information that we would have needed from Game Data (the XML file), it doesn’t increase complexity for that section of the project.


A second trade off is whether to store the information in the GameEngine or just that “change”. A positive aspect about having the “rules” in the GameEngine is that it decreases the responsibility of the GameEngine (avoids errors and makes sure that data is synchronized). However, the big trade off about this is that it really limits the behaviour of the game since a lot of the rules are going to be based on the previous state of the things in the game. For that reason we decided to keep track of the current state of everything in the GUI. In addition to this, doing it this way allows us to send blocks of informations through an interface rather than continuously have to call methods.


*Game Author:*

The largest blindspot is depending on the data framework API abstraction for building our own abstractions. So the model code and the functional units mentioned earlier will be very coupled to that. Another topic we discussed was handling presets of sprites versus general inputs, and we figured that since we could directly build the game it wouldn’t have to know about presets per se, but that we would have some means of inferring presets of entities from the sprite inheritance tree. If we’re gonna run game inside of authoring environment calling player might need to hand the engine / player the current game object directly, with all of the integration issues that presents.


*Game Player:*

We struggled with creating a view for something that was not hard coded. For example, with the Sprite Views we did not know whether or not they should have an ImageView directly associated with them, but we ultimately decided that the best way to handle that problem was to have a sprite factory that would make that correct sprite depending on what the data called for. 


