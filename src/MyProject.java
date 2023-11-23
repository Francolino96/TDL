import java.util.ArrayList;
import java.util.Scanner;

public class MyProject {
    private final Scanner scanner;
    private final IO newIO = IO.getInstance();

    MyProject(Scanner scanner) {
        this.scanner = scanner;
    }

    public String homePage(ArrayList<ToDo> myTDL) {
        // renders a basic choice-based home interface and returns the user input to the main

        System.out.println("\n\nYOUR TO DO LIST \n");
        if (myTDL.isEmpty())
            System.out.println(" The list is empty\n");
        for (ToDo tdlElement : myTDL) { //prints out all the commitments on the list
            IO.printCommitment(tdlElement);
        }
        String userInput;
        do {
            System.out.println("Choose an operation between the following ones: ");
            System.out.println("  Add a commitment    - PRESS 'a'");
            System.out.println("  Modify a commitment - PRESS 'm'");
            System.out.println("  Delete a commitment - PRESS 'd'");
            userInput = scanner.nextLine();
            if (!(userInput.equals("m") || userInput.equals("a") || userInput.equals("d"))) {
                System.out.println("\nError. You entered an incorrect command.");
                System.out.println("Enter a new command.\n");
            }
        } while (!(userInput.equals("m") || userInput.equals("a") || userInput.equals("d")));
        return userInput;
    }
    
    public int searchCommitment(ArrayList<ToDo> myTDL, String title) {
        // researches by the title a commitment inside the list and returns its position or -1 if the commitment isn't found

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

    public String makeAChoice(String question) {
        // asks confirmation for a choice made by the user and returns the answer the user gave
        
        String userInput;
        do {
            System.out.println(question + "\n  Yes - PRESS 'y'\n  No  - PRESS 'n'");
            userInput = scanner.nextLine();
            if (!(userInput.equals("n") || userInput.equals("y"))) {
                System.out.println("\nError. You entered an incorrect command.");
                System.out.println("Enter a new command.\n");
            }
        } while (!(userInput.equals("n") || userInput.equals("y")));
        return userInput;
    }

    public void modifyCommitment(ArrayList<ToDo> myTDL) {
        // modifies a commitment
        
        System.out.println("\n\nMODIFY A COMMITMENT");
        String userInput;
        System.out.println("\nInsert the title of the commitment that you want to modify: ");
        userInput = scanner.nextLine();
        int elementPosition = searchCommitment(myTDL, userInput);
        if (elementPosition == -1) System.out.println("Error. A commitment with that title does not exist");
        else {
            ToDo myToDo = myTDL.get(elementPosition);
            IO.printCommitment(myToDo);
            String choice = makeAChoice("Are you sure you want to modify this commitment?");
            if (choice.equals("y")) {
                choice = makeAChoice("\nDo you want to modify the title?");
                if (choice.equals("y"))
                    newIO.insertTitleCourseHoursAtHomeOrText(myToDo, "title");
                if (myToDo instanceof PersonalToDo){
                    choice = makeAChoice("\nDo you want to modify the place of this commitment?");
                    if (choice.equals("y"))
                        newIO.insertTitleCourseHoursAtHomeOrText(myToDo, "at home");
                }
                else if (myToDo instanceof UniversityToDo){
                    choice = makeAChoice("\nDo you want to modify the course?");
                    if (choice.equals("y"))
                        newIO.insertTitleCourseHoursAtHomeOrText(myToDo, "course");
                }
                else if (myToDo instanceof WorkToDo){
                    choice = makeAChoice("\nDo you want to modify the number of hours of this commitment?");
                    if (choice.equals("y"))
                        newIO.insertTitleCourseHoursAtHomeOrText(myToDo, "number of hours");
                }
                choice = makeAChoice("\nDo you want to modify the priority?");
                if (choice.equals("y"))
                    newIO.insertPriority(myToDo);
                choice = makeAChoice("\nDo you want to modify the text?");
                if (choice.equals("y"))
                    newIO.insertTitleCourseHoursAtHomeOrText(myToDo, "text");
            } else
                System.out.println("\nThe commitment has not been modified.");
        }
    }

    public void createNewCommitment(ArrayList<ToDo> myTDL) {
        // creates a new commitment
        
        System.out.println("\n\nCREATE A NEW COMMITMENT");
        String userInput, choice, category;
        do {
            do {
                System.out.println("\nChoose between the following categories:");
                System.out.println("""
                          University - PRESS 'u'\s
                          Work       - PRESS 'w'\s
                          Personal   - PRESS 'p'\
                        """);
                userInput = scanner.nextLine();
                switch (userInput) {
                    case "u" -> category = "University";
                    case "w" -> category = "Work";
                    case "p" -> category = "Personal";
                    default -> {
                        category = "Error";
                        System.out.println("Error. Something went wrong in the switch statement.");
                    }
                }
                if(!(userInput.equals("u") || userInput.equals("w") || userInput.equals("p"))){
                    System.out.println("\nError. You entered an incorrect command.");
                    System.out.println("Enter a new command.\n");
                }
            } while (!(userInput.equals("u") || userInput.equals("w") || userInput.equals("p")));
            choice = makeAChoice("The category you chose is: " + category + "\nIs it correct?");
        } while (choice.equals("n"));
        switch (category) {
            case "University" -> {
                UniversityToDo newUTD = new UniversityToDo();
                newIO.insertTheFields(newUTD, myTDL);
            }
            case "Work" -> {
                WorkToDo newWTD = new WorkToDo();
                newIO.insertTheFields(newWTD, myTDL);
            }
            case "Personal" -> {
                PersonalToDo newPTD = new PersonalToDo();
                newIO.insertTheFields(newPTD, myTDL);
            }
        }
    }

    public void deleteCommitment(ArrayList<ToDo> myTDL) {
        // deletes a commitment
        
        System.out.println("\n\nDELETE A COMMITMENT");
        String userInput;
        System.out.println("\nInsert the title of the commitment that you want to delete: ");
        userInput = scanner.nextLine();
        int elementPosition = searchCommitment(myTDL, userInput);
        if (elementPosition == -1)
            System.out.println("Error. A commitment with that title does not exist");
        else {
            IO.printCommitment(myTDL.get(elementPosition));
            userInput = makeAChoice("Are you sure you want to delete this commitment?");
            if (userInput.equals("y"))
                myTDL.remove(elementPosition);
            else
                System.out.println("The commitment has not been deleted.");
        }
    }
}

