package Assignment2.SimulationProject.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

import Assignment2.SimulationProject.Model.CashRegister;
import Assignment2.SimulationProject.Model.Client;
import Assignment2.SimulationProject.Model.Scheduler;
import Assignment2.SimulationProject.View.MainView;

public class GeneralController implements Runnable {

	private int minArrivingTime;
	private int maxArrivingTime;
	private int minProcessingTime;
	private int maxProcessingTime;
	private int nrQ;
	private int simulationInterval;
	private int nrClients;
	private Thread t = new Thread(this);
	private Scheduler scheduler;
	private MainView view = new MainView(nrQ);
	private List<Client> generatedClients;

	public GeneralController() {
		view.setVisible(true);
		OKListener OkL = new OKListener();
		this.view.addOkButtonListener(OkL);
	}

	public void generateRandomClients(int nrClients) {
		String name = "C ";
		for (int i = 0; i < nrClients; i++) {
			int serviceTime = this.minProcessingTime
					+ (int) (Math.random() * (this.maxProcessingTime - this.minProcessingTime + 1));
			int arrivalTime = this.minArrivingTime
					+ (int) (Math.random() * (this.maxArrivingTime - this.minArrivingTime + 1));
			Client c = new Client();
			c.setProcessingTime(serviceTime);
			c.setArrivalTime(arrivalTime);
			c.setName(name + (i + 1));
			generatedClients.add(c);
		}

		Collections.sort(generatedClients);
	}

	@SuppressWarnings("deprecation")
	public void run() {
		int currentTime = 1;
		int[] time = new int[nrQ];
		int[] max = new int[nrQ];
		int[] emptyTime = new int[nrQ];
		while (currentTime <= simulationInterval) {
			for (int i = 0; i < this.generatedClients.size(); i++) {

				if (generatedClients.get(i).getArrivalTime() == currentTime) {
					int result = scheduler.dispatchClient(generatedClients.get(i));
					this.view.getSim().print(result, this.generatedClients.get(i).getName());
					this.view.getLog().getLogs().append("Client " + this.generatedClients.get(i).getName() + " ( Arr. "
							+ this.generatedClients.get(i).getArrivalTime() + ", Pro. "
							+ this.generatedClients.get(i).getProcessingTime() + " ) " + " added to Cash Register nr. "
							+ result + " at " + this.generatedClients.get(i).getArrivalTime() + " o'clock\n");
				}
			}

			for (int i = 0; i < this.scheduler.getCashRegisters().size(); i++) {
				if (this.scheduler.getCashRegisters().get(i).getWaitingTime().get() == 0) {
					emptyTime[i]++;
				}
			}

			for (int i = 0; i < nrQ; i++) {
				if (this.scheduler.getCashRegisters().get(i).getWaitingTime().get() > max[i]) {
					max[i] = this.scheduler.getCashRegisters().get(i).getWaitingTime().get();
					time[i] = currentTime;
				}
			}

			this.view.getSim().getCounter().setText(currentTime + "");

			currentTime++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (Thread t : this.scheduler.getThreads()) {
			t.interrupt();
		}

		float sum = 0;
		float sum2 = 0;

		for (CashRegister cr : this.scheduler.getCashRegisters()) {
			float temp = cr.getTotalWaiting() / (float) cr.getTotalClients();
			this.view.getOut().getAvgTimeResQ().setText(this.view.getOut().getAvgTimeResQ().getText() + "Q" + cr.getID()
					+ ": " + String.format("%.1f", temp) + " \t");
			sum = sum + temp;

			float temp2 = cr.getTotalProcessing() / (float) cr.getTotalClients();
			this.view.getOut().getAvgServiceResQ().setText(this.view.getOut().getAvgServiceResQ().getText() + "Q"
					+ cr.getID() + ": " + String.format("%.1f", temp2) + " \t");
			sum2 = sum2 + temp2;
		}

		float rez = 0;
		int rez2 = 0;

		for (int i = 0; i < nrQ; i++) {
			rez = rez + time[i];
			rez2 = rez2 + emptyTime[i];
			this.view.getOut().getAvgEmptyResQ().setText(this.view.getOut().getAvgEmptyResQ().getText() + "Q"
					+ this.scheduler.getCashRegisters().get(i).getID() + ": " + emptyTime[i] + " \t");
		}

		this.view.getOut().getPeakRes().setText((int) (rez / nrQ) + "");
		this.view.getOut().getAvgServiceRes().setText(String.format("%.1f", sum2 / (float) this.nrQ) + "");
		this.view.getOut().getAvgTimeRes().setText(String.format("%.1f", sum / (float) this.nrQ) + "");
		this.view.getOut().getAvgEmptyRes().setText(rez2 / nrQ + "");

		JOptionPane.showMessageDialog(null, "End of the Simulation!", "The end!", JOptionPane.INFORMATION_MESSAGE);

		if (this.t.isAlive())
			this.t.stop();
	}

	class OKListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				minArrivingTime = Integer.parseInt(view.getIn().getMinimText().getText());
				maxArrivingTime = Integer.parseInt(view.getIn().getMaxText().getText());
				minProcessingTime = Integer.parseInt(view.getIn().getMinServiceText().getText());
				maxProcessingTime = Integer.parseInt(view.getIn().getMaxServiceText().getText());
				nrQ = Integer.parseInt(view.getIn().getNrQText().getText());
				simulationInterval = Integer.parseInt(view.getIn().getIntervalText().getText());
				nrClients = Integer.parseInt(view.getIn().getNrClientsText().getText());
				generatedClients = new ArrayList<Client>();
				scheduler = new Scheduler(nrQ, nrClients, view, simulationInterval);
				scheduler.selectStrategy();
				generateRandomClients(nrClients);
				view.simsim(nrQ);
				view.getSim().updateUI();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					System.out.println("ERROR Starting the main THREAD");
				}
				t.start();
			} catch (NumberFormatException ex) {
				System.out.println("ERROR");
				JOptionPane.showMessageDialog(null, "Please insert correct values!", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
