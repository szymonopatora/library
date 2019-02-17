package pl.sda.library;

import pl.sda.library.model.*;


public class Main {
    public static void main(String[] args) {
        Library<MultiMedia> library = new Library<>();
        library.addMedia(new PaperBookBuilder()
                .authorFirstName("Carol")
                .authorLastName("Lewis")
                .title("Lew, czarownica i stara szafa")
                .build());
        library.addMedia(new PaperBookBuilder()
                .authorFirstName("Andrzej")
                .authorLastName("Sapkowski")
                .title("Krew Elfów")
                .build());
        library.addMedia(new PaperBookBuilder()
                .authorFirstName("Maria")
                .authorLastName("Zmierczak")
                .title("Spór o istotę fszyzmu")
                .build());
        library.addMedia(new PaperBookBuilder()
                .authorFirstName("Michaił")
                .authorLastName("Bułhakow")
                .title("Mistrz i Małgorzata")
                .build());
        library.addMedia(new PaperBookBuilder()
                .authorFirstName("Michalina")
                .authorLastName("Wisłocka")
                .title("Sztuka kochania")
                .build());
        library.addMedia(new PaperBookBuilder()
                .authorFirstName("Niccolo")
                .authorLastName("Machiavelli")
                .title("Książę")
                .build());
        library.addMedia(new PaperBookBuilder()
                .authorFirstName("Sun")
                .authorLastName("Tzu")
                .title("Sztuka wojny")
                .build());
        library.addMedia(new AudioBookBuilder()
                .authorFirstName("Carol")
                .authorLastName("Lewis")
                .title("Lew, czarownica i stara szafa")
                .build());
        library.addMedia(new AudioBookBuilder()
                .authorFirstName("Andrzej")
                .authorLastName("Sapkowski")
                .title("Krew Elfów")
                .build());
        library.addMedia(new AudioBookBuilder()
                .authorFirstName("Maria")
                .authorLastName("Zmierczak")
                .title("Spór o istotę fszyzmu")
                .build());
        library.addMedia(new AudioBookBuilder()
                .authorFirstName("Michaił")
                .authorLastName("Bułhakow")
                .title("Mistrz i Małgorzata")
                .build());
        library.addMedia(new AudioBookBuilder()
                .authorFirstName("Michalina")
                .authorLastName("Wisłocka")
                .title("Sztuka kochania")
                .build());
        library.addMedia(new AudioBookBuilder()
                .authorFirstName("Niccolo")
                .authorLastName("Machiavelli")
                .title("Książę")
                .build());
        library.addMedia(new AudioBookBuilder()
                .authorFirstName("Sun")
                .authorLastName("Tzu")
                .title("Sztuka wojny")
                .build());
        library.addMedia(new MagazineBuilder()
                .title("Motor")
                .number(15)
                .pageCount(32)
                .build());
        library.addMedia(new MagazineBuilder()
                .title("Newsweek")
                .number(14)
                .pageCount(64)
                .build());
        library.addMedia(new MagazineBuilder()
                .title("Polityka")
                .number(10)
                .pageCount(50)
                .build());
        library.addMedia(new MovieBuilder()
                .title("Skazani na Shawshank")
                .directorFirstName("Frank")
                .directorLastName("Darabont")
                .duration(120)
                .build());
        library.addMedia(new MovieBuilder()
                .title("Zielona mila")
                .directorFirstName("Frank")
                .directorLastName("Darabont")
                .duration(180)
                .build());
        library.addMedia(new MovieBuilder()
                .title("Nietykalni")
                .directorFirstName("Olivier")
                .directorLastName("Nakache")
                .duration(110)
                .build());
        library.getMedia().forEach(System.out::println);

    }
}
