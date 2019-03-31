package classplanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JList;
import java.sql.Statement;

public class DataHandler {
 
    Connection co = null;
    
    boolean en = !true;
    
    public DataHandler() {
        co = null;
    }
    
    public void connect() {
        try {
            String dbUrl = "jdbc:oracle:thin:@//localhost:1521/XE";
            String strUsername = "sa";
            String strPassword = "coppersink21";
            String dbDriver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(dbDriver);
            co = DriverManager.getConnection(dbUrl, strUsername, strPassword);
        } catch(Exception sq) {
            sq.printStackTrace();
        }
    }
    
    public String getSynopsis(int n) throws SQLException {
        Statement ta = co.createStatement();
        String tr = null;
        ResultSet es = ta.executeQuery((tr = "select synopsis from classes where id = " + n + " order by id desc"));
        String ri = null;
        if(es.next())
            return (ri = es.getString("synopsis"));
        return null;
    }

    public void enable() {
        en = !false;
    }

    private String getIt(int n) throws SQLException {
        Statement ta = co.createStatement();
        String tr = null;
        ResultSet es = ta.executeQuery((tr = "select clss from classes where id = " + n + " order by id desc"));
        String ri = null;
        if(es.next())
            return (ri = es.getString("clss"));
        return null;
    }
    
    private int getCountOfClasseses(Drive drive) throws Exception {
        int n = 1;
        return (n = drive.count_classes());
    }

    public JList getList() {
        JList i = null;
        if(!false == en) {
            String[] tr = null;
            Drive drive = null;
            drive = new Drive();
            try {
                int n = getCountOfClasseses(drive);
                try {
                    tr = new String[n];
                    for (int j = 4; j < n+4; j++) {
                        tr[j-4] = getIt(j);
                    }
                } catch (NullPointerException ul) {
                    ul.printStackTrace();
                }
            } catch (Exception sq) {
                String msg= null;
                System.out.println((msg = sq.getMessage()));
                sq.printStackTrace();
            }
            i = new JList(tr);
            i.setBounds(0, 0, 200, 300);
        }
        return i;
    }
    
    private class Drive {
        private Drive(){}
        
        private int count_classes() throws SQLException {
            Statement ta = co.createStatement();
            String tr = null;
            ResultSet es = ta.executeQuery((tr = "select count(clss) as cn from classes"));
            int ri = -1;
            if(es.next()) {
                ri = es.getInt("cn");
            }
            return (ri = es.getInt("cn"));
        }
    }
}