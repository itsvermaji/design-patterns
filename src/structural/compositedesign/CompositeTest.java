package structural.compositedesign;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Component {
    void showPrice();
}

class Leaf implements Component {
    int price;
    String name;

    public Leaf(String n, int p) {
        name = n;
        price = p;
    }

    @Override
    public void showPrice() {
        System.out.println(MessageFormat.format("Name: {0}, Price: {1}", name, price));
    }
}

class Composite implements Component {
    private List<Component> components = new ArrayList<>();
    private String name;

    public Composite(String n) {
        name = n;
    }

    public void addComponents(Component ...c) {
        components.addAll(Arrays.stream(c).toList());
    }

    @Override
    public void showPrice() {
        System.out.println("Name: " + name);
        components.forEach(Component::showPrice);
    }
}


public class CompositeTest {
    public static void main(String[] args) {
        Component l1 = new Leaf("leaf1", 10);
        Component l2 = new Leaf("leaf2", 20);
        Component l3 = new Leaf("leaf3", 30);
        Component l4 = new Leaf("leaf4", 40);
        Composite l5 = new Composite("Composite1");
        l5.addComponents(l1, l2);

        Composite l6 = new Composite("Composite2");
        l6.addComponents(l3, l4);

        Composite l7 = new Composite("Composite3");
        l7.addComponents(l5, l6);

        l7.showPrice();
    }


}
