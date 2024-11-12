package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

    private static String TEKST = "TEKST";
    private static String BILDE = "BILDE";

    public static Blogg les(String mappe, String filnavn) {
        File file = new File(mappe, filnavn);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int antallInnlegg = Integer.parseInt(reader.readLine().trim());
            Blogg samling = new Blogg(antallInnlegg);
            
            // Read each entry
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(TEKST)) {
                    int id = Integer.parseInt(reader.readLine().trim());
                    String bruker = reader.readLine().trim();
                    String dato = reader.readLine().trim();
                    int likes = Integer.parseInt(reader.readLine().trim());
                    String tekst = reader.readLine().trim();
                    
                    Tekst tekstInnlegg = new Tekst(id, bruker, dato, likes, tekst);
                    samling.leggTil(tekstInnlegg);
                    
                } else if (line.equals(BILDE)) {
                    int id = Integer.parseInt(reader.readLine().trim());
                    String bruker = reader.readLine().trim();
                    String dato = reader.readLine().trim();
                    int likes = Integer.parseInt(reader.readLine().trim());
                    String tekst = reader.readLine().trim();
                    String url = reader.readLine().trim();
                    
                    Bilde bildeInnlegg = new Bilde(id, bruker, dato, likes, tekst, url);
                    samling.leggTil(bildeInnlegg);
                }
            }
            
            return samling;
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
        /*
         * åååååå fyyyy
         * programmering er gøy helt til du begynner
         * med lesing og skriving av filer
         */
    }
}