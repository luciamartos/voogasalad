package author.view.pages.characteristics;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

public class SpriteCharacteristicEditor {

	private Accordion myAccordion;
	private List<TitledPane> myPanes;
	
	public SpriteCharacteristicEditor() {
		myAccordion = new Accordion();
		myPanes = new ArrayList<>();
		
		String[] characteristicsNames = new String[]{"Bouncer", "Breakable", "Damager"};
				
		for(int i = 0; i < characteristicsNames.length; i++){
			myPanes.add(new TitledPane(characteristicsNames[i], new CharacteristicEditBox().getPane()));
		}
		
		myAccordion.getPanes().addAll(myPanes);
	}

	public Node getNode(){
		return myAccordion;
	}
	
}
