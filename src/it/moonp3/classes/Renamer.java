package it.moonp3.classes;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

public class Renamer {
	
	private static Logger log = Logger.getLogger(Renamer.class);
	
	public static void main(File directory, JTextArea textArea){
		
		int fileNumber = 0;
		File listFile[] = directory.listFiles();
		String[] filename = null;
		//TODO DIVIDERE PRIMA IL NOME DAL TITOLO
		log.debug("Renamer iniziato");
		if(listFile != null){				
			for(int i = 0; i < listFile.length; i++){
				textArea.append(fileNumber++ + " - " + listFile[i].getName() + "\n");
				filename = listFile[i].getName().split(" ");
				for(int j = 0; j < filename.length; j++){
					
				}
				log.info("Sto cercando il file numero " + fileNumber + " con il nome: " + listFile[i].getName());
			}		
		}
		log.debug("Renamer finito");
	}
}
