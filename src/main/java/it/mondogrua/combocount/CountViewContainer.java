package it.mondogrua.combocount;

import it.mondogrua.combocount.count.Count;

public class CountViewContainer  {

    public void openOn(final Count count, Builder builder) {
        buildViewsOn(count, builder);
    }

    private void buildViewsOn(final Count count, Builder builder) {
    	builder.addPane();
    	builder.addDisplayBoxOn(count, 1, 1);
    	builder.addIncrementButtonOn(count, 0, 2);
    	builder.addDecrementButtonOn(count, 1, 2);
    	builder.addResetButtonOn(count, 2, 2);
    }

}
