import java.util.ArrayList;

public class HotelReservationSystem {

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    public HotelReservationSystem() {

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));
    }

    public void viewRooms() {

        System.out.println("\nAvailable Rooms:");

        for (Room room : rooms) {

            System.out.println(
                    room.getRoomNumber()
                    + " - "
                    + room.getRoomType()
                    + " - "
                    + (room.isAvailable() ? "Available" : "Booked"));
        }
    }

    public void bookRoom(String customerName, int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber
                    && room.isAvailable()) {

                room.bookRoom();

                bookings.add(
                        new Booking(customerName, room));

                System.out.println("Booking Successful!");
                System.out.println("Payment Status: Paid");

                return;
            }
        }

        System.out.println("Room Not Available!");
    }

    public void cancelBooking(int roomNumber) {

        for (Booking booking : bookings) {

            if (booking.getRoom()
                    .getRoomNumber() == roomNumber) {

                booking.getRoom().cancelBooking();

                bookings.remove(booking);

                System.out.println(
                        "Booking Cancelled Successfully!");

                return;
            }
        }

        System.out.println("Booking Not Found!");
    }

    public void viewBookings() {

        if (bookings.isEmpty()) {

            System.out.println(
                    "No Bookings Available.");
            return;
        }

        System.out.println("\nBooking Details:");

        for (Booking booking : bookings) {

            System.out.println(
                    "Customer: "
                    + booking.getCustomerName()
                    + " | Room: "
                    + booking.getRoom()
                    .getRoomNumber()
                    + " | Type: "
                    + booking.getRoom()
                    .getRoomType());
        }
    }
}