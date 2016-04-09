import builders.Stub;
import builders.Stub2;
import factory.FirstFactory;
import factory.SecondFactory;

public class Main {

    public static void main(String[] args) {
        Generator firstRec = new BuilderRecorder();
        firstRec.generate();

        System.out.println(FirstFactory.create(Stub.class,"someArg"));
        System.out.println(FirstFactory.create(Stub2.class,"someArg2"));

        Generator secondRec = new PresenterRecorder();
        secondRec.generate();

        System.out.println(SecondFactory.create("stringKey1","param1"));
        System.out.println(SecondFactory.create("stringKey2","param2"));


    }
}
