package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pc_login {
	public static boolean loginTest(String id, String password) {
		boolean flag = false;
		
		Connection conn = null; // DB�뿰寃곕맂 �긽�깭(�꽭�뀡)�쓣 �떞�� 媛앹껜
        PreparedStatement pstm = null;  // SQL 臾몄쓣 �굹���궡�뒗 媛앹껜
        ResultSet rs = null;
        // 荑쇰━臾몄쓣 �궇由곌쾬�뿉 ���븳 諛섑솚媛믪쓣 �떞�쓣 媛앹껜       
        
        try {
            // SQL 臾몄옣�쓣 留뚮뱾怨� 留뚯빟 臾몄옣�씠 吏덉쓽�뼱(SELECT臾�)�씪硫�
            // 洹� 寃곌낵瑜� �떞�쓣 ResulSet 媛앹껜瑜� 以�鍮꾪븳 �썑 �떎�뻾�떆�궓�떎.
            String quary = "SELECT password FROM PCROOM_MEMBER where id = ?";            
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(quary);
            pstm.setString(1, id);
            rs = pstm.executeQuery();  
            /*  pcroom �뀒�씠釉붿쓽 �뜲�씠�꽣 ���엯
       
                num NOT NULL NUMBER(4) -- int auto sequence
                id VARCHAR2(10) -- String
                password VARCHAR2(9) -- String
                age NUMBER(4) -- int
                mileage NUMBER(4) -- int
                phone VARCHAR2(9) -- String
 
            */           
            while(rs.next()){
                String getpw = rs.getString("PASSWORD");
                if(password.equals(getpw)) {
                	flag = true;
                }
              
            }
            
        } catch (SQLException sqle) {
            System.out.println("SELECT臾몄뿉�꽌 �삁�쇅 諛쒖깮");
            sqle.printStackTrace();
            
        }finally{
            // DB �뿰寃곗쓣 醫낅즺�븳�떎.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
		return flag;
	}
	public static void main(String[] args) {
		System.out.println(loginTest("wo2jin","wo2jin2732"));
    }

}
