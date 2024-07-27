package creational.builderpattern;

import creational.builderpattern.phone.Phone;
import creational.builderpattern.phone.PhoneBuilder;

public class Shop {
    public static void main(String[] args) {
        // without using pattern
        Phone p = new Phone("Android", 2, "Qualcom", 5.5, 3100);
        System.out.println(p);

        // after using pattern
        Phone p2 = new PhoneBuilder()
                .setBattery(3500)
                .setOs("Kali")
                .build();

        System.out.println(p2);
    }
}
