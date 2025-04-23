public class Student extends Person {
    private String studentId;
    private Room assignedRoom;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    public void assignRoom(Room room) {
        this.assignedRoom = room;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student: " + name + ", ID: " + studentId + ", Age: " + age);
        if (assignedRoom != null)
            System.out.println("Assigned Room: " + assignedRoom.getRoomNumber());
    }
}