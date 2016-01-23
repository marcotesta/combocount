package it.mondogrua.combocount;

import it.mondogrua.valuemodel.ValueModel;
import javafx.scene.Scene;

public interface Builder {
	public void addPane();
    public void addDisplayBoxOn(final ValueModel valueModel, int x, int y) ;
    public void addResetButtonOn(final ValueModel valueModel, int x, int y) ;
    public void addDecrementButtonOn(final ValueModel valueModel, int x, int y) ;
    public void addIncrementButtonOn(final ValueModel valueModel, int x, int y) ;
	public Scene getScene(int x, int y);
}
