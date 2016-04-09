package factory;

import builders.Builder;
import initializers.BuilderInitializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Константин on 09.04.2016.
 */
public class FirstFactory {
    public static Map<Class, BuilderInitializer> map = new HashMap<>();
    public static void register(Class clazz, BuilderInitializer<? extends Builder> initializer){
        map.put(clazz,initializer);
    }
    public static String create(Class classType){
        Builder builder = (Builder) map.get(classType).newInstance();
        return builder.create();
    }
}
