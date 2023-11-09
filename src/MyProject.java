import java.util.ArrayList;
import java.util.Scanner;

public class MyProject {
    private final Scanner scanner;

    MyProject(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printCommitment(ToDo el) {
        System.out.println("  " + el.getTitle());
        if (el instanceof UniversityToDo)
            System.out.println("  Category: University");
        else if (el instanceof PersonalToDo)
            System.out.println("  Category: Personal");
        else
            System.out.println("  Category: Work");
        System.out.print("  ");
        printPriority(el.getPriority());
        System.out.println("  " + el.getText() + "\n");
    }

    public void printPriority(String priorityCode) {
        if (priorityCode.equals("1"))
            System.out.println("High Priority");
        else if (priorityCode.equals("2"))
            System.out.println("Medium Priority");
        else
            System.out.println("Low Priority");
    }

    public int searchCommitment(ArrayList<ToDo> myTDL, String title) {
        boolean trovato = false;
        int i = 0;
        while (i < myTDL.size() && !trovato) {
            if (myTDL.get(i).getTitle().equals(title))
                trovato = true;
            i++;
        }
        if (trovato) return --i;
        else return -1;
    }

    public String homePage(ArrayList<ToDo> myTDL) {
        System.out.println("\n\nYOUR TO DO LIST \n");
        if (myTDL.isEmpty())
            System.out.println(" The list is empty\n");
        for (ToDo tdlElement : myTDL) {
            printCommitment(tdlElement);
        }
        System.out.println("Choose an operation between the following ones: ");
        System.out.println("  Add a commitment - PRESS 'a'");
        System.out.println("  Modify a commitment - PRESS 'm'");
        System.out.println("  Delete a commitment - PRESS 'd'");
        String userInput = scanner.nextLine();
        while (!(userInput.equals("m") || userInput.equals("a") || userInput.equals("d"))) {
            System.out.println("\nError. You entered an incorrect command.");
            System.out.println("Enter a new command.\n");
            System.out.println("Choose an operation between the following ones: ");
            System.out.println("  Add a commitment - PRESS 'a'");
            System.out.println("  Modify a commitment - PRESS 'm'");
            System.out.println("  Delete a commitment - PRESS 'd'");
            userInput = scanner.nextLine();
        }
        //scanner.close();
        return userInput;
    }

    public String makeAChoice(String question) {
        System.out.println(question + "\n  Yes - PRESS 'y'\n  No - PRESS 'n'");
        String userInput = scanner.nextLine();
        while (!(userInput.equals("n") || userInput.equals("y"))) {
            System.out.println("Error. You entered an incorrect command.");
            System.out.println("Enter a new command:");
            System.out.println(question + "\n  Yes - PRESS 'y'\n  No - PRESS 'n'");
            userInput = scanner.nextLine();
        }
        return userInput;
    }

    public void insertTitleOrText(ToDo commitment, String element) {
        String userInput, choice, element_input;
        do {
            System.out.println("\nInsert the " + element + ":");
            userInput = scanner.nextLine();
            element_input = userInput;
            choice = makeAChoice("The " + element + " is: " + element_input + "\nIs it correct?");
        } while (choice.equals("n"));
        switch (element) {
            case "title" -> commitment.setTitle(element_input);
            case "text" -> commitment.setText(element_input);
        }
    }

    public void insertPriority(ToDo commitment) {
        String userInput;
        String priority = "";
        do {
            System.out.println("\nInsert the priority:\n High priority - PRESS '1'\n Medium priority - PRESS '2'\n Low priority - PRESS '3'");
            userInput = scanner.nextLine();
            while (!(userInput.equals("1") || userInput.equals("2") || userInput.equals("3"))) {
                System.out.println("Error. You entered an incorrect command.");
                System.out.println("Enter a new command:");
                System.out.println("Insert the priority:\n High priority - PRESS '1'\n Medium priority - PRESS '2'\n Low priority - PRESS '3'");
                userInput = scanner.nextLine();
            }
            priority = userInput;
            System.out.print("You selected: ");
            printPriority(userInput);
            System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
            userInput = scanner.nextLine();
            while (!(userInput.equals("n") || userInput.equals("y"))) {
                System.out.println("Error. You entered an incorrect command.");
                System.out.println("Enter a new command:");
                System.out.print("You selected: ");
                printPriority(userInput);
                System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
                userInput = scanner.nextLine();
            }
        } while (userInput.equals("n"));
        commitment.setPriority(priority);
    }

    public void modifyCommitment(ArrayList<ToDo> myTDL) {
        System.out.println("\nMODIFY A COMMITMENT");
        String userInput;
        System.out.println("\nInsert the title of the commitment that you want to modify: ");
        userInput = scanner.nextLine();
        int elementPosition = searchCommitment(myTDL, userInput);
        if (elementPosition == -1) System.out.println("Error. A commitment with that title does not exist");
        else {
            printCommitment(myTDL.get(elementPosition));
            String choice = makeAChoice("Are you sure you want to modify this commitment?");
            if (choice.equals("y")) {
                choice = makeAChoice("Do you want to modify the title?");
                if (choice.equals("y"))
                    insertTitleOrText(myTDL.get(elementPosition), "title");
                choice = makeAChoice("Do you want to modify the priority?");
                if (choice.equals("y"))
                    insertPriority(myTDL.get(elementPosition));
                choice = makeAChoice("Do you want to modify the text?");
                if (choice.equals("y"))
                    insertTitleOrText(myTDL.get(elementPosition), "text");
            } else
                System.out.println("The commitment has not been modified.");
        }
    }

    public void createNewCommitment(ArrayList<ToDo> myTDL) {
        System.out.println("\nCREATE A NEW COMMITMENT");
        String userInput, choice, category;
        category = "NotDefined";
        do {
            System.out.println("\nChoose between the following categories:");
            System.out.println("  University - PRESS 'u' \n  Work - PRESS 'w' " +
                    "\n  Personal - PRESS 'p'");
            userInput = scanner.nextLine();
            switch (userInput){
                case "u":
                    category = "University";
                break;
                case "w":
                    category = "Work";
                break;
                case "p":
                    category = "Personal";
                break;
                default:
                    System.out.println("Error. Something went wrong in the switch statement.");
                break;
            }
            choice = makeAChoice("The category is: " + category + "\nIs it correct?");
        } while (choice.equals("n"));
        switch (category){
            case "University":
                UniversityToDo newUTD = new UniversityToDo();
                insertTitleOrText(newUTD, "title"); // inserts the title of the ToDo
                insertPriority(newUTD); // inserts the priority of the ToDo
                insertTitleOrText(newUTD, "text"); // inserts the text of the ToDo
                System.out.println("Your new commitment:\n");
                printCommitment(newUTD);
                myTDL.add(newUTD);
            break;
            case "Work":
                UniversityToDo newWTD = new UniversityToDo();
                insertTitleOrText(newWTD, "title"); // inserts the title of the ToDo
                insertPriority(newWTD); // inserts the priority of the ToDo
                insertTitleOrText(newWTD, "text"); // inserts the text of the ToDo
                System.out.println("Your new commitment:\n");
                printCommitment(newWTD);
                myTDL.add(newWTD);
            break;
            case "Personal":
                UniversityToDo newPTD = new UniversityToDo();
                insertTitleOrText(newPTD, "title"); // inserts the title of the ToDo
                insertPriority(newPTD); // inserts the priority of the ToDo
                insertTitleOrText(newPTD, "text"); // inserts the text of the ToDo
                System.out.println("Your new commitment:\n");
                printCommitment(newPTD);
                myTDL.add(newPTD);
            break;
        }
    }

    public void deleteCommitment(ArrayList<ToDo> myTDL) {
        System.out.println("\nDELETE A COMMITMENT");
        String userInput;
        System.out.println("\nInsert the title of the commitment that you want to delete: ");
        userInput = scanner.nextLine();
        int elementPosition = searchCommitment(myTDL, userInput);
        if (elementPosition == -1)
            System.out.println("Error. A commitment with that title does not exist");
        else {
            printCommitment(myTDL.get(elementPosition));
            userInput = makeAChoice("Are you sure you want to delete this commitment?");
            if (userInput.equals("y"))
                myTDL.remove(elementPosition);
            else
                System.out.println("The commitment has not been deleted.");
        }
        //scanner.close();
    }
}

