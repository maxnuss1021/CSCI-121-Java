import java.io.*;

//serializable makes it so we can save the node in a file.
//class node and then variables for use later.
class node implements Serializable{
    String str;
    node yes;
    node no;

    // Constructor for the node
    node(String str) {
        this.str = str;
        this.yes = null;
        this.no = null;
    }
}