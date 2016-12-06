package init;

import java.io.File;
 

public class diskFileExplorer {
 
    private String initialpath = "";
    private Boolean recursivePath = false;
    public int filecount = 0;
    public int dircount = 0;
 
/**
 * Constructeur
 * @param path chemin du répertoire
 * @param subFolder analyse des sous dossiers
 */
    public diskFileExplorer(String path, Boolean subFolder) {
        super();
        this.initialpath = path;
        this.recursivePath = subFolder;
    }
 
    public String list() {
        return this.listDirectory(this.initialpath);
    }
 
    private String listDirectory(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() == true) {
                    System.out.println("Dossier: " + files[i].getAbsolutePath());
                    this.dircount++;
                } else {
                    System.out.println(i+1 + " : " + files[i].getName());
                    this.filecount++;
                }
                if (files[i].isDirectory() == true && this.recursivePath == true) {
                    this.listDirectory(files[i].getAbsolutePath());
                }
            }
        }
        int choix = ScanEntrer.scannerEntier(1, files.length, "Désolé, choix invalide!");
        return files[choix - 1].getName();
		
    }    
}