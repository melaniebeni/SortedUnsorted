import java.awt.GridLayout;

import javax.swing.*;

/**
 * Display the contents of the lists in a GUI that has a GridLayout left column
 * displays unsorted candle list from file right column displays ordered candle
 * list
 * 
 * @author melaniebeni
 *
 */

public class CandleGUI extends JFrame {
	private JTextArea left, right;

	public CandleGUI(String list) {
		super(list);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200, 200);
		this.setLayout(new GridLayout(1, 2));
		createFileMenu();
		this.left = new JTextArea();
		this.right = new JTextArea();
		this.setVisible(true);
		this.getContentPane().add(this.left);
		this.getContentPane().add(this.right);
	}// CandleGUI contractor

	private void createFileMenu() {
		JMenuItem item;
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		FileMenuHandler fmh = new FileMenuHandler(this);

		item = new JMenuItem("Open"); // Open
		item.addActionListener(fmh);
		fileMenu.add(item);

		fileMenu.addSeparator();

		item = new JMenuItem("Quit"); // Quit
		item.addActionListener(fmh);
		fileMenu.add(item);

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
	} // createMenu

	public void showLists(SortedCandleList sorted, UnsortedCandleList unsorted) {
		CandleNode us = unsorted.first.next;
		CandleNode s = sorted.first.next;
		left.append("Unsorted\n");
		right.append("Sorted\n");
		while (us != null && s != null) {
			left.append(us.data + "\n");
			us = us.next;
			right.append(s.data + "\n");
			s = s.next;
		} // while

	}// ShowLists

}// CandleGUI