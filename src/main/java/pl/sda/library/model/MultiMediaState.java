package pl.sda.library.model;

public interface MultiMediaState {
    MultiMediaState borrowMultimedia (String firstName, String lastName);

    MultiMediaState returnMultiMedia ();
}
