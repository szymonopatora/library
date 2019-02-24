package pl.sda.library.command;

import pl.sda.library.model.Library;
import pl.sda.library.model.MultiMedia;
import pl.sda.library.model.MultiMediaState;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class BorrowMultiMediaCommand implements Command {

    private final Library<MultiMedia> library;
    private final PrintStream printStream;

    public BorrowMultiMediaCommand(Library<MultiMedia> library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        printStream.println("Tytuł: ");
        String title = scanner.nextLine();
        printStream.println("Imię osoby wypożyczającej: ");
        String firstName = scanner.nextLine();
        printStream.println("Nazwisko osoby wypożyczającej: ");
        String lastName = scanner.nextLine();
        Optional<MultiMedia> multiMedia = library.getMedia().stream()
                .filter(m -> Objects.equals(m.getTitle(), title))
                .findFirst();
        Optional<MultiMediaState> state= multiMedia.map(m -> m.getState().borrowMultimedia(firstName,lastName));
        multiMedia.ifPresent(m->m.setState(state.get()));
        if (!multiMedia.isPresent()) {
            printStream.println("Książka nie istnieje");
        }
    }
}
