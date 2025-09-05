import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class VotingSystem{

public static ArrayList<ArrayList<String>> candidatesList = new ArrayList<>();
public static ArrayList<ArrayList<String>> votersList = new ArrayList<>();
public static void main(String[] args){
ArrayList<String> candidateDetails = new ArrayList<String>();
ArrayList<String> voterDetails = new ArrayList<String>();

Scanner input = new Scanner(System.in);
boolean list0fOptions = true;
while (list0fOptions){
	String menu = """
		1. Candidate Registration
		2. Voter Registration
		3. Voting Process
		4. Vote Counting
		5. Election Result
		0. Exit
		""";
	System.out.println(menu); 
	System.out.println("Select an option: ");
	int userResponse = input.nextInt();
	switch(userResponse){
		case 1:
			displayWelcomeNote(userResponse)	;	
			System.out.println("Enter your name: ");
			String candidateName = input.next();
			boolean isAlpha = isAllLetters(candidateName);
			while (isAlpha == false){
				System.out.print("Invalid Name. Please ");
				System.out.println("Enter your name: ");
				candidateName = input.next();
			}
			
			System.out.println("Enter your Party abreviation: ");
			String candidateParty = input.next();
			candididateParty = candididateParty.toUpperCase();
			isAlpha = isAllLetters(candidateParty);
			while (isAlpha == false){
				System.out.print("Invalid Party Abbreviation. Please ");
				System.out.println("Enter your Party abreviation: ");
				candidateParty = input.next();
			}
			
			System.out.println("Enter your voter's identification number: ");
			String candidateVin = input.next();
			boolean alphaNumeric = isAlphaNumeric(candidateVin);
			while (alphaNumeric == false){				
				System.out.print("Invalid Voter Identification number. Please ");
				System.out.println("Enter your voter's identification number: ");
				candidateVin = input.next();
			}

			
		
			candidateDetails.add(candidateName);
			candidateDetails.add(candidateParty);
			candidateDetails.add(candidateVin);
			
			candidatesList.add(getStoredCandidateDetails(candidateDetails));
			System.out.println(candidateDetails);
			System.out.println(candidatesList);
			
			break;
		case 2:
			displayWelcomeNote(userResponse)	;
			System.out.println("Enter your name:");
			String voterName = input.next();
			isAlpha = isAllLetters(voterName);
			while (isAlpha == false){
				System.out.println("Enter your name:");
				voterName = input.next();
			}
			System.out.println("Enter your DOB: ");
			String voterDateOfBirth = input.next();
			
			System.out.println("Enter your state of origin: ");
			String voterStateOfOrigin = input.next();
			voterStateOfOrigin = voterStateOfOrigin.toUpperCase();
			isAlpha = isAllLetters(voterStateOfOrigin);
			while (isAlpha == false){
				System.out.println("Enter your state of origin: ");
				voterStateOfOrigin = input.next();
			}

			System.out.println("Enter your LGA: ");
			String voterLGA = input.next();
			isAlpha = isAllLetters(voterLGA);
			while (isAlpha == false){
				System.out.println("Enter your LGA: ");
				voterLGA = input.next();
			}

			System.out.println("Enter your Contact: ");
			String voterContact = input.next();
			boolean isDigit = isAllDigits(voterContact);
			while (isDigit == false){
				System.out.println("Enter your Contact: ");
				voterContact = input.next();
			}
			
			voterDetails.add(voterName);
			voterDetails.add(voterDateOfBirth);
			voterDetails.add(voterStateOfOrigin);
			voterDetails.add(voterLGA);
			voterDetails.add(voterContact);
			
			String voterVIN = getVIN(voterDetails);
			System.out.println("This is your voters identification number " + voterVIN);
			
			voterDetails.add(voterVIN);
			votersList.add(getVotersList(voterDetails));
			System.out.println(votersList);

			
	}
}

		
}

public static ArrayList<String> getStoredCandidateDetails(ArrayList<String> candidateDetails){
	ArrayList<String> storedCandidateDetails = new ArrayList<String>();
	storedCandidateDetails.add(candidateDetails.get(0));
	storedCandidateDetails.add(candidateDetails.get(1));
	storedCandidateDetails.add(candidateDetails.get(2));
	return storedCandidateDetails;
}

public static String getStateZipCode(ArrayList<String> voterDetails){
	Map<String, String> stateZipCode = new HashMap<>();
	
	stateZipCode.put("ABIA", "440001");  stateZipCode.put("ADAMAWA", "640001");
	stateZipCode.put("AKWA IBOM", "520001");  stateZipCode.put("ANAMBRA", "420001");
	stateZipCode.put("BAUCHI", "740001");  stateZipCode.put("BAYELSA", "561001");
	stateZipCode.put("BENUE", "970001");  stateZipCode.put("BORNO", "600001");
	stateZipCode.put("CROSS RIVER", "540001");  stateZipCode.put("DELTA", "320001");
	stateZipCode.put("EBONYI", "840001");  stateZipCode.put("EDO", "300001");
	stateZipCode.put("EKITI", "360001");  stateZipCode.put("ENUGU", "400001");
	stateZipCode.put("GOMBE", "760001");  stateZipCode.put("IMO", "460001");
	stateZipCode.put("JIGAWA", "720001");  stateZipCode.put("KADUNA", "700001");
	stateZipCode.put("KANO", "800001");  stateZipCode.put("KASTINA", "820001");
	stateZipCode.put("KEBBI", "860001");  stateZipCode.put("KOGI", "260001");
	stateZipCode.put("KWARA", "240001");  stateZipCode.put("LAGOS", "100001");
	stateZipCode.put("NASARAWA", "962001,");  stateZipCode.put("NIGER", "920001");
	stateZipCode.put("OGUN", "110001");  stateZipCode.put("ONDO", "340001");
	stateZipCode.put("OSUN", "230001");  stateZipCode.put("OYO", "200001");
	stateZipCode.put("PLATEAU", "930001");  stateZipCode.put("RIVERS", "500001");
	stateZipCode.put("SOKOTO", "840001");  stateZipCode.put("TARABA", "660001");
	stateZipCode.put("YOBE", "620001");  stateZipCode.put("FCT", "900001");

	String state = voterDetails.get(2);
	return stateZipCode.get(state);
}

public static String getVIN(ArrayList<String> voterDetails){
	String zipCode = getStateZipCode(voterDetails);
	String regNum = "" + (int)(Math.random() * 1000);
	String lgaAbbreviation = voterDetails.get(2);
	lgaAbbreviation = lgaAbbreviation.substring(0, 3);
	lgaAbbreviation += zipCode;
	lgaAbbreviation += regNum;
	lgaAbbreviation += (voterDetails.get(3)).substring(0, 3);
	return lgaAbbreviation;
}

public static ArrayList<String> getVotersList(ArrayList<String> voterDetails){
	ArrayList<String> storedVotersDetails = new ArrayList<String>();
	storedVotersDetails.add(voterDetails.get(0));
	storedVotersDetails.add(voterDetails.get(1));
	storedVotersDetails.add(voterDetails.get(2));
	storedVotersDetails.add(voterDetails.get(3));
	storedVotersDetails.add(voterDetails.get(4));
	storedVotersDetails.add(voterDetails.get(5));
	return storedVotersDetails;
}


public static boolean isAllLetters(String word){
	boolean isAlpha = true;
	for(char c: word.toCharArray()){
		if(!Character.isLetter(c)){
			isAlpha = false;
			break;
		}
	}
	return isAlpha;
}
	
public static boolean isAlphaNumeric(String wordNum){
	for(char c : wordNum.toCharArray()){
		if(!Character.isLetterOrDigit(c)){
			return false;
		}
	}
	return true;
	
}

public static boolean isAllDigits(String number){
	for(char c: number.toCharArray()){
		if (!Character.isDigit(c)){
			return false;
		}
	}
	return true;
}

public static void displayWelcomeNote(int number){
	if (number == 1){
		System.out.println("""
		===============================================
		Welcome to the registration site for candidates
		Fill the form below:
		================================================
		""");
	}
	else if (number == 2){
		System.out.println("""
		===============================================
		Welcome to the registration site for voters
		Fill the form below:
		================================================
		""");
	}

}



	
	


}
	