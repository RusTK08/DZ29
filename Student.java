public class Student extends User{
    private int studentID;
    public Student(String firstName, String secondName, String lastName, int studentID) {
        super(firstName, secondName, lastName);
        this.studentID = studentID;
    }
    public int getStudentID(){
        return studentID;
    }
    public void setStudentID(int studentID){
        this.studentID = studentID;
    }
    @Override
    public String toString(){
        return "Cтудент {" + "ID =" + studentID + " Имя: " + super.getFirstName() + " Отчество: "
        + super.getSecondName() + " Фамилия: " + super.getLastName() + "}";
    }
}
