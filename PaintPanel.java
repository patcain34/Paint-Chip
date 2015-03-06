import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	int numChips;
	int redStart;
	int redEnd;
	int redInc;
	int redDec;
	boolean redAdd;
	int greenStart;
	int greenEnd;
	int greenInc;
	int greenDec;
	boolean greenAdd;
	int blueStart;
	int blueEnd;
	int blueInc;
	int blueDec;
	boolean blueAdd;
	int r_x = 50;
	int r_y = 50;

	// Color testColor = new Color(10, 150, 135);

	public PaintPanel(int n, int rs, int re, int gs, int ge, int bs, int be) {
		super();
		numChips = n;
		redStart = rs;
		redEnd = re;
		greenStart = gs;
		greenEnd = ge;
		blueStart = bs;
		blueEnd = be;
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D r = new Rectangle2D.Double(r_x, r_y, 130, 120);

		// calculate increments for each RGB value
		if (redStart < redEnd) {
			redInc = (((redEnd / redStart) / numChips) * redStart);
			redAdd = true;
			// System.out.println("Red true");
		}
		if (redStart > redEnd) {
			redDec = (((redStart / redEnd) / numChips) * redEnd);
			redAdd = false;
			// System.out.println("Red true");
		}
		if (redStart == redEnd) {
			redInc = 0;
			redAdd = true;
		}

		if (greenStart < greenEnd) {
			greenInc = (((greenEnd / greenStart) / numChips) * greenStart);
			greenAdd = true;
			System.out.println("green inc = " + greenInc);
		}
		if (greenStart > greenEnd) {
			greenDec = (((greenStart / greenEnd) / numChips) * greenEnd);
			greenAdd = false;
		}
		if (greenStart == greenEnd) {
			greenInc = 0;
			greenAdd = true;
		}

		if (blueStart < blueEnd) {
			blueInc = (((blueEnd / blueStart) / numChips) * blueStart);
			blueAdd = true;
			System.out.println("blue inc = " + blueInc);
		}
		if (blueStart > blueEnd) {
			blueDec = (((blueStart / blueEnd) / numChips) * blueEnd);
			blueAdd = false;
		}
		if (blueStart == blueEnd) {
			blueInc = 0;
			blueAdd = true;
		}

		for (int i = 0; i < numChips; i++) {
			r.setRect(r_x, r_y, 100, 100);
			Color chipColor = new Color(redStart, greenStart, blueStart);
			System.out.println(redStart);
			System.out.println(greenStart);
			System.out.println(blueStart);
			g2.setPaint(chipColor);
			g2.draw(r);
			g2.fill(r);
			r_x = r_x + 105;

			if (redAdd == true)
				redStart = redStart + redInc;
			if (redAdd == false)
				redStart = redStart - redDec;

			if (greenAdd == true)
				greenStart = greenStart + greenInc;
			if (greenAdd == false)
				greenStart = greenStart - greenDec;

			if (blueAdd == true)
				blueStart = blueStart + blueInc;
			if (blueAdd == false)
				blueStart = blueStart - blueDec;
		}

	}
}
