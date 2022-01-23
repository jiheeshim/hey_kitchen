package qnaService;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.QnaDAO;
import model.QnaDTO;

public class QnaListService {
	
	public int getListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		listCount = qnaDAO.selectListCount();
		close(con);
		return listCount;
	}
	
	public ArrayList<QnaDTO> getQnaList(int page, int limit) throws Exception {
		ArrayList<QnaDTO> articleList = null;
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		articleList = qnaDAO.selectQnaList(page,limit);
		close(con);
		return articleList;
		
	}
}
