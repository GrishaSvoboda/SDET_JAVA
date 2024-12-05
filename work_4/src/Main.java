import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Главный класс программы.
 */
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Создаем студентов
        students.add(new Student("Алексей Иванов", "Группа 1", 1, createGrades(5, 4, 3, 2)));
        students.add(new Student("Мария Сидорова", "Группа 1", 2, createGrades(4, 3, 5, 4)));
        students.add(new Student("Петр Петров", "Группа 2", 3, createGrades(2, 2, 2, 3)));
        students.add(new Student("Ирина Кузнецова", "Группа 2", 4, createGrades(5, 5, 4, 5)));
        students.add(new Student("Владимир Смирнов", "Группа 3", 2, createGrades(3, 3, 3, 3)));
        students.add(new Student("Екатерина Морозова", "Группа 3", 1, createGrades(4, 4, 5, 5)));
        students.add(new Student("Олег Никифоров", "Группа 1", 5, createGrades(5, 4, 5, 5)));
        students.add(new Student("Татьяна Павлова", "Группа 2", 3, createGrades(2, 3, 2, 1)));
        students.add(new Student("Дмитрий Орлов", "Группа 1", 1, createGrades(5, 5, 4, 4)));

        System.out.println();
        System.out.println("Исходный список студентов:");
        printTable(students);

        // Списки для отчисленных и выпускников
        List<Student> expelled = new ArrayList<>();
        List<Student> graduates = new ArrayList<>();

        // Обработка студентов
        StudentUtils.processStudents(students, expelled, graduates);

        System.out.println("\nСписок студентов после обработки (сортировка по курсам):");
        printStudentsByCourses(students);

        System.out.println("\nСписок выпускников:");
        printGraduates(graduates);

        System.out.println("\nСписок отчисленных:");
        printTable(expelled);
    }

    /**
     * Создает оценки для студента.
     */
    private static Map<String, Integer> createGrades(int... grades) {
        Map<String, Integer> subjects = new HashMap<>();
        subjects.put("Математика", grades[0]);
        subjects.put("Физика", grades[1]);
        subjects.put("История", grades[2]);
        subjects.put("Литература", grades[3]);
        return subjects;
    }

    /**
     * Выводит список студентов в виде таблицы.
     */
    private static void printTable(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        System.out.printf("%-20s %-15s %-10s %-15s%n", "Студент", "Группа", "Курс", "Средний балл");
        System.out.println("------------------------------------------------------------------");
        for (Student student : students) {
            System.out.printf("%-20s %-15s %-10d %-15.2f%n",
                    student.getName(),
                    student.getGroup(),
                    student.getCourse(),
                    student.calculateAverageGrade());
        }
    }

    /**
     * Выводит студентов, сгруппированных по курсам.
     */
    private static void printStudentsByCourses(List<Student> students) {
        students.stream()
                .collect(Collectors.groupingBy(Student::getCourse))
                .forEach((course, studentsInCourse) -> {
                    System.out.println("Студенты на курсе " + course + ":");
                    System.out.println("------------------------------------------------------------------");
                    studentsInCourse.forEach(student -> System.out.printf("%-20s %-15s Средний балл: %.2f%n",
                            student.getName(), student.getGroup(), student.calculateAverageGrade()));
                    System.out.println();
                });
    }
    private static void printGraduates(List<Student> graduates) {
        if (graduates.isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        System.out.printf("%-20s %-15s %-15s%n", "Студент", "Группа", "Средний балл");
        System.out.println("----------------------------------------------------");
        for (Student graduate : graduates) {
            System.out.printf("%-20s %-15s %-15.2f%n",
                    graduate.getName(),
                    graduate.getGroup(),
                    graduate.calculateAverageGrade());
        }
    }
}