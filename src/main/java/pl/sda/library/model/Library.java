package pl.sda.library.model;

import pl.sda.library.model.Book;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Library<T extends Serializable> {

   private List<T> books;

    public List<T> getBooks() {
        //return books;
        return Collections.unmodifiableList(books); //chroni przed nieporządanymi modyfikacjami listy, poza klasą "Library"
    }

    public void setBooks(List<T> books) {
        this.books = new LinkedList<>(books);
    }

    public void addBook (T book) {
        if (books==null) {
            books= new LinkedList<>();
        }
        books.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
