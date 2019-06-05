package Assignment2.SimulationProject.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.Box.Filler;

public class Simulation extends JPanel {

	JLabel sim = new JLabel("Simulation             ");
	JLabel counter = new JLabel(" ");
	JLabel q1 = new JLabel("Q1          ");
	JLabel q2 = new JLabel("Q2          ");
	JLabel q3 = new JLabel("Q3          ");
	JLabel q4 = new JLabel("Q4          ");
	JLabel q5 = new JLabel("Q5          ");
	JTextField q1Text = new JTextField();
	JTextField q2Text = new JTextField();
	JTextField q3Text = new JTextField();
	JTextField q4Text = new JTextField();
	JTextField q5Text = new JTextField();
	private List<JLabel> labels = new ArrayList<JLabel>();
	private List<JTextField> texts = new ArrayList<JTextField>();
	private List<JPanel> panels = new ArrayList<JPanel>();
	private List<String> value = new ArrayList<String>();

	public Simulation(int nr) {
		for (int i = 0; i < nr; i++) {
			value.add("");
		}
		value.add("");
		GridLayout layout = new GridLayout(0, 1);
		JPanel panel = new JPanel();
		panel.setLayout(layout);
		panel.setBackground(Color.GREEN);
		for (int i = 0; i < nr; i++) {
			JLabel q = new JLabel("Q" + (i + 1) + "          ");
			q.setFont(new Font("Arial", Font.BOLD, 20));
			labels.add(q);
			JTextField qText = new JTextField();
			qText.setPreferredSize(new Dimension(300, 25));
			qText.setEditable(false);
			texts.add(qText);
			JPanel p = new JPanel();
			p.add(q);
			p.add(qText);
			p.setBackground(Color.GREEN);
			panels.add(p);
			panel.add(p);
		}

		JPanel p2 = new JPanel();
		p2.setBackground(Color.GREEN);
		Box.Filler b = (Filler) Box.createRigidArea(new Dimension(0, 10));
		p2.add(sim);
		p2.add(counter);
		sim.setFont(new Font("Arial", Font.BOLD, 20));
		counter.setFont(new Font("Arial", Font.BOLD, 20));
		this.add(p2);
		this.add(panel);
		this.setBackground(Color.GREEN);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}

	public void print(int cashRegister, String client) {
		String text;
		text = this.value.get(cashRegister - 1);
		text = text + " " + client;
		this.value.remove(cashRegister - 1);
		this.value.add(cashRegister - 1, text);
		this.texts.get(cashRegister - 1).setText(value.get(cashRegister - 1));
	}

	public void remove(int cashRegister, String client) {
		if (this.value.size() > (cashRegister - 1)) {
			String temp2;
			if (this.value.get(cashRegister - 1).length() > 4 && this.value.get(cashRegister - 1).charAt(4) != ' ')
				temp2 = this.value.get(cashRegister - 1).substring(5, this.value.get(cashRegister - 1).length());
			else
				temp2 = this.value.get(cashRegister - 1).substring(4, this.value.get(cashRegister - 1).length());
			this.value.remove(cashRegister - 1);
			this.value.add(cashRegister - 1, temp2);
			this.texts.get(cashRegister - 1).setText(value.get(cashRegister - 1));

		}
	}

	public JLabel getCounter() {
		return counter;
	}

	public void setCounter(JLabel counter) {
		this.counter = counter;
	}
}
