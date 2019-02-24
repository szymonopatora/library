package pl.sda.library.model;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.only;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ReturnedStateTest {

    @Test
    public void shouldBorrowBookWhenIsReturned() {
        //given
        PrintStream printStreamMock = mock(PrintStream.class);
        MultiMediaState state = new ReturnedState(printStreamMock);
        String firstName = "Jan";
        String lastName = "Kowalski";

        //when
        MultiMediaState multiMediaState = state.borrowMultimedia(firstName, lastName);

        //then
        assertTrue(multiMediaState instanceof BorrowedState);
        assertEquals(firstName, ((BorrowedState) multiMediaState).getFirstName());
        assertEquals(lastName, ((BorrowedState) multiMediaState).getLastName());
    }

    @Test
    public void shouldNotReturnBookWhenIsBookReturned () {
        //given
        PrintStream printStreamMock = mock(PrintStream.class);
        MultiMediaState state = new ReturnedState(printStreamMock);


        //when
        MultiMediaState multiMediaState = state.returnMultiMedia();

        //then
        assertTrue(multiMediaState instanceof ReturnedState);
        verify(printStreamMock, only()).println("Nie można zwrócić książki ponownie");
    }

}