package pl.sda.library.model;

import java.util.Objects;

public abstract class MultiMedia {

    protected String title;
    protected MultiMediaState state;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return getClass().getSimpleName();
    }

    public MultiMediaState getState() {
        return state;
    }

    public void setState(MultiMediaState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiMedia that = (MultiMedia) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, state);
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                '}';
    }
}
