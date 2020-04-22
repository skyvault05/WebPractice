package ex0416.dao;

import java.sql.SQLException;
import java.util.List;

import ex0416.domain.Member;

/**
 * 회원관리에 필요한 CRUD
 * @author hyo-jinkim
 *
 */
public interface MemberDAO {
	/**
	 * 회원 등록
	 * INSERT INTO member(id, pwd, name, age, phone, addr, join_date)
	 * VALUES (?, ?, ?, ?, ?, ?, SYSDATE);
	 */
	int insert(Member member)throws SQLException;
	
	/**
	 * id중복체크
	 * @return : true(duplicated), false(available)
	 */
	boolean idCheck(String id)throws SQLException;
	
	/**
	 * 회원 전체검색
	 * 결과 레코드가 0 이상이면 대부분 -LIST를 사용
	 */
	List<Member> selectAll()throws SQLException;
	
	/**
	 * id에 해당하는 레코드 검색
	 * 결과 레코드가 0 or 1이면 Member 로 리턴(domain object)
	 */
	Member selectById(String id)throws SQLException;
	
	/**
	 * keyField에 해당하는(필드명) keyword를 포함한 레코드 검색하기
	 * select * FROM member WHERE id LIKE '%a%' or select * FROM member WHERE name LIKE '%a%' or select * FROM member WHERE addr LIKE '%a%'
	 */
	List<Member> searchByKeyword(String keyField, String keyword)throws SQLException;
	
	/**
	 * 회원 삭제
	 */
	int delete(String id)throws SQLException;
	
}
