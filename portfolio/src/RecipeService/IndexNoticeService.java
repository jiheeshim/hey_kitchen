package RecipeService;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import dao.IndexDAO;
import model.NoticeDTO;
import myBatis.MyBatisConfig;

public class IndexNoticeService {
	
	public List<NoticeDTO> getIndexNotice() throws Exception {
		
		SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
		IndexDAO indexDAO = IndexDAO.getInstance();
		indexDAO.setSqlSessionF(sqlSessionF);
		
		List<NoticeDTO> noticeList = indexDAO.indexNoticeSelect();
		
		return noticeList;
	}

}
