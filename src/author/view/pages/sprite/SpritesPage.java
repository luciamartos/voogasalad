package author.view.pages.sprite;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.Arrays;

import author.view.pages.sprite.editor.BaseSpriteEditPage;
import author.view.pages.sprite.editor.character.EnemySpriteEditPage;
import author.view.pages.sprite.editor.character.PlayerSpriteEditPage;
import author.view.pages.sprite.editor.item.ItemSpriteEditPage;
import author.view.pages.sprite.editor.projectile.ProjectileSpriteEditPage;
import author.view.pages.sprite.editor.terrain.TerrainSpriteEditPage;
import author.view.util.TabPaneFacade;
import javafx.geometry.Side;
import javafx.scene.layout.Region;

public class SpritesPage {
	
	private Pane myPane;
	private SpriteScroller myPlayerScroller;
	private SpriteScroller myEnemyScroller;
	private SpriteScroller myTerrainScroller;
	private SpriteScroller myItemScroller;
	private SpriteScroller myProjectileScroller;
	
	public SpritesPage(){
		myPane = new HBox();
		myPlayerScroller = new SpriteScroller("Player");
		myEnemyScroller = new SpriteScroller("Enemy");
		myTerrainScroller = new SpriteScroller("Terrain");
		myItemScroller = new SpriteScroller("Item");
		myProjectileScroller = new SpriteScroller("Projectile");
		
		myPane.getChildren().addAll(
				myPlayerScroller.getNode(),
				myEnemyScroller.getNode(),
				myTerrainScroller.getNode(),
				myItemScroller.getNode(),
				myProjectileScroller.getNode()
				);		
	}
	
	public Region getRegion(){
		return myPane;
	}
	
	@Override
	public String toString(){
		return "Sprite Editor";
	}
}
