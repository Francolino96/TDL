public class UniversityToDo extends ToDo {
    String course;
    public void setCourse(String newCourse){
        course = newCourse;
    }
    public String getCourse(){
        return course;
    }

    UniversityToDo(){
        super("-", "-", "3");
        this.course = "-";
    }
    UniversityToDo(String title, String text, String priority, String course){
        super(title, text, priority);
        this.course = course;
    }
}
