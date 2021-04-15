import javax.swing.*;
import java.io.File;
import java.awt.event.*;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener {
	JFrame jframe;

	public FileMenuHandler(JFrame jf) {
		jframe = jf;
	}// FileMenuHandler constructor

	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Open"))
			file();
		else if (menuName.equals("Quit"))
			System.exit(0);
	} // actionPerformed

	private void file() {
		JFileChooser fileChooser = new JFileChooser("./");
		int status=fileChooser.showOpenDialog(null);
		if(status==JFileChooser.APPROVE_OPTION){
		   File myFile = fileChooser.getSelectedFile();
		   read(myFile.getAbsolutePath());
		}
	}// file

	private void read(String f) {
		SortedCandleList sorted = new SortedCandleList();
		UnsortedCandleList unsorted = new UnsortedCandleList();
		TextFileInput tfi = new TextFileInput(f);
		String line = tfi.readLine();// reads each line
		while (line != null) {
			StringTokenizer tokens = new StringTokenizer(line, ",");
			if (tokens.countTokens() != 3) {
				System.out.print(line + " ");
			} else {
				int height = Integer.parseInt(tokens.nextToken());
				int width = Integer.parseInt(tokens.nextToken());
				float price = Float.parseFloat(tokens.nextToken());
				Candle a = new Candle(height, width, price);
				unsorted.add(a);// adds tokens to lists
				sorted.add(a);
			} // else
			line = tfi.readLine();
		} // while loop
		//CandleGUI gui = new CandleGUI("Candles");
		Project3.gui.showLists(sorted, unsorted);
	}// read

}// FileMenuHandler