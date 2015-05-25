package it.mondogrua.combocount.swing_count_view;

import it.mondogrua.utils.ComboObservable;
import it.mondogrua.utils.JavaUtilObserver;
import it.mondogrua.utils.JavaUtilObserverObserver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class DisplayBox extends JLabel implements JavaUtilObserverObserver {

    private final JavaUtilObserver observer;

    public DisplayBox(ComboObservable count, String action) {
        this.observer = new JavaUtilObserver(this);
        count.addObserver(observer);
        update(count, action);
    }

    @Override  // JavaUtilObserverObserver
    public void update(ComboObservable observable, Object action) {
        setContent(getContentFrom(observable, (String) action));
    }

    // Private Methods --------------------------------------------------------

    private void setContent(String value) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setText(value);
            }
        });
    }

    private String getContentFrom(Object model, String action) {

        Method method;
        try {
            method = model.getClass().getMethod(action);
            Object ret = method.invoke(model, new Object[]{});
            return ret.toString();
        } catch (SecurityException e) {
            // ...
        } catch (NoSuchMethodException e) {
            // ...
        } catch (IllegalAccessException e) {
            // ...
        } catch (IllegalArgumentException e) {
            // ...
        } catch (InvocationTargetException e) {
            // ...
        }
        return "";
    }

}
