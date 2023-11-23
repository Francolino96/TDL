public class PersonalToDo extends ToDo{

    private boolean atHome;
    public void setAtHome(boolean atHome){
        this.atHome = atHome;
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
