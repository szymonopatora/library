package pl.sda.library.model;


import java.util.Optional;

public class AudioBookBuilder {

    private String authorFirstName;
    private String authorLastName;
    protected String title;
    private Format format;
    private int duration;

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

    public AudioBookBuilder duration (int duration) {
        this.duration = duration;
        return this;
    }

    public AudioBook build() {
        AudioBook book = new AudioBook();
        Creator author = new Creator();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        book.setAuthor(author);
        book.setTitle(title);
        book.setFormat(Optional.ofNullable(this.format).orElse(Format.MP3));
        Optional<Format> formatOptional = Optional.ofNullable(this.format);
        formatOptional.orElse(Format.MP3);//instead of if statement
        book.setDuration(duration);
        return book;
    }
}
