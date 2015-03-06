// Patrick Cain
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.JFrame;

public class PaintChipTest {

	public static void main(String[] args) {
		int numChips;
		int redStart;
		int redEnd;
		int greenStart;
		int greenEnd;
		int blueStart;
		int blueEnd;
		Scanner scan = new Scanner(System.in);

		System.out
				.println("How many colors would you like to see on your paint chip? ");
		numChips = scan.nextInt();
		System.out.println("Enter the starting red value (0 - 255): ");
		redStart = scan.nextInt();
		System.out.println("Enter the starting green value (0 - 255): ");
		greenStart = scan.nextInt();
		System.out.println("Enter blue value (0 - 255): ");
		blueStart = scan.nextInt();
		System.out.println("Enter the ending red value (0 - 255): ");
		redEnd = scan.nextInt();
		System.out.println("Enter the ending green value (0 - 255): ");
		greenEnd = scan.nextInt();
		System.out.println("Enter ending blue value (0 - 255): ");
		blueEnd = scan.nextInt();

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		f.add(new PaintPanel(numChips, redStart, redEnd, greenStart, greenEnd,
				blueStart, blueEnd));
		f.setSize(screenSize.width, screenSize.height);
		f.setVisible(true);
	}

}
