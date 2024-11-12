package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {
        String c = samling.toString();
        try {
            File file = new File(mappe, filnavn);
            PrintWriter writer = new PrintWriter(file);
            writer.print(c);
            writer.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }
}
