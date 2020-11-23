package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import admin.model.FoodIntroContent;
import jdbc.JdbcUtil;

public class AdminContentDao {
	
	   public FoodIntroContent insert(Connection conn, FoodIntroContent content) 
			   throws SQLException {
			      PreparedStatement pstmt = null;
			      try {
			         pstmt = conn.prepareStatement(
			               "insert into food_info_content " + 
			               "(f_num, content, f_imageAddress, f_title, introduce ) "
			               + "values (?,?,?,?,?)");
			         pstmt.setLong  (1, content.getNumber());
			         pstmt.setString(2, content.getContent());
			         pstmt.setString(3, content.getImageAddress()); 
			         pstmt.setString(4, content.getTitle());
			         pstmt.setString(5, content.getIntroduce());
			         
			         int insertedCount = pstmt.executeUpdate();
			         if (insertedCount > 0) {
			            return content;
			         } else {
			            return null;
			         }
			      } finally {
			         JdbcUtil.close(pstmt);
			      }
			   }
	
		
}
