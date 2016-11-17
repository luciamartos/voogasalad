/**
 * 
 */
package author.model;

import java.util.ArrayList;
import java.util.List;


import author.controller.IAuthorController;
import author.model.game_observables.observable_sprite.ObservableSprite;
import author.model.game_observables.observable_sprite.ObservableSpriteFactory;
import author.model.presets.ISpritePreset;
import author.model.presets.SpritePresetFactory;
import author.model.sprite_builder.SpriteBuilder;
import game_data.Sprite;

/**
 * @author Cleveland Thompson V (ct168)
 *
 */
public abstract class AuthorModel implements IAuthorModel{

	private List<ISpritePreset> spritePresets = new ArrayList<>();
	private IAuthorController authorController;
	/**
	 * 
	 */
	public AuthorModel(IAuthorController aAuthorController) {
		this.authorController = aAuthorController;
	}
	
	@Override
	public List<ISpritePreset> getPresets(){
		return this.spritePresets;
	}
	
	@Override
	public void addPreset(Sprite aPresetSprite){
		ObservableSprite observableSprite = new ObservableSpriteFactory().create(aPresetSprite);
		this.spritePresets.add(new SpritePresetFactory().create(observableSprite));
	}
	
	/**
	 * @return createdSprite
	 * For use when dragging sprites to level. SpriteBuilder Doesn't do much right now, essentially dummy. 
	 * Will have to improve to use generics or reflection or something.
	 */
	@Override
	public Sprite addSprite(ISpritePreset spritePreset){
		Sprite createdSprite = new SpriteBuilder().createSpriteFromPreset(spritePreset);
		this.authorController.getCurrentGame().getCurrentLevel().addNewSprite(createdSprite);
		return createdSprite;
	}

}
