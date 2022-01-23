package qnaCommand;

import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;

public class QnaFileDownCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// file 읽어오기
		String fileName = request.getParameter("fileName");
		String savePath = "/qnaUpload"; // WebContent 안의 첨부파일 저장할 폴더경로
		ServletContext context = request.getServletContext(); // 서블릿 실행 환경 정보를 리턴
		String realDownloadPath = context.getRealPath(savePath); // 첨부파일 저장 폴더의 실제 경로
		String realFilePath = realDownloadPath + "/" + fileName; // 첨부파일까지의 실제 경로
		
		byte b[] = new byte[4096];
		FileInputStream in = new FileInputStream(realFilePath); // 첨부파일을 바이트로 쪼개서 읽어 오기 위한 스트림
		
		// 확장자 구분
		String mime_type = context.getMimeType(realFilePath); // 확장자 구분
		if(mime_type == null) {
			mime_type = "application/octet-stream"; // 알려지지 않은 확장자일 경우 주로 사용
		}
		response.setContentType(mime_type);
		
		// 브라우저 구분
		String agent = request.getHeader("User-Agent");
		boolean ieBrowser = (agent.indexOf("MSIE") > -1) || (agent.indexOf("Trident") > -1);
		if(ieBrowser) {
			fileName = URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "%20");
		} else {
			fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
		}
		
		response.setHeader("Content-Disposition",  "attachment; filename = " + fileName);
		
		// 읽어온 file 내용 출력하기
		ServletOutputStream out = response.getOutputStream();
		int numRead;
		while((numRead = in.read(b, 0, b.length)) != -1) {
			out.write(b, 0, numRead);
		}
		
		out.flush();
		out.close();
		in.close();
		
		return null;
	}
}
