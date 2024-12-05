import java.util.Iterator;
import java.util.List;

/**
 * Вспомогательный класс для операций над списком студентов.
 */
public class StudentUtils {

    /**
     * Удаляет студентов со средним баллом < 3, переводит остальных на следующий курс.
     * Выпускников (курс > 5) добавляет в отдельный список.
     * Отчисленных (средний балл < 3) добавляет в список отчисленных.
     */
    public static void processStudents(List<Student> students, List<Student> expelled, List<Student> graduates) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.calculateAverageGrade() < 3) {
                expelled.add(student);
                iterator.remove();
            } else {
                student.setCourse(student.getCourse() + 1);
                if (student.getCourse() > 5) {
                    graduates.add(student);
                    iterator.remove();
                }
            }
        }
    }
}