package Assignment2.SimulationProject.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.Box.Filler;

public class LogOfEvents extends JPanel {

	JTextArea logs = new JTextArea(15, 40);
	JLabel text = new JLabel("Log of events", SwingConstants.CENTER);
	JScrollPane scroll = new JScrollPane(logs);

	public LogOfEvents() {
		Box.Filler b = (Filler) Box.createRigidArea(new Dimension(0, 10));
		JPanel p1 = new JPanel();
		p1.add(text);
		p1.setBackground(Color.MAGENTA);
		text.setFont(new Font("Arial", Font.BOLD, 20));
		logs.setEditable(false);
		logs.setBackground(Color.LIGHT_GRAY);
		logs.setFont(new Font("Arial", Font.BOLD, 14));
		logs.setForeground(Color.BLACK);
		this.add(b);
		this.add(p1);
		this.add(b);
		this.add(scroll);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		this.setBackground(Color.MAGENTA);
	}

	public JTextArea getLogs() {
		return logs;
	}

	public void setLogs(JTextArea logs) {
		this.logs = logs;
	}

	public JLabel getText() {
		return text;
	}

	public void setText(JLabel text) {
		this.text = text;
	}
}
