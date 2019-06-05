package Assignment2.SimulationProject.Model;

public class Client implements Comparable<Client> {

	private int arrivalTime;
	private int finishTime;
	private int processingTime;
	private String name;

	public Client() {
		this.arrivalTime = 0;
		this.finishTime = 0;
		this.processingTime = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	public int getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}

	public int compareTo(Client c) {
		if (this.arrivalTime > c.arrivalTime)
			return 1;
		else if (this.arrivalTime < c.arrivalTime)
			return -1;
		else
			return 0;
	}
}
