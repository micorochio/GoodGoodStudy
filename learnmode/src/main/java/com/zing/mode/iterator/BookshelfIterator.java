package com.zing.mode.iterator;

/**
 * @author zing
 * @date 2018/3/6 15:38
 */
public class BookshelfIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index;

    public BookshelfIterator() {
    }

    public BookshelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    public Book next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
