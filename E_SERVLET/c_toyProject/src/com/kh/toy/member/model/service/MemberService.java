package com.kh.toy.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kh.toy.common.exception.DataAccessException;
import com.kh.toy.common.exception.ToAlertException;
import com.kh.toy.common.template.JDBCTemplate;
import com.kh.toy.member.model.dao.MemberDao;
import com.kh.toy.member.model.vo.Member;


//Service
// 웹어플리케이션의 비지니스 로직 작성
// 사용자가 전송한 데이터를 Controller에게 전달 받고
// 비지니스 로직을 위해 추가적으로 필요한 데이터를 Dao에게 요청해
// 핵심로직인 비지니스 로직을 작성한다.
// 비지니스 로직을 Service가 담당하기 때문에 트랜잭션 관리를 Service가 한다 **

public class MemberService {

	MemberDao memberDao = new MemberDao();
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public MemberService() {
		
	}
	
	public Member memberAuthenticate(String userId, String password) {
		Connection conn = jdt.getConnection();
		//Dao에게 userId와 password로 식별할 수 있는 회원 정보를,DB에서 조회할 것을 요청
		Member member = memberDao.memberAuthenticate(conn, userId, password);
		jdt.close(conn);
		return member;
	}
	
	public Member selectMemberById(String userId) {
		Connection conn = jdt.getConnection();
		Member member = memberDao.selectMemberById(conn, userId);
		jdt.close(conn);
		return member;
	}
	
	public List<Member> selectMemberByRegdate(Date beginDate, Date endDate){
		Connection conn = jdt.getConnection();
		List<Member> memberList = memberDao.selectMemberByRegdate(conn, beginDate, endDate);
		jdt.close(conn);
		return memberList;
	}
	
	public ArrayList<Member> selectMemberList(){
		Connection conn = jdt.getConnection();
		ArrayList<Member> memberList = memberDao.selectMemberList(conn);
		jdt.close(conn);
		return memberList;
	}
	
	public int insertMember(Member member) {
		//Transaction관리를 Service단에서 처리하기 위해 Connection을 
		//Service의 메서드에서 생성
		Connection conn = jdt.getConnection();
		int res = 0;
		try {
			//DAO 메서드로 생성한 Connection 주입
			res = memberDao.insertMember(conn, member);
			jdt.commit(conn);
		}catch(DataAccessException e) {
			//DAO에서 SQLException이 발생할 경우 rollback처리
			jdt.rollback(conn);
			throw new ToAlertException(e.error);			
		}finally {
			jdt.close(conn);
		}		
		return res;
	}
	
	public int updateMember(Member member) {
		Connection conn = jdt.getConnection();
		int res = 0;
		try {
			res = memberDao.updateMember(conn, member);
			jdt.commit(conn);
		}catch(DataAccessException e) {
			jdt.rollback(conn);
			throw new ToAlertException(e.error);			
		}finally {
			jdt.close(conn);
		}		
		return res;
	}
	
	public int deleteMember(String userId) {
		Connection conn = jdt.getConnection();
		int res = 0;
		try {
			res = memberDao.UpdateMemberToLeave(conn, userId);
			jdt.commit(conn);
		}catch(DataAccessException e) {
			jdt.rollback(conn);
			throw new ToAlertException(e.error);			
		}finally {
			jdt.close(conn);
		}
		return res;
	}
	
}
