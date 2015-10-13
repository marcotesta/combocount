package it.mondogrua.combocount;

import it.mondogrua.combocount.count.Count;
import javafx.scene.Scene;

public interface Builder {
	public void addPane();
    public void addDisplayBoxOn(final Count count, int x, int y) ;
    public void addResetButtonOn(final Count count, int x, int y) ;
    public void addDecrementButtonOn(final Count count, int x, int y) ;
    public void addIncrementButtonOn(final Count count, int x, int y) ;
	public Scene getScene(int x, int y);
}
