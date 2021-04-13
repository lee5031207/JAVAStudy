package com.kh.bookmanager.rent;

import java.util.List;

import com.kh.bookmanager.book.Book;

public class RentController {
	
	RentService rentService = new RentService();
	
	public Rent findRent(long rmIdx){
		return rentService.findRentById(rmIdx);		
	}
	
	public List<Rent> findRentsOnRent(String userId){
		return rentService.findRentsOnRent(userId);
	}
	
	public boolean registRent(List<Book> bookList, String userId) {
		return false;
	}
	
	public boolean returnBook(Rent rent) {
		return false;
	}
	
	public Rent addRentBookToRent(long rbIdx,long rmIdx) {
		return rentService.addRentBookToRent(rmIdx, rbIdx);
	}

	public List<Rent> findAllRent() {
		return rentService.findAllRent();
	}
	
	
	
	
}
