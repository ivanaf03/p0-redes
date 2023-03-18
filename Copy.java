package es.udc.redes.tutorial.copy;
import java.io.*;

public class Copy {

    public static void main(String[] args) throws IOException {
        if (args.length==2) {
            int aux;
            FileInputStream rd = new FileInputStream(args[0]);
            FileOutputStream wr = new FileOutputStream(args[1]);
            while ((aux = rd.read()) != -1) {
                wr.write(aux);
            }
            rd.close();
            wr.close();
        }
    }
}
