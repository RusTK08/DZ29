import java.util.List;
public class Group {
    private int numGroup;
    private User teacherGroup;
    private List<User> students;

    public Group(int numGroup, User teacherGroup, List<User> students) {
        this.teacherGroup = teacherGroup;
        this.students = students;
        this.numGroup = numGroup;
    }
    public User getTeacherGroup(){
        return teacherGroup;
    }

    public void setTeacherGroup(User teacherGroup) {
        this.teacherGroup = teacherGroup;
    }
    public List<User> getStudents(){
        return students;
    }
    public void setStudents(List<User> students){
        this.students = students;
    }
    public int getNumGroup(){
        return numGroup;
    }
    public void setNumGroup(int numGroup){
        this.numGroup = numGroup;
    }
    @Override
    public String toString() {
        return "Группа № " + numGroup +
                teacherGroup +
                ", students:" + students + '}';

    }
}
