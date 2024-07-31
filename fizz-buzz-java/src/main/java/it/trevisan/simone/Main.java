package it.trevisan.simone;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("uno", "due", "tre", "quattro", "cinque");

        // Invertiamo gli elementi dello stream e li stampiamo
        ArrayList<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(list);
        list.forEach(System.out::println);

        HashMap<Integer, String> configMap = new HashMap<Integer, String>();
        // configMap.put(2, "DUE");
        configMap.put(3, "Tre");
        configMap.put(7, "Sette");
        configMap.put(11, "Undici");
        configMap.put(13, "Tredici");
        configMap.put(17, "Diciassette");
        configMap.put(19, "Diciannove");
        configMap.put(23, "Ventitr");

        FizzBuzz item = new FizzBuzz(configMap);
        // verify(item.generate2(2), configMap, 2);
        // verify(item.generate2(3), configMap, 3);
        // verify(item.generate2(5), configMap, 5);
        // verify(item.generate2(500), configMap, 500);

        int test = 100;
        long start = System.currentTimeMillis();
        item.generate(test);
        System.out.println("generate:" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        item.generate2(test);
        System.out.println("generate2:" + (System.currentTimeMillis() - start));
        // scrivere un generatore di stringhe che generi una sequenza di caratteri lunga
        // n (da input) separati da virgola secondo le seguenti regole:
        // nelle posizioni multiple di 3 il numero è sostituito da "Tre"
        // nelle posizioni multiple di 5 il numero è sostituito da "Cinque"
        // nelle posizioni multiple sia di 3 che 5 il numero è sostituito da "TreCinque"
        // nelle restanti ci deve essere il numero della posizione
        // esempi
        // generate(3) > "1,2,Tre"
        // generate(5) > "1,2,Tre,4,Cinque"
        // generate(15) > "1,2,Tre,4,Cinque,Tre,7,8,Tre,Cinque,11,Tre,13,14,TreCinque"

        // scrivere un test per generate(50000)
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
