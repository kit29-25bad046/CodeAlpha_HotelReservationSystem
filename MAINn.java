import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HotelReservationSystem hotel =
                new HotelReservationSystem();

        int choice;

        do {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    hotel.viewRooms();
                    break;

                case 2:

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();

                    hotel.bookRoom(name, roomNo);

                    break;

                case 3:

                    System.out.print("Enter Room Number: ");
                    int cancelRoom = sc.nextInt();

                    hotel.cancelBooking(cancelRoom);

                    break;

                case 4:

                    hotel.viewBookings();
                    break;

                case 5:

                    System.out.println("Thank You!");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}