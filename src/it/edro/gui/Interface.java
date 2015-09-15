package it.edro.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.PropertyConfigurator;

import it.edro.classes.Renamer;
import java.awt.Font;

public class Interface {

	private JFrame frmMoonp;
	private JProgressBar progressBar;
	private JButton btnRetag;
	private JButton btnRename;
	private JButton btnStartBoth;
	private JButton btnBrowse;
	private	JTextArea textArea;
	private JScrollPane scrollPane;
	
	private JFileChooser chooser;

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
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PropertyConfigurator.configure("log/log4j.xml");
		
		frmMoonp = new JFrame();
		frmMoonp.setResizable(false);
		frmMoonp.setIconImage(Toolkit.getDefaultToolkit().getImage(Interface.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		frmMoonp.setTitle("Moonp3");
		frmMoonp.setBounds(100, 100, 530, 380);
		frmMoonp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMoonp.getContentPane().setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(6, 321, 508, 19);
		frmMoonp.getContentPane().add(progressBar);
		
		btnRetag = new JButton("Retag");
		btnRetag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRetag.setBounds(424, 282, 90, 28);
		frmMoonp.getContentPane().add(btnRetag);
		
		btnRename = new JButton("Rename");
		btnRename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chooser == null)
					textArea.append("\n Nessuna directory scelta\n");
				else{
					if (chooser.getSelectedFile() == null)
						textArea.append("\n Nessuna directory scelta\n");
					else
						Renamer.main(chooser.getSelectedFile(), textArea);
				}
			}
		});
		btnRename.setBounds(424, 243, 90, 28);
		frmMoonp.getContentPane().add(btnRename);
		
		btnStartBoth = new JButton("Start Both");
		btnStartBoth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnStartBoth.setBounds(424, 204, 90, 28);
		frmMoonp.getContentPane().add(btnStartBoth);
		
		//Serve per prendere la directory
		btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File(System.getProperty("user.home")));
			    chooser.setDialogTitle("Mp3s' directory");
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);

			    if (chooser.showOpenDialog(frmMoonp) == JFileChooser.APPROVE_OPTION) {
			    	textArea.append(" La directory selezionata è: \n " + chooser.getSelectedFile() + "\n");
			    } else {
			    	textArea.append(" Directory non selezionata" + "\n");
			    }
			}
		});
		btnBrowse.setBounds(425, 12, 89, 23);
		frmMoonp.getContentPane().add(btnBrowse);

		textArea = new JTextArea();
		textArea.setFont(new Font("Verdana", Font.PLAIN, 12));
		textArea.setEditable(false);
		textArea.setBounds(6, 10, 322, 215);
		textArea.setText(" Selezionare la cartella che contiene gli mp3\n");
		textArea.setLineWrap(true);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(6, 10, 408, 299);
		frmMoonp.getContentPane().add(scrollPane);
		
	}
}
