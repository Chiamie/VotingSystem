const prompt = require('prompt-sync')();

function countWordsInSentence(str){
	let wordsInArray = str.split(" ");
	let count = 0;
	for(let index = 0; index < wordsInArray.length; index++){
		count++;
	}
	return count;
}

function countErrors(systemStr, userResponse){
	let count = 0;
	for(let index = 0; index < userResponse.length; index++){
		if (userResponse.charAt(index) != systemStr.charAt(index))
			count++;
		if ((systemStr.length - 1) == index)
			break;
	}
	console.log(count);
	let minuend = systemStr.length;
	console.log(minuend);
	let subtrahend = userResponse.length;
	console.log(subtrahend);
	let lengthDifference = 0;
	if (systemStr.length != userResponse.length){
		if (systemStr.length <  userResponse.length){
			minuend = userResponse.length;
			subtrahend = systemStr.length;
		}
		lengthDifference = minuend - subtrahend;
		console.log(lengthDifference);
	}
	count = count + lengthDifference;
	return count;
}

let sentenceToBeDisplayed = "The program should display a sentence for the user.";
let startTime = Date.now();
console.log(sentenceToBeDisplayed);
let userResponse = prompt("");
let endTime = Date.now();

let duration = endTime - startTime;
let durationInSeconds = Math.floor(duration / 1000);
let durationInMinutes = Math.floor(durationInSeconds / 60);
console.log(durationInMinutes);


let numberOfWords = countWordsInSentence(userResponse);
let wordsPerMinute = numberOfWords / durationInMinutes;



let numberOfErrors = countErrors(sentenceToBeDisplayed, userResponse);
let totalKeyStrokes = userResponse.length;

let correctKeyStrokes = totalKeyStrokes - numberOfErrors;



let accuracyPercentage = (correctKeyStrokes / totalKeyStrokes) * 100;

console.log(`Your result is stated below:\nTime taken (seconds): ${durationInSeconds}\nWords per minute: ${wordsPerMinute}\nAccuracy percentage: ${accuracyPercentage}\n`);






