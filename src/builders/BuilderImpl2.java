package builders;

/**
 * Created by Константин on 09.04.2016.
 */
@RegisterAsBuilder(firstType = Stub2.class)
public class BuilderImpl2 implements Builder {
    @Override
    public String create() {
        return "Hello from: " + this.getClass().getTypeName();
    }
}
