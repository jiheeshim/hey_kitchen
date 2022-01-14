package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandInterface {
	public String commandData(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
