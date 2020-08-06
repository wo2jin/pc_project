package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pc_login {
	static boolean loginTest(String id, String password) {
		boolean flag = false;
		
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;
        // 쿼리문을 날린것에 대한 반환값을 담을 객체       
        
        try {
            // SQL 문장을 만들고 만약 문장이 질의어(SELECT문)라면
            // 그 결과를 담을 ResulSet 객체를 준비한 후 실행시킨다.
            String quary = "SELECT password FROM PCROOM_MEMBER where id = ?";            
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(quary);
            pstm.setString(1, id);
            rs = pstm.executeQuery();  
            /*  pcroom 테이블의 데이터 타입
       
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
            System.out.println("SELECT문에서 예외 발생");
            sqle.printStackTrace();
            
        }finally{
            // DB 연결을 종료한다.
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
