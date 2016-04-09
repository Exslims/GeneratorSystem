import presenters.RegisterAsPresenter;
import presenters.Presenter;
import presenters.PresenterImpl;
import presenters.PresenterImpl2;
import factory.SecondFactory;
import initializers.PresenterInitializer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Константин on 09.04.2016.
 */
public class PresenterRecorder extends Generator {
    @Override
    protected void putClassesToList(List<AsyncDescriptor<?>> list, Class clazz) {
        RegisterAsPresenter annotation = (RegisterAsPresenter)clazz.getAnnotation(RegisterAsPresenter.class);
        list.add(new AsyncDescriptor<String>(annotation.keyAsString(),clazz));
    }

    @Override
    protected Class getDeclaredAnnotation() {
        return RegisterAsPresenter.class;
    }

    @Override
    protected Class getInterface() {
        return null;
    }

    @Override
    protected List<Class> findClasses() {
        List<Class> list = new ArrayList<>();
        list.add(PresenterImpl.class);
        list.add(PresenterImpl2.class);
        return list;
    }

    @Override
    protected void finish(List<AsyncDescriptor<?>> asyncDescriptorList) {
        for (AsyncDescriptor asyncDescriptor : asyncDescriptorList) {
            SecondFactory.register((String) asyncDescriptor.getAliasType(), new PresenterInitializer<Presenter>() {
                @Override
                public Presenter newInstance(String test) {
                    try {
                        return (Presenter)asyncDescriptor.getaClass().newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            });
        }

    }
}
