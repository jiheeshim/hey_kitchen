package qnaService;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.QnaDAO;
import model.QnaDTO;

public class QnaEditProService {
	
	Connection con = getConnection();
	QnaDAO qnaDAO = QnaDAO.getInstance();
	
	public boolean isRightPw(int qnaNo, String qnaPw) throws Exception {
		
		boolean isRightPw = false;
		
		qnaDAO.setConnection(con);
		isRightPw = qnaDAO.isRightPw(qnaNo, qnaPw);
		return isRightPw;
	}
	
	public boolean editQna(QnaDTO qna) throws Exception {
		
		boolean isEditSuccess = false;
		
		qnaDAO.setConnection(con);
		int updateCount = qnaDAO.updateQna(qna);
		
		if(updateCount > 0) {
			commit(con);
			isEditSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		return isEditSuccess;
		
	}

}
