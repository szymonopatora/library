package pl.sda.library.model;


    public enum Format {
        MP3("mp3"), FLAC("flac");

        private String name;

        Format (String name) {
            this.name=name;
        }
        public String getName() {
            return name;
        }
    }
