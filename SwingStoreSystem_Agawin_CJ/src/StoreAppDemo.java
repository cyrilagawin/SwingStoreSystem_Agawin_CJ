import javax.swing.SwingUtilities;

public class StoreAppDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StoreData data = new StoreData();
                TransactionFrame mainFrame = new TransactionFrame(data);
                mainFrame.setVisible(true);
            }
        });
    }
}