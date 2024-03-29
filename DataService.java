import java.util.ArrayList;
import java.util.List;




public class DataService {
    private List<User> userList = new ArrayList<>();

    public void create(String firstName, String secondName, String lastName, Type type) {
        int id = getMaxID(type);
        if (type == Type.STUDENT) {
            userList.add(new Student(firstName, secondName, lastName, id));
        }
        if (type == Type.TEACHER) {
            userList.add(new Teacher(firstName, secondName, lastName, id));
        }

    }

    private int getMaxID(Type type) {
        boolean itsStudent = type == Type.STUDENT;
        int maxID = 1;
        for (User user : userList) {
            if (user instanceof Student && itsStudent) {
                maxID = ((Student) user).getStudentID() + 1;
            }
            if (user instanceof Teacher && !itsStudent) {
                maxID = ((Teacher) user).getTeacherID() + 1;

            }

        }
        return maxID;
    }

    public List<User> getAllConcUser(Type type) {
        List<User> resultList = new ArrayList<>();
        boolean itsStudent = type == Type.STUDENT;
        for (User user : userList) {
            if (user instanceof Student && itsStudent) {
                resultList.add(user);
            }
            if (user instanceof Teacher && !itsStudent) {
                resultList.add(user);

            }
        }
        return resultList;
    }

    public User getUserById(Type type, int id) { // реализован поиск user по id
        boolean itsStudent = Type.STUDENT == type;
        for (User user : userList) {
            if (user instanceof Teacher && !itsStudent && ((Teacher) user).getTeacherID() == id) {
                return user;
            }
            if (user instanceof Student && itsStudent && ((Student) user).getStudentID() == id) {
                return user;
            }
        }
        return null;
    }

}
