package qnaService;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.QnaDAO;
import model.QnaDTO;

public class QnaViewService {
	
	// qna 게시물 정보 select + 조회수 update
	public QnaDTO readQna(int qnaNo, boolean isEdit) throws Exception {
		
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		
		if(!isEdit) { // 수정이 아니라 조회인 경우에만 조회수 +1
			int updateCount = qnaDAO.updateReadCount(qnaNo);
			if(updateCount > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		}
		
		QnaDTO qna = qnaDAO.selectQna(qnaNo);
		close(con);
		return qna;
		
	}
}
