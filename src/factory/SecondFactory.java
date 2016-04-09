package factory;

import builders.Presenter;
import initializers.PresenterInitializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Константин on 09.04.2016.
 */
public class SecondFactory {
    public static Map<String, PresenterInitializer> map = new HashMap<>();
    public static void register(String string, PresenterInitializer<? extends Presenter> initializer){
        map.put(string,initializer);
    }
    public static String create(String alias, String testInfo){
        Presenter presenter = (Presenter) map.get(alias).newInstance(testInfo);
        return presenter.create(testInfo);
    }
}
