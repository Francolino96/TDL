public class WorkToDo extends ToDo {

    private int hours;
    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    WorkToDo(){
        super("-", "-", "3");
        this.hours = 0;
    }
    WorkToDo(String title, String text, String priority, int hours) {
        super(title, text, priority);
        this.hours = hours;
    }
}
