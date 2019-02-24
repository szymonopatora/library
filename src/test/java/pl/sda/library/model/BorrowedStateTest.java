package pl.sda.library.model;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class BorrowedStateTest {

    @Test
    public void shouldNotBorrowBookWhenIsBorrowed() {

        //given
        PrintStream printStreamMock = Mockito.mock(PrintStream.class);
        BorrowedState state = new BorrowedState(printStreamMock);
        String firstName1 = "Jan";
        String lastName1 = "Kowalski";
        state.setFirstName(firstName1);
        state.setLastName(lastName1);
        String firstName2 = "Andrzej";
        String lastName2 = "Kowalski";


        //when
        MultiMediaState multiMediaState = state.borrowMultimedia(firstName2, lastName2);

        //then
        assertTrue(multiMediaState instanceof BorrowedState);
        assertEquals(firstName1, ((BorrowedState) multiMediaState).getFirstName());
        assertEquals(lastName1, ((BorrowedState) multiMediaState).getLastName());
        verify(printStreamMock, only()).println("Książka jest już wypożyczona");
    }

    @Test
    public void shouldReturnBookWhenBookIsBorrowed () {
        //given
        PrintStream printStreamMock = Mockito.mock(PrintStream.class);
        BorrowedState state = new BorrowedState(printStreamMock);

        //when
        MultiMediaState multiMediaState = state.returnMultiMedia();

        //then
        assertTrue(multiMediaState instanceof ReturnedState);
        verify(printStreamMock, never()).println(anyString());
    }

}