import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class test {
    public static void main(String[] args) {
        Frame frame = new Frame("AWT Sum Calculator");
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(2, 2));

        Label label1 = new Label("Number 1:");
        TextField textField1 = new TextField();
        Label label2 = new Label("Number 2:");
        TextField textField2 = new TextField();

        Button button = new Button("Addition");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField tx = new TextField();
                try {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    double sum = num1 + num2;

                    Frame frame2 = new Frame("Answer Frame for sum");
                    frame2.setSize(400, 200);
                    frame2.setLayout(new GridLayout(2, 2));
                    Label l1 = new Label("Answer:");
                    

                    tx.setText(Double.toString(sum));
                    frame2.add(l1);
                    frame2.add(tx);
                    frame2.setVisible(true);
                } catch (NumberFormatException ex) {
                    tx.setText("Invalid input!");
                }
            }
        });

        Button button1 = new Button("Substraction");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField tx = new TextField();
                try {
                    double num1 = Double.parseDouble(textField1.getText());
                    double num2 = Double.parseDouble(textField2.getText());
                    double sum = num1 - num2;

                    Frame frame2 = new Frame("Answer Frame for sum");
                    frame2.setSize(400, 200);
                    frame2.setLayout(new GridLayout(4, 2));
                    Label l1 = new Label("Answer:");
                    

                    tx.setText(Double.toString(sum));
                    frame2.add(l1);
                    frame2.add(tx);
                    frame2.setVisible(true);
                } catch (NumberFormatException ex) {
                    tx.setText("Invalid input!");
                }
            }
        });

        frame.add(label1);
        frame.add(textField1);
        frame.add(label2);
        frame.add(textField2);
        frame.add(new Label());
        frame.add(button);
        frame.add(button1);

        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}
