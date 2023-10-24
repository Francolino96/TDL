import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyProject project = new MyProject(scanner);

        ArrayList<TDLElement> myTDL = new ArrayList<>();

        TDLElement myElement = new TDLElement();
        myElement.setTitle("Palestra");
        myElement.setText("Domani gambe, plank e stacco rumeno");
        myElement.setPriority("3");
        myElement.setCategory("Sport");
        myTDL.add(myElement);

        TDLElement myElement2 = new TDLElement();
        myElement2.setTitle("Paraurti");
        myElement2.setText("Martedì devo andare dal carrozziere a sistemare il paraurti");
        myElement2.setPriority("1");
        myElement2.setCategory("Faccende domestiche");
        myTDL.add(myElement2);

        TDLElement myElement3 = new TDLElement();
        myElement3.setTitle("Studiare DWM");
        myElement3.setText("Devo mettermi al passo con DWM");
        myElement3.setPriority("2");
        myElement3.setCategory("Univeristà");
        myTDL.add(myElement3);

        TDLElement myElement4 = new TDLElement();
        myElement4.setTitle("Controllare infiltrazioni");
        myElement4.setText("Controllare infiltrazioni tetto lato camino");
        myElement4.setPriority("1");
        myElement4.setCategory("Faccende domestiche");
        myTDL.add(myElement4);

        while (true) {
            String userInput = project.homePage(myTDL);
            switch (userInput) {
                case "m":
                    project.modifyCommitment(myTDL);
                    break;
                case "a":
                    project.createNewCommitment(myTDL);
                    break;
                case "d":
                    project.deleteCommitment(myTDL);
                    break;
                default:
                    System.out.println("Error. Something went wrong in the switch statement.");
            }
        }
    }
}
