package pl.sda.library.command;

import pl.sda.library.model.MultiMedia;

import java.io.PrintStream;
import java.util.Scanner;

public interface CreateMultiMediaStrategy {

    MultiMedia createMultiMedia(Scanner scanner, PrintStream printStream);

    boolean isTypeCorrect(String type);

}
