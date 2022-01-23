package qnaService;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QnaDAO;
import model.QnaDTO;

public class QnaSearchService {
	
	public int getListCount(String field, String qnaSearchTxt) throws Exception {
		
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		int listCount = qnaDAO.searchQnaListCount(field, qnaSearchTxt);
		close(con);
		return listCount;
	
	}
	
	public ArrayList<Integer> getQnaRefList(String field, String qnaSearchTxt) throws Exception {
		
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		ArrayList<Integer> qnaRefList = qnaDAO.searchQnaRefList(field, qnaSearchTxt);
		close(con);
		return qnaRefList;
	}
	
	public ArrayList<QnaDTO> getQnaList(ArrayList<Integer> qnaRefList, int page, int limit) throws Exception {
		
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		ArrayList<QnaDTO> qnaList = qnaDAO.searchQnaList(qnaRefList, page, limit);
		close(con);
		return qnaList;
	}

}
