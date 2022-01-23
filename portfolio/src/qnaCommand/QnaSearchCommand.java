package qnaCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;
import model.PageInfoDTO;
import model.QnaDTO;
import qnaService.QnaSearchService;

public class QnaSearchCommand implements Command {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String field = request.getParameter("field");
		String qnaSearchTxt = request.getParameter("qnaSearchTxt");
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		QnaSearchService qnaSearchService = new QnaSearchService();
		int listCount = qnaSearchService.getListCount(field, qnaSearchTxt); // 페이징을 위한 총 게시물 개수
		if(listCount == 0) { // 검색 결과 없어도 페이지 출력하기 위해 1로 재설정
			listCount = 1;
		}
		ArrayList<Integer> qnaRefList = qnaSearchService.getQnaRefList(field, qnaSearchTxt); // 검색된 결과를 가지고 있는 글들의 답글&원글 모두 가져오기 위해 qnaRefList 먼저 구하기
		if(qnaRefList.size() > 0) {
			ArrayList<QnaDTO> qnaList = qnaSearchService.getQnaList(qnaRefList, page, limit); // qnaRefList의 qnaRef 일치하는 모든 글들 가져오기
			request.setAttribute("qnaList", qnaList);
		}
		
		// 페이징
		int maxPage = (int)((double)listCount / limit + 0.95);
		int startPage = (((int)((double)page / 10 + 0.9)) - 1) * 10 + 1;
		int endPage = startPage + 9;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		PageInfoDTO pageInfo = new PageInfoDTO();
		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		
		request.setAttribute("pageInfo", pageInfo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/qnaSearchList.jsp");
		return forward;
		
	}

}
