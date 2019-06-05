package Assignment2.SimulationProject.Model;

import java.util.List;

public class WaitingTimeStrategy implements Strategy {

	public int addClients(List<CashRegister> cashRegs, Client c) {
		int minIndex = 0;
		int minValue = cashRegs.get(minIndex).getWaitingTime().get();
		for (int i = 0; i < cashRegs.size(); i++) {
			int value = cashRegs.get(i).getWaitingTime().get();
			if (value < minValue) {
				minValue = value;
				minIndex = i;
			}
		}
		cashRegs.get(minIndex).addClient(c);
		return minIndex + 1;
	}
}
