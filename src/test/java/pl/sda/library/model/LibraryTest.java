package pl.sda.library.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    @Test
    public void shouldAddBookWhenListOfBooksExist() {

        //given
        Library library = new Library();
        library.setMedia(new LinkedList<Book>());
        Book book = new PaperBook();
        book.setTitle("W pustyni i w puszczy");

        //when
        library.addMedia(book);

        //then
        assertEquals(Arrays.asList(book), library.getMedia());
    }
    @Test
    public void shouldAddBookWhenListOfBooksIsNull() {

        //given
        Library library = new Library();
        Book book = new PaperBookBuilder()
                .title("W pustyni i w puszczy")
                .build();
        //when
        library.addMedia(book);

        //then
        assertEquals(Arrays.asList(book), library.getMedia());
    }
}