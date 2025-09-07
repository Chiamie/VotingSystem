

def view_all_books(books_in_library):
	number = 1;
	result = "";
	for book in books_in_library:
		result += f"{number}. {book}: {books_in_library[book]}\n";
		number += 1
	return result


def borrow_a_book(book_number):
	count = 0
	for book in books_in_library:
		count += 1
		if count == book_number:
			books_in_library[book] = "Borrowed"
			break;
	return books_in_library


def return_a_book(book_number):
	count = 0
	for book in books_in_library:
		count += 1
		if count == book_number:
			books_in_library[book] = "Available";
	return books_in_library

books_in_library = {"Chike and the River": "Avaliable", "Arrow at Ease": "Avaliable", "Purple Hibiscus": "Avaliable", "The Incorruptiple Judge": "Avaliable", 
"The Richest Man In Babylon": "Avaliable", "The Millionaire FastLane": "Avaliable", "Rich Dad, Poor Dad": "Avaliable", "No Excuses": "Avaliable", 
"The Power Of A Praying Woman": "Avaliable", "There was a country": "Avaliable"};

menu = """
	1. View all books
	2. Borrow a book
	3. Return a book
	0. Exit
	"""

library_portal = True
while library_portal:
	print(menu)
	menu_select = int(input("Select an option: "))
	match(menu_select):
		case 1:
			print(view_all_books(books_in_library))
			
		case 2:
			print(view_all_books(books_in_library))
			book_number = int(input("Select the book you want to borrow: "))
			books_in_library = borrow_a_book(book_number)
			number = 1
			for book in books_in_library:
				print(f"{number}. {book}: {books_in_library[book]}")
				number += 1
			
			
		case 3:
			print(view_all_books(books_in_library));
			book_number = int(input("Select the book you want to return: "))
			books_in_library = return_a_book(book_number)
			number = 1
			for book in books_in_library:
				print(f"{number}. {book}: {books_in_library[book]}")
				number += 1
			

		case 0:
			library_portal = False
	























