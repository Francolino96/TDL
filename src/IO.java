import java.util.ArrayList;
import java.util.Scanner;


public class IO {

    private final Scanner scanner;

    private static IO instance;

    private IO(){
        instance = null;
        scanner = new Scanner(System.in);
    }

    public static IO getInstance(){
        if (instance == null) {
            instance = new IO();
        }
        return instance;
    }

    public void insertTitleCourseHoursAtHomeOrText(ToDo myToDo, String element) {
        // Sets the title or the text given by the user and asks confirmation for it

        String userInput = "";
        String choice, element_input;
        do {
            if (myToDo instanceof PersonalToDo && element.equals("at home")) {
                System.out.println("\nWhere is this commitment set to happen?");
                System.out.println("Insert 1 if it'll happen at home, 0 if not:");
            }
            else{
                System.out.println("\nInsert the " + element + ":");
                userInput = scanner.nextLine();
            }

            element_input = userInput;
            do { //asks for confirmation
                if (myToDo instanceof PersonalToDo && element.equals("at home"))
                    do {
                        element_input = scanner.nextLine();
                        if (element_input.equals("1"))
                            System.out.println("""
                                    This personal commitment is set to happen at home.
                                    Is it correct?
                                      Yes - PRESS 'y'
                                      No  - PRESS 'n'""");
                        else if (element_input.equals("0"))
                            System.out.println("""
                                    This personal commitment is set to happen outside home.
                                    Is it correct?
                                      Yes - PRESS 'y'
                                      No  - PRESS 'n'""");
                        else {
                            System.out.println("Error. You entered an incorrect command.");
                            System.out.println("Enter a new command:");
                        }
                    } while (!(element_input.equals("1") || element_input.equals("0")));
                else
                    System.out.println("The " + element + " is: " + element_input + "\nIs it correct?\n  Yes - PRESS 'y'\n  No  - PRESS 'n'");
                userInput = scanner.nextLine();
                if(!(userInput.equals("n") || userInput.equals("y"))){
                    System.out.println("Error. You entered an incorrect command.");
                    System.out.println("Enter a new command:");
                }
            } while (!(userInput.equals("n") || userInput.equals("y")));
            choice = userInput;
        } while (choice.equals("n"));
        switch (element) {
            case "title" -> myToDo.setTitle(element_input);
            case "text" -> myToDo.setText(element_input);
        }
        if (myToDo instanceof UniversityToDo && element.equals("course")){
            ((UniversityToDo)myToDo).setCourse(element_input);
        }
        else if (myToDo instanceof WorkToDo && element.equals("number of hours")) {
            ((WorkToDo)myToDo).setHours(Integer.parseInt(element_input));
        }
        else if (myToDo instanceof PersonalToDo && element.equals("at home")){
            ((PersonalToDo)myToDo).setAtHome(Integer.parseInt(element_input) != 0);
        }
    }

    public void insertPriority(ToDo myToDo) {
        // Sets the priority given by the user and asks confirmation for it

        String userInput, priority;
        do {
            do { // asks the user to select the priority
                System.out.println("\nInsert the priority:\n High priority   - PRESS '1'\n Medium priority - PRESS '2'\n Low priority    - PRESS '3'");
                userInput = scanner.nextLine();
                if(!(userInput.equals("1") || userInput.equals("2") || userInput.equals("3"))){
                    System.out.println("Error. You entered an incorrect command.");
                    System.out.println("Enter a new command:");
                }
            } while (!(userInput.equals("1") || userInput.equals("2") || userInput.equals("3")));
            priority = userInput;
            do { //asks for confirmation
                System.out.print("You selected: ");
                printPriority(userInput);
                System.out.println("Is it correct?\n Yes - PRESS 'y'\n No  - PRESS 'n'");
                userInput = scanner.nextLine();
                if(!(userInput.equals("n") || userInput.equals("y"))){
                    System.out.println("Error. You entered an incorrect command.");
                    System.out.println("Enter a new command:");
                }
            } while (!(userInput.equals("n") || userInput.equals("y")));
        } while (userInput.equals("n"));
        myToDo.setPriority(priority);
    }

    public static void printCommitment(ToDo myToDo) {
        // prints out the commitment

        System.out.println("  " + myToDo.getTitle());
        if (myToDo instanceof UniversityToDo){
            System.out.println("  Category: University");
            System.out.println("  Course: " + ((UniversityToDo) myToDo).getCourse());
        }
        else if (myToDo instanceof PersonalToDo){
            System.out.println("  Category: Personal");
            System.out.println("  At home: " + ((PersonalToDo) myToDo).getAtHome());
        }
        else {
            System.out.println("  Category: Work");
            System.out.println("  Number of hours: " + ((WorkToDo) myToDo).getHours());
        }
        System.out.print("  ");
        printPriority(myToDo.getPriority());
        System.out.println("  " + myToDo.getText() + "\n");
    }

    private static void printPriority(String priorityCode) {
        // prints out the priority

        if (priorityCode.equals("1"))
            System.out.println("High Priority");
        else if (priorityCode.equals("2"))
            System.out.println("Medium Priority");
        else
            System.out.println("Low Priority");
    }

    public void insertTheFields(ToDo newToDo, ArrayList<ToDo> myTDL){
        // inserts the fields of the new commitment

        insertTitleCourseHoursAtHomeOrText(newToDo, "title"); // inserts the title of the ToDo
        if (newToDo instanceof UniversityToDo) {
            insertTitleCourseHoursAtHomeOrText(newToDo, "course"); // inserts the course of the ToDo
        }
        else if (newToDo instanceof WorkToDo) {
            insertTitleCourseHoursAtHomeOrText(newToDo, "number of hours"); // inserts the number of hours of the ToDo
        }
        else if (newToDo instanceof PersonalToDo) {
            insertTitleCourseHoursAtHomeOrText(newToDo, "at home"); // inserts the place where the ToDo occurs
        }
        insertPriority(newToDo); // inserts the priority of the ToDo
        insertTitleCourseHoursAtHomeOrText(newToDo, "text"); // inserts the text of the ToDo
        System.out.println("Your new commitment:\n");
        printCommitment(newToDo);
        myTDL.add(newToDo);
    }
}
