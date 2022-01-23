package qnaService;

import java.sql.Connection;

import dao.QnaDAO;
import model.QnaDTO;

import static db.JdbcUtil.*;

public class QnaWriteProService {
	
	// writeQna() : qna 문의글 등록을 위해 필요한 DAO의 메소드 호출 실행하여 결과 리턴 
	public boolean writeQna(QnaDTO qna) throws Exception {
		
		boolean isWriteSuccess = false;
		
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		int insertCount = qnaDAO.insertQna(qna);
		if(insertCount > 0) {
			commit(con);
			isWriteSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		return isWriteSuccess;
		
	}

}
