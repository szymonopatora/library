package pl.sda.library.command;
import pl.sda.library.model.*;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CreateMultiMediaCommand implements Command{

    private final Library<MultiMedia> library;
    private final PrintStream printStream;
    private final List<CreateMultiMediaStrategy> strategies = Arrays.asList(
            new CreateAudioBookCommandStrategy(),
            new CreatePaperBookCommandStrategy(),
            new CreateMovieCommandStrategy(),
            new CreateMagazineCommandStrategy()
    );

    public CreateMultiMediaCommand(Library<MultiMedia> library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        printStream.println("Typ: ");
        String type = scanner.nextLine();
        Optional<MultiMedia> multiMedia=strategies.stream()
                .filter(s -> s.isTypeCorrect(type))
                .findFirst()
                .map(s -> s.createMultiMedia(scanner, printStream));
        multiMedia.ifPresent(m -> library.addMedia(m));
        }
    }

