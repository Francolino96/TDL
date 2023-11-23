public class PersonalToDo extends ToDo{

    boolean atHome;
    public void setAtHome(boolean atHomeChoice){
        atHome = atHomeChoice;
    }
    public boolean getAtHome(){
        return atHome;
    }

    PersonalToDo(){
        super("-", "-", "3");
        this.atHome = true;
    }
    PersonalToDo(String title, String text, String priority, boolean atHome){
        super(title, text, priority);
        this.atHome = atHome;
    }
}
