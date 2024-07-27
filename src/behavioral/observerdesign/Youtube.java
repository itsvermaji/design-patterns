package behavioral.observerdesign;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Channel {
    private final List<Subscriber> subscriberList = new ArrayList<>();
    private String title;

    public Channel(String title) {
        this.title = title;
    }

    public void subscribe(Subscriber ...sub) {
        subscriberList.addAll(List.of(sub));
    }

    public void unSubscribe(Subscriber sub) {
        subscriberList.removeIf(subscriber -> subscriber.getName().equals(sub.getName()));
    }

    public void notifySubscribers(String message) {
        subscriberList.forEach(sub -> sub.update(message));
    }

    public void upload(String title) {
        notifySubscribers("Watch the newly released " + title);
    }

}

class Subscriber {
    private String name;
    private List<String> newNotifications = new ArrayList<>();
    private List<String> historyNotifications = new ArrayList<>();

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        newNotifications.add(message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void subscribe(Channel ch) {
        ch.subscribe(this);
    }

    public void unSubscribe(Channel ch) {
        ch.unSubscribe(this);
    }

    public void readNotifications() {
        System.out.println("Subscriber: " + name);
        newNotifications.forEach(System.out::println);

        historyNotifications.addAll(newNotifications);
        historyNotifications = historyNotifications.reversed();
        newNotifications = new ArrayList<>();
    }

    public void readHistory() {
        System.out.println("Subscriber " + name);
        historyNotifications.forEach(history -> System.out.println(history));
    }
}

public class Youtube {
    public static void main(String[] args) throws InterruptedException {
        Channel deepak = new Channel("Deepak woodworks");
        Channel mansi = new Channel("Mansi travel vlogs");

        Subscriber lakshya = new Subscriber("Lakshya");
        Subscriber keshu = new Subscriber("Keshu");
        Subscriber s3 = new Subscriber("S3");
        Subscriber s4 = new Subscriber("S4");
        Subscriber s5 = new Subscriber("S5");

        lakshya.subscribe(deepak);
        lakshya.subscribe(mansi);
        keshu.subscribe(mansi);
        s3.subscribe(deepak);
        s4.subscribe(deepak);
        s5.subscribe(deepak);

        deepak.upload("How to check good quality of wood!");
        deepak.upload("How to check good quality of wood! Part - 2");
        deepak.upload("How to check good quality of wood! Part - 3");
        mansi.upload("Experience the divine views of Leh with Mansi");

        lakshya.readNotifications();
        keshu.readNotifications();

        System.out.println("After lakshya and keshu are done reading their notifications they check their history");
        TimeUnit.SECONDS.sleep(5);
        System.out.println();
        System.out.println();

        lakshya.readHistory();
        keshu.readHistory();
    }
}
