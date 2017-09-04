package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {

	public enum Operator {
		plus, minus, product, division, negative_sign, power, modular;
	}

	JFrame frame;
	JTextField tf;
	boolean flag;
	boolean pointFlag;
	double num;
	double num1;

	double output;
	int n = 0;
	JButton[] buttons;
	Operator op;

	private void createCalculator() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelA = new JPanel();
		tf = new JTextField(20);
		tf.setText("0.0");
		tf.setHorizontalAlignment(JTextField.RIGHT);
		// tf.setSize(400, 60);
		panelA.setLayout(new BorderLayout());// 这句很重要，首先要新建一个BorderLayout
		panelA.add(BorderLayout.NORTH, tf);

		JPanel panelB = new JPanel();
		String[] buttonNames = new String[] { "AC", "+/-", "%", "^", "7", "8",
				"9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".",
				"=", "+" };
		buttons = new JButton[20];
		panelB.setLayout(new GridLayout(5, 4));
		for (int i = 0; i < 20; i++) {
			buttons[i] = new JButton(buttonNames[i]);
			buttons[i].addActionListener(new ButtonListener());
			panelB.add(buttons[i]);
		}
		panelA.add(panelB);
		frame.getContentPane().add(panelA);

		frame.setName("Calculator");
		frame.setSize(500, 600);
		frame.pack();
		frame.setVisible(true);

		tf.addActionListener(new ButtonListener());
		n = 0;
		op = ' ';

	}

	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String comm = e.getActionCommand();
			if (comm.equals("+"))
				op = add;
			if (Character.isDigit(comm.charAt(0))) {
				if (n == 0) {
					num = num * 10 + Double.parseDouble(comm);
				} else {
					num = num + Double.parseDouble(comm) / (Math.pow(10, n++));
				}
				tf.setText(String.valueOf(num));
			} else if (comm.equals(".")) {
				n = 1;
			} else if (comm.equals("AC")) {
				n = 0;
				op = ' ';
				num = num1 = output = 0;
				tf.setText("0.0");
			} else {// operator
				char c = op;
				op = comm.charAt(0);
				if (c == ' ') {
					num1 = num;
					num = 0;
					n = 0;
				} else {
					switch (c) {
					case '+': {
						output = num1 + num;
						tf.setText(String.valueOf(output));
						break;
					}
					case '-': {
						output = num1 - num;
						tf.setText(String.valueOf(output));
						break;
					}
					case '*': {
						output = num1 * num;
						tf.setText(String.valueOf(output));
						break;
					}
					case '/': {
						if (num != 0) {
							output = num1 / num;
							tf.setText(String.valueOf(output));
						} else {
							tf.setText("Invalid Divisor!");
							// 状态不变才对
						}
						break;
					}
					default: {
						break;
					}
					}// switch
					num1 = output;
					num = 0;
					n = 0;

				}
			}

		}
	}

	public static void main(String[] args) {
		// 显示应用 GUI
		Calculator calculator = new Calculator();
		calculator.createCalculator();

	}

}
