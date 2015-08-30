package it.edro.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Toolkit;

public class Interface {

	private JFrame frmMoonp;
	private JProgressBar progressBar;
	private JButton btnRetag;
	private JButton btnRename;
	private JButton btnStartBoth;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmMoonp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmMoonp = new JFrame();
		frmMoonp.setResizable(false);
		frmMoonp.setIconImage(Toolkit.getDefaultToolkit().getImage(Interface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		frmMoonp.setTitle("Moonp3");
		frmMoonp.setBounds(100, 100, 443, 291);
		frmMoonp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMoonp.getContentPane().setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(6, 236, 422, 19);
		frmMoonp.getContentPane().add(progressBar);
		
		btnRetag = new JButton("Retag");
		btnRetag.setBounds(338, 196, 90, 28);
		frmMoonp.getContentPane().add(btnRetag);
		
		btnRename = new JButton("Rename");
		btnRename.setBounds(338, 156, 90, 28);
		frmMoonp.getContentPane().add(btnRename);
		
		btnStartBoth = new JButton("Start Both");
		btnStartBoth.setBounds(338, 116, 90, 28);
		frmMoonp.getContentPane().add(btnStartBoth);
		
		textPane = new JTextPane();
		textPane.setBounds(6, 6, 320, 218);
		frmMoonp.getContentPane().add(textPane);
	}
}
