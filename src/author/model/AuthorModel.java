/**
 * 
 */
package author.model;

import java.util.ArrayList;
import java.util.List;

import author.controller.IAuthorController;
import author.model.game_observables.ObservableSprite;
import author.model.game_observables.ObservableSpriteFactory;
import author.model.presets.ISpritePreset;
import author.model.presets.SpritePresetFactory;
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
	 * @return createdSprite. For use when dragging sprites to level. Returns Null right now.
	 */
	@Override
	public Sprite addSprite(ISpritePreset spritePreset){
		//Still need to implement
		return null;
	}

}
