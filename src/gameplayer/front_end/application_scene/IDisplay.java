// This entire file is part of my masterpiece.
// Ted Marchildon

/*
 * Used in the factory design pattern implemented by the application controller
 */

package gameplayer.front_end.application_scene;

import gameplayer.front_end.gui_generator.IGUIGenerator.ButtonDisplay;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

/**
 * Every display must have an init method that returns a Scene
 *
 * 
 * @author tedmarchildon, hannah
 *
 */
public interface IDisplay {
	
	public Scene init();
	
	public void addButton(String aLabel, EventHandler<? super MouseEvent> aHandler, ButtonDisplay aType);
	
	public void addNode(Node aNode);
	
	public void setBackground(String aFilePath, double aWidth, double aHeight);
	
}
