package RecipeCommand;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RecipeService.IngrScrapSaveService;
import model.ActionForward;
import model.IngrScrapDTO;

public class IngrScrapSaveCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		String[] checkedArr = request.getParameterValues("checked");
		String[] ingrArr = request.getParameterValues("ingr");
		boolean saveSuccess = false;
		
		if(ingrArr != null) { // 저장해야 할 목록이 있을 경우에만 insert 실행
			IngrScrapSaveService ingrScrapSaveService = new IngrScrapSaveService();
			
			IngrScrapDTO ingrScrap = new IngrScrapDTO();
			for(int i = 0; i < ingrArr.length; i++) { // 재료 텍스트 개수만큼 반복문
				String checked = "0"; // 체크되어 있는지 (기본 0 : 체크 안 됨)
				
				// 체크되어 있는 재료 항목들만 checked 값 변경
				if(checkedArr != null) { // 체크된 항목들이 있는 경우,
					for(int j = 0; j < checkedArr.length; j++) { // 체크된 체크박스의 value들 중 해당 재료가 있으면,
						if(ingrArr[i].equals(checkedArr[j])) {
							checked = "1"; // 1 : 체크됨
						}
					}
				}
				
				// ingrScrap 객체 값 설정
				ingrScrap.setIngr(ingrArr[i]);
				ingrScrap.setChecked(checked);
				ingrScrap.setId(id);
				
				// insert
				saveSuccess = ingrScrapSaveService.saveIngrScrap(ingrScrap);
				if(!saveSuccess) { // insert 실패하면
					System.out.println(i + "번째 ingr save 오류");
					break;
				}
			}
		} else { // 저장할 게 없는 경우 바로 패스
			saveSuccess = true;
		}
		
		if(saveSuccess) { // 저장 성공하면
			forward = new ActionForward();
			forward.setPath("ingrScrapView.rec");
		} else { // 실패하면
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('저장 중 오류가 발생하였습니다. 다시 시도해주세요.'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
