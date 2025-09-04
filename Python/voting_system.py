import random
def get_stored_candidate_details(candidate_details):
	if type(candidate_details) != list:
		raise TypeError("candidate_details must be a List")
	for item in candidate_details:
		if not item.isalnum():
			raise ValueError("card_number must be all numeric strings")

		
	stored_candidate_details = {}
	stored_candidate_details['Name'] = candidate_details[0]
	stored_candidate_details['Party'] = candidate_details[1]
	stored_candidate_details['VIN'] = candidate_details[2]
	return stored_candidate_details
	
def get_state_zip_code(voter_details):
	states_and_zip_code = {
	"ABIA": 440001, "ADAMAWA": 640001, "AKWA IBOM": 520001, "ANAMBRA": 420001, "BAUCHI": 740001,
	"BAYELSA": 561001, "BENUE": 970001, "BORNO": 600001, "CROSS RIVER": 540001, "DELTA": 320001,
	"EBONYI": 840001, "EDO": 300001, "EKITI": 360001, "ENUGU": 400001, "GOMBE": 760001, "IMO": 460001,
	"JIGAWA": 720001, "KADUNA": 700001, "KANO": 800001, "KASTINA": 820001, "KEBBI": 860001, "KOGI": 260001,
	"KWARA": 240001, "LAGOS": 100001, "NASARAWA": 962001, "NIGER": 920001, "OGUN": 110001, "ONDO": 340001,
	"OSUN": 230001, "OYO": 200001, "PLATEAU": 930001, "RIVERS": 500001, "SOKOTO": 840001, "TARABA": 660001,
	"YOBE": 620001, "FCT": 900001
	}
	state = voter_details[2]
	
	return states_and_zip_code[state]

def get_vin(voter_details):
	zip_code = str(get_state_zip_code(voter_details))
	reg_num = str(random.randrange(0, 1000))
	lga_abbreviation = [voter_details[2][0:3], voter_details[3][0:3]]
	vin = lga_abbreviation[0] + zip_code + reg_num + str(lga_abbreviation[1])
	return vin

def get_voters_list(voter_details):
	stored_voters_details = {}
	stored_voters_details['Name'] = voter_details[0]
	stored_voters_details['DOB'] = voter_details[1]
	stored_voters_details['State'] = voter_details[2]
	stored_voters_details['LGA'] = voter_details[3]
	stored_voters_details['Contact'] = voter_details[4]
	stored_voters_details['VIN'] = voter_details[5]
	return stored_voters_details
	
def is_valid(user_response, voters_list, cast_voters):
	for number in range(0, len(voters_list)):
		for key in voters_list[number]:
			if key == "VIN":
				if voters_list[number][key] == user_response:
					if user_response not in cast_voters:
						return "valid"
					else:
						return "not allowed"
				
	return "invalid"

def get_registered_parties(candidates_list):
	return [candidate["Party"] for candidate in candidates_list]


def get_count_of_votes(list_of_casted_votes):
	counts = {}
	for casted_votes in list_of_casted_votes:
		counts[casted_votes] = counts.get(casted_votes, 0) + 1
	return(counts)


def get_election_result(vote_count, registered_parties):
	result = []
	for index_str, count in vote_count.items():
		index = int(index_str) - 1
		party = registered_parties[index]
		result.append(f"{party} scored {count}")
	return result	

def display_final_result(result):
	largest = 0
	winner = ""
	result_sentence = ""
	for election_result in result:
		party = election_result.split("scored")[0].strip()
		score = int(election_result.split("scored")[1].strip())
		if score > largest:
			largest = score
			winner = party
			result_sentence = election_result
	return f"The winner is {winner} because {result_sentence}"
			
	
