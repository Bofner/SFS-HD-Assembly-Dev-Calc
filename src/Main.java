import model.Model;
import view.CalculatorApp;
import view.DrawingPanel;

public class Main {
    public static void main(String[] args) throws Exception {
        Model m = new Model();
        CalculatorApp frame = new CalculatorApp(m);
        DrawingPanel contentPane = frame.getContentFrame();
		frame.setVisible(true);
        contentPane.setFocusable(true);
		contentPane.requestFocusInWindow();
    }
}
