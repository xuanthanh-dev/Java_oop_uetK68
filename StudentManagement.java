import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentManagement {
    //Khởi tạo mảng students
    private static Student[] students;

    //Khởi tại số thứ tự của student
    private int studentCount = 0;

    public int getStudentCount() {
        return studentCount;
    }

    //Constructor k tham số
    public StudentManagement() {
        students = new Student[100];
    }

    /**
     *   so sánh 2 student.
     */
    public static boolean sameGroup(Student s1, Student s2) {
        if (s1 == null || s2 == null || s1.getGroup() == null || s2.getGroup() == null) {
            return false;
        }
        return s1.getGroup().equals(s2.getGroup());
    }

    /**
     *   Thêm student.
     */
    public void addStudent(Student newStudent) {
        if (newStudent == null) {
            return;
        }
        boolean exist = false;

        //Kiểm tra xem có bị trùng không
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(newStudent.getId())) {
                exist = true;
                break;
            }
        }

        //Nếu k trùng thì thêm vào
        if (!exist) {
            if (studentCount < 100) {
                students[studentCount] = newStudent;
                studentCount++;
            }
        }

    }

    /**
     *   Xóa học sinh.
     */
    public void removeStudent(String id) {
        if (studentCount == 0) {
            return;
        }
        for (int i = 0; i < studentCount; ++i) {
            if (students[i].getId().equals(id)) {
                for (int j = i; j < studentCount - 1; ++j) {
                    students[j] = students[j + 1];
                }
                studentCount--;
                return;
            }
        }
    }

    /**
     *  In ra theo lớp.
     */
    public String studentsByGroup() {
        if (studentCount == 0) {
            return "Danh sách trống!\n";
        }
        StringBuilder output = new StringBuilder();
        Map<String, List<Student>> studentGroupMap = new LinkedHashMap<>();

        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null) {
                String group = students[i].getGroup();
                if (studentGroupMap.get(group) == null) {
                    List<Student> listStudent = new ArrayList<>();
                    listStudent.add(students[i]);
                    studentGroupMap.put(group, listStudent);
                } else {
                    studentGroupMap.get(group).add(students[i]);
                }
            }
        }

        for (String group : studentGroupMap.keySet()) {
            output.append(group).append("\n");
            List<Student> listStudent = studentGroupMap.get(group);
            for (Student student : listStudent) {
                output.append(student.getInfo()).append("\n");
                }
        }

        return output.toString();
    }
}