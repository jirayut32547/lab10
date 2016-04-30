package coinmachine;

import java.awt.EventQueue;
import java.util.Scanner;
/**
 * Application of CoinMachine
 * @author Jirayut Leeupathumvong 5810546617
 * @version 1.0
 */
public class CoinMachineApp {
	public static void main (String[] args){
		Scanner console = new Scanner( System.in );
		System.out.print("Input capacity of machine : ");
		int capacity = console.nextInt();
		
		CoinMachine machine = new CoinMachine( capacity );
		Demo demo = new Demo();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoinMachineObserver coinMachine = new CoinMachineObserver(machine); 
					AmountOfCoinObserverUI amountOfCoin = new AmountOfCoinObserverUI(machine);
					machine.addObserver(amountOfCoin);
					machine.addObserver(coinMachine);
					amountOfCoin.setVisible(true);
					coinMachine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		demo.insertDialog(machine);
	}
}
