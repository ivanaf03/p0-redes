package es.udc.redes.tutorial.info;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;

public class Info {

    public static void main(String[] args) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if(args.length==1) {
            File file = new File(args[0]);
            if (file.exists()) {
                System.out.println("Name: " + file.getName());
                System.out.println("Size: " + file.length());
                System.out.println("Last modification date: " + formatter.format(file.lastModified()));
                System.out.println("Extension: " + args[0].substring(args[0].lastIndexOf('.') + 1));
                System.out.println("File: " + Files.probeContentType(file.toPath()));
                System.out.println("Absolute path: " + file.getAbsolutePath());
            } else {
                throw new IllegalArgumentException("No such file");
            }
        }
    }
    
}
