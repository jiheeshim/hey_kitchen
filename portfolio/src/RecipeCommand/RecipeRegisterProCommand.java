package RecipeCommand;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import RecipeService.RecipeRegisterProService;
import model.ActionForward;
import model.RecipeDTO;
import model.RecipeImgDTO;

public class RecipeRegisterProCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		HttpSession session = request.getSession();
		RecipeRegisterProService recipeRegisterProService = new RecipeRegisterProService();
		
		String folder = "/recipeUpload";
		int fileSize = 10 * 1024 * 1024; // 최대 15MB
		String realFolder = request.getServletContext().getRealPath(folder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "utf-8", new DefaultFileRenamePolicy());
		
		int emptyCheck = 0;
		
		// recipeNo 설정
		int recipeNo = recipeRegisterProService.getMaxNo() + 1;
		
		// recipe category string 설정
		String category = "";
		String[] categoryArr = multi.getParameterValues("category");
		if(categoryArr != null) { // 카테고리가 선택되어 있으면,
			for(int i = 0; i < categoryArr.length; i++) {
				category += categoryArr[i] + " ";
			}
		} else { // 카테고리가 선택되어 있지 않으면
			emptyCheck = 1;
		}
		
		// recipe ingredients string 설정
		String ingredients = "";
		String[] ingrName = multi.getParameterValues("ingrName");
		String[] ingrAmount = multi.getParameterValues("ingrAmount");
		if(ingrName.length == ingrAmount.length) { // 재료와 재료양이 잘 입력되어 있으면
			for(int i = 0 ; i < ingrName.length ; i++) {
				ingredients += ingrName[i] + " " + ingrAmount[i];
				if(i != (ingrName.length - 1)) {
					ingredients += ", "; // 재료 쇼핑 리스트를 위한 재료별 구분 기호
				}
			}
		} else { // 재료와 재료양 입력에 이상이 있으면
			emptyCheck = 2;
		}
		
		Boolean recipeSuccess = false; // 레시피 테이블 입력 결과
		Boolean imgSuccess = false; // 레시피 이미지(요리단계) 테이블 입력 결과
		Boolean registerSuccess = false; // 종합적 입력 결과
		
		// recipe 객체 값 설정 + insert
		RecipeDTO recipe = new RecipeDTO();
		recipe.setRecipeNo(recipeNo);
		recipe.setRecipeName(multi.getParameter("recipeName"));
		recipe.setThumbnail(multi.getOriginalFileName("thumbnail"));
		recipe.setThumbnailServer(multi.getFilesystemName("thumbnail"));
		recipe.setCategory(category);
		recipe.setReadCount(0);
		recipe.setScrapCount(0);
		recipe.setRecipeDesc(multi.getParameter("recipeDesc"));
		recipe.setIngredients(ingredients);
		recipe.setRegDate(LocalDate.now().toString());
		recipe.setId((String)session.getAttribute("id"));
		recipeSuccess = recipeRegisterProService.registerRecipe(recipe);
		 
		// 요리단계 개수만큼 for문으로 recipeImg 객체 값 설정 + insert
		RecipeImgDTO recipeImg = null;
		String[] imgDesc = multi.getParameterValues("imgDesc");
		for(int i = 0; i < imgDesc.length; i++) {
			recipeImg = new RecipeImgDTO();
			recipeImg.setImgNo(0);
			recipeImg.setRecipeNo(recipeNo);
			String fileName = "imgName" + i;
			recipeImg.setImgName(multi.getOriginalFileName(fileName));
			recipeImg.setImgServerName(multi.getFilesystemName(fileName));
			recipeImg.setImgDesc(imgDesc[i]);
			imgSuccess = recipeRegisterProService.registerRecipeImg(recipeImg);
			if(!imgSuccess) {
				System.out.println(i + " recipe img insert fail");
				break;
			}
		}
		
		if(recipeSuccess && imgSuccess) { // 레시피와 요리단계 테이블 모두 입력 성공하면,
			registerSuccess = true;
		}
		
		// 각 실행 결과에 따른 이동
		if(emptyCheck == 1) { // 카테고리 미입력 경우
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('카테고리를 선택하지 않으셨습니다.'); history.go(-1);</script>");
		} else if(emptyCheck == 2) { // 재료 미입력 경우
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('재료명과 재료양을 모두 작성해주세요.'); history.go(-1);</script>");
		} else if(emptyCheck == 0) { // DB 필수 사항 모두 입력된 경우
			if(registerSuccess) { // DB 입력 성공
				forward = new ActionForward();
				
				// 레시피 등록하기 버튼을 눌렀던 곳으로 돌아갈 수 있도록 조건문으로 변경할 예정
				forward.setPath("recipeMyFeedView.rec");
				
			} else { // DB 입력 실패
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('레시피 등록에 실패했습니다.'); history.go(-1);</script>");
			}
		}
		
		return forward;
	}

}
