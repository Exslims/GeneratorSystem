import builders.Builder;
import builders.BuilderImpl;
import builders.BuilderImpl2;
import builders.RegisterAsBuilder;
import factory.FirstFactory;
import initializers.BuilderInitializer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Константин on 09.04.2016.
 */
public class BuilderRecorder extends Generator {
    @Override
    protected void putClassesToList(List<AsyncDescriptor<?>> list, Class clazz) {
        RegisterAsBuilder annotation = (RegisterAsBuilder)clazz.getAnnotation(getDeclaredAnnotation());
        if(annotation != null){
            list.add(new AsyncDescriptor<Class>(annotation.keyAsClass(),clazz));
        }
    }

    @Override
    protected Class getDeclaredAnnotation() {
        return RegisterAsBuilder.class;
    }

    @Override
    protected Class getInterface() {
        return Builder.class;
    }

    @Override
    protected List<Class> findClasses() {
        List<Class> list = new ArrayList<>();
        list.add(BuilderImpl.class);
        list.add(BuilderImpl2.class);
        return list;
    }

    @Override
    protected void finish(List<AsyncDescriptor<?>> asyncDescriptorList) {
        for (AsyncDescriptor asyncDescriptor : asyncDescriptorList) {
            FirstFactory.register((Class)asyncDescriptor.getAliasType(), new BuilderInitializer<Builder>(){
                @Override
                public Builder newInstance() {
                    try {
                        return (Builder)(asyncDescriptor.getaClass().newInstance());
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
