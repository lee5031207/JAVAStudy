package com.kh.bookmanager.rent;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kh.bookmanager.book.Book;
import com.kh.bookmanager.jpa.JpaUtil;

public class RentService {
	
	private RentRepository rentRepository = new RentRepository();
	
	public Rent addRentBookToRent(long rmIdx, long rbIdx) {
		Rent rent = null;
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			rent = em.find(Rent.class, rmIdx);
			RentBook rentBook = em.find(RentBook.class, rbIdx);
			rentBook.changeRent(rent); //rent가 가지고 있는 rentBooks가 증가
			
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return rent;
	}
	
	public List<Rent> findAllRent(){
		List<Rent> rents = null;
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			rents = rentRepository.findAllRent(em);
		} finally {
			em.close();
		}
		
		return rents;
	}
	
	public Rent findRentById(long rmIdx) {
		EntityManager em =  JpaUtil.getEntityManager();
		Rent rent = null;
		
		try {
			rent = em.find(Rent.class, rmIdx);
		} finally{
			em.close();
		}
		
		return rent;
	}

	public List<Rent> findRentsOnRent(String userId) {
		
		Session session = JpaUtil.createSession();
		List<Rent> rents = null;

		try {
			rents = rentRepository.findRentsOnRent(userId,session);
		} finally {
			session.close();
		}
		
		return rents;
	}
	
	
	
	public boolean insertRent(List<Book> bookList, String userId) {
		
		Transaction tx = null;
		boolean res = false;
		
		try(Session session = JpaUtil.createSession()){
			tx = session.getTransaction();
			tx.begin();
			
			
			
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		
		return res;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
