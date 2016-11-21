package author.view.pages.sprite;

import java.util.Arrays;

import author.view.pages.sprite.editor.SpriteEditPage;
import author.view.pages.sprite.editor.character.EnemySpriteEditPage;
import author.view.pages.sprite.editor.character.PlayerSpriteEditPage;
import author.view.pages.sprite.editor.item.ItemSpriteEditPage;
import author.view.pages.sprite.editor.projectile.ProjectileSpriteEditPage;
import author.view.pages.sprite.editor.terrain.TerrainSpriteEditPage;
import author.view.util.TabPaneFacade;
import javafx.geometry.Side;
import javafx.scene.layout.Region;

public class SpritesPage {
	
	TabPaneFacade mySpriteTabs;
	
	public SpritesPage(){
		mySpriteTabs = new TabPaneFacade();
		mySpriteTabs.getTabPane().setSide(Side.LEFT);
		SpriteEditPage[] spriteEditors= new SpriteEditPage[]{
				new PlayerSpriteEditPage(), 
				new EnemySpriteEditPage(), 
				new ItemSpriteEditPage(),
				new TerrainSpriteEditPage(),
				new ProjectileSpriteEditPage()
		};
		
		Arrays.asList(spriteEditors).forEach( se -> mySpriteTabs.addTab(se.getName(), se.getPane()));
	}
	
	public Region getRegion(){
		return mySpriteTabs.getTabPane();
	}
	
	@Override
	public String toString(){
		return "Sprite Editor";
	}
}
