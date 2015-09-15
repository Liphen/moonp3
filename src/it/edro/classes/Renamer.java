package it.edro.classes;

import java.io.File;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

public class Renamer {
	
	private static Logger log = Logger.getLogger(Renamer.class);
	
	public static void main(File directory, JTextArea textArea){
		File listFile[] = directory.listFiles();
		int fileNumber = 0; 
		
		if(listFile != null){
			
			log.debug("Renamer iniziato");
			
			for(int i = 0; i < listFile.length; i++){
				textArea.append(fileNumber++ + " " + listFile[i].getName() + "\n");
				log.info("Sto cercando il file numero " + fileNumber + " con il nome: " + listFile[i].getName());
				
			}		
			
			log.debug("Renamer finito");
		}
	}
}
