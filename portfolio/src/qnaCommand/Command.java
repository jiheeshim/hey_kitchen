package qnaCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;

public interface Command {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
