package pl.sda.library;

import pl.sda.library.model.*;

import static pl.sda.library.model.Cover.HARD;


public class Main {
    public static void main(String[] args) {
        Library<Book> library = new Library<>();
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Carol")
                .authorLastName("Lewis")
                .title("Lew, czarownica i stara szafa")
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Andrzej")
                .authorLastName("Sapkowski")
                .title("Krew Elfów")
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Maria")
                .authorLastName("Zmierczak")
                .title("Spór o istotę fszyzmu")
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Michaił")
                .authorLastName("Bułhakow")
                .title("Mistrz i Małgorzata")
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Michalina")
                .authorLastName("Wisłocka")
                .title("Sztuka kochania")
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Niccolo")
                .authorLastName("Machiavelli")
                .title("Książę")
                .build());
        library.addBook(new PaperBookBuilder()
                .authorFirstName("Sun")
                .authorLastName("Tzu")
                .title("Sztuka wojny")
                .build());
        library.addBook(new AudioBookBuilder()
                .authorFirstName("Carol")
                .authorLastName("Lewis")
                .title("Lew, czarownica i stara szafa")
                .build());
        library.addBook(new AudioBookBuilder()
                .authorFirstName("Andrzej")
                .authorLastName("Sapkowski")
                .title("Krew Elfów")
                .build());
        library.addBook(new AudioBookBuilder()
                .authorFirstName("Maria")
                .authorLastName("Zmierczak")
                .title("Spór o istotę fszyzmu")
                .build());
        library.addBook(new AudioBookBuilder()
                .authorFirstName("Michaił")
                .authorLastName("Bułhakow")
                .title("Mistrz i Małgorzata")
                .build());
        library.addBook(new AudioBookBuilder()
                .authorFirstName("Michalina")
                .authorLastName("Wisłocka")
                .title("Sztuka kochania")
                .build());
        library.addBook(new AudioBookBuilder()
                .authorFirstName("Niccolo")
                .authorLastName("Machiavelli")
                .title("Książę")
                .build());
        library.addBook(new AudioBookBuilder()
                .authorFirstName("Sun")
                .authorLastName("Tzu")
                .title("Sztuka wojny")
                .build());
        for (Book book: library.getBooks()) {
            System.out.println(book);
        }
    }
}
