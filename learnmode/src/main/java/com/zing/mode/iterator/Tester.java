package com.zing.mode.iterator;

/**
 * @author zing
 * @date 2018/3/6 15:45
 */
public class Tester {
    public static void main(String[] args) {
        Book b1 = new Book("Around the World in 80 Days", "A");
        Book b2 = new Book("Bible", "B");
        Book b3 = new Book("Cinderella", "C");
        Book b4 = new Book("Daddy Long Legs", "D");

        BookShelf shelf = new BookShelf();
        shelf.addBooks(new Book[]{b1, b2, b3, b4});

        Iterator<Book> iterator = shelf.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
