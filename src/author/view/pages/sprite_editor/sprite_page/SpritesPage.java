package author.view.pages.sprite_editor.sprite_page;

import author.view.utility.TabPaneFacade;
import javafx.geometry.Side;
import javafx.scene.layout.Region;

public class SpritesPage {
	
	TabPaneFacade mySpriteTabs;
	
	public SpritesPage(){
		mySpriteTabs = new TabPaneFacade();
		mySpriteTabs.getTabPane().setSide(Side.TOP);
		String[] sprites = new String[]{"Characters", "Items", "Projectiles", "Terrains"};
		
		for(String name: sprites){
			mySpriteTabs.addTab(name, null);
		}
		
	}
	
	public Region getRegion(){
		return mySpriteTabs.getTabPane();
	}
	
	@Override
	public String toString(){
		return "Sprite Editor";
	}
}
