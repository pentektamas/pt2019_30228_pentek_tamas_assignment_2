package Assignment2.SimulationProject.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class Input extends JLabel {

	JLabel minimTime = new JLabel("Minimum arriving time:");
	JTextField minimText = new JTextField();
	JLabel maxTime = new JLabel("Maximum arriving time:");
	JTextField maxText = new JTextField();
	JLabel minimService = new JLabel("Minimum processing time:");
	JTextField minServiceText = new JTextField();
	JLabel maxService = new JLabel("Maximum processing time:");
	JTextField maxServiceText = new JTextField();
	JLabel nrQ = new JLabel("Number of queues:");
	JTextField nrQText = new JTextField();
	JLabel Sinterval = new JLabel("Simulation interval:");
	JTextField intervalText = new JTextField();
	JLabel nrClients = new JLabel("Number of clients:");
	JTextField nrClientsText = new JTextField();
	JButton ok = new JButton("START");
	JLabel in = new JLabel("Input");

	public Input() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		JPanel p9 = new JPanel();
		minimText.setPreferredSize(new Dimension(75, 25));
		maxText.setPreferredSize(new Dimension(75, 25));
		minServiceText.setPreferredSize(new Dimension(75, 25));
		maxServiceText.setPreferredSize(new Dimension(75, 25));
		nrQText.setPreferredSize(new Dimension(75, 25));
		intervalText.setPreferredSize(new Dimension(75, 25));
		nrClientsText.setPreferredSize(new Dimension(75, 25));
		minimTime.setFont(new Font("Arial", Font.BOLD, 16));
		maxTime.setFont(new Font("Arial", Font.BOLD, 16));
		minimService.setFont(new Font("Arial", Font.BOLD, 16));
		maxService.setFont(new Font("Arial", Font.BOLD, 16));
		nrQ.setFont(new Font("Arial", Font.BOLD, 16));
		Sinterval.setFont(new Font("Arial", Font.BOLD, 16));
		nrClients.setFont(new Font("Arial", Font.BOLD, 16));
		in.setFont(new Font("Arial", Font.BOLD, 20));
		p1.add(minimTime);
		p1.add(minimText);
		p2.add(maxTime);
		p2.add(maxText);
		p3.add(minimService);
		p3.add(minServiceText);
		p4.add(maxService);
		p4.add(maxServiceText);
		p5.add(nrQ);
		p5.add(nrQText);
		p6.add(Sinterval);
		p6.add(intervalText);
		p9.add(nrClients);
		p9.add(nrClientsText);
		p7.add(ok);
		p8.add(in);
		GridLayout layout = new GridLayout(0, 1);
		this.add(p8);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(p6);
		this.add(p9);
		this.add(p7);
		p1.setBackground(Color.ORANGE);
		p2.setBackground(Color.ORANGE);
		p3.setBackground(Color.ORANGE);
		p4.setBackground(Color.ORANGE);
		p5.setBackground(Color.ORANGE);
		p6.setBackground(Color.ORANGE);
		p7.setBackground(Color.ORANGE);
		p8.setBackground(Color.ORANGE);
		p9.setBackground(Color.ORANGE);
		this.setLayout(layout);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}

	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public JTextField getMinimText() {
		return minimText;
	}

	public void setMinimText(JTextField minimText) {
		this.minimText = minimText;
	}

	public JTextField getMaxText() {
		return maxText;
	}

	public void setMaxText(JTextField maxText) {
		this.maxText = maxText;
	}

	public JTextField getMinServiceText() {
		return minServiceText;
	}

	public void setMinServiceText(JTextField minServiceText) {
		this.minServiceText = minServiceText;
	}

	public JTextField getMaxServiceText() {
		return maxServiceText;
	}

	public void setMaxServiceText(JTextField maxServiceText) {
		this.maxServiceText = maxServiceText;
	}

	public JTextField getNrQText() {
		return nrQText;
	}

	public void setNrQText(JTextField nrQText) {
		this.nrQText = nrQText;
	}

	public JTextField getIntervalText() {
		return intervalText;
	}

	public void setIntervalText(JTextField intervalText) {
		this.intervalText = intervalText;
	}

	public JTextField getNrClientsText() {
		return nrClientsText;
	}

	public void setNrClientsText(JTextField nrClientsText) {
		this.nrClientsText = nrClientsText;
	}

}
