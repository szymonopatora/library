package pl.sda.library.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Library<T extends MultiMedia> {

   private List<T> media;

    public List<T> getMedia() {
        //return media;
        return Collections.unmodifiableList(media); //chroni przed nieporządanymi modyfikacjami listy, poza klasą "Library"
    }

    public void setMedia(List<T> media) {
        this.media = new LinkedList<>(media);
    }

    public void addMedia(T book) {
        if (media ==null) {
            media = new LinkedList<>();
        }
        media.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(media, library.media);
    }

    @Override
    public int hashCode() {
        return Objects.hash(media);
    }

    @Override
    public String toString() {
        return "Library{" +
                "media=" + media +
                '}';
    }
}
