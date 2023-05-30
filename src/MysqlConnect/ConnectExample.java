package MysqlConnect;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectExample {
    public static void main(String[] args) {
        Connection conn = null;

        //JDBC Driver 등록
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Resultset resultset;
                //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:mysql://10.80.161.190:3306/thisisjava",
                    "java",
                    "mysql"
            );
            String sql = "" + "Insert Into users(userid, username, userpassword ,userage, useremail)"+"VALUES(?,?,?,?,?)";
            //String sql2 = ""+ "Select * from users";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //resultset = (Resultset) pstmt.executeQuery(sql2);
            pstmt.setString(1, "csp");
            pstmt.setString(2,"이재명");
            pstmt.setString(3, "1234");
            pstmt.setInt(4,20);
            pstmt.setString(5,"csp@mycompany.com");

            int rows = pstmt.executeUpdate(); // 저장된 행의 값이 리턴이 된다.
            System.out.println("저장된 행 수 :" + rows);

            //PreParedStatement 닫기
            pstmt.close();

        }catch( ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(conn != null){
                try{
                    //연결 끊기
                    conn.close();
                    System.out.println("연결 끊기");
                }catch(SQLException e){}
            }
        }
    }

}
