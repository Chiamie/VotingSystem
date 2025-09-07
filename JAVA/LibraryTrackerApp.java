import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibraryTrackerApp{
public static void main(String[] args){

Scanner input = new Scanner(System.in);

Map<String, String> booksInLibrary = new HashMap<>();
booksInLibrary.put("Chike and the River", "Avaliable");
booksInLibrary.put("The Richest Man In Babylon", "Avaliable");
booksInLibrary.put("The Power Of A Praying Woman", "Avaliable");
booksInLibrary.put("There was a country", "Avaliable");
booksInLibrary.put("The Millionaire FastLane", "Avaliable");
booksInLibrary.put("Rich Dad, Poor Dad", "Avaliable");
booksInLibrary.put("No Excuses", "Avaliable");
booksInLibrary.put("Arrow at Ease", "Avaliable");
booksInLibrary.put("Purple Hibiscus", "Avaliable");
booksInLibrary.put("The Incorruptiple Judge", "Avaliable");
booksInLibrary.put("Chike and the River", "Avaliable");

String menu = """
		1. View all books
		2. Borrow a book
		3. Return a book
		0. Exit
		""";

boolean libraryPortal = true;
while(libraryPortal){
	System.out.println(menu);
	System.out.println("Select an option: ");
	int menuSelect = input.nextInt();
	switch(menuSelect){
		case 1:
			System.out.println(viewAllBooks(booksInLibrary));
			break;
		case 2:
			System.out.println(viewAllBooks(booksInLibrary));
			System.out.println("Select the book you want to borrow: ");
			int bookNumber = input.nextInt();
			System.out.println(borrowAbook(bookNumber, booksInLibrary));
			break;
			
		case 3:
			System.out.println(viewAllBooks(booksInLibrary));
			System.out.println("Select the book you want to borrow: ");
			bookNumber = input.nextInt();
			System.out.println(returnAbook(bookNumber, booksInLibrary));
			break;
		default:
			System.out.println("Invalid selection");
			break;
		case 0:
			libraryPortal = false;
	}
}

}
public static String viewAllBooks(Map<String, String> booksInLibrary){
	int number = 1;
	String result = "";
	for(Map.Entry<String, String> entry : booksInLibrary.entrySet()){
		result += number + ". " + entry.getKey() + ": " + entry.getValue() + "\n";
		number++;
	}
	return result;
}

public static String borrowAbook(int bookNumber, Map<String, String> booksInLibrary){
	int count = 0;
	for(Map.Entry<String, String> entry : booksInLibrary.entrySet()){
		count++;
		if (count == bookNumber){
			booksInLibrary.replace(entry.getKey(), "Borrowed");
		}
	}
	return "Borrowed Successfully";
}

public static String  returnAbook(int bookNumber, Map<String, String> booksInLibrary){
	int count = 0;
	for(Map.Entry<String, String> entry : booksInLibrary.entrySet()){
		count++;
		if (count == bookNumber){
			booksInLibrary.replace(entry.getKey(), "Available");		}
	}
	return "Book returned successfully";
}




}



























