package pl.sda.library.command;

import org.junit.Test;
import org.mockito.Mockito;
import pl.sda.library.model.*;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DisplayMultiMediaCommandTest {
    @Test
    public void shouldDisplayMultiMediaWhenSomeMultiMediaIsAvailable() {

        //given
        PaperBook book = new PaperBookBuilder()
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .title("W pustyni i w puszczy")
                .cover(Cover.HARD)
                .pageCount(100)
                .build();
        Movie movie = new MovieBuilder()
                .directorFirstName("Andrzej")
                .directorLastName("Wajda")
                .title("W pustyni i w puszczy")
                .duration(100)
                .build();
        Library<MultiMedia> library = new Library<>();
        library.addMedia(book);
        library.addMedia(movie);
        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new DisplayMultiMediaCommand(library, printStreamMock);

        //when
        command.execute();

        //then
        verify(printStreamMock, times(1)).println(book);
        verify(printStreamMock, times(1)).println(movie);

    }
}