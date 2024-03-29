public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createStudent("Паша", "Леонидович", "Сальников");
        controller.createStudent("Сеня", "Петрович", "Пушка");
        controller.createStudent("Григорий", "Ярославович", "Сгоркин");
        controller.createStudent("Лена", "Игоревич", "Ступкин");
        controller.createTeacher("ВаськаКосой", "Григорьевич", "Максименко");
        controller.createTeacher("ПетькаЛенивый", "Владимирович", "Арбузов");
        controller.createGroup();
    }
}
