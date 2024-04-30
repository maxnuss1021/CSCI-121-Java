import java.util.*;
import java.io.*;
public class twentyq {
    //creates variables to be used later
    private node root;
    private Scanner in;
    private static final String FILENAME = "NussbaumGame.ser";
    public int counter = 0;
    //constructor throws exceptions to protect against a few different errors
    public twentyq() throws IOException, ClassNotFoundException {
        //scans for the file name - if it already exits it just starts the game. If it doesn't exist it creates the file
        in = new Scanner(System.in);
        File f = new File(FILENAME);
        if (f.exists()){
            loadGame();
        }
        else{
        setupDefault();}
    }
    public void setupDefault(){
        //creates a file with a few different questions already built in. (this is the creative aspect)
        root = new node("Is it alive?");
        root.yes = new node("Is it a plant?");
        root.yes.yes = new node("Is it a tree?");
        root.yes.no = new node("Is it a cat?");
        root.no = new node("Is it an electronic?");
        root.no.no = new node("Is it a sneaker?");
        root.no.yes = new node("Is it a telephone?");
    }
    //goes through the tree. First checks to see if 20 questions have already been asked.
    // If they haven't reached 20 questions, It goes into the next question.
    public void traverseRoot(node n) {
        System.out.println("question " + counter);
        if (counter == 20){
            System.out.println("I didnt get it in 20 questions. I loose.");
        }
        //checks to see if it is a leaf.
        else if (n.yes == null && n.no == null) {
            System.out.println( " " + n.str + "? (yes/no)");
            String answer = in.nextLine();
            //checks answer
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("Great! I guessed it!");
            }
            else if (answer.equalsIgnoreCase("no")) {
                System.out.println("I loose - what was your thing?");
                String NewAnswer = (in.nextLine());
                System.out.println("Give an example of a question would lead me to that thing.");
                String NewQuestion = in.nextLine();
                System.out.println("What is the answer to " + NewQuestion+"? (yes/no)");
                String yn = in.next();
                String oldData = n.str;
                node old = new node(oldData);
                node newAnswer = new node(NewAnswer);
                //adds a new question/answer to help it narrow down options.
                if (yn.equalsIgnoreCase("yes")) {
                    n.str = NewQuestion;
                    n.yes = newAnswer;
                    n.no = old;
                } else if (yn.equalsIgnoreCase("no")) {
                    n.str = NewQuestion;
                    n.no = newAnswer;
                    n.yes = old;
                }
            }
        }
        //if it isnt a leaf it simply goes on asking questions
        else {
            System.out.println(" " + n.str + "? (yes/no)");
            String answer = in.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                counter += 1;
                traverseRoot(n.yes);}
             else if (answer.equalsIgnoreCase("no")) {
                 counter += 1;
                traverseRoot(n.no);
            }
        }
    }
    //saveGame class saves the users answer into the created file.
    private void saveGame() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(FILENAME);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(root);
        out.close();
        fileOut.close();
    }
    //load game class loads in the file and looks for the nodes if the file exists.
    private void loadGame() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(FILENAME);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        root = (node) in.readObject();
        in.close();
        fileIn.close();
    }
    //play is called in the main function -
    // it traverses the root until completion and then saves the game so if the user adds a question it saves for a later date.
    public void play() throws IOException {
        System.out.println("Think of an object and I will try to guess it!");
        counter += 1;
        traverseRoot(root);
        saveGame();
    }
    //main function runs the program
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        twentyq game = new twentyq();
        game.play();
    }
}
