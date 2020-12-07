package com.kh.jdbc.rent.controller;

import java.util.List;

import com.kh.jdbc.book.model.vo.Book;
import com.kh.jdbc.book.model.vo.RentBook;
import com.kh.jdbc.common.code.ErrorCode;
import com.kh.jdbc.rent.model.service.RentService;
import com.kh.jdbc.rent.model.vo.Rent;

public class RentController {

	RentService rentService = new RentService();
	public RentController() {
		
	}
	public List<Rent> searchRentList(String title){
		return null;		
	}
	public List<RentBook> searchRentBookList(String title){
		return null;		
	}
	
	public String registRent(List<Book> bookList, String userId) {
		Rent rent = new Rent();
		//대출 건 제목 작성, xxx외 N권
		String title = bookList.get(0).getTitle() + " 외"
				+ (bookList.size()-1) + "권";
		rent.setUserId(userId);
		rent.setTitle(title);
		rent.setRentbookCnt(bookList.size());
		
		if(rentService.insertRentBookInfo(rent, bookList)) {
			return title;
		}else {
			return ErrorCode.IR01.errMsg();
		}		
	}
	
	public boolean returnBook(int rbIdx) {
		return rentService.updateReturnRentBook(rbIdx);
	}
	
	public boolean extendBook(int rbIdx) {
		return true;
	}
	
	
	
}
