import java.time.Instant;
import java.time.Duration;
import java.util.Scanner;

public class TypingSpeed{
public static void main(String[] args){

Scanner input = new Scanner(System.in);

String sentenceToBeDisplayed = "The program should display a sentence for the user.";
Instant startTime = Instant.now();
System.out.println(sentenceToBeDisplayed);
String userResponse = input.nextLine();
Instant endTime = Instant.now();

Duration duration = Duration.between(startTime, endTime);
long durationInSeconds = duration.getSeconds();

long durationInMinutes = duration.toMinutes();
System.out.println(durationInMinutes);


int numberOfWords = countWordsInSentence(userResponse);
long wordsPerMinute = numberOfWords / durationInMinutes;



int numberOfErrors = countErrors(sentenceToBeDisplayed, userResponse);
int totalKeyStrokes = userResponse.length();

int correctKeyStrokes = totalKeyStrokes - numberOfErrors;



int accuracyPercentage = (correctKeyStrokes / totalKeyStrokes) * 100;

System.out.printf("Your result is stated below:%nTime taken (seconds): %d%nWords per minute: %d%nAccuracy percentage: %d%n", durationInSeconds, wordsPerMinute, accuracyPercentage);
}





public static int countWordsInSentence(String str){
	String[] wordsInArray = str.split(" ");
	int count = 0;
	for(int index = 0; index < wordsInArray.length; index++){
		count++;
	}
	return count;
}

public static int countErrors(String systemStr, String userResponse){
	int count = 0;
	String largest = userResponse;
	if (systemStr.length() >  userResponse.length()){
		largest = systemStr;
	}
	for(int index = 0; index < userResponse.length(); index++){
		if (userResponse.charAt(index) != systemStr.charAt(index))
			count++;
		if ((systemStr.length() - 1) == index)
			break;
	}
	System.out.println(count);
	int minuend = systemStr.length();
	System.out.println(minuend);
	int subtrahend = userResponse.length();
	System.out.println(subtrahend);
	int lengthDifference = 0;
	if (systemStr.length() != userResponse.length()){
		if (systemStr.length() <  userResponse.length()){
			minuend = userResponse.length();
			subtrahend = systemStr.length();
		}
		lengthDifference = minuend - subtrahend;
		System.out.println(lengthDifference);
	}
	count = count + lengthDifference;
	return count;
}














}