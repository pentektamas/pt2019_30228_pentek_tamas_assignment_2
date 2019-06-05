package Assignment2.SimulationProject.View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainView extends JFrame {
	Input in = new Input();
	Output out = new Output();
	LogOfEvents log = new LogOfEvents();
	Simulation sim;
	JPanel p = new JPanel();

	public MainView(int nrQ) {
		sim = new Simulation(nrQ);
		GridLayout layout = new GridLayout(0, 2);
		p.setLayout(layout);
		p.add(in);
		p.add(out);
		log.setMinimumSize(new Dimension(50, 50));
		p.add(log);
		p.add(sim);
		this.setContentPane(p);
		this.pack();
		this.setMinimumSize(new Dimension(1200, 700));
		this.setTitle("Simulare");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void simsim(int nr) {
		this.remove(sim);
		sim = new Simulation(nr);
		sim.revalidate();
		sim.repaint();
		this.add(sim);
	}

	public void addOkButtonListener(ActionListener al) {
		in.getOk().addActionListener(al);
	}

	public Input getIn() {
		return in;
	}

	public void setIn(Input in) {
		this.in = in;
	}

	public Simulation getSim() {
		return sim;
	}

	public void setSim(Simulation sim) {
		this.sim = sim;
	}

	public Output getOut() {
		return out;
	}

	public void setOut(Output out) {
		this.out = out;
	}

	public LogOfEvents getLog() {
		return log;
	}

	public void setLog(LogOfEvents log) {
		this.log = log;
	}

	public JPanel getP() {
		return p;
	}

	public void setP(JPanel p) {
		this.p = p;
	}
}
