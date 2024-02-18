package busres;

import java.util.*;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat; 
public class booking  {
	String passengerName;
	int busNo;
	Date date;
	
	booking(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name of passenger: ");
		passengerName = scanner.next();
		System.out.println("Enter bus no: ");
		busNo = scanner.nextInt();
		System.out.println("Enter date dd-mm-yyyy");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		

		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public boolean isAvailable()  throws SQLException{
		
		BusDao busdao = new BusDao();
		BookingDao bookingdao = new BookingDao();
		int capacity = busdao.getCapacity(busNo);

		int booked = bookingdao.getBookedCount(busNo,date);
		
		return booked<capacity;
		
	}
}
