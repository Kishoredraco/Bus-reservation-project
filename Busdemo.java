package busres;

import java.util.Scanner; //nested package/ hierarchical package


public class BusDemo {

	public static void main(String[] args)  {
		
		BusDao busdao = new BusDao();
		
		try {
			busdao.displayBusInfo();
			
			int userOpt = 1;
			Scanner scanner = new Scanner(System.in);
					
			while(userOpt==1) {
				System.out.println("Enter 1 to Book and 2 to exit");
				userOpt = scanner.nextInt();
				if(userOpt == 1) {
					booking booking = new booking();
					if(booking.isAvailable()) {
						BookingDao bookingdao = new BookingDao();
				 bookingdao.addBooking(booking);
						System.out.println("Your booking is confirmed");
					}
					else
						System.out.println("Sorry. Bus is full. Try another bus or date.");
				}
			}
			scanner.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
