package skillup.day03.library.controller;

import com.kh.member.model.vo.Member;
import java.lang.*;

import skillup.day03.library.model.vo.AniBook;
import skillup.day03.library.model.vo.Book;
import skillup.day03.library.model.vo.CookBook;

public class LibraryManager {
	
	skillup.day03.library.model.vo.Member mem = new skillup.day03.library.model.vo.Member();
	Book[] bList = new Book[5];
	{
		bList[0] = new CookBook("백종원의 집밥","백종원","tvN",true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스","루피","japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요","이혜정","문학",false);
		bList[4] = new CookBook("최현석 날 따라해","최현석","소금책",true);
	}
	public LibraryManager() {
		
	}
	
	public void insertMember(skillup.day03.library.model.vo.Member m) {
		//전달 받은 m 주소 값을
		//this.mem(회원)에 대입
		this.mem = m;
	}
	
	public skillup.day03.library.model.vo.Member myPage(){
		//회원 레퍼런스(mem) 주소 값 리턴
		System.out.println(mem.toString());
		return mem;
	}
	
	public Book[] selectAll() {
		//도서배열 레퍼런스(bList) 주소 값 리턴
		return bList;
	}
	
	public Book[] searchBook(String keyword) {
		//검색 결과 여러 개의 도서가 검색 될 수도 있으니 검색된 도서를 담 아줄 Book객체 배열 새로 생성

		//for문을 이용하여 bList 안의 도서 들과 전달받은 keyword를 비교하여 제목에
		//해당 keyword를 포함하 고 있는 경우 새로운 배열에 차곡 차곡 담기
		int count = 0;
		for(int i=0; i<bList.length; i++) {
			if(bList[i].getTitle().contains(keyword)) {				
				count++;				
			}
		}
		Book[] searchList = new Book[count];
		count = 0;
		for(int i=0; i<bList.length; i++) {
			if(bList[i].getTitle().contains(keyword)) {				
				searchList[count] = bList[i];
				count++;
			}
		}
		
		//그 배열 주소 값 리턴
		return searchList;
	}
	
	public int rentBook(int index) {
		//대여 결과 값을 받아줄 int 변수 result 선언 (0으로 초기화)
		int result = 0;
		if(bList[index] instanceof AniBook) {
			//전달받은 인덱스의 도서가 AniBook일 경우 회원 나이와 해당 도서의 제한 나이를 비교하여 회원 나이가 더 적을 경우(대여 불가)
			if(((AniBook)bList[index]).getAccessAge() > mem.getAge()) {
				//result 값 1로 초기화
				result = 1;
			}
		}else if(bList[index] instanceof CookBook) {
			if(((CookBook)bList[index]).isCoupon()) {
				mem.setCouponCount(mem.getCouponCount()+1);	
				result = 2;
			}
		}
		// CookBook일 경우 해당 도서에 요리쿠폰이 있을 경우
		//(대여 성공 및 쿠폰 발급) result 2로 초기화 후 회원의 couponCount 수 1 증가
		return result;
	}
	
	
}
