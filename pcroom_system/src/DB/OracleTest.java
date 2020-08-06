package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleTest {
	
	public static void main(String args[]){
        Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;
        // 쿼리문을 날린것에 대한 반환값을 담을 객체       
        try {
            // SQL 문장을 만들고 만약 문장이 질의어(SELECT문)라면
            // 그 결과를 담을 ResulSet 객체를 준비한 후 실행시킨다.
            String quary = "SELECT * FROM PCROOM_MEMBER";            
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(quary);
            rs = pstm.executeQuery();  
            /*  pcroom 테이블의 데이터 타입
       
                num NOT NULL NUMBER(4) -- int auto sequence
                id VARCHAR2(10) -- String
                password VARCHAR2(9) -- String
                age NUMBER(4) -- int
                mileage NUMBER(4) -- int
                phone VARCHAR2(9) -- String
 
            */            
            System.out.println("회원 번호 아이디 비밀번호 나이 마일리지 폰번호");
            System.out.println("=================================");
            
            while(rs.next()){
//            	System.out.println("debug2");
//            	System.out.println(rs);
                int num = rs.getInt("NUM");
                //int empno = rs.getInt("empno"); 숫자 대신 컬럼 이름을 적어도 된다.
                String id = rs.getString("ID");
                String password = rs.getString("PASSWORD");
                int age = rs.getInt("AGE");
//              java.sql.Date hiredate = rs.getDate(5); // Date 타입 처리
                int mileage = rs.getInt("MILEAGE");
                String phone = rs.getString("PHONE");
              
                String result = num+" "+id+" "+password+" "+age+" "+mileage+" "+phone;
                System.out.println(result);
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
    }

}
