import java.util.ArrayList;
import java.util.Scanner;

public class MyProject {

    public static String homePage(ArrayList<TDLElement> myTDL){
        System.out.println("YOUR TO DO LIST \n");
        for(int i=0; i<myTDL.size(); i++){
            System.out.println("Category: "+myTDL.get(i).getCategory());
            if(myTDL.get(i).getPriority().equals("1")) System.out.println("High Priority");
            else if(myTDL.get(i).getPriority().equals("2")) System.out.println("Medium Priority");
            else System.out.println("Low Priority");
            System.out.println(myTDL.get(i).getName());
            System.out.println(myTDL.get(i).getText()+"\n");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add a commitment - PRESS 'a'");
        System.out.println("Modify a commitment - PRESS 'm'");
        System.out.println("Delete a commitment - PRESS 'd'");
        String userInput = scanner.nextLine();
        while(!(userInput.equals("m")||userInput.equals("a")||userInput.equals("d"))) {
            System.out.println("Error. You entered an incorrect command.");
            System.out.println("Enter a new command:");
            System.out.println("Add a commitment - PRESS 'a'");
            System.out.println("Modify a commitment - PRESS 'm'");
            System.out.println("Delete a commitment - PRESS 'd'");
            userInput = scanner.nextLine();
        }
        scanner.close();
        return userInput;
    }
    public static void modifyCommitment(ArrayList<TDLElement> myTDL){

    }
    public static void createNewCommitment(ArrayList<TDLElement> myTDL){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCREATE NEW COMMITMENT\n");
        String category="";
        String userInput;
        do{
            System.out.println("Insert the category:");
            userInput = scanner.nextLine();
            category = userInput;
            System.out.println("The category is: "+userInput+"\n");
            System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
            userInput = scanner.nextLine();
            while(!(userInput.equals("n")||userInput.equals("y"))) {
                System.out.println("Error. You entered an incorrect command.");
                System.out.println("Enter a new command:");
                System.out.println("The category is: "+category+"\n");
                System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
                userInput = scanner.nextLine();
            }
        } while (userInput.equals("n"));
        TDLElement newElement = new TDLElement();
        newElement.setCategory(category);

        String priority;
        do{
            System.out.println("\nInsert the priority:\n High priority - PRESS '1'\n Medium priority - PRESS '2'\n Low priority - PRESS '3'");
            userInput = scanner.nextLine();
            while(!(userInput.equals("1")||userInput.equals("2")||userInput.equals("3"))) {
                System.out.println("Error. You entered an incorrect command.");
                System.out.println("Enter a new command:");
                System.out.println("Insert the priority:\n High priority - PRESS '1'\n Medium priority - PRESS '2'\n Low priority - PRESS '3'");
                userInput = scanner.nextLine();
            }
            if(userInput.equals("1")) System.out.println("The priority is high.\n");
            else if(userInput.equals("2")) System.out.println("The priority is medium.\n");
            else System.out.println("The priority is low.\n");
            System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
            userInput = scanner.nextLine();
            while(!(userInput.equals("n")||userInput.equals("y"))) {
                System.out.println("Error. You entered an incorrect command.");
                System.out.println("Enter a new command:");
                if(userInput.equals("1")) System.out.println("The priority is high.\n");
                else if(userInput.equals("2")) System.out.println("The priority is medium.\n");
                else System.out.println("The priority is low.\n");
                System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
                userInput = scanner.nextLine();
            }
            priority=userInput;
        } while (userInput.equals("n"));
        newElement.setPriority(priority);

        String title;
        do{
            System.out.println("\nInsert the title:");
            userInput = scanner.nextLine();
            title = userInput;
            System.out.println("The title is: "+title+"\n");
            System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
            userInput = scanner.nextLine();
            while(!(userInput.equals("n")||userInput.equals("y"))) {
                System.out.println("Error. You entered an incorrect command.");
                System.out.println("Enter a new command:");
                System.out.println("The text is: "+title+"\n");
                System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
                userInput = scanner.nextLine();
            }
        } while (userInput.equals("n"));
        newElement.setName(title);

        String text;
        do{
            System.out.println("\nInsert the text:");
            userInput = scanner.nextLine();
            text = userInput;
            System.out.println("The text is: "+text+"\n");
            System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
            userInput = scanner.nextLine();
            while(!(userInput.equals("n")||userInput.equals("y"))) {
                System.out.println("Error. You entered an incorrect command.");
                System.out.println("Enter a new command:");
                System.out.println("The text is: "+text+"\n");
                System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
                userInput = scanner.nextLine();
            }
        } while (userInput.equals("n"));
        newElement.setText(text);

        System.out.println("Your new commitment:\n");
        System.out.println("Category: "+newElement.getCategory());
        if(newElement.getPriority().equals("1")) System.out.println("High Priority");
        else if(newElement.getPriority().equals("2")) System.out.println("Medium Priority");
        else System.out.println("Low Priority");
        System.out.println(newElement.getName());
        System.out.println(newElement.getText()+"\n");
        myTDL.add(newElement);
        scanner.close();
    }

    public static void deleteCommitment(ArrayList<TDLElement> myTDL){
        System.out.println("\nDELETE COMMITMENT\n");
        Scanner scanner = new Scanner(System.in);
        String userInput;
        do{
            System.out.println("\nInsert the name of the commitment that you want to delete: ");
            userInput = scanner.nextLine();
            int i=0;
            boolean trovato = false;
            while(i<myTDL.size()&&!trovato){
                if(myTDL.get(i).getName().equals(userInput)) {
                    System.out.println("Category: "+myTDL.get(i).getCategory());
                    if(myTDL.get(i).getPriority().equals("1")) System.out.println("High Priority");
                    else if(myTDL.get(i).getPriority().equals("2")) System.out.println("Medium Priority");
                    else System.out.println("Low Priority");
                    System.out.println(myTDL.get(i).getName());
                    System.out.println(myTDL.get(i).getText()+"\n");
                    System.out.println("Are you sure you want to delete this commitment?\n Yes - PRESS 'y'\n No - PRESS 'n'");
                    userInput = scanner.nextLine();
                    while(!(userInput.equals("n")||userInput.equals("y"))) {
                        System.out.println("Error. You entered an incorrect command.");
                        System.out.println("Enter a new command:");
                        System.out.println("The priority is low.\n");
                        System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
                        userInput = scanner.nextLine();
                    }
                    trovato=true;
                    myTDL.remove(i);
                }
                i++;
            }
            if(!trovato){
                System.out.println("Error. A commitment with that name does not exist");
                System.out.println("Enter the name again:");
            }
            if(userInput.equals("1")) System.out.println("The priority is high.\n");
            else if(userInput.equals("2")) System.out.println("The priority is medium.\n");
            else System.out.println("The priority is low.\n");
            System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
            userInput = scanner.nextLine();
            while(!(userInput.equals("n")||userInput.equals("y"))) {
                System.out.println("Error. You entered an incorrect command.");
                System.out.println("Enter a new command:");
                if(userInput.equals("1")) System.out.println("The priority is high.\n");
                else if(userInput.equals("2")) System.out.println("The priority is medium.\n");
                else System.out.println("The priority is low.\n");
                System.out.println("Is it correct?\n Yes - PRESS 'y'\n No - PRESS 'n'");
                userInput = scanner.nextLine();
            }
            String priority=userInput;
        } while (userInput.equals("n"));
        scanner.close();
    }



    public static void main(String[] args) {
        ArrayList<TDLElement> myTDL = new ArrayList<TDLElement>();
        TDLElement myElement = new TDLElement();
        myElement.setName("Palestra");
        myElement.setText("Domani gambe, plank e stacco rumeno");
        myElement.setPriority("1");
        myElement.setCategory("Sport");
        //newElement.setDate("23/09/2023 15:30");
        myTDL.add(myElement);
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

