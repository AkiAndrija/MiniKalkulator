import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

    public MyFrame(String title) {
        this.setTitle(title);

        setLayout(new BorderLayout());
        Panel leftPanel = new Panel();
        leftPanel.setLayout(new GridLayout(4, 1));
        Label lbl = new Label("Enter first number");
        Label lbl1 = new Label("Chose operations");
        Label lbl2 = new Label("Enter second number");
        Label lbl3 = new Label("Result is");
        lbl3.setBackground(Color.PINK);
        leftPanel.add(lbl);
        leftPanel.add(lbl1);
        leftPanel.add(lbl2);
        leftPanel.add(lbl3);
        add(leftPanel, BorderLayout.WEST);
        TextField tf = new TextField("");
        add(tf, BorderLayout.EAST);


        Panel rightPanel = new Panel();
        rightPanel.setLayout(new GridLayout(5, 1));
        TextField tf1 = new TextField("");
        Choice choice = new Choice();
        choice.add("+");
        choice.add("-");
        choice.add("*");
        choice.add("/");
        choice.setBackground(Color.PINK);
        TextField tf2 = new TextField("");
        Button btn = new Button("Calucate");
        TextField tf3 = new TextField("");
        rightPanel.add(tf1);
        rightPanel.add(choice);
        rightPanel.add(tf2);
        rightPanel.add(btn);
        rightPanel.add(tf3);
        add(rightPanel, BorderLayout.EAST);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(tf1.getText());
                double num2 = Double.parseDouble(tf2.getText());
                String operator = choice.getSelectedItem();
                double result = 0;
                if (operator.equals("+")) {
                    result = num1 + num2;
                } else if (operator.equals("-")) {
                    result = num1 - num2;
                } else if (operator.equals("*")) {
                    result = num1 * num2;
                } else if (operator.equals("/")) {
                    result = num1 / num2;
                }
                tf3.setText(Double.toString(result));

                addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
            }
        });
        setSize(500, 200);
        setVisible(true);
    }


    public static void main(String[] args) {
         MyFrame f = new MyFrame("Mini awt calculator");
    }
}