package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.QnaDTO;

// DB 데이터 처리 관련 메소드들을 선언한 클래스
public class QnaDAO {
	
	DataSource ds = null;
	Connection con = null;
	
	// 싱글톤 패턴
	private static QnaDAO qnaDAO;
	private QnaDAO() {} //
	public static QnaDAO getInstance() {
		if(qnaDAO == null) {
			qnaDAO = new QnaDAO();
		}
		return qnaDAO;
	}
	
	// JdbcUtil을 통해 받아온 Connection으로 이 클래스에서도 사용할 수 있도록 하기 위한 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}
		
	// selectListCount() : qna 테이블 전체 레코드 개수(게시물 개수) select
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from qna";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	// selectQnaList(page, limit) : page에 맞는 문의글을 limit만큼 select
	public ArrayList<QnaDTO> selectQnaList(int page, int limit) {
		ArrayList<QnaDTO> qnaList = new ArrayList<QnaDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from qna order by qnaRef desc, qnaSeq asc limit ?, ?";
		int startrow = (page - 1) * 10; // 페이지에 따라 몇 번째 게시물부터 select할 것인지
		// limit 10, 10 : 11번째 데이터부터 10개 select
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				QnaDTO qna = new QnaDTO();
				qna.setQnaNo(rs.getInt("qnaNo"));
				qna.setQnaCategory(rs.getString("qnaCategory"));
				qna.setSecret(rs.getString("secret"));
				qna.setTitle(rs.getString("title"));
				qna.setQnaFile(rs.getString("qnaFile"));
				qna.setId(rs.getString("id"));
				qna.setQnaRef(rs.getInt("qnaRef"));
				qna.setQnaLev(rs.getInt("qnaLev"));
				qna.setQnaSeq(rs.getInt("qnaSeq"));
				qna.setReadCount(rs.getInt("readCount"));
				qna.setRegDate(rs.getString("regDate"));
				qna.setEditDate(rs.getString("editDate"));
				// 목록 화면에서 필요하지 않는 내용,비밀번호는 생략한 상태
				qnaList.add(qna);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return qnaList;
	}
	
	// selectQnaNo() : qna 테이블의 qnaNo 중 가장 큰 숫자 select + 1
	public int selectQnaNo() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int qnaNo = 0;
		
		try {
			String sql = "select max(qnaNo) from qna";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				qnaNo = rs.getInt(1) + 1;
			} else {
				qnaNo = 1;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return qnaNo;
	}
	
