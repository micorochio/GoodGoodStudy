package com.zing.mode.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zing
 * @date 2018/3/6 15:34
 */
public class BookShelf implements Aggregate {

    private ArrayList<Book> books;
    private int last = 0;

    public BookShelf() {
        this.books = new ArrayList<Book>();
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public Iterator iterator() {
        return new BookshelfIterator(this);
    }

    public int getLength() {
        return last;
    }

    public void addBooks(Book[] b) {
        List<Book> l = Arrays.asList(b);
        books.addAll(l);
        this.last = books.size();
    }
}
