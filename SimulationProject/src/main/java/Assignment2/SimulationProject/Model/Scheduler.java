package Assignment2.SimulationProject.Model;

import java.util.ArrayList;
import java.util.List;

import Assignment2.SimulationProject.View.MainView;

public class Scheduler {

	private List<CashRegister> cashRegisters;
	private int nrQueues;
	private int simulationInterval;
	private Strategy strategy;
	private MainView view;
	private List<Thread> threads = new ArrayList<Thread>();

	public Scheduler(int nrQ, int nrClients, MainView v, int interval) {
		view = v;
		simulationInterval = interval;
		this.nrQueues = nrQ;
		cashRegisters = new ArrayList<CashRegister>();
		for (int i = 0; i < nrQueues; i++) {
			CashRegister cashReg = new CashRegister(view, nrClients, simulationInterval);
			cashReg.setID(i + 1);
			cashRegisters.add(cashReg);
			Thread th = new Thread(cashReg);
			threads.add(th);
			th.start();
		}
	}

	public void selectStrategy() {
		this.strategy = new WaitingTimeStrategy();
	}

	public int dispatchClient(Client c) {
		int result = strategy.addClients(this.cashRegisters, c);
		return result;
	}

	public List<CashRegister> getCashRegisters() {
		return cashRegisters;
	}

	public void setCashRegisters(List<CashRegister> cashRegisters) {
		this.cashRegisters = cashRegisters;
	}

	public int getNrQueues() {
		return nrQueues;
	}

	public void setNrQueues(int nrQueues) {
		this.nrQueues = nrQueues;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public List<Thread> getThreads() {
		return threads;
	}

	public void setThreads(List<Thread> threads) {
		this.threads = threads;
	}
}