	// selectQna(qnaNo) : 해당 게시물의 정보 select
	public QnaDTO selectQna(int qnaNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnaDTO qna = null;
		
		try {
			String sql = "select * from qna where qnaNo = " + qnaNo;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				qna = new QnaDTO();
				qna.setQnaNo(qnaNo);
				qna.setQnaCategory(rs.getString("qnaCategory"));
				qna.setSecret(rs.getString("secret"));
				qna.setTitle(rs.getString("title"));
				qna.setContent(rs.getString("content"));
				qna.setQnaFile(rs.getString("qnaFile"));
				qna.setId(rs.getString("id"));
				qna.setQnaPw(rs.getString("qnaPw"));
				qna.setQnaRef(rs.getInt("qnaRef"));
				qna.setQnaLev(rs.getInt("qnaLev"));
				qna.setQnaSeq(rs.getInt("qnaSeq"));
				qna.setReadCount(rs.getInt("readCount"));
				qna.setRegDate(rs.getString("regDate"));
				qna.setEditDate(rs.getString("editDate"));
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return qna;
	}
	
	// isRightPw(qnaNo, qnaPw) : 해당 게시물의 비밀번호와 qnaPw가 일치하는지
	public boolean isRightPw(int qnaNo, String qnaPw) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean isRightPw = false;
		
		try {
			String sql = "select qnaPw from qna where qnaNo = " + qnaNo;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("qnaPw").equals(qnaPw)) {
					isRightPw = true;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isRightPw;
	}
	
	// searchQnaListCount(field, qnaSearchTxt) : 검색되는 값의 개수 select
	public int searchQnaListCount(String field, String qnaSearchTxt) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int searchListCount = 0;
		
		try {
			if(field.equals("both")) {
				sql = "select count(*) from qna where title like ? or content like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + qnaSearchTxt + "%");
				pstmt.setString(2, "%" + qnaSearchTxt + "%");
			} else {
				sql = "select count(*) from qna where " + field + " like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + qnaSearchTxt + "%");
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				searchListCount = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return searchListCount;
	}
	
	// searchQnaRefList(field, qnaSearchTxt) : 검색되는 게시물의 qnaRef select
	public ArrayList<Integer> searchQnaRefList(String field, String qnaSearchTxt) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<Integer> qnaRefList = new ArrayList<Integer>();
		
		try {
			if(field.equals("both")) {
				sql = "select qnaRef from qna where title like ? or content like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + qnaSearchTxt + "%");
				pstmt.setString(2, "%" + qnaSearchTxt + "%");
			} else {
				sql = "select qnaRef from qna where " + field + " like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + qnaSearchTxt + "%");
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qnaRefList.add(rs.getInt(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return qnaRefList;
	}
	
	// searchQnaList(qnaRefList, page, limit) : qnaRefList와 같은 qnaRef를 가진 글 select
	public ArrayList<QnaDTO> searchQnaList(ArrayList<Integer> qnaRefList, int page, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<QnaDTO> qnaList = new ArrayList<QnaDTO>();
		String sql = "";
		int startrow = (page - 1) * 10;
		
		try {
			
			sql = "select * from qna where qnaRef in (";
			for(int i = 0; i < qnaRefList.size(); i++) {
				String s = "";
				if(i == qnaRefList.size() - 1) {
					s = qnaRefList.get(i) + ")";
				} else {
					s = qnaRefList.get(i) + ",";
				}
				sql += s;
			}
			sql += " order by qnaRef desc, qnaSeq asc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaDTO qna = new QnaDTO();
				qna.setQnaNo(rs.getInt("qnaNo"));
				qna.setQnaCategory(rs.getString("qnaCategory"));
				qna.setSecret(rs.getString("secret"));
				qna.setTitle(rs.getString("title"));
				qna.setContent(rs.getString("content"));
				qna.setQnaFile(rs.getString("qnaFile"));
				qna.setId(rs.getString("id"));
				qna.setQnaPw(rs.getString("qnaPw"));
				qna.setQnaRef(rs.getInt("qnaRef"));
				qna.setQnaLev(rs.getInt("qnaLev"));
				qna.setQnaSeq(rs.getInt("qnaSeq"));
				qna.setReadCount(rs.getInt("readCount"));
				qna.setRegDate(rs.getString("regDate"));
				qna.setEditDate(rs.getString("editDate"));
				qnaList.add(qna);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return qnaList;
	}

	// insertQna(qna) : qna 데이터를 insert
	public int insertQna(QnaDTO qna) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {
			
			int qnaNo = selectQnaNo();
			String sql = "insert into qna"
					+ "(qnaNo, qnaCategory, secret, title, content, qnaFile, id, qnaPw, qnaRef, qnaLev, qnaSeq, readCount, regDate)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			pstmt.setString(2, qna.getQnaCategory());
			pstmt.setString(3, qna.getSecret());
			pstmt.setString(4, qna.getTitle());
			pstmt.setString(5, qna.getContent());
			pstmt.setString(6, qna.getQnaFile());
			pstmt.setString(7, qna.getId());
			pstmt.setString(8, qna.getQnaPw());
			pstmt.setInt(9, qnaNo);
			pstmt.setInt(10, 0);
			pstmt.setInt(11, 0);
			pstmt.setInt(12, 0);
			pstmt.setString(13, qna.getRegDate());
			insertCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	// insertQnaReply(qna) : qna 답변 게시물 insert
	public int insertQnaReply(QnaDTO qna) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {
			int qnaNo = selectQnaNo(); // 답글의 qnaNo(PK) 값
			int qnaRef = qna.getQnaRef();
			int qnaLev = qna.getQnaLev();
			int qnaSeq = qna.getQnaSeq();
			
			// 이미 있는 답글들의 순서를 update(뒤로 +1씩 밀기)
			String sql1 = "update qna set qnaSeq = qnaSeq + 1 where qnaRef = ? and qnaSeq > ?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, qnaRef);
			pstmt.setInt(2, qnaSeq);
			int updateCount = pstmt.executeUpdate();
			if(updateCount > 0) {
				commit(con);
				close(pstmt);
			}
			
			// 답글 데이터 insert
			qnaLev++;
			qnaSeq++; // 답글이므로 1씩 추가
			
			String sql2 = "insert into qna (qnaNo, qnaCategory, secret, title, content, id, qnaPw, qnaRef, qnaLev, qnaSeq, readCount, regDate)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, qnaNo);
			pstmt.setString(2, qna.getQnaCategory());
			pstmt.setString(3, qna.getSecret());
			pstmt.setString(4, qna.getTitle());
			pstmt.setString(5, qna.getContent());
			pstmt.setString(6, qna.getId());
			pstmt.setString(7, qna.getQnaPw());
			pstmt.setInt(8, qnaRef);
			pstmt.setInt(9, qnaLev);
			pstmt.setInt(10, qnaSeq);
			pstmt.setInt(11, 0);
			pstmt.setString(12, qna.getRegDate());
			insertCount = pstmt.executeUpdate(); 
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	// updateReadCount(qnaNo) : 해당 게시물의 조회수(readCount) + 1 update
	public int updateReadCount(int qnaNo) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		
		try {
			String sql = "update qna set readCount = readCount + 1 where qnaNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	// updateQna(qnaNo) : 해당 게시물 update
	public int updateQna(QnaDTO qna) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		
		try {
			String sql = "update qna set qnaCategory = ?, secret = ?, title = ?, content = ?, qnaFile = ?, editDate = ? where qnaNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qna.getQnaCategory());
			pstmt.setString(2, qna.getSecret());
			pstmt.setString(3, qna.getTitle());
			pstmt.setString(4, qna.getContent());
			pstmt.setString(5, qna.getQnaFile());
			pstmt.setString(6, qna.getEditDate());
			pstmt.setInt(7, qna.getQnaNo());
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	// deleteQna(qnaNo) : 해당 게시물 delete
	public int deleteQna(int qnaNo) {
		PreparedStatement pstmt = null;
		int deleteCount = 0;
		
		try {
			String sql = "delete from qna where qnaNo = " + qnaNo;
			pstmt = con.prepareStatement(sql);
			deleteCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
}
