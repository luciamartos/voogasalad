package author.view.pages.sprite;

import java.util.Arrays;

import author.controller.IAuthorController;
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
	
	private IAuthorController myController;
	
	public SpritesPage(IAuthorController aController){
		myController = aController;
		
		myPane = new HBox();
		myPlayerScroller = new SpriteScroller("Player", myController);
		myEnemyScroller = new SpriteScroller("Enemy", myController);
		myTerrainScroller = new SpriteScroller("Terrain", myController);
		myItemScroller = new SpriteScroller("Item", myController);
		myProjectileScroller = new SpriteScroller("Projectile", myController);
		
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
