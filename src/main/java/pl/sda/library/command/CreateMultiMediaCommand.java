package pl.sda.library.command;

import pl.sda.library.model.*;

import java.io.PrintStream;
import java.util.Scanner;

public class CreateMultiMediaCommand implements Command{

    public static final String AUDIO_BOOK = "AudioBook";
    private final Library<MultiMedia> library;
    private final PrintStream printStream;

    public CreateMultiMediaCommand(Library<MultiMedia> library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        printStream.println("Typ: ");
        String type = scanner.nextLine();
        if (type.equals(AUDIO_BOOK)) {
            printStream.println("Tytuł: ");
            String title = scanner.nextLine();
            printStream.println("Imię autora: ");
            String authorFirstName = scanner.nextLine();
            printStream.println("Nazwisko autora: ");
            String authorLastName = scanner.nextLine();
            printStream.println("Format: ");
            String format = scanner.nextLine();
            printStream.println("Czas trwania: ");
            int duration = scanner.nextInt();
            scanner.nextLine();
            AudioBook audioBook = new AudioBookBuilder()
                    .title(title)
                    .authorFirstName(authorFirstName)
                    .authorLastName(authorLastName)
                    .format(Format.valueOf(format))
                    .duration(duration)
                    .build();
            library.addMedia(audioBook);
        }
    }
}
