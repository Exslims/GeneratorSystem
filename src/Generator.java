import java.util.ArrayList;
import java.util.List;

/**
 * Created by Константин on 09.04.2016.
 */
public abstract class Generator {
    protected abstract void putClassesToList(List<AsyncDescriptor<?>> list, Class clazz);
    protected abstract Class getDeclaredAnnotation();
    protected abstract Class getInterface();
    public void generate(){
        List<AsyncDescriptor<?>> list = new ArrayList<>();
        List<Class> arrayOfClasses = findClasses();
        for (Class aClass : arrayOfClasses) {
            putClassesToList(list, aClass);
        }
        finish(list);
    }
    protected abstract List<Class> findClasses();
    protected abstract void finish(List<AsyncDescriptor<?>> asyncDescriptorList);

}
