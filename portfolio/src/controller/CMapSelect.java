package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MapDTO;
import model.MapSelect;

public class CMapSelect implements CommandInterface {

	@Override
	public String commandData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MapSelect mapSelect = new MapSelect();
		List<MapDTO> mapList = mapSelect.getMapList();
		request.setAttribute("mapList", mapList);
		
		return "mapSearch.jsp";
	}

}
