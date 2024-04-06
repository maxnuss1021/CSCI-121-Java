//the SongLinkedList class creates a linked list, includes get functions for the tail and head of the first and last node
//includes a function that inserts a new node into the linked list, searches for a node, deletes all the same nodes, and returns the number of nodes in the linked list
public class SongLinkedList {
    //sets variables for the variable SongLinkedList
    private SongNode head;
    private SongNode tail;
    //declares a linked list called "CopyPlaylist"
    private static SongLinkedList CopyPlaylist = new SongLinkedList();
    //takes in a head and tail and sets them equal to null
    public SongLinkedList() {
        head = null;
        tail = null;

    }
    //get function for the tail node of the linked list
    public SongNode getTail(){
        return tail;
    }
    //get function for the head node of the linked list
    public SongNode getHead() {
        return head;
    }

    //creating a linked list by itself
    public void insertNode(Song song) { //goes into linked list insert function and creates a brand new node
        SongNode node = new SongNode(song);
        if (head == null) {//if we haven't added a head yet then set head to the node defined in line 10
            head = node;
        } else {
            tail.setNext(node);//if the head is there then we set the tail node to the given node
        }
        tail = node;
    }

    //removes the next song in the playlist
    public void removeAfter(SongNode song) {
        SongNode remove = song.getNext();
        if ((song.getSong() != null) && (remove.getSong() != null)) {
            SongNode next = remove.getNext();
            song.setNext(next);
        }
    }
    //copies the playlist
    public SongLinkedList copy(SongNode song) {
        //creates a new playlist with the song node that was taken in and all the songs after
        SongNode current = song;
        while (current != null) {
            CopyPlaylist.insertNode(current.getSong());
            current = current.getNext();
        }
        return CopyPlaylist;
    }
    //allows for the user to search for a node in the linked list
    public SongNode searchNode(String title) {
        SongNode current = head;
        if (!current.getSong().getTitle().equals(title)) {
            while (current.getNext() != null) {
                String sname = current.getNext().getSong().getTitle();
                if (sname.equals(title)) {
                    return current;
                } else {
                    current = current.getNext();
                }
            }
        }
        return current;
    }
    //removes nodes(songs) in the playlist that match the given title
    //if it doesnt remove any songs returns a false boolean
    public Boolean removeDuplicate(SongLinkedList Playlist, String title) {
        SongNode current = head;
        Boolean check = false;
        if (!current.getSong().getTitle().equals(title)) {
            while (current.getNext() != null) {
                String sname = current.getNext().getSong().getTitle();
                if (sname.equals(title)) {
                    Playlist.removeAfter(current);
                    check = true;
                } else {
                    current = current.getNext();
                }
            }
        } else {
            head = current.getNext();
        }
        return check;
    }
    //returns the number of nodes(songs) in the linked list (playlist)
    public int max(SongNode node) {
        //returns the maximum value of the int.
        // In this case the int is the placing of the song.
        // It will return the number of songs in the playlist
        int max = 0;
        while (node != null) {
            if (max < node.getSong().getPlace()) {
                max = node.getSong().getPlace();
                node = node.getNext();
            } else {
                node = node.getNext();
            }
        }
        return max;
    }
    //returns all the elements in the given linked list
    public String toString() {
        SongNode current = head;
        String returnString = "";
        while (current != null) {
            returnString += ("<html>" + current.getSong().getTitle() + " By: " + current.getSong().getArtist()  + "<br> <html>");
            current = current.getNext();
        }
        return returnString;
    }
}


