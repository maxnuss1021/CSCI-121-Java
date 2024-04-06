import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    //declares the linked list
    public static SongLinkedList Playlist;
    //creates labels and buttons for the first frame
    JLabel j1 = new JLabel("Spotify");
    JLabel j2 = new JLabel("<html> <br> Welcome, click continue to view your playlist <html>");
    JButton continueButton = new JButton("Continue");
    //declares the width and height of the frame
    final int WIDTH = 1000;
    final int HEIGHT = 700;
    public GUI() {
        super("My Frame");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        //sets the size and font of the words
        //adds the labels and buttons to the JFrame
        Font labelFont1 = j1.getFont();
        j1.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 125));
        add(j1);
        j1.setForeground (Color.green);

        Font labelFont2 = j2.getFont();
        j2.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 40));
        add(j2);
        //sets the dimensions of the button
        continueButton.setPreferredSize(new Dimension(250,75));
        add(continueButton);
        continueButton.addActionListener(this);
        //sets the frame to close when the exit button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //sets the frame to switch to the next when the button is clicked
        if (e.getSource() == continueButton) {
            Screen2 screen2 = new Screen2(Playlist);
            screen2.setVisible(true);
        }
    }
    public static void main(String[] args){
        //creates songs for the playlist
        Song S1 = new Song("Topia Twins", "Travis Scott", 1);
        Song S2 = new Song("Missing Piece", "Vance Joy", 2);
        Song S3 = new Song("Ghost in the Medicine", "SZA", 3);
        Song S4 = new Song("Power", "Kanye West", 4);
        Song S5 = new Song("Golden Hour", "JVKE", 5);
        Song S6 = new Song("Run this Town", "Jay Z", 6);
        Song S7 = new Song("90210", "Travis Scott", 7);
        Song S8 = new Song("AP", "Pop Smoke", 8);
        Song S9 = new Song("Day N Night", "Kid Cudi", 9);
        Song S10 = new Song("Pure Cocaine", "Lil Baby", 10);
        Playlist = new SongLinkedList();
        Playlist.insertNode(S1);
        Playlist.insertNode(S2);
        Playlist.insertNode(S3);
        Playlist.insertNode(S4);
        Playlist.insertNode(S5);
        Playlist.insertNode(S6);
        Playlist.insertNode(S7);
        Playlist.insertNode(S8);
        Playlist.insertNode(S9);
        Playlist.insertNode(S10);

        GUI gui = new GUI();
        gui.setVisible(true);

    }
}

