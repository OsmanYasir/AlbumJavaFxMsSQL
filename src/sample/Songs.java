package sample;

public class Songs extends Music {
    private int Id;
    private String artist;
    private String album;
    private String genre;
    private int year;

    public Songs(int id, String artist, String album, String genre, int year) {
        this.Id = id;
        this.artist=artist;
        this.album = album;
        this.genre = genre;
        this.year = year;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String getInfo() {
        return genre;
    }
}
