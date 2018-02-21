import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

//new
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent; 

public class LightsOut extends JFrame {
	
	private static final int GRIDSIZE = 5;
	private LightButton[][] terrain = new LightButton[GRIDSIZE][GRIDSIZE];
	private static final long serialVersionUID = 1L;
	JPanel titlePanel = new JPanel();
	
	
	public LightsOut(){
		initGUI();
		
		setTitle("Lights Out");
		setSize(200, 200); //pixels
		setResizable(false);
		pack();
		setLocationRelativeTo(null); //centers on screen, do this after packing but before visible
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void initGUI() {	
		JPanel titlePanel = new JPanel();
		add(titlePanel, BorderLayout.PAGE_START);
		//also change background
		titlePanel.setBackground(Color.BLACK);
		JLabel titleLabel = new JLabel("Welcome to Lights Out");
		
		titlePanel.add(titleLabel);
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
		Font titlefont = new Font("Georgia", Font.BOLD, 18);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(titlefont);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		add(centerPanel, BorderLayout.CENTER);
	
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		add(centerPanel, BorderLayout.CENTER);
		for (int r = 0; r < GRIDSIZE; r++) {
			for (int c = 0; c < GRIDSIZE; c++) {
				terrain[r][c] = new LightButton();
				terrain[r][c].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						LightButton button = (LightButton) e.getSource();
						//toggle();
						
						//int row = button.getRow();
						//int col = button.getCol();
						//buttonClicked(int r, int c);
					}

										
				});
				centerPanel.add(terrain[r][c]);
	
			}
			
		}
		
		
		
	}
	
	//i don't know if below is correct
	private void addToNeighborsCount(int row, int col) {
		addToCount(row-1, col-1);
		addToCount(row-1, col);
		addToCount(row-1, col+1);
		addToCount(row, col-1);
		addToCount(row, col+1);
		addToCount(row+1, col-1);
		addToCount(row+1, col);
		addToCount(row+1, col+1);	
	}
	private void addToCount(int row, int col) {
		if (row > -1 && row < GRIDSIZE && col > -1 && col < GRIDSIZE ) {
			terrain[row][col].toggle();
			//commented out in Task 9: 1
		}
	}
	
	
	public void boardSetup() {
		
	}
	
	public void buttonClicked(int r, int c) {
		//toggle button
		//toggle neighbor 
		if (terrain[r][c].hasHole()){
			String message = "Game over! You stepped on a hole and lost. Do you want to play again?";
			promptForNewGame(message);
		}
		else {
			check(row, col);
			checkNeighbors(row, col);
			if ((GRIDSIZE*GRIDSIZE) - NUMBEROFHOLES == totalRevealed){
				String message = "Yay, you won! You found all the mines. Do you want to play again?";
				promptForNewGame(message);
			}
			
		}
	}
	
	private void promptForNewGame(String message) {
		int option = JOptionPane.showConfirmDialog(this, message, "Play Again?", JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			newGame();
		}
		else {
			System.exit(0);
		}
	}
	
	private void newGame() {
		for (int r = 0; r < GRIDSIZE; r++) {
			for (int c = 0; c < GRIDSIZE; c++) {
				terrain[r][c].reset();
				
			}
			
		}
		
	}	
	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new LightsOut();
            }   
        });

	}

}
