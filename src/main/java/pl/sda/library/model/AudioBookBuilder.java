package pl.sda.library.model;


import java.util.Optional;

public class AudioBookBuilder {

    protected String authorFirstName;
    protected String authorLastName;
    protected String title;
    protected Format format;

    public AudioBookBuilder format(Format format) {
        this.format = format;
        return this;
    }

    public AudioBookBuilder authorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }


    public AudioBookBuilder authorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }


    public AudioBookBuilder title(String title) {
        this.title = title;
        return this;
    }

    public AudioBook build() {

        AudioBook book = new AudioBook();
        Author author = new Author();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        book.setAuthor(author);
        book.setTitle(title);
        book.setFormat(Optional.ofNullable(this.format).orElse(Format.MP_3));
        Optional<Format> formatOptional = Optional
                .ofNullable(this.format);
        formatOptional.orElse(Format.MP_3);//instead of if statement
        return book;

    }
}
