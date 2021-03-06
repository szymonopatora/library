package pl.sda.library.command;

import pl.sda.library.model.Library;
import pl.sda.library.model.MultiMedia;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.StreamCorruptedException;
import java.util.Scanner;
import java.util.stream.Stream;

public class FilterByTypeCommand implements Command {

    private final Library<MultiMedia> library;
    private final PrintStream printStream;


    public FilterByTypeCommand(Library<MultiMedia> library, PrintStream printStream) {
        this.library = library;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        printStream.println("Typ:");
        String type = scanner.nextLine();
        library.getMedia().stream()
                .filter(x -> x.getType().equals(type))
                .forEach(printStream::println);
        /*for (MultiMedia multiMedia:library.getMedia()) {
            if (multiMedia.getClass().getSimpleName().equals(type)) {
                printStream.println(multiMedia);
            }
        }*/



    }
}