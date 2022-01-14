package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MealplanPriceDTO;
import model.MealplanPriceSelect;

public class CMealplanPriceSelect implements CommandInterface {
	private static CMealplanPriceSelect cMppSelect = new CMealplanPriceSelect();
	public static CMealplanPriceSelect getInstance() {
		return cMppSelect;
	}
	
	@Override
	public String commandData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MealplanPriceSelect mppSelect = MealplanPriceSelect.getInstance();
		List<MealplanPriceDTO> priceList = mppSelect.mealplanPriceSelect();
		request.setAttribute("priceList", priceList);
		return "mealplanOrder.jsp";
	}
	
}
