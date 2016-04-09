package initializers;

/**
 * Created by Константин on 09.04.2016.
 */
public interface PresenterInitializer<T> {
    T newInstance(String test);
}
