package pl.sda.library.model;

import java.io.PrintStream;
import java.util.Objects;

public class ReturnedState implements MultiMediaState {

    private final PrintStream printStream;

    public ReturnedState() {
        this.printStream = System.out;
    }

    public ReturnedState(PrintStream printStream) {
        this.printStream = printStream;
    }


    @Override
    public MultiMediaState borrowMultimedia(String firstName, String lastName) {
        BorrowedState borrowedState = new BorrowedState(printStream);
        borrowedState.setFirstName(firstName);
        borrowedState.setLastName(lastName);
        return  borrowedState;
    }

    @Override
    public MultiMediaState returnMultiMedia() {
        printStream.println("Nie można zwrócić książki ponownie");
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnedState that = (ReturnedState) o;
        return Objects.equals(printStream, that.printStream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printStream);
    }

    @Override public String toString() {
        return "ReturnedState{}";
    }

}
