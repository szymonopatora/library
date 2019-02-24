package pl.sda.library.model;

import java.io.PrintStream;
import java.util.Objects;

public class BorrowedState implements MultiMediaState {

    private final PrintStream printStream;
    private String firstName;
    private String lastName;

    public BorrowedState() {
        this.printStream = System.out;
    }

    public BorrowedState(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public MultiMediaState borrowMultimedia(String firstName, String lastName) {
        printStream.println("Książka jest już wypożyczona");
        return this;
    }

    @Override
    public MultiMediaState returnMultiMedia() {
        return new ReturnedState(printStream);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowedState state = (BorrowedState) o;
        return Objects.equals(printStream, state.printStream) &&
                Objects.equals(firstName, state.firstName) &&
                Objects.equals(lastName, state.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printStream, firstName, lastName);
    }

    @Override
    public String toString() {
        return "BorrowedState{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
