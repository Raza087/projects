import java.util.*; 
public class Hostel {
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