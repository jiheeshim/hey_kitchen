package RecipeCommand;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RecipeService.IngrScrapProService;
import model.ActionForward;
import model.IngrScrapDTO;

public class IngrScrapProCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ajax용 커맨드이므로, PrintWriter 미리 선언
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		
		// insert 결과 변수
		boolean scrapSuccess = false; 
		
		// 현재 아이디 불러오기
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id == null) { // js에서 로그인 안 된 상태 잡지 못하는 경우 대비용 (id값 not null이므로 필수)
			out.println("<script>alert('로그인 후 이용 가능한 서비스입니다.'); history.go(-1);</script>");
		}
		
		// 체크된 재료들 불러오기
		String[] ingr = request.getParameterValues("ingr");
		
		// ingrScrap 객체 생성
		IngrScrapDTO ingrScrap = null;
		for(int i = 0; i < ingr.length; i++) {
			ingrScrap = new IngrScrapDTO();
			ingrScrap.setIngr(ingr[i]);
			ingrScrap.setChecked("0");
			ingrScrap.setId(id);
			
			// insert 시행
			IngrScrapProService ingrScrapProService = new IngrScrapProService();
			scrapSuccess = ingrScrapProService.scrapIngr(ingrScrap);
			
			// fail 시 break
			if(!scrapSuccess) {
				System.out.println(i + "번째 재료 scrap 실패");
				break;
			}
		}
		
		String result = "";
		if(scrapSuccess) { // insert 성공 시
			result = "추가되었습니다. 내 장보기 목록으로 가시겠습니까?";
			out.println(result);
		} else { // insert 실패 시
			result = "장보기 목록에 추가 중 오류가 발생하였습니다. 다시 시도해주세요.";
			out.println(result);
		}
		
		return null;
	}

}
