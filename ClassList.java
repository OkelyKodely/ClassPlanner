package classplanner;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class ClassList {

    JScrollPane sp = null;
    
    JList l = null;
    
    DataHandler da = null;
    
    public ClassList(DataHandler dh) {
        (da = dh).connect();
        da.enable();
        sp = new JScrollPane((l = da.getList()));
        sp.setBounds(10, 10, 200, 300);
    }
}