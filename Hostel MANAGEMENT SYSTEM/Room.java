import java.util.*;
public class Room {
    private String roomNumber;
    private int capacity;
    private List<Student> students;

    public Room(String roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public boolean addStudent(Student student) {
        if (students.size() < capacity) {
            students.add(student);
            student.assignRoom(this);
            return true;
        }
        return false;
    }

    public List<Student> getStudents() {
        return students;
    }
}