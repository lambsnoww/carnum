package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.println(e.toString());
		// System.out.println(((JButton) e.getSource()).getText());
		// System.out.println(e.getActionCommand());
		String comm = e.getActionCommand();

	}

}
