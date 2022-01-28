package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.MealkitDTO;
import model.MealplanDTO;
import model.MealplanDeliveryDTO;
import model.MealplanMenuDTO;

public class MealplanDAO {

	DataSource ds = null;
	Connection con = null;
	
	private static MealplanDAO mealplanDAO;
	public static MealplanDAO getInstance() {
		if(mealplanDAO == null) {
			mealplanDAO = new MealplanDAO();
		}
		return mealplanDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	// mealplanSubSelect() : 구독관리용 mealplan select
	public MealplanDTO mealplanSubSelect(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MealplanDTO mealplan = null;
		
		try {  
			// id & 구독취소하지 않은
			String sql = "select * from mealplan where id = ? and cancelDate is null";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mealplan = new MealplanDTO();
				mealplan.setMealplanNo(rs.getString("mealplanNo"));
				mealplan.setId(rs.getString("id"));
				mealplan.setSubDate(rs.getString("subDate"));
				mealplan.setServing(rs.getInt("serving"));
				mealplan.setServingCnt(rs.getInt("servingCnt"));
				mealplan.setSubPrice(rs.getInt("subPrice"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return mealplan;
	}
	
	// deliverySubSelect() : 구독관리용 mealplanDelivery select
	public MealplanDeliveryDTO deliverySubSelect(String mealplanNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MealplanDeliveryDTO delivery = null;
		
		try {
			String sql = "select * from mealplanDelivery where mealplanNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mealplanNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				delivery = new MealplanDeliveryDTO();
				delivery.setDeliveryNo(rs.getString("deliveryNo"));
				delivery.setDeliverDate(rs.getString("deliverDate"));
				delivery.setMealplanNo(rs.getString("mealplanNo"));
				delivery.setPostcode(rs.getString("postcode"));
				delivery.setAddr1(rs.getString("addr1"));
				delivery.setExtraAddr(rs.getString("extraAddr"));
				delivery.setAddr2(rs.getString("addr2"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return delivery;
	}
	
	// mealkitSubSelect() : 구독관리용 mealkitName select
	public ArrayList<String> mealkitSubSelect(String deliveryNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> mealkitNames = new ArrayList<String>();
		
		try {
			String sql = "select mealkitName from mealkit join mealplanMenu on deliveryNo = ? and mealplanMenu.mealkitNo = mealkit.mealkitNo";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, deliveryNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mealkitNames.add(rs.getString(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return mealkitNames;
	}
	
	// mealplanMenuSelect() : deliveryNo에 해당하는 mealplanMenu 정보 리스트로 select
	public ArrayList<MealplanMenuDTO> mealplanMenuSelect(String deliveryNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MealplanMenuDTO> menuList = new ArrayList<MealplanMenuDTO>();
		
		try {
			String sql = "select * from mealplanMenu where deliveryNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, deliveryNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MealplanMenuDTO menu = new MealplanMenuDTO();
				menu.setMenuNo(rs.getString("menuNo"));
				menu.setDeliveryNo(rs.getString("deliveryNo"));
				menu.setMealkitNo(rs.getString("mealkitNo"));
				menuList.add(menu);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return menuList;
	}
	
	// mealplanHistorySelect(id, startDate, endDate) : 해당 id의 startDate ~ endDate에 포함된 mealplan select
	public ArrayList<MealplanDTO> mealplanHistorySelect(String id, String startDate, String endDate) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MealplanDTO> mealplanList = new ArrayList<MealplanDTO>();

		try {
			String sql = "select * from mealplan where ((subDate <= ? and (cancelDate is null or cancelDate >= ?)) or (subDate between ? and ?)) and id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setString(3, startDate);
			pstmt.setString(4, endDate);
			pstmt.setString(5, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MealplanDTO mealplan = new MealplanDTO();
				mealplan.setMealplanNo(rs.getString("mealplanNo"));
				mealplan.setSubDate(rs.getString("subDate"));
				mealplan.setServing(rs.getInt("serving"));
				mealplan.setServingCnt(rs.getInt("servingCnt"));
				mealplan.setSubPrice(rs.getInt("subPrice"));
				mealplan.setCancelDate(rs.getString("cancelDate"));
				mealplanList.add(mealplan);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return mealplanList;
	}
	
	// deliveryUpdate() : mealplanDelivery 배송지 update
	public int deliveryUpdate(MealplanDeliveryDTO delivery) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		
		try {
			String sql = "update mealplanDelivery set postcode = ?, addr1 = ?, extraAddr = ?, addr2 = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, delivery.getPostcode());
			pstmt.setString(2, delivery.getAddr1());
			pstmt.setString(3, delivery.getExtraAddr());
			pstmt.setString(4, delivery.getAddr2());
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	// menuUpdate() : mealplanMenu mealkitNo update
	public int menuUpdate(MealplanMenuDTO menu) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		
		try {
			String sql = "update mealplanMenu set mealkitNo = ? where menuNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, menu.getMealkitNo());
			pstmt.setString(2, menu.getMenuNo());
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
		
	}
	
	// mealplanCancelUpdate(cancelDate, mealplanNo) : mealplan cancelDate 추가
	public int mealplanCancelUpdate(String cancelDate, String mealplanNo) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		
		try {
			String sql = "update mealplan set cancelDate = ? where mealplanNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cancelDate);
			pstmt.setString(2, mealplanNo);
			updateCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
}
