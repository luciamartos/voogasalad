package author.view.pages.characteristics;

import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

public class SpriteCharacteristicEditor {

	private static final String[] TEST_NAMES =
			new String[]{"Zero","One", "Two"};
	
	private Accordion myAccordion;
	
	public SpriteCharacteristicEditor() {
		myAccordion = new Accordion();
		
		TitledPane[] tps = new TitledPane[TEST_NAMES.length];
		
		for(int i = 0; i < TEST_NAMES.length; i++){
			tps[i] = new TitledPane(
					TEST_NAMES[i], 
					new Label(TEST_NAMES[i]));
		}
		
		myAccordion.getPanes().addAll(tps);
		
	}

	public Node getNode(){
		return myAccordion;
	}
	
}