class Screen2 extends JFrame implements ActionListener{
    //creates labels and buttons for the JFrame
    JLabel j1 = new JLabel("Your Playlist: ");
    JLabel toString;
    JLabel j2 = new JLabel("Press the 'Add' or 'delete' button to add or delete songs from your playlist");
    JLabel j3 = new JLabel("If you are happy with the songs on your playlist press the 'save playlist' button");
    JButton continueButton = new JButton("Save Playlist");
    JButton addSong = new JButton("Add Song");
    JButton deleteSong = new JButton("Delete Song");
    //declares the playlist
    public SongLinkedList Playlist;
    //declares the width and height of the frame
    final int WIDTH = 1000;
    final int HEIGHT = 700;
    public Screen2(SongLinkedList Playlist) {
        super("My Frame");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        this.Playlist = Playlist;
        //sets the font and size of the text and adds it to the JFrame
        Font labelFont1 = j1.getFont();
        j1.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 25));
        add(j1);

        toString = new JLabel(Playlist.toString());

        Font labelFont21 = toString.getFont();
        toString.setFont(new Font(labelFont21.getFontName(), Font.PLAIN, 25));
        add(toString);

        Font labelFont22 = j2.getFont();
        j2.setFont(new Font(labelFont22.getFontName(), Font.PLAIN, 25));
        add(j2);

        Font labelFont23 = j3.getFont();
        j3.setFont(new Font(labelFont23.getFontName(), Font.PLAIN, 25));
        add(j3);
        //sets the dimensions of the button
        continueButton.setPreferredSize(new Dimension(300,40));
        add(continueButton);
        continueButton.addActionListener(this);

        addSong.setPreferredSize(new Dimension(300,40));
        add(addSong);
        addSong.addActionListener(this);

        deleteSong.setPreferredSize(new Dimension(300,40));
        add(deleteSong);
        deleteSong.addActionListener(this);
        //sets the frame to close when the exit button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //sets the frame to switch to the next when the button is clicked
        if (e.getSource() == continueButton) {
            Screen3 screen3 = new Screen3(Playlist);
            screen3.setVisible(true);
        }
        if (e.getSource() == addSong) {
            addScreen addscreen = new addScreen(Playlist);
            addscreen.setVisible(true);
        }
        if (e.getSource() == deleteSong) {
            deleteScreen deletescreen = new deleteScreen(Playlist);
            deletescreen.setVisible(true);
        }
    }
}
class addScreen extends JFrame implements ActionListener {
    //creates labels, textFields, and buttons for the frame
    JLabel addSong = new JLabel("Please enter the title and artist of the song you would like to add        ");
    JLabel songLabel = new JLabel("Title: ");
    JTextField songTextField = new JTextField(15);
    JLabel artistLabel = new JLabel("Artist: ");
    JTextField artistTextField = new JTextField(15);
    JButton continueButton = new JButton("Continue");
    //declares a linked list
    public SongLinkedList Playlist;
    //sets the dimensions of the JFrame
    final int WIDTH = 1000;
    final int HEIGHT = 700;
    public addScreen(SongLinkedList Playlist) {
        super("My Frame");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        this.Playlist = Playlist;
        //sets the font and size of the text and adds it to the JFrame
        Font labelFont1 = addSong.getFont();
        addSong.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 28));
        add(addSong);

        Font labelFont2 = songLabel.getFont();
        songLabel.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 30));
        add(songLabel);

        add(songTextField);

        Font labelFont3 = artistLabel.getFont();
        artistLabel.setFont(new Font(labelFont3.getFontName(), Font.PLAIN, 30));
        add(artistLabel);

        add(artistTextField);
        //sets the dimensions of the button and adds it to the JFrame
        continueButton.setPreferredSize(new Dimension(300,40));
        add(continueButton);
        continueButton.addActionListener(this);
        //sets the frame to close when the exit button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continueButton) {
            //gets the song and artist names of the song from the user
            String songName = songTextField.getText();
            String artistName = artistTextField.getText();
            int n = Playlist.max(Playlist.getHead());
            Song songAdd = new Song(songName, artistName, (n + 1));
            Playlist.insertNode(songAdd);
            //changes the JFrame to Screen2
            Screen2 screen2 = new Screen2(Playlist);
            screen2.setVisible(true);
        }
    }
}
class deleteScreen extends JFrame implements ActionListener {
    //declares a variable for the counter
    static int counter = 0;
    //creates labels, textFields, and buttons for the JFrame
    JLabel deleteSong = new JLabel("Please enter the title and artist of the song you would like to delete");
    JLabel songName = new JLabel("Title: ");
    JTextField nameTextField = new JTextField(15);
    JLabel songArtist = new JLabel("Artist: ");
    JTextField artistTextField = new JTextField(15);
    JButton continueButton = new JButton("Continue");
    public SongLinkedList Playlist;
    //sets the dimensions of the JFrame
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    public deleteScreen(SongLinkedList Playlist) {
        super("My Frame");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        this.Playlist = Playlist;
        //sets the font and size of the text and adds them to the JFrame
        Font labelFont1 = deleteSong.getFont();
        deleteSong.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 28));
        add(deleteSong);

        Font labelFont2 = songName.getFont();
        songName.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 30));
        add(songName);

        add(nameTextField);

        Font labelFont3 = songArtist.getFont();
        songArtist.setFont(new Font(labelFont3.getFontName(), Font.PLAIN, 30));
        add(songArtist);

        add(artistTextField);
        //sets the dimensions of the buttons and adds them to the JFrame
        continueButton.setPreferredSize(new Dimension(300, 40));
        add(continueButton);
        continueButton.addActionListener(this);
        //closes the frame when the user clicks the x button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continueButton) {
            //will try to delete the disered song
            // will throw an error if the boolean checking to see if there was a song deleted returns false.
            try {
                //statement changes the place of the last song so you have an accurate playlist length
                Playlist.getTail().getSong().setPlace(Playlist.max(Playlist.getHead()) - 1);
                String songs = nameTextField.getText();
                //removes the desired song
                Boolean clear = Playlist.removeDuplicate(Playlist, songs);
                Screen2 screen2 = new Screen2(Playlist);
                screen2.setVisible(true);
                if (!clear) {
                    int x = 1 / 0;
                }
            } catch (Exception exception) {
                //if it catches the mistake it will prompt the user to exit the app and restart
                JOptionPane.showMessageDialog(this, "You have asked to delete a song that doesnt exist. Please exit and restart. ");
            }
        }

    }
}
class Screen3 extends JFrame implements ActionListener {
    //adds labels and buttons to the JFrame
    JLabel j1 = new JLabel("Would you like to download the playlist?");
    JButton yesButton = new JButton("Yes");
    JButton noButton = new JButton("No");
    public SongLinkedList Playlist;
    //sets the dimensions of the JFrame
    final int WIDTH = 1000;
    final int HEIGHT = 700;
    public Screen3(SongLinkedList Playlist) {
        super("My Frame");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        this.Playlist = Playlist;
        //sets the size and font of the text and adds them to the JFrame
        Font labelFont1 = j1.getFont();
        j1.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 40));
        add(j1);
        //sets the dimensions of the buttons
        yesButton.setPreferredSize(new Dimension(300,40));
        add(yesButton);
        yesButton.addActionListener(this);

        noButton.setPreferredSize(new Dimension(300,40));
        add(noButton);
        noButton.addActionListener(this);
        //closes the frame when the user clicks the x button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //switches the frame based on with button is clicked by the user
        if (e.getSource() == yesButton) {
            Screen4 screen4 = new Screen4(Playlist);
            screen4.setVisible(true);
        }
        if (e.getSource() == noButton) {
            Screen5 screen5 = new Screen5(Playlist);
            screen5.setVisible(true);
        }
    }


}
class Screen4 extends JFrame implements ActionListener{
    //adds labels and buttons to the Jframe
    JLabel j1;
    JLabel j2 = new JLabel("Click 'View Playlist' to view your playlist");
    JLabel j3 = new JLabel("or click the x button to close the screen");
    JButton playlistButton = new JButton("View Playlist");
    public SongLinkedList CopyPlaylist;
    //sets the dimensions of the JFrame
    final int WIDTH = 1000;
    final int HEIGHT =700;
    public Screen4(SongLinkedList Playlist) {
        super("My Frame");
        j1 = new JLabel("Your playlist of " + Playlist.max(Playlist.getHead()) +" songs has been downloaded.");
        CopyPlaylist = Playlist.copy(Playlist.getHead()); //makes a copy of the playlist for downloading purposes
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        //sets the font and size of the text and adds it to the frame
        Font labelFont1 = j1.getFont();
        j1.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 40));
        add(j1);

        Font labelFont2 = j2.getFont();
        j2.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 40));
        add(j2);

        Font labelFont3 = j3.getFont();
        j3.setFont(new Font(labelFont3.getFontName(), Font.PLAIN, 40));
        add(j3);

        playlistButton.setPreferredSize(new Dimension(300,100));
        add(playlistButton);
        playlistButton.addActionListener(this);
        //closes the frame when the user clicks the x button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playlistButton) {
            Screen2 screen2 = new Screen2(CopyPlaylist); //sends back a copy instead of the original.
            screen2.setVisible(true);
        }
    }
}

class Screen5 extends JFrame {
    //ending phrase
    JLabel thankYou = new JLabel("Thank you for using Spotfiy!");
    public SongLinkedList Playlist;
    //sets the dimensions of the JFrame
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    public Screen5(SongLinkedList Playlist) {
        super("My Frame");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        this.Playlist = Playlist;
        //adds text to the Jframe
        Font labelFont1 = thankYou.getFont();
        thankYou.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 40));
        add(thankYou);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
