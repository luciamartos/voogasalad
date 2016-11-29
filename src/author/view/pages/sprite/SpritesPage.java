package author.view.pages.sprite;

import java.util.Arrays;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
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
		
		SpriteScroller[] scrollers = new SpriteScroller[]{
				myPlayerScroller,
				myEnemyScroller,
				myTerrainScroller,
				myItemScroller,
				myProjectileScroller};
		
		Arrays.asList(scrollers).forEach(s -> {
			myPane.getChildren().add(s.getNode());
			HBox.setHgrow(s.getNode(), Priority.ALWAYS);
		});
	}
	
	public Region getRegion(){
		return myPane;
	}
	
	@Override
	public String toString(){
		return "Sprite Editor";
	}
}
