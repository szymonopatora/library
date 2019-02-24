package pl.sda.library.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.sda.library.model.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CreateMultiMediaCommandTest {
    private static final String TEST_AUDIO_BOOK_INPUT = "AudioBook\nW pustyni i w puszczy\nHenryk\nSienkiewicz\nMP3\n100\n";
    private static final String TEST_PAPER_BOOK_INPUT = "PaperBook\nW pustyni i w puszczy\nHenryk\nSienkiewicz\nHARD\n300\n";
    private static final String TEST_MOVIE_BOOK_INPUT = "Movie\nCzłowiek z żelaza\nAndrzej\nWajda\n120\n";
    private static final String TEST_MAGAZINE_BOOK_INPUT = "Magazine\nProgramista\n10\n100\n";
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
    public void shouldCreateAudioBookWhenAudioBookWasTyped() {

        //given
        System.setIn(new ByteArrayInputStream(TEST_AUDIO_BOOK_INPUT.getBytes()));
        Library<MultiMedia> library = new Library<>();

        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new CreateMultiMediaCommand(library, printStreamMock);

        //when
        command.execute();

        //then
        AudioBook audioBook = new AudioBookBuilder()
                .title("W pustyni i w puszczy")
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .format(Format.MP3)
                .duration(100)
                .build();
        Library<MultiMedia> expectedLibrary = new Library<>();
        expectedLibrary.addMedia(audioBook);
        assertEquals(expectedLibrary, library);
        verify(printStreamMock, times(1)).println("Typ: ");
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Imię autora: ");
        verify(printStreamMock, times(1)).println("Nazwisko autora: ");
        verify(printStreamMock, times(1)).println("Format: ");
        verify(printStreamMock, times(1)).println("Czas trwania: ");
    }
    @Test
    public void shouldCreatePaperBookWhenPaperBookWasTyped() {

        //given
        System.setIn(new ByteArrayInputStream(TEST_PAPER_BOOK_INPUT.getBytes()));

        Library<MultiMedia> library = new Library<>();

        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new CreateMultiMediaCommand(library, printStreamMock);

        //when
        command.execute();

        //then
        PaperBook paperBook = new PaperBookBuilder()
                .title("W pustyni i w puszczy")
                .authorFirstName("Henryk")
                .authorLastName("Sienkiewicz")
                .cover(Cover.HARD)
                .pageCount(300)
                .build();
        Library<MultiMedia> expectedLibrary = new Library<>();
        expectedLibrary.addMedia(paperBook);
        assertEquals(expectedLibrary, library);
        verify(printStreamMock, times(1)).println("Typ: ");
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Imię autora: ");
        verify(printStreamMock, times(1)).println("Nazwisko autora: ");
        verify(printStreamMock, times(1)).println("Okładka: ");
        verify(printStreamMock, times(1)).println("Liczba stron: ");
    }
    @Test
    public void shouldCreateMovieWhenMovieWasTyped() {

        //given
        System.setIn(new ByteArrayInputStream(TEST_MOVIE_BOOK_INPUT.getBytes()));
        Library<MultiMedia> library = new Library<>();

        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new CreateMultiMediaCommand(library, printStreamMock);

        //when
        command.execute();

        //then
        Movie movie = new MovieBuilder()
                .title("Człowiek z żelaza")
                .directorFirstName("Andrzej")
                .directorLastName("Wajda")
                .duration(120)
                .build();
        Library<MultiMedia> expectedLibrary = new Library<>();
        expectedLibrary.addMedia(movie);
        assertEquals(expectedLibrary, library);
        verify(printStreamMock, times(1)).println("Typ: ");
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Imię reżysera: ");
        verify(printStreamMock, times(1)).println("Nazwisko reżysera: ");
        verify(printStreamMock, times(1)).println("Czas trwania: ");
    }
    @Test
    public void shouldCreateMagazineWhenMagazineWasTyped() {

        //given
        System.setIn(new ByteArrayInputStream(TEST_MAGAZINE_BOOK_INPUT.getBytes()));
        Library<MultiMedia> library = new Library<>();

        PrintStream printStreamMock = mock(PrintStream.class);
        Command command = new CreateMultiMediaCommand(library, printStreamMock);

        //when
        command.execute();

        //then
        Magazine magazine = new MagazineBuilder()
                .title("Programista")
                .number(10)
                .pageCount(100)
                .build();
        Library<MultiMedia> expectedLibrary = new Library<>();
        expectedLibrary.addMedia(magazine);
        assertEquals(expectedLibrary, library);
        verify(printStreamMock, times(1)).println("Typ: ");
        verify(printStreamMock, times(1)).println("Tytuł: ");
        verify(printStreamMock, times(1)).println("Numer: ");
        verify(printStreamMock, times(1)).println("Liczba stron: ");
    }
}