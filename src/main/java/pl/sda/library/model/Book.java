package pl.sda.library.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Book extends MultiMedia implements Serializable {

    protected Creator author;


    public Creator getAuthor() {
        return author;
    }

    public void setAuthor(Creator author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public String toString() {
        return "{" +
                "author=" + author +
                + '\'' +
                '}'+ super.toString();
    }
}
