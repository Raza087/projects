
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