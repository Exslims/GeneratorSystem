package builders;

/**
 * Created by Константин on 09.04.2016.
 */
@RegisterAsBuilder(keyAsClass = Stub.class)
public class BuilderImpl implements Builder {
    @Override
    public String create(String someArg) {
        return "Hello from: "  + this.getClass().getTypeName() + " i created something through: " + someArg;
    }
}
