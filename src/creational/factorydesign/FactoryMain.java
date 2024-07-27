package creational.factorydesign;
import creational.factorydesign.phone.*;

public class FactoryMain {
    public static void main(String[] args) {
        OS obj = new OperatingSystemFactory().getInstance("Hello");
//        OS obj = new Windows();
        obj.spec();

    }
}
