import java.util.*;
public class Test
{

abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void displayInfo();
}

class Student extends Person {
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


class HostelStaff extends Person {
    private String role;

    public HostelStaff(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    @Override
    public void displayInfo() {
        System.out.println("Staff: " + name + ", Role: " + role + ", Age: " + age);
    }
}


class Room {
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


class Hostel {
    private String name;
    private List<Room> rooms;
    private List<HostelStaff> staffList;

    public Hostel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.staffList = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addStaff(HostelStaff staff) {
        staffList.add(staff);
    }

    public void displayDetails() {
        System.out.println("Hostel: " + name);
        for (Room room : rooms) {
            System.out.println("Room: " + room.getRoomNumber());
            for (Student s : room.getStudents()) {
                s.displayInfo();
            }
        }
        System.out.println("Staff:");
        for (HostelStaff s : staffList) {
            s.displayInfo();
        }
    }
}


class RoomCleaner extends Thread {
    private Room room;

    public RoomCleaner(Room room) {
        this.room = room;
    }

    @Override
    public void run() {
        System.out.println("Cleaning Room " + room.getRoomNumber() + " started.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Cleaning interrupted.");
        }
        System.out.println("Cleaning Room " + room.getRoomNumber() + " done.");
    }
}


public class HostelSystem {
    public static void main(String[] args) {
        Hostel hostel = new Hostel("GM Hostel");

        Room room1 = new Room("101", 2);
        Room room2 = new Room("102", 1);
        hostel.addRoom(room1);
        hostel.addRoom(room2);

        HostelStaff staff1 = new HostelStaff("Hadi", 45, "Warden");
        hostel.addStaff(staff1);

        Student st1 = new Student("Ali", 20, "086");
        Student st2 = new Student("Raza", 21, "087");
        Student st3 = new Student("Nabeel", 22, "038");

        room1.addStudent(st1);
        room1.addStudent(st2);
        room2.addStudent(st3);

        hostel.displayDetails();

        // Threads
        new RoomCleaner(room1).start();
        new RoomCleaner(room2).start();
    }
}
}