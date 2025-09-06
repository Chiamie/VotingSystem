const prompt = require('prompt-sync')();

function viewAllBooks(booksInLibrary){
	let number = 1;
	let result = "";
	for(let book in booksInLibrary){
		result +=`${number}. ${book}: ${booksInLibrary[book]}\n`;
		number++;
	}
	return result
}

function borrowAbook(bookNumber){
	let count = 0;
	for(let book in booksInLibrary){
		count++;
		if (count == bookNumber){
			booksInLibrary[book] = "Borrowed";
		}
	}
	return booksInLibrary;
}

function returnAbook(bookNumber){
	let count = 0;
	for(let book in booksInLibrary){
		count++;
		if (count == bookNumber){
			booksInLibrary[book] = "Available";
		}
	}
	return booksInLibrary;
}

let booksInLibrary = {"Chike and the River": "Avaliable", "Arrow at Ease": "Avaliable", "Purple Hibiscus": "Avaliable", "The Incorruptiple Judge": "Avaliable", 
"The Richest Man In Babylon": "Avaliable", "The Millionaire FastLane": "Avaliable", "Rich Dad, Poor Dad": "Avaliable", "No Excuses": "Avaliable", 
"The Power Of A Praying Woman": "Avaliable", "There was a country": "Avaliable"};

const menu = `
		1. View all books
		2. Borrow a book
		3. Return a book
		0. Exit
		`;

let libraryPortal = true;
while(libraryPortal){
	console.log(menu);
	let menuSelect = parseInt(prompt("Select an option: "));
	switch(menuSelect){
		case 1:
			console.log(viewAllBooks(booksInLibrary));
			break;
		case 2:
			console.log(viewAllBooks(booksInLibrary));
			bookNumber = parseInt(prompt("Select the book you want to borrow: "));
			booksInLibrary = borrowAbook(bookNumber);
			let number = 1;
			for(let book in booksInLibrary){
				console.log(`${number}. ${book}: ${booksInLibrary[book]}`);
				number++;
			}
			break;
			
		case 3:
			console.log(viewAllBooks(booksInLibrary));
			bookNumber = parseInt(prompt("Select the book you want to return: "));
			booksInLibrary = returnAbook(bookNumber);
			let number1 = 1;
			for(let book in booksInLibrary){
				console.log(`${number1}. ${book}: ${booksInLibrary[book]}`);
				number1++;
			}
			break;

		case 0:
			libraryPortal = false;
	}
}





















