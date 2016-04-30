package coinmachine;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import java.awt.BorderLayout;
/**
 * UI and Observer of Amount of Coin.
 * @author Jirayut Leeupathumvong 5810546617
 * @version 1.0
 */
public class AmountOfCoinObserverUI extends JFrame implements Observer{
	
	private CoinMachine coinMachine ;
	private JTextField amountCoin;
	private JLabel status;
	/**
	 * Constructor of AmountOfCoinObserverUI.
	 * set Title and called initComponent. 
	 * @param cmc Observer CoinMachine.
	 */
	public AmountOfCoinObserverUI( CoinMachine cmc ) {
		super("Amount of coin");
		coinMachine = cmc;
		
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,300,250,100);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblcoins = new JLabel("#Coins : ");
		panel.add(lblcoins);
		
		amountCoin = new JTextField();
		amountCoin.setHorizontalAlignment(SwingConstants.CENTER);
		amountCoin.setEnabled(false);
		panel.add(amountCoin);
		amountCoin.setColumns(10);
		
		status = new JLabel("");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(status, BorderLayout.CENTER);
	}
	
	/**
	 * /**
	 * Update text and value in UI.
	 * @param o Is Observable CoinMachine.
	 * @param arg Not used.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof CoinMachine){
			CoinMachine coinMachine = (CoinMachine)o;
			amountCoin.setText(Integer.toString(coinMachine.getCount()));
			if (coinMachine.getCount() == coinMachine.getCapacity())
				status.setText("<html><font color = red >Machine is FULL </font></html>");
			else if (coinMachine.getCount() > 0)
				status.setText("<html><font color = green >Accepting Coins </font></html>");
		}
	}

}
