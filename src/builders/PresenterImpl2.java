package builders;

/**
 * Created by Константин on 09.04.2016.
 */
@RegisterAsPresenter(keyAsString = "stringKey2")
public class PresenterImpl2 implements Presenter {
    @Override
    public String create(String testInfo) {
        return "Hello from: " + this.getClass().getTypeName() + " my parameter: " + testInfo;
    }
}
