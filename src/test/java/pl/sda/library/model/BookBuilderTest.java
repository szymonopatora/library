package pl.sda.library.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookBuilderTest {

    @Test
    public void shouldBuildBookWhenBookDetailsAreDefined () {
        //given
        String authorFirstName = "Henryk";
        String authorLastName = "Sienkiewicz";
        String title = "W pustyni i w puszczy";

        //when
        Book book= new BookBuilder().authorFirstName(authorFirstName).authorLastName(authorLastName).title(title).build();

        //then
        assertNotNull(book);
        assertNotNull(book.getAuthor());
        assertNotNull(authorFirstName, book.getAuthor().getFirstName());
        assertNotNull(authorLastName, book.getAuthor().getLastName());
        assertNotNull(title, book.getTitle());
    }

}