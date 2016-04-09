/**
 * Created by Константин on 09.04.2016.
 */
public class AsyncDescriptor<AliasType> {
    private AliasType aliasType;
    private Class aClass;

    public AsyncDescriptor(AliasType aliasType, Class aClass) {
        this.aliasType = aliasType;
        this.aClass = aClass;
    }

    public AliasType getAliasType() {
        return aliasType;
    }

    public void setAliasType(AliasType aliasType) {
        this.aliasType = aliasType;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public String toString() {
        return "AsyncDescriptor{" +
                "aliasType=" + aliasType +
                ", aClass=" + aClass +
                '}';
    }
}
