package pl.sda.library.model;

import java.util.Objects;

public class Movie extends MultiMedia implements DigitalMedium {
    private Creator director;

    private int duration;

    Movie() {

    }

    public Movie(String title, Creator director, int duration) {
        super(title);
        this.director = director;
        this.duration = duration;
    }

    public Movie(Creator director, int duration) {
        this.director = director;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return duration == movie.duration &&
                Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), director, duration);
    }

    @Override
    public int getDuration() {
        return duration;
    }

    public Creator getDirector() {
        return director;
    }

    public void setDirector(Creator director) {
        this.director = director;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "director=" + director +
                ", duration=" + duration +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
