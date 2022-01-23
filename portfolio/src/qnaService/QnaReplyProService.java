package qnaService;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.QnaDAO;
import model.QnaDTO;

public class QnaReplyProService {
	
	public boolean replyQna(QnaDTO qna) throws Exception {
		
		boolean isReplySuccess = false;
		
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		int insertCount = qnaDAO.insertQnaReply(qna);
		
		if(insertCount > 0) {
			commit(con);
			isReplySuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		return isReplySuccess;
	}

}
