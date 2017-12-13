import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Game {

	public int total = 0;
	public int wins = 0;
	public int losses = 0;
	public int draws = 0;
	
	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Game window = new Game();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public static String move() {
		int random = 1 + (int) (3 * Math.random());
		if (random == 1) {
			return "Rock";
		} else if (random == 2) {
			return "Paper";
		} else {
			return "Scissors";
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {		
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Game Machine");
		
		Label totalLabel = new Label(shell, SWT.NONE);
		totalLabel.setBounds(370, 10, 70, 14);
		totalLabel.setText("Total Games");
		
		Label winLabel = new Label(shell, SWT.NONE);
		winLabel.setBounds(381, 75, 59, 14);
		winLabel.setText("Wins");
		
		Label lossLabel = new Label(shell, SWT.NONE);
		lossLabel.setBounds(381, 140, 59, 14);
		lossLabel.setText("Losses");
		
		Label drawLabel = new Label(shell, SWT.NONE);
		drawLabel.setBounds(381, 205, 59, 14);
		drawLabel.setText("Draws");
		
		Label resultLabel = new Label(shell, SWT.NONE);
		resultLabel.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 18, SWT.NORMAL));
		resultLabel.setBounds(25, 225, 252, 30);
		
		Label totalDisplay = new Label(shell, SWT.NONE);
		totalDisplay.setText("" + total);
		totalDisplay.setBounds(381, 30, 59, 14);
		
		Label winDisplay = new Label(shell, SWT.NONE);
		winDisplay.setText("" + wins);
		winDisplay.setBounds(381, 95, 59, 14);
		
		Label lossDisplay = new Label(shell, SWT.NONE);
		lossDisplay.setText("" + losses);
		lossDisplay.setBounds(381, 160, 59, 14);
		
		Label drawDisplay = new Label(shell, SWT.NONE);
		drawDisplay.setText("" + draws);
		drawDisplay.setBounds(381, 225, 59, 14);
		
		Label resultDisplay = new Label(shell, SWT.NONE);
		resultDisplay.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 20, SWT.NORMAL));
		resultDisplay.setBounds(247, 111, 115, 43);
		resultDisplay.setText("Pick One!");

		Button rockButton = new Button(shell, SWT.NONE);
		rockButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String opponent = move();
				resultLabel.setText("The opponent played " + opponent);
				if (opponent.equals("Rock")) {
					resultDisplay.setText("It's a draw!");
					total++;
					totalDisplay.setText("" + total);
					draws++;
					drawDisplay.setText("" + draws);
				} else if (opponent.equals("Paper")) {
					resultDisplay.setText("You lose!");
					total++;
					totalDisplay.setText("" + total);
					losses++;
					lossDisplay.setText("" + losses);
				} else {
					resultDisplay.setText("You win!");
					total++;
					totalDisplay.setText("" + total);
					wins++;
					winDisplay.setText("" + wins);
				}
			}
		});
		rockButton.setBounds(80, 30, 140, 60);
		rockButton.setText("Rock");
		
		Button paperButton = new Button(shell, SWT.NONE);
		paperButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String opponent = move();
				resultLabel.setText("The opponent played " + opponent);
				if (opponent.equals("Paper")) {
					resultDisplay.setText("It's a draw!");
					total++;
					totalDisplay.setText("" + total);
					draws++;
					drawDisplay.setText("" + draws);
				} else if (opponent.equals("Scissors")) {
					resultDisplay.setText("You lose!");
					total++;
					totalDisplay.setText("" + total);
					losses++;
					lossDisplay.setText("" + losses);
				} else {
					resultDisplay.setText("You win!");
					total++;
					totalDisplay.setText("" + total);
					wins++;
					winDisplay.setText("" + wins);
				}
			}
		});
		paperButton.setBounds(80, 95, 140, 60);
		paperButton.setText("Paper");
		
		Button scissorsButton = new Button(shell, SWT.NONE);
		scissorsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String opponent = move();
				resultLabel.setText("The opponent played " + opponent);
				if (opponent.equals("Scissors")) {
					resultDisplay.setText("It's a draw!");
					total++;
					totalDisplay.setText("" + total);
					draws++;
					drawDisplay.setText("" + draws);
				} else if (opponent.equals("Rock")) {
					resultDisplay.setText("You lose!");
					total++;
					totalDisplay.setText("" + total);
					losses++;
					lossDisplay.setText("" + losses);
				} else {
					resultDisplay.setText("You win!");
					total++;
					totalDisplay.setText("" + total);
					wins++;
					winDisplay.setText("" + wins);
				}
			}
		});
		scissorsButton.setBounds(80, 160, 140, 60);
		scissorsButton.setText("Scissors");
		
		Button resetButton = new Button(shell, SWT.NONE);
		resetButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				total = 0;
				wins = 0;
				losses = 0;
				draws = 0;
				totalDisplay.setText("" + total);
				winDisplay.setText("" + wins);
				lossDisplay.setText("" + losses);
				drawDisplay.setText("" + draws);
				resultLabel.setText("");
				resultDisplay.setText("Pick One!");
				
			}
		});
		resetButton.setBounds(0, 0, 94, 28);
		resetButton.setText("Reset");
	}

}
