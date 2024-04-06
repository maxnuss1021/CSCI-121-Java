//the song class defines the song variable that takes in a title, artist, and place and then creates set and get functions
public class Song {
    //defines variables for the Song variable to take in
    String title;
    String artist;
    int place;
    //a variable that takes in the title, artist, and placement in the linked list for a song
    public Song(String title, String artist, int place){
        this.title = title;
        this.artist = artist;
        this.place = place;
    }

    //get function for the title of the song
    public String getTitle() {
        return title;
    }

    //set function for the title of the song
    public void setTitle(String title) {
        this.title = title;
    }

    //set function for the placement of the song in the Linked list
    public void setPlace(int x){
        place = x;
    }

    //get function for the artist of the song
    public String getArtist() {
        return artist;
    }

    //set function for the artist of the song
    public void setArtist(String artist) {
        this.artist = artist;
    }

    //get function for the placement of the song in the linked list
    public int getPlace(){
        return place;
    }
}
