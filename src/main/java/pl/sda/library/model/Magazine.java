package pl.sda.library.model;

import java.util.Objects;

public class Magazine extends MultiMedia implements PaperMedium {

    private int number;
    private int pageCount;

    Magazine() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return number == magazine.number &&
                pageCount == magazine.pageCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, pageCount);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getPageCount() {
        return pageCount;
    }

    @Override
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "number=" + number +
                ", pageCount=" + pageCount +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
