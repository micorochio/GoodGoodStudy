package com.zing.mode.iterator;

/**
 * @author zing
 * @date 2018/3/6 15:34
 */
public class BookShelf implements Aggregate {

    private Book[] books;
    private int last = 0;

    public BookShelf(int shelfSize) {
        this.books = new Book[shelfSize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public Iterator iterator() {
        return new BookshelfIterator(this);
    }

    public int getLength() {
        return last;
    }

    public void setBooks(Book[] books) {
        this.books = books;
        this.last = books.length;
    }
}
