package BookStore;

public class Store {
	
	private static int totalItems 	= 0; 	// So quyen sach hien tai trong kho sach
	private final int MAX_ITEMS		= 3; 	// So quyen sach lon nhat ma kho sach chua duoc
	private Book[] listItems		= null; 
	
	// listItems[0] = bookObj1
	// listItems[1] = bookObj2
	// listItems[2] = bookObj3
	
	public Store() {
		listItems = new Book[MAX_ITEMS];
	}
	
	public int getItemPosition(String bookID) {
		for(int i = 0; i < totalItems; i++) {
			if(bookID.equals(listItems[i].getID()) == true) return i;
		}
		return -1;
	}
	
	// check full
	public boolean checkFull() {
		
		if(totalItems == MAX_ITEMS) return true;
		return false;
		
	}
	
	// check empty
	public boolean checkEmpty() {
		
		if(totalItems == 0) return true;
		return false;
		
	}
	
	// Add Book
	public void add(Book bookObj) {
		if(this.checkFull() == false) {
			this.listItems[totalItems] = bookObj;  // them moi 1 quyen sách
			this.totalItems++;	
			System.out.println("Add successful");
		}else {
			System.out.println("Store is full!");
		}
	}
	
	// Edit Book
	public void edit(String bookID, String bookName, double bookPrice) {
		int bookPosition = this.getItemPosition(bookID);
		if(bookPosition == -1) {
			System.out.println("This book is not exist!");
		}else {
			listItems[bookPosition].setName(bookName);
			listItems[bookPosition].setPrice(bookPrice);
			System.out.println("Edit successful!");
		}
	}
	
	// Delete Book
	public void delete(String bookID) {
		int bookPosition = this.getItemPosition(bookID);
		if(bookPosition == -1) {
			System.out.println("This book is not exist!");
		}else {
			
			for(int i = bookPosition; i < totalItems - 1; i++) {
				listItems[i] = listItems[i+1];
			}
			this.totalItems--;	
			System.out.println("Delete successful!");
		}
	}
	
	// Find Book
	public void find(String bookID) {
		// listItems[0] = 1 java 13
		// listItems[1] = 2 androi 20
		// listItems[2] = 3 PHP 22
		int bookPosition = this.getItemPosition(bookID);
		if(bookPosition == -1) {
			System.out.println("This book is not exist!");
		}else {
			listItems[bookPosition].showInfo();
		}
	}
	
	// List Book
	public void list() {
		if(this.checkEmpty() == false) {
			for(int i = 0; i < totalItems; i++) {
				this.listItems[i].showInfo();
			}
		}else {
			System.out.println("Store is empty!");
		}
	}		
}


































