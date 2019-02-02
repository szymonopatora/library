package pl.sda.library;

import pl.sda.library.model.Book;

import pl.sda.library.model.BookBuilder;
import pl.sda.library.model.Library;



public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new BookBuilder()
                .authorFirstName("Carol")
                .authorLastName("Lewis")
                .title("Lew, czarownica i stara szafa")
                .build());
        library.addBook(new BookBuilder()
                .authorFirstName("Andrzej")
                .authorLastName("Sapkowski")
                .title("Krew Elfów")
                .build());
        library.addBook(new BookBuilder()
                .authorFirstName("Maria")
                .authorLastName("Zmierczak")
                .title("Spór o istotę fszyzmu")
                .build());
        library.addBook(new BookBuilder()
                .authorFirstName("Michaił")
                .authorLastName("Bułhakow")
                .title("Mistrz i Małgorzata")
                .build());
        library.addBook(new BookBuilder()
                .authorFirstName("Michalina")
                .authorLastName("Wisłocka")
                .title("Sztuka kochania")
                .build());
        library.addBook(new BookBuilder()
                .authorFirstName("Niccolo")
                .authorLastName("Machiavelli")
                .title("Książę")
                .build());
        library.addBook(new BookBuilder()
                .authorFirstName("Sun")
                .authorLastName("Tzu")
                .title("Sztuka wojny")
                .build());
        for (Book book: library.getBooks()) {
            System.out.println(book);
        }
    }
}
