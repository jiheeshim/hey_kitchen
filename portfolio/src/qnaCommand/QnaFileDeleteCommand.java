package qnaCommand;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;

public class QnaFileDeleteCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String fileName = request.getParameter("qnaRealFile");
		String savePath = "/qnaUpload";
		String realDownloadPath = request.getServletContext().getRealPath(savePath);
		String realFilePath = realDownloadPath + "/" + fileName;
		
		File f = new File(realFilePath);
		System.out.println(realFilePath);
		
		if(f.exists()) {
			f.delete();
		}
		
		return null;
	}

}
