import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyProject project = new MyProject(scanner);

        ArrayList<ToDo> myTDL = new ArrayList<>();

        ToDo myElement = new PersonalToDo("Palestra",
                "Domani gambe, plank e stacco rumeno", "3", false);
        myTDL.add(myElement);

        ToDo myElement2 = new WorkToDo("Paraurti",
                "Martedì devo andare dal carrozziere a sistemare il paraurti", "1", 3);
        myTDL.add(myElement2);

        ToDo myElement3 = new UniversityToDo("Studiare DWM",
                "Devo mettermi al passo con DWM", "2", "DWM");
        myTDL.add(myElement3);

        ToDo myElement4 = new PersonalToDo("Controllare infiltrazioni",
                "Controllare infiltrazioni tetto lato camino", "1", true);
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
