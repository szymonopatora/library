package pl.sda.library.model;


import java.util.Optional;

public class PaperBookBuilder {

    protected String authorFirstName;
    protected String authorLastName;
    protected String title;
    private Cover cover;

    public PaperBookBuilder cover(Cover cover) {
        this.cover = cover;
        return this;
    }

    public PaperBookBuilder authorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }


    public PaperBookBuilder authorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }


    public PaperBookBuilder title(String title) {
        this.title=title;
        return this;
    }

    public PaperBook build() {
        PaperBook book = new PaperBook();
        Author author = new Author();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        book.setAuthor(author);
        book.setTitle(title);
        book.setCover(Optional.ofNullable(this.cover).orElse(Cover.SOFT));
        Optional<Cover>coverOptional=Optional
                .ofNullable(this.cover);
        coverOptional.orElse(Cover.SOFT);//instead of if statement
        return book;

    }
}
