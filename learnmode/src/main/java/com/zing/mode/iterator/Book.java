package com.zing.mode.iterator;

/**
 * @author zing
 * @date 2018/3/6 15:32
 * <p>
 * 书
 */
public class Book {
    /**
     * 书名
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
