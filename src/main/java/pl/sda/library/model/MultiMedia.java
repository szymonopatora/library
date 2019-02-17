package pl.sda.library.model;

import java.util.Objects;

public abstract class MultiMedia {
    protected String title;

    public MultiMedia(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiMedia that = (MultiMedia) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public MultiMedia() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MultiMedia{" +
                "title='" + title + '\'' +
                '}';
    }
}
