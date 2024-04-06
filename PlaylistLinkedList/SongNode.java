//the SongNode class creates a SongNode function that takes in the Song and a null variable
public class SongNode {
    //defines variables for the SongNode variable to take in
    private Song song;
    private SongNode next;
    //takes in the Song variable and sets the next node null
    public SongNode(Song song) {
        this.song = song;
        this.next = null;//this means that the next node is null until the user sets it
    }
    //get function for the Song
    public Song getSong() {
        return song;
    }
    //get function for the next SongNode
    public SongNode getNext() {
        return next;
    }
    //set function for the next SongNode
    public void setNext(SongNode next) {
        this.next = next;
    }
}
