
public class RoomCleaner extends Thread {
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