/**
 * 
 */
package author.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import author.controller.IAuthorController;
import author.model.presets.ISpritePreset;
import author.model.presets.SpritePresetFactory;
import author.model.sprite_builder.SpriteBuilder;
import game_data.Game;
import game_data.Level;
import game_data.Sprite;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class AuthorModel implements IAuthorModel{

	private List<ISpritePreset> spritePresets = new ArrayList<>();
	@SuppressWarnings("unused")
	private IAuthorController authorController;
	
	private Game activeGame;
	private Level activeLevel;

	
	public AuthorModel(IAuthorController aAuthorController) {
		this.authorController = aAuthorController;
	}
	
	public void newGame(){
		this.activeGame = new Game();
	}

	public void saveGameAs(String aGameFilePath, String aGameFileName){
		this.activeGame.saveGameAs(aGameFilePath, aGameFileName);
	}
	
	public Level addLevel(int aWidth, int aHeight, String aBackgroundImageFilePath){
		this.activeLevel = new Level(aWidth, aHeight, aBackgroundImageFilePath);
		this.activeGame.addNewLevel(this.activeLevel);
		return this.activeLevel;
	}
	
	@Override
	public void addPreset(Sprite aPresetSprite){
		this.spritePresets.add(new SpritePresetFactory().create(aPresetSprite));
	}
	
	@Override
	public Sprite addSprite(ISpritePreset spritePreset){
		Sprite createdSprite = new SpriteBuilder().createSpriteFromPreset(spritePreset);
		this.activeLevel.addNewSprite(createdSprite);
		return createdSprite;
	}
	
	public void setActiveLevel(Level aLevel) {
		this.activeLevel = aLevel;
	}
	
	/**
	 *  ultimately might get rid of this
	 */
	public List<Level> getLevels(){
		return Collections.unmodifiableList(this.activeGame.getLevels());
	}
	
	@Override
	public List<ISpritePreset> getPresets(){
		return this.spritePresets;
	}

}
