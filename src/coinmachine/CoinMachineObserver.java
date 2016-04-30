package coinmachine;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Observer and UI of CoinMachine.
 * @author Jirayut Leeupathumvong 5810546617
 * @version 1
 */
public class CoinMachineObserver extends JFrame implements Observer{

	private JButton oneBaht;
	private JButton fiveBaht;
	private JButton tenBaht;
	private JProgressBar progressBar;
	private JLabel balanceAmount;
	private CoinMachine machine;
	
	/**
	 * Update text and value in UI.
	 * @param o Is Observable CoinMachine.
	 * @param arg Not used.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof CoinMachine){
			CoinMachine coinMachine = (CoinMachine)o;
			progressBar.setValue(coinMachine.getCount());
			progressBar.setString(Integer.toString(coinMachine.getCount()));
			balanceAmount.setText(Integer.toString(coinMachine.getBalance()));
			System.out.println("The balance of machine is : " + coinMachine.getBalance());
		}

	}
	
	/**
	 * Constructor of CoinMachineObserver.
	 * set Title and called initComponent. 
	 * @param cmc Observer CoinMachine.
	 */
	public CoinMachineObserver(CoinMachine cmc){
		super("Coin Machine");
		this.machine = cmc;
		initComponent();
	}
	
	/**
	 * UI of ConinMachineObserver.
	 */
	private void initComponent(){
		setResizable(false);
		setBounds(100,100,320,180);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblBalance = new JLabel("Balance :");
		panel.add(lblBalance);

		balanceAmount = new JLabel("0");
		panel.add(balanceAmount);

		JLabel lblStatus = new JLabel(" Status : ");
		panel.add(lblStatus);
		
        progressBar = new JProgressBar(0,machine.getCapacity());
		progressBar.setBackground(Color.LIGHT_GRAY);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.LIGHT_GRAY);
		progressBar.setString("0");
		panel.add(progressBar);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		panel_1.setBorder( BorderFactory.createTitledBorder("Insert Money"));

		oneBaht = new JButton();
		oneBaht.setIcon(new ImageIcon(CoinMachineObserver.class.getResource("/images/1baht.png")));
		oneBaht.addActionListener(new ButtonCoin());
		panel_1.add(oneBaht);

		fiveBaht = new JButton();
		fiveBaht.setIcon(new ImageIcon(CoinMachineObserver.class.getResource("/images/5baht.png")));
		fiveBaht.addActionListener(new ButtonCoin());
		panel_1.add(fiveBaht);

		tenBaht = new JButton();
		tenBaht.setIcon(new ImageIcon(CoinMachineObserver.class.getResource("/images/10baht.png")));
		tenBaht.addActionListener(new ButtonCoin());
		panel_1.add(tenBaht);
	}
	
	/**
	 * ActionListener when click coin button and add Coin to CoinMachine.
	 * @author Jirayut Leeupathumvong 5810546617
	 *
	 */
	class ButtonCoin implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

			if (oneBaht.isFocusOwner()){
				Coin oneBaht = new Coin(1);
				System.out.println( oneBaht +" inserted");
				machine.insert(oneBaht);
				
			} else if ( fiveBaht.isFocusOwner()){
				Coin fiveBaht = new Coin(5);
				machine.insert(fiveBaht);
				System.out.println( fiveBaht +" inserted");
			} else if ( tenBaht.isFocusOwner()){
				Coin tenBaht = new Coin(10);
				machine.insert(tenBaht);
				System.out.println( tenBaht +" inserted");
			}

		}
	}
}
