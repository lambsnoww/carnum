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
	double a;
	double b;
	double output;
	int n = 0;
	JButton[] buttons;
	char op;

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

		flag = false;
		tf.addActionListener(new ButtonListener());
		n = 0;
		op = ' ';

	}

	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String comm = e.getActionCommand();

			if (Character.isDigit(comm.charAt(0)) || comm.equals("+/-")) {
				if (comm.equals("+/-")) {
					a = a * (-1);
				} else if (n == 0) {
					a = a * 10 + Double.parseDouble(comm);
				} else {
					a = a + Double.parseDouble(comm) / (Math.pow(10, n++));
				}
				tf.setText(String.valueOf(a));
			} else if (comm.equals(".")) {
				n = 1;
			} else if (comm.equals("AC")) {
				n = 0;
				op = ' ';
				a = b = output = 0;
				flag = false;
				tf.setText("0.0");
			} else {// operator or "="

				char c = op;
				op = comm.charAt(0);
				if (flag == false) {
					b = a;
					a = 0;
					n = 0;
					flag = true;
				} else {
					switch (c) {
					case '+': {
						output = b + a;
						tf.setText(String.valueOf(output));
						break;
					}
					case '-': {
						output = b - a;
						tf.setText(String.valueOf(output));
						break;
					}
					case '*': {
						output = b * a;
						tf.setText(String.valueOf(output));
						break;
					}
					case '/': {
						if (a != 0) {
							output = b / a;
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
					b = output;
					a = 0;
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
