package Assignment2.SimulationProject.Model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import Assignment2.SimulationProject.View.MainView;

public class CashRegister implements Runnable {

	private BlockingQueue<Client> clients;
	private AtomicInteger waitingTime;
	private AtomicInteger finishTime;
	private int ID;
	private MainView view;
	private int totalWaiting = 0;
	private int totalClients = 0;
	private int totalProcessing = 0;
	private int nr = 0;
	private int interval;

	public CashRegister(MainView v, int nrClients, int simulation) {
		view = v;
		interval = simulation;
		clients = new ArrayBlockingQueue<Client>(nrClients);
		waitingTime = new AtomicInteger();
		finishTime = new AtomicInteger();
	}

	public void addClient(Client newClient) {
		totalWaiting = totalWaiting + waitingTime.get();
		totalClients++;
		totalProcessing = totalProcessing + newClient.getProcessingTime();
		try {
			clients.put(newClient);
		} catch (InterruptedException e) {
			System.out.println("The Queue is full!!!");
			e.printStackTrace();
		}
		if (nr == 0) {
			finishTime.addAndGet(newClient.getArrivalTime());
			nr++;
		}
		waitingTime.addAndGet(newClient.getProcessingTime());
		finishTime.addAndGet(newClient.getProcessingTime());
		newClient.setFinishTime(this.finishTime.get());
	}

	public void run() {
		try {
			while (true) {
				Client c = clients.take();
				Thread.sleep(c.getProcessingTime() * 1000);
				if (this.interval >= c.getFinishTime()) {
					this.view.getSim().remove(this.getID(), c.getName());
					this.view.getLog().getLogs()
							.append("Client: " + c.getName() + " ( Arr. " + c.getArrivalTime() + ", Pro. "
									+ c.getProcessingTime() + " ) removed from Cash Register nr. " + this.ID + " at "
									+ c.getFinishTime() + " o'clock \n");
				}
				waitingTime.addAndGet(-c.getProcessingTime());
			}
		} catch (InterruptedException e) {
		} catch (Exception ex) {
			System.out.println("EXCEPTION RUN CASH");
		}
	}

	public BlockingQueue<Client> getClients() {
		return clients;
	}

	public void setClients(BlockingQueue<Client> clients) {
		this.clients = clients;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public AtomicInteger getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(AtomicInteger waitingTime) {
		this.waitingTime = waitingTime;
	}

	public int getTotalWaiting() {
		return totalWaiting;
	}

	public void setTotalWaiting(int totalWaiting) {
		this.totalWaiting = totalWaiting;
	}

	public int getTotalClients() {
		return totalClients;
	}

	public void setTotalClients(int totalClients) {
		this.totalClients = totalClients;
	}

	public int getTotalProcessing() {
		return totalProcessing;
	}

	public void setTotalProcessing(int totalProcessing) {
		this.totalProcessing = totalProcessing;
	}
}
