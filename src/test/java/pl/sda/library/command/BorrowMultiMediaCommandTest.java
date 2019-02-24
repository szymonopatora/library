package pl.sda.library.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.sda.library.model.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static sun.misc.Version.println;

public class BorrowMultiMediaCommandTest {

    private InputStream inputStream;

    @Before
    public void setUp() {
        inputStream = System.in;
    }

    @After
    public void tearDown() {
        System.setIn(inputStream);
    }

    @Test
    public void shouldBorrowMovieWhenIsReturned() {

        //given
        Library<MultiMedia> libraryMock = mock(Library.class);
        PrintStream printStreamMock = mock(PrintStream.class);
        BorrowMultiMediaCommand command = new BorrowMultiMediaCommand(libraryMock, printStreamMock);
        Movie movie = new MovieBuilder().title("Testowy tytuł").build();
        movie.setState(new ReturnedState());
        when(libraryMock.getMedia()).thenReturn(Arrays.asList(movie));
        System.setIn(new ByteArrayInputStream("Testowy tytuł\nJan\nKowalski\n".getBytes()));
        //when(libraryMock.getMedia()).thenThrow(NullPointerException.class);
        //Mockito.doNothing().when(printStreamMock).println();

        //when
        command.execute();

        //then
        verify(printStreamMock, times(1))
                .println("Tytuł: ");
        verify(printStreamMock, times(1))
                .println("Imię osoby wypozyczającej: ");
        verify(printStreamMock, times(1))
                .println("Nazwisko osoby wypożyczającej: ");
        MultiMediaState state = movie.getState();
        assertTrue(state instanceof BorrowedState);
        assertEquals("Jan", ((BorrowedState) state).getFirstName());
        assertEquals("Kowalski", ((BorrowedState) state).getLastName());
    }

    @Test
    public void shouldNotBorrowMovieWhenIsBorrowed() {

        //given
        Library<MultiMedia> libraryMock = mock(Library.class);
        PrintStream printStreamMock = mock(PrintStream.class);
        BorrowMultiMediaCommand command = new BorrowMultiMediaCommand(libraryMock, printStreamMock);
        Movie movie = new MovieBuilder().title("Testowy tytuł").build();
        movie.setState(new BorrowedState(printStreamMock));
        when(libraryMock.getMedia()).thenReturn(Arrays.asList(movie));
        System.setIn(new ByteArrayInputStream("Testowy tytuł\nJan\nKowalski\n".getBytes()));
        //when(libraryMock.getMedia()).thenThrow(NullPointerException.class);
        //Mockito.doNothing().when(printStreamMock).println();

        //when
        command.execute();

        //then
        verify(printStreamMock, times(1))
                .println("Tytuł: ");
        verify(printStreamMock, times(1))
                .println("Imię osoby wypozyczającej: ");
        verify(printStreamMock, times(1))
                .println("Nazwisko osoby wypożyczającej: ");
        verify(printStreamMock, times(1)).println("Książka jest już wypożyczona");
        MultiMediaState state = movie.getState();
        assertTrue(state instanceof BorrowedState);
        assertNull(null, ((BorrowedState) state).getFirstName());
        assertNull(null, ((BorrowedState) state).getLastName());
    }

    @Test
    public void shouldNotBorrowMovieWhenIsNotExisting() {

        //given
        Library<MultiMedia> libraryMock = mock(Library.class);
        PrintStream printStreamMock = mock(PrintStream.class);
        BorrowMultiMediaCommand command = new BorrowMultiMediaCommand(libraryMock, printStreamMock);

        when(libraryMock.getMedia()).thenReturn(Collections.emptyList());
        System.setIn(new ByteArrayInputStream("Testowy tytuł\nJan\nKowalski\n".getBytes()));

        //when
        command.execute();

        //then
        verify(printStreamMock, times(1))
                .println("Tytuł: ");
        verify(printStreamMock, times(1))
                .println("Imię osoby wypozyczającej: ");
        verify(printStreamMock, times(1))
                .println("Nazwisko osoby wypożyczającej: ");
        verify(printStreamMock, times(1))
                .println("Książka nie istnieje");

    }

}