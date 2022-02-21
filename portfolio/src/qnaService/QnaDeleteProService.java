package qnaService;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.QnaDAO;

public class QnaDeleteProService {
	
	public boolean isRightPw(int qnaNo, String qnaPw) throws Exception {
		
		boolean isRightPw = false;
		
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		
		isRightPw = qnaDAO.isRightPw(qnaNo, qnaPw);
		close(con);
		return isRightPw;
	}
	
	public boolean deleteQna(int qnaNo) throws Exception {
		
		Boolean isDeleteSuccess = false;
		
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		
		int deleteCount = qnaDAO.deleteQna(qnaNo);
		
		if(deleteCount > 0) {
			commit(con);
			isDeleteSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		
		return isDeleteSuccess;
		
	}
}
