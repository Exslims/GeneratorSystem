import builders.Stub;
import builders.Stub2;
import factory.FirstFactory;
import factory.SecondFactory;

public class Main {

    public static void main(String[] args) {
        BuilderRecorder firstReg = new BuilderRecorder();
        firstReg.generate();

        System.out.println(FirstFactory.create(Stub.class));
        System.out.println(FirstFactory.create(Stub2.class));

        PresenterRecorder secondReg = new PresenterRecorder();
        secondReg.generate();

        System.out.println(SecondFactory.create("stringKey1","param1"));
        System.out.println(SecondFactory.create("stringKey2","param2"));


    }
}
