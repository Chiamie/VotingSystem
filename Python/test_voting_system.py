import unittest
import inspect
from voting_system import get_stored_candidate_details
from voting_system import get_state_zip_code
from voting_system import get_vin
from voting_system import get_voters_list
from voting_system import is_valid


class TestGetStoredCandidateDetailsFunction(unittest.TestCase):
	def test_that_the_get_stored_candidate_details_function_accepts_1_argument(self):
		function_signature = inspect.signature(get_stored_candidate_details)
		dic_parameter = function_signature.parameters
		self.assertEqual(len(dic_parameter), 1)
	def test_that_the_get_stored_candidate_details_function_raises_validation_when_argument_is_a_float(self):
		self.assertRaises(TypeError, get_stored_candidate_details, 32.8)
	def test_that_the_get_stored_candidate_details_function_raises_validation_when_argument_is_an_integer(self):
		self.assertRaises(TypeError, get_stored_candidate_details, 32)
	def test_that_the_get_stored_candidate_details_function_raises_validation_when_argument_is_a_string(self):
		self.assertRaises(TypeError, get_stored_candidate_details, "mummy")
	def test_that_the_get_stored_candidate_details_function_raises_validation_when_argument_is_empty(self):
		self.assertRaises(TypeError, get_stored_candidate_details, "")
	def test_that_the_get_stored_candidate_details_function_raises_validation_when_list_has_an_empty_element(self):
		self.assertRaises(ValueError, get_stored_candidate_details, ["", "name", 123])
	def test_that_the_get_stored_candidate_details_function_returns_correct_result(self):
		result = get_stored_candidate_details(['Chi', 'pdp', '234'])
		self.assertEqual(result, {'Name': 'Chi', 'Party': 'pdp', 'VIN': '234'})


class TestGetStateZipCodeDetailsFunction(unittest.TestCase):
	def test_that_the_get_state_zip_code_function_accepts_1_argument(self):
		function_signature = inspect.signature(get_state_zip_code)
		dic_parameter = function_signature.parameters
		self.assertEqual(len(dic_parameter), 1)
	def test_that_the_get_state_zip_code_function_raises_validation_when_argument_is_a_float(self):
		self.assertRaises(TypeError, get_state_zip_code, 32.8)
	def test_that_the_get_state_zip_code_function_raises_validation_when_argument_is_an_integer(self):
		self.assertRaises(TypeError, get_state_zip_code, 32)
	def test_that_the_get_stored_candidate_details_function_raises_validation_when_argument_is_empty(self):
		self.assertRaises(TypeError, get_stored_candidate_details, "")



