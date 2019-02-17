package pl.sda.library.command;

import pl.sda.library.model.Library;
import pl.sda.library.model.MultiMedia;

import java.io.PrintStream;

public class DisplayMultiMediaCommand implements Command {

    private final Library<MultiMedia> library;
    private final PrintStream printStream;

    public DisplayMultiMediaCommand(Library<MultiMedia> library, PrintStream printStream) {
        this.library = library;
        this.printStream=printStream;
    }

    @Override
    public void execute() {
        //TODO
        library.getMedia().forEach(printStream::println);
    }
}
