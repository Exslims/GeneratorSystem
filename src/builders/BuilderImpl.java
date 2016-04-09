package builders;

/**
 * Created by Константин on 09.04.2016.
 */
@RegisterAsBuilder(firstType = Stub.class)
public class BuilderImpl implements Builder {
    @Override
    public String create() {
        return "Hello from: "  + this.getClass().getTypeName();
    }
}
