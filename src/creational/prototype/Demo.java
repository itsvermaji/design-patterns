package creational.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Book {
    String id;
    public Book(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                '}';
    }
}

class BookShop implements Cloneable {
    private String shopName;
    List<Book> books = new ArrayList<>();

    public BookShop(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void loadData() throws InterruptedException {
        System.out.println("Loading books data...");
        TimeUnit.SECONDS.sleep(3);
        setBooks(IntStream.range(0, 10).boxed().map(i -> new Book(String.valueOf(i))).collect(Collectors.toList()));
        System.out.println("Books loaded successfully");
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public BookShop clone() {
        try {
            BookShop clone = (BookShop) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            clone.setBooks(clone.getBooks().stream().map(book -> new Book(book.id)).collect(Collectors.toList()));
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}


public class Demo {
    public static void main(String[] args) throws InterruptedException {
        BookShop bookShop = new BookShop("Deepinder publications");
        bookShop.loadData();

        System.out.println(bookShop.getBooks());

        // prototype dp
        BookShop bs2 = new BookShop("my library");
        bs2 = bookShop.clone();

        bs2.getBooks().getLast().setId("1000");

        System.out.println(bookShop.getBooks());
        System.out.println(bs2.getBooks());


    }
}
