package qnaService;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.QnaDAO;

public class QnaViewPwService {
	
	public boolean isRightPw(int qnaNo, String qnaPw) throws Exception {
		
		boolean isRightPw = false;
		
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		isRightPw = qnaDAO.isRightPw(qnaNo, qnaPw);
		close(con);
		
		return isRightPw;
	}

}
