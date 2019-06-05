package Assignment2.SimulationProject.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class Output extends JPanel {

	JLabel avgTime = new JLabel("Average waiting time:");
	JLabel avgTimeRes = new JLabel(" ");
	JLabel avgTimeResQ = new JLabel(" ");
	JLabel avgService = new JLabel("Average processing time:");
	JLabel avgServiceRes = new JLabel(" ");
	JLabel avgServiceResQ = new JLabel(" ");
	JLabel peak = new JLabel("Peak hour:");
	JLabel peakRes = new JLabel(" ");
	JLabel avgEmpty = new JLabel("Average of empty queue time:");
	JLabel avgEmptyRes = new JLabel(" ");
	JLabel avgEmptyResQ = new JLabel(" ");
	JLabel out = new JLabel("Output");

	public Output() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		JPanel p9 = new JPanel();
		JPanel p10 = new JPanel();
		avgTime.setFont(new Font("Arial", Font.BOLD, 16));
		avgService.setFont(new Font("Arial", Font.BOLD, 16));
		peak.setFont(new Font("Arial", Font.BOLD, 16));
		avgEmpty.setFont(new Font("Arial", Font.BOLD, 16));
		out.setFont(new Font("Arial", Font.BOLD, 20));
		avgTimeRes.setFont(new Font("Arial", Font.BOLD, 16));
		avgServiceRes.setFont(new Font("Arial", Font.BOLD, 16));
		avgTimeResQ.setFont(new Font("Arial", Font.BOLD, 16));
		avgServiceResQ.setFont(new Font("Arial", Font.BOLD, 16));
		peakRes.setFont(new Font("Arial", Font.BOLD, 16));
		avgEmptyRes.setFont(new Font("Arial", Font.BOLD, 16));
		avgEmptyResQ.setFont(new Font("Arial", Font.BOLD, 16));
		p1.add(avgTime);
		p1.add(avgTimeRes);
		p8.add(avgTimeResQ);
		p2.add(avgService);
		p2.add(avgServiceRes);
		p9.add(avgServiceResQ);
		p3.add(peak);
		p3.add(peakRes);
		p4.add(avgEmpty);
		p4.add(avgEmptyRes);
		p10.add(avgEmptyResQ);
		p7.add(out);

		p1.setBackground(Color.CYAN);
		p2.setBackground(Color.CYAN);
		p3.setBackground(Color.CYAN);
		p4.setBackground(Color.CYAN);
		p7.setBackground(Color.CYAN);
		p8.setBackground(Color.CYAN);
		p9.setBackground(Color.CYAN);
		p10.setBackground(Color.CYAN);

		GridLayout layout = new GridLayout(0, 1);
		this.add(p7);
		this.add(p1);
		this.add(p8);
		this.add(p2);
		this.add(p9);
		this.add(p4);
		this.add(p10);
		this.add(p3);
		this.setLayout(layout);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}

	public JLabel getAvgTime() {
		return avgTime;
	}

	public void setAvgTime(JLabel avgTime) {
		this.avgTime = avgTime;
	}

	public JLabel getAvgTimeRes() {
		return avgTimeRes;
	}

	public void setAvgTimeRes(JLabel avgTimeRes) {
		this.avgTimeRes = avgTimeRes;
	}

	public JLabel getAvgService() {
		return avgService;
	}

	public void setAvgService(JLabel avgService) {
		this.avgService = avgService;
	}

	public JLabel getAvgServiceRes() {
		return avgServiceRes;
	}

	public void setAvgServiceRes(JLabel avgServiceRes) {
		this.avgServiceRes = avgServiceRes;
	}

	public JLabel getPeak() {
		return peak;
	}

	public void setPeak(JLabel peak) {
		this.peak = peak;
	}

	public JLabel getPeakRes() {
		return peakRes;
	}

	public void setPeakRes(JLabel peakRes) {
		this.peakRes = peakRes;
	}

	public JLabel getAvgEmpty() {
		return avgEmpty;
	}

	public void setAvgEmpty(JLabel avgEmpty) {
		this.avgEmpty = avgEmpty;
	}

	public JLabel getAvgEmptyRes() {
		return avgEmptyRes;
	}

	public void setAvgEmptyRes(JLabel avgEmptyRes) {
		this.avgEmptyRes = avgEmptyRes;
	}

	public JLabel getOut() {
		return out;
	}

	public void setOut(JLabel out) {
		this.out = out;
	}

	public JLabel getAvgTimeResQ() {
		return avgTimeResQ;
	}

	public void setAvgTimeResQ(JLabel avgTimeResQ) {
		this.avgTimeResQ = avgTimeResQ;
	}

	public JLabel getAvgServiceResQ() {
		return avgServiceResQ;
	}

	public void setAvgServiceResQ(JLabel avgServiceResQ) {
		this.avgServiceResQ = avgServiceResQ;
	}

	public JLabel getAvgEmptyResQ() {
		return avgEmptyResQ;
	}

	public void setAvgEmptyResQ(JLabel avgEmptyResQ) {
		this.avgEmptyResQ = avgEmptyResQ;
	}
}
