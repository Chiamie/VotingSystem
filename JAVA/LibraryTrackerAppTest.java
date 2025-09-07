import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;
import java.util.LinkedHashMap;


public class LibraryTrackerAppTest{
@Test	
public void testViewAllBooksFunction(){
	Map<String, String> booksInLibrary = new LinkedHashMap<>();
	booksInLibrary.put("Chike and the River", "Available");
	booksInLibrary.put("Arrow at Ease", "Available");
	booksInLibrary.put("Purple Hibiscus", "Available");

	LibraryTrackerApp libraryTrackerApp = new LibraryTrackerApp();
	String result = libraryTrackerApp.viewAllBooks(booksInLibrary);
	String expected = "1. Chike and the River: Avaliable\n2. Arrow at Ease: Avaliable\n3. Purple Hibiscus: Avaliable\n";
	
	assertEquals(result, expected);
							
}

}


