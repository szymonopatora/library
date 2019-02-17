package pl.sda.library;

import pl.sda.library.command.Command;
import pl.sda.library.command.DisplayMultiMediaCommand;
import pl.sda.library.command.FilterByTypeCommand;
import pl.sda.library.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Library<MultiMedia> library = getMultiMediaLibrary();
        Scanner scanner = new Scanner(System.in);
        Map<String, Command> commands = new HashMap<>();
        commands.put("exit", () -> System.exit(0));
        commands.put("display", new DisplayMultiMediaCommand(library, System.out));
        commands.put("filter", new FilterByTypeCommand(library, System.out));
        while (true) {
            System.out.println("Podaj komendę");
            String commandName = scanner.nextLine();
            Command command = commands.get(commandName);
            Optional.ofNullable(command).ifPresent(Command::execute);
            //Optional.ofNullable(command).ifPresent(c->c.execute());
        }


    }

    private static Library<MultiMedia> getMultiMediaLibrary() {
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
        return library;
    }
}
