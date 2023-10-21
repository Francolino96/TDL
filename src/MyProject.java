import java.util.ArrayList;
import java.util.Scanner;

public class MyProject {

    public static void printCommitment(TDLElement el){
        System.out.println(el.getTitle());
        System.out.println("Category: "+el.getCategory());
        printPriority(el.getPriority());
        System.out.println(el.getText()+"\n");
    }

    public static void printPriority(String priorityCode){
        if(priorityCode.equals("1")) System.out.println("High Priority");
        else if(priorityCode.equals("2")) System.out.println("Medium Priority");
        else System.out.println("Low Priority");
    }

    public static int searchCommitment(ArrayList<TDLElement> myTDL, String title){
        boolean trovato = false;
        int i=0;
        while(i<myTDL.size()&&!trovato) {
            if (myTDL.get(i).getTitle().equals(title)) trovato=true;
            i++;
        }
        if (trovato) return --i;
        else return -1;
    }

    public static String homePage(ArrayList<TDLElement> myTDL){
        System.out.println("\n\nYOUR TO DO LIST \n");
        if (myTDL.size()==0) System.out.println("The list is empty");
        for(int i=0; i<myTDL.size(); i++){
            printCommitment(myTDL.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add a commitment - PRESS 'a'");
        System.out.println("Modify a commitment - PRESS 'm'");
        System.out.println("Delete a commitment - PRESS 'd'");
        String userInput = scanner.nextLine();
        while(!(userInput.equals("m")||userInput.equals("a")||userInput.equals("d"))) {
            System.out.println("\nError. You entered an incorrect command.");
            System.out.println("Enter a new command:");
            System.out.println("Add a commitment - PRESS 'a'");
            System.out.println("Modify a commitment - PRESS 'm'");
            System.out.println("Delete a commitment - PRESS 'd'");
            userInput = scanner.nextLine();
        }
        //scanner.close();
        return userInput;
    }

    public static String makeAChoice(String userInput, String question){
        Scanner scanner = new Scanner(System.in);
        System.out.println(question+"\n Yes - PRESS 'y'\n No - PRESS 'n'");
        userInput = scanner.nextLine();
        while(!(userInput.equals("n")||userInput.equals("y"))) {
            System.out.println("Error. You entered an incorrect command.");
            System.out.println("Enter a new command:");
            System.out.println(question+"\n Yes - PRESS 'y'\n No - PRESS 'n'");
            userInput = scanner.nextLine();
        }
        return userInput;
    }

    public static void insertTtl_Ctgr_Txt(TDLElement commitment, String element){
        Scanner scanner = new Scanner(System.in);
        String userInput, choice, element_input;
        do{
            System.out.println("\nInsert the "+element+":");
            userInput = scanner.nextLine();
            element_input = userInput;
            choice=makeAChoice(userInput, "The "+element+" is: "+element_input+"\nIs it correct?");
        } while (choice.equals("n"));
        if (element.equals("title")) commitment.setTitle(element_input);
        else if (element.equals("category")) commitment.setCategory(element_input);
        else if (element.equals("text")) commitment.setText(element_input);
    }

    public static void insertPriority(TDLElement commitment){
        Scanner scanner = new Scanner(System.in);
        String userInput, choice, priority;
        do{
            System.out.println("\nInsert the priority:\n High priority - PRESS '1'\n Medium priority - PRESS '2'\n Low priority - PRESS '3'");
            userInput = scanner.nextLine();
            while(!(userInput.equals("1")||userInput.equals("2")||userInput.equals("3"))) {
                System.out.println("Error. You entered an incorrect command.");
                System.out.println("Enter a new command:");
                System.out.println("Insert the priority:\n High priority - PRESS '1'\n Medium priority - PRESS '2'\n Low priority - PRESS '3'");
                userInput = scanner.nextLine();
            }
            System.out.print("You selected: ");
            printPriority(userInput);
            System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
            userInput = scanner.nextLine();
            while(!(userInput.equals("n")||userInput.equals("y"))) {
                System.out.println("Error. You entered an incorrect command.");
                System.out.println("Enter a new command:");
                System.out.print("You selected: ");
                printPriority(userInput);
                System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
                userInput = scanner.nextLine();
            }
            priority=userInput;
        } while (userInput.equals("n"));
        commitment.setPriority(priority);
    }

    public static void modifyCommitment(ArrayList<TDLElement> myTDL){
        System.out.println("\nMODIFY A COMMITMENT");
        Scanner scanner = new Scanner(System.in);
        String userInput;
        System.out.println("\nInsert the title of the commitment that you want to modify: ");
        userInput = scanner.nextLine();
        int elementPosition=searchCommitment(myTDL,userInput);
        if (elementPosition==-1) System.out.println("Error. A commitment with that title does not exist");
        else{
            printCommitment(myTDL.get(elementPosition));
            String choice=makeAChoice(userInput, "Are you sure you want to modify this commitment?");
            if(choice.equals("y")) {
                choice=makeAChoice(userInput, "Do you want to modify the title?");
                if(choice.equals("y")) insertTtl_Ctgr_Txt(myTDL.get(elementPosition), "title");
                choice=makeAChoice(userInput, "Do you want to modify the category?");
                if(choice.equals("y")) insertTtl_Ctgr_Txt(myTDL.get(elementPosition), "category");
                choice=makeAChoice(userInput, "Do you want to modify the priority?");
                if(choice.equals("y")) insertPriority(myTDL.get(elementPosition));
                choice=makeAChoice(userInput, "Do you want to modify the text?");
                if(choice.equals("y")) insertTtl_Ctgr_Txt(myTDL.get(elementPosition), "text");
            }
            else System.out.println("The commitment has not been modified.");
        }
    }

    public static void createNewCommitment(ArrayList<TDLElement> myTDL){
        System.out.println("\nCREATE A NEW COMMITMENT");
        TDLElement newElement = new TDLElement();
        insertTtl_Ctgr_Txt(newElement, "title");
        insertTtl_Ctgr_Txt(newElement, "category");
        insertPriority(newElement);
        insertTtl_Ctgr_Txt(newElement, "text");
        System.out.println("Your new commitment:\n");
        printCommitment(newElement);
        myTDL.add(newElement);
    }

    public static void deleteCommitment(ArrayList<TDLElement> myTDL){
        System.out.println("\nDELETE A COMMITMENT");
        Scanner scanner = new Scanner(System.in);
        String userInput;
        System.out.println("\nInsert the title of the commitment that you want to delete: ");
        userInput = scanner.nextLine();
        int elementPosition=searchCommitment(myTDL,userInput);
        if (elementPosition==-1) System.out.println("Error. A commitment with that title does not exist");
        else{
            printCommitment(myTDL.get(elementPosition));
            userInput=makeAChoice(userInput, "Are you sure you want to delete this commitment?");
            if(userInput.equals("y")) myTDL.remove(elementPosition);
            else System.out.println("The commitment has not been deleted.");
        }
        //scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<TDLElement> myTDL = new ArrayList<TDLElement>();

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

        while(true){
            String userInput = homePage(myTDL);
            switch(userInput){
                case "m":
                    modifyCommitment(myTDL);
                    break;
                case "a":
                    createNewCommitment(myTDL);
                    break;
                case "d":
                    deleteCommitment(myTDL);
                    break;
                default:
                    System.out.println("Error. Something went wrong in the switch statement.");
            }
        }
    }
}

