package presenters;

/**
 * Created by Константин on 09.04.2016.
 */
@RegisterAsPresenter(keyAsString = "stringKey1")
public class PresenterImpl implements Presenter {
    @Override
    public String create(String testInfo) {
        return "Hello from: " + this.getClass().getTypeName() + " my parameter: " + testInfo;
    }
}
