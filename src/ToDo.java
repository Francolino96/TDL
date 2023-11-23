/*
interface generalMethods{
    void insertTitleCourseHoursAtHomeOrText(String element);
    void insertPriority();
    void printCommitment();
}*/

abstract public class ToDo /*implements generalMethods*/ {

    String title;
    public void setTitle(String newTitle){
        title = newTitle;
    }
    public String getTitle(){
        return title;
    }

    String text;
    public void setText(String newText){
        text = newText;
    }
    public String getText(){
        return text;
    }

    String priority;
    public void setPriority(String newPriority){
        priority = newPriority;
    }
    public String getPriority(){
        return priority;
    }

    //public abstract void Metodo ();

    ToDo(){
        title = "-";
        text = "-";
        priority = "3";
    }

    ToDo(String title, String text, String priority){
        this.title = title;
        this.text = text;
        this.priority = priority;
    }

    /*
    Calendar date;

    public void setDate(String stringDate){
        int day, month, year;
        int hour, min;
        if(stringDate.length()!=16||(stringDate.charAt(0)>'3'||stringDate.charAt(0)<'0')||(stringDate.charAt(1)>'9'||stringDate.charAt(1)<'0')
                ||stringDate.charAt(2)!='/'||(stringDate.charAt(3)>'1'||stringDate.charAt(3)<'0')||(stringDate.charAt(4)<'1'||stringDate.charAt(4)>'9')
                ||stringDate.charAt(5)!='/'||(stringDate.charAt(6)>'2'||stringDate.charAt(6)<'0')||(stringDate.charAt(7)>'9'||stringDate.charAt(7)<'0')
                ||stringDate.charAt(8)!=' '||(stringDate.charAt(9)>'2'||stringDate.charAt(9)<'0')||(stringDate.charAt(10)>'9'||stringDate.charAt(10)<'0')
                ||stringDate.charAt(11)!=':'||(stringDate.charAt(12)>'5'||stringDate.charAt(12)<'0')||(stringDate.charAt(13)>'9'||stringDate.charAt(13)<'0')){
            System.out.println("Error. The datetime format is not correct");
        }
        else{
            date.set(2023, Calendar.SEPTEMBER, 28, , min, 0);
        }

    }
    public Calendar getDate(){
        return date;
    }
    */
}

