import time

def count_words_in_sentence(str):
	words_in_list = str.split(" ")
	count = 0;
	for element in words_in_list:
		count += 1
	return count


def count_errors(systemStr, userResponse):
	count = 0;
	for index in range(0, len(userResponse)):
		if userResponse[index] != systemStr[index]:
			count += 1
			
		if len(systemStr) - 1 == index:
			break
	
	print(count)
	minuend = len(systemStr)
	print(minuend)
	subtrahend = len(userResponse)
	print(subtrahend);
	lengthDifference = 0;
	if len(systemStr) != len(userResponse):
		if len(systemStr) <  len(userResponse):
			minuend = len(userResponse)
			subtrahend = len(systemStr)
		lengthDifference = minuend - subtrahend
		print(lengthDifference)
	count = count + lengthDifference;
	return count





sentence_to_be_displayed = "The program should display a sentence for the user.";
start_time = time.time()
print(sentence_to_be_displayed)
user_response = input("")
end_time = time.time()

duration_in_seconds = end_time - start_time

duration_in_minutes = (int) duration_in_seconds // 60
print(duration_in_minutes)


number_of_words = count_words_in_sentence(user_response)
words_per_minute = (int) number_of_words // duration_in_minutes

number_of_errors = count_errors(sentence_to_be_displayed, user_response);
total_key_strokes = len(user_response)

correct_key_strokes = total_key_strokes - number_of_errors

accuracy_percentage = (correct_key_strokes / total_key_strokes) * 100;

print(f"Your result is stated below:\nTime taken (seconds): {duration_in_seconds}\nWords per minute: {words_per_minute}\nAccuracy percentage: {accuracy_percentage}\n")






