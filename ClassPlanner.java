package classplanner;

public class ClassPlanner {

    Manager mgr = new Manager();
    
    public ClassPlanner() {
        mgr.setClassList(new ClassList(new DataHandler()));
    }
    
    private void show() {
        mgr.show();
    }
    
    public static void main(String[] args) {
        new ClassPlanner().show();
    }
}