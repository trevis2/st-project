package it.trevisan.simone;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // Stream<String> stream = Stream.of("uno", "due", "tre", "quattro", "cinque");

        // // Invertiamo gli elementi dello stream e li stampiamo
        // ArrayList<String> list =
        // stream.collect(Collectors.toCollection(ArrayList::new));
        // Collections.reverse(list);
        // list.forEach(System.out::println);

        HashMap<Integer, String> configMap = new HashMap<Integer, String>();
        // configMap.put(2, "DUE");
        configMap.put(3, "Tre");
        configMap.put(7, "Sette");
        configMap.put(11, "Undici");
        // configMap.put(13, "Tredici");
        // configMap.put(17, "Diciassette");
        // configMap.put(19, "Diciannove");
        // configMap.put(23, "Ventitr");

        FizzBuzz item = new FizzBuzz(configMap);
        // verify(item.generate2(2), configMap, 2);
        // verify(item.generate2(3), configMap, 3);
        // verify(item.generate2(5), configMap, 5);
        // verify(item.generate2(500), configMap, 500);

        int numeroElementi = 1000;
        long start = System.currentTimeMillis();
        // item.generate(test);
        // System.out.println("generate:" + (System.currentTimeMillis() - start));
        // start = System.currentTimeMillis();
        String valore = item.generate2(numeroElementi);
        verify(valore, configMap, numeroElementi);
        saveToFile(valore, "log.txt", false);
        System.out.println("generate2:" + (System.currentTimeMillis() - start));
    }

    /**
     * Salva la sequenza in un file, con l'opzione di appendere o sovrascrivere.
     * 
     * @param sequence La sequenza da salvare
     * @param fileName Il nome del file
     * @param append   Se true, appende al file; se false, sovrascrive
     * @throws IOException Se si verifica un errore durante la scrittura
     */
    public static void saveToFile(String sequence, String fileName, boolean append) {
        try {
            if (append) {
                appendSequenceToFile(sequence, fileName);
            } else {
                saveSequenceToFile(sequence, fileName);
            }
        } catch (Exception e) {
            System.out.println("errore durante il salvataggio");
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Appende la sequenza a un file esistente. Se il file non esiste, lo crea.
     * 
     * @param sequence La sequenza da appendere
     * @param fileName Il nome del file
     * @throws IOException Se si verifica un errore durante la scrittura
     */
    public static void appendSequenceToFile(String sequence, String fileName) throws IOException {
        Files.write(Paths.get(fileName), sequence.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    /**
     * Salva la sequenza in un file, sovrascrivendo il contenuto esistente.
     * 
     * @param sequence La sequenza da salvare
     * @param fileName Il nome del file
     * @throws IOException Se si verifica un errore durante la scrittura
     */
    public static void saveSequenceToFile(String sequence, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(sequence);
        }
    }

    static void verify(String stringDaVerify, HashMap<Integer, String> configMap, int numeroElementi) {
        String[] array = stringDaVerify.split(",");
        try {
            assertThat(array.length == numeroElementi)
                    .as("lunghezza array errata:" + array.length + ", expected:" + numeroElementi).isTrue();

            configMap.keySet().stream().forEach(prime -> {
                long conto = Arrays.stream(array).filter(item -> item.contains(configMap.get(prime))).count();
                assertThat((numeroElementi / prime) == conto)
                        .as("la divisione di " + prime + ":" + numeroElementi / prime + ", non torna con il conto:"
                                + conto)
                        .isTrue();
            });
            System.out.println("verifica stringa effettuata!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class FizzBuzz {
    HashMap<Integer, String> configMap;
    ArrayList<Integer> arl;

    FizzBuzz(HashMap<Integer, String> config) {
        this.configMap = config;
        Set<Integer> sets = configMap.keySet();
        ArrayList<Integer> al = new ArrayList<>();
        al.addAll(sets);
        setArl(al);
    }

    private void setArl(ArrayList<Integer> al) {
        this.arl = al;
    }

    public String generate(int n) {
        String compositeString = "";
        for (int i = 1; i < n + 1; i++) {
            boolean found = false;

            for (int j : arl) {
                if (i % j == 0) {
                    compositeString += configMap.get(j);
                    found = true;
                }
            }
            if (found) {
                // non fare niente
            } else {
                compositeString += i;
            }
            if (i != n) {
                compositeString += ",";
            }
        }
        return compositeString;
    }

    public String generate2(Integer n) {
        return IntStream
                .rangeClosed(1, n)
                .mapToObj(nvalue -> {
                    String resp = configMap.keySet().stream().filter(k -> nvalue % k == 0).map(configMap::get)
                            .collect(Collectors.joining());
                    return resp.isEmpty() ? Integer.toString(nvalue) : resp;
                })
                .collect(Collectors.joining(","));
    }
}
