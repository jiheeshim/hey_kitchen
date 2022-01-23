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
			// 배달날짜가 현재날짜보다 크고, mealplanNo 일치하는
			String sql = "select * from mealplanDelivery where deliverDate > ? and mealplanNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(LocalDate.now()));
			pstmt.setString(2, mealplanNo);
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
			// deliveryNo 일치하고, mealkitNo 같은
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
}
