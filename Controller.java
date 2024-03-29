import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private final DataService dataService = new DataService();
    private final StudentView studentView = new StudentView();
    private final TeacherView teacherView = new TeacherView();
    private final GroupView groupView = new GroupView();
    private final GroupService groupService = new GroupService();

    public void createStudent(String firstName, String secondName, String lastName){
        dataService.create(firstName,secondName,lastName, Type.STUDENT);
    }
    public void getAllStudent(){
        for (User user : dataService.getAllConcUser(Type.STUDENT)){
            studentView.printOnConsole((Student) user);
        }
    }
    public void createTeacher(String firstName, String secondName,String lastNameS) {
        dataService.create(firstName,secondName,lastNameS,Type.TEACHER); // Cоздаем преподавателя
    }
    public void getAllTeacher(){
        for (User user: dataService.getAllConcUser(Type.TEACHER)){
            teacherView.printOnConsole((Teacher) user);
        }
    }
    public Integer getGroupNumber() {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер группы");
        number = scanner.nextInt();
        return number;
    }
    public User getGroupTeacher() {
        int id;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID педагога");
        id = scanner.nextInt();
        return dataService.getUserById(Type.TEACHER, id);
    }
    public List<User> studentsInGroup() {
        List<User> studentsGroup = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Id студентов через пробел, закончите - введите 0");
        while (true) {
            int number = scanner.nextInt();
            studentsGroup.add(dataService.getUserById(Type.STUDENT, number));
            if(number == 0) {
                break;
            }
        }
        return studentsGroup;
    }

    public void createGroup(){
        int numberGroup = getGroupNumber();
        User teacherGroup = getGroupTeacher();
        List<User> students = studentsInGroup();
        Group group = groupService.createGroup(numberGroup,teacherGroup,students);
        groupView.printOnConsole(group);
    }
}