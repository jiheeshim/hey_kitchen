package qnaCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;
import model.PageInfoDTO;
import model.QnaDTO;
import qnaService.QnaListService;
public class QnaListCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<QnaDTO> qnaList=new ArrayList<QnaDTO>();
	  	int page = 1; // page 값이 따로 등록된 게 없으면 자동 1페이지
		int limit = 10; // 한 페이지 당 10개씩만
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		QnaListService qnaListService = new QnaListService();
		int listCount = qnaListService.getListCount(); // 총 게시물 개수 구하기
		qnaList = qnaListService.getQnaList(page,limit); // 페이지에 따라 필요한 게시물들 select
		request.setAttribute("qnaList", qnaList);
		
		// 페이징
   		int maxPage = (int)((double)listCount/limit + 0.95); // 최대 페이지(총 페이지 수)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1; // 나열된 페이지 수들 중 시작 숫자
   	    int endPage = startPage + 10 - 1; // 나열된 페이지 수들 중 마지막 숫자
   		if (endPage > maxPage) endPage = maxPage; // 마지막 숫자가 전체 페이지 수보다 큰 경우에는, 전체 페이지까지만 나타내게끔

   		// 페이지 정보들 pageInfo 객체에 저장
   		PageInfoDTO pageInfo = new PageInfoDTO();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		request.setAttribute("pageInfo", pageInfo);
		
		ActionForward forward= new ActionForward();
   		forward.setPath("/qnaList.jsp");
   		return forward;
	}
	// page 1 ~ 10 : startPage = 1
		// page 11 ~ 20 : startPage = 11 ...

}
