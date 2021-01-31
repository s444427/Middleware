import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Main{

    public static void main(String args[]) {

        Connectionx X = new Connectionx();
        X.connect();
//
//
//        Connection conn = null;
//        try {
////            Connection
//            Class.forName("org.postgresql.Driver");
//
//            conn = DriverManager
//                    .getConnection("jdbc:postgresql://localhost:5432/People",
//                            "postgres", "admin");
//
////              Query
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("select version()");
//
//            while (rs.next())
//            {
//                System.out.print("Column 1 returned ");
//                System.out.println(rs.getString(1));
//            }
//            rs.close();
//            st.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }
//        System.out.println("Opened database successfully");
    }
 }