package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.AdminDTO;
import model.NoticeDTO;
import model.UsersDTO;

public class ControllerDAO {
	String dbUrl = "jdbc:mysql://localhost:3306/webdb";
	String dbId = "root";
	String dbPw = "9999";
	
	Connection conn = null;
	Statement stmt = null;
	
	public void accessDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeDB() {
		try {
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// loginSelectAdmin() : 로그인 시 일치하는 정보가 있는지 select하고 해당 아이디의 정보 가져오기
	public AdminDTO loginSelectAdmin(String adminId, String adminPw) {
		accessDB();
		AdminDTO admin = new AdminDTO();
		try {
			stmt = conn.createStatement();
			String sql = "select * from admin where adminId = '" + adminId + "';";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				if(adminPw.equals(rs.getString("adminPw"))) {
					admin.setAdminId(rs.getString("adminId"));
					admin.setAdminName(rs.getString("adminName"));
				}
				else
					admin = null;
			} else
				admin = null;
		} catch(Exception e) {
			e.printStackTrace();
		}
		closeDB();
		return admin;
	}
	
	// loginSelect() : 로그인 시 정보 select하여 아이디, 비밀번호가 일치하는 정보가 있는지(1) 없는지(0) 리턴하는 메소드
	public int loginSelect(String id, String pw) {
		accessDB();
		int result = 0;
		try {
			stmt = conn.createStatement();
			String sql = String.format("select * from users where id = '%s' and pw = '%s';", id, pw);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				result = 1;
			else
				result = 0;
		} catch(Exception e) {
			e.printStackTrace();
		}
		closeDB();
		return result;
	}
	
	// userSelect() : users 테이블에서 회원정보 select하는 메소드
	public UsersDTO userSelect(String id) {
		accessDB();
		UsersDTO user = new UsersDTO();
		try {
			stmt = conn.createStatement();
			String sql = "select * from users where id = '" + id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setTel(rs.getString("tel"));
				user.setGender(rs.getString("gender"));
				user.setBirthday(rs.getString("birthday"));
				user.setPostcode(rs.getString("postcode"));
				user.setAddr1(rs.getString("addr1"));
				user.setExtraAddr(rs.getString("extraAddr"));
				user.setAddr2(rs.getString("addr2"));
				user.setRefcode(rs.getString("refcode"));
				user.setFamilynum(rs.getInt("familynum"));
				user.setPoint(rs.getInt("point"));
				user.setMarketing(rs.getString("marketing"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		closeDB();
		return user;
	}
	
	// noticeListSelect() : 공지사항/이벤트 게시판 전체 목록 select하는 메소드
	public ArrayList<NoticeDTO> noticeListSelect() {
		accessDB();
		ArrayList<NoticeDTO> noticeList = new ArrayList<NoticeDTO>();
		try {
			stmt = conn.createStatement();
			String sql = "select * from notice order by impo desc, ifnull(editDate, regDate) desc, noticeNo desc;";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				NoticeDTO notice = new NoticeDTO();
				notice.setNoticeNo(rs.getInt("noticeNo"));
				notice.setCategory(rs.getString("category"));
				notice.setTitle(rs.getString("title"));
				notice.setAdminName(rs.getString("adminName"));
				notice.setImpo(rs.getString("impo"));
				notice.setRegDate(rs.getString("regDate"));
				notice.setEditDate(rs.getString("editDate"));
				noticeList.add(notice);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		closeDB();
		return noticeList;
	}
	
	// noticeSelect() : 게시글 하나를 select하는 메소드
	public NoticeDTO noticeSelect(int noticeNo) {
		accessDB();
		NoticeDTO notice = new NoticeDTO();
		try {
			stmt = conn.createStatement();
			String sql = "select * from notice where noticeNo = " + noticeNo + ";";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				notice.setNoticeNo(rs.getInt("noticeNo"));
				notice.setCategory(rs.getString("category"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setFileName(rs.getString("fileName"));
				notice.setImgName(rs.getString("imgName"));
				notice.setAdminName(rs.getString("adminName"));
				notice.setImpo(rs.getString("impo"));
				notice.setRegDate(rs.getString("regDate"));
				notice.setEditDate(rs.getString("editDate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		closeDB();
		return notice;
	}
	
	// noticeSearch() : 검색 조건에 따라 select하는 메소드 (검색 조건이 하나인 경우, field2는 ""로 지정)
	public ArrayList<NoticeDTO> noticeSearch(String field1, String field2, String words) {
		accessDB();
		ArrayList<NoticeDTO> noticeList = new ArrayList<NoticeDTO>();
		try {
			stmt = conn.createStatement();
			String sql = "";
			if(field2.equals(""))
				sql = String.format("select * from notice where %s like '%%%s%%' order by impo desc, ifnull(editDate, regDate) desc, noticeNo desc;", field1, words);
			else
				sql = String.format("select * from notice where %s like '%%%s%%' or %s like '%%%s%%' order by impo desc, ifnull(editDate, regDate) desc, noticeNo desc;", field1, words, field2, words);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				NoticeDTO notice = new NoticeDTO();
				notice.setNoticeNo(rs.getInt("noticeNo"));
				notice.setCategory(rs.getString("category"));
				notice.setTitle(rs.getString("title"));
				notice.setAdminName(rs.getString("adminName"));
				notice.setImpo(rs.getString("impo"));
				notice.setRegDate(rs.getString("regDate"));
				notice.setEditDate(rs.getString("editDate"));
				noticeList.add(notice);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		closeDB();
		return noticeList;
	}
	
	// noticeInsert() : 새로 작성한 공지사항/이벤트 insert하는 메소드
	public int noticeInsert(NoticeDTO notice) {
		accessDB();
		int result = 0;
		try {
			stmt = conn.createStatement();
			String sql = String.format("insert into notice (noticeNo, title, category, content, fileName, imgName, adminName, impo, regDate)"
					+ "values (default, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
					notice.getTitle(), notice.getCategory(), notice.getContent(), notice.getFileName(), notice.getImgName(), notice.getAdminName(), notice.getImpo(), notice.getRegDate());
			result = stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
		closeDB();
		return result;
	}
	
	// userUpdate() : 회원정보를 update하는 메소드
	public int userUpdate(UsersDTO user) {
		accessDB();
		int result = 0;
		try {
			stmt = conn.createStatement();
			String sql = String.format("update users set name = '%s', email = '%s', tel = '%s', birthday = %s, familynum = %d, marketing = %s where id = '%s';",
					user.getName(),user.getEmail(), user.getTel(), user.getBirthday(), user.getFamilynum(), user.getMarketing(), user.getId());
			result = stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
		closeDB();
		return result;
	}
	
	// noticeUpdate() : 수정한 내용으로 update하는 메소드
	public int noticeUpdate(NoticeDTO notice) {
		accessDB();
		int result = 0;
		try {
			stmt = conn.createStatement();
			String sql = String.format("update notice set title = '%s', category = '%s', content = '%s', fileName = '%s', imgName = '%s', adminName = '%s', impo = '%s', editDate = '%s' where noticeNo = %d;",
					notice.getTitle(), notice.getCategory(), notice.getContent(), notice.getFileName(), notice.getImgName(), notice.getAdminName(), notice.getImpo(), notice.getEditDate(), notice.getNoticeNo());
			result = stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
		closeDB();
		return result;
	}
	
	// userDelete() : 회원 delete하는 메소드
	public int userDelete(String id) {
		accessDB();
		int result = 0;
		try {
			stmt = conn.createStatement();
			String sql = "delete from users where id = '" + id + "';";
			result = stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
		closeDB();
		return result;
	}
	
	// noticeDelete() : 게시물 delete하는 메소드
	public int noticeDelete(int noticeNo) {
		accessDB();
		int result = 0;
		try {
			stmt = conn.createStatement();
			String sql = "delete from notice where noticeNo = " + noticeNo + ";";
			result = stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
		closeDB();
		return result;
	}
}
