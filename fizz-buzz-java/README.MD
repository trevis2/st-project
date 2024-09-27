# Esercizio: Generatore di Sequenze in Java

Implementare una classe `SequenceGenerator` con un metodo `generate` che generi una sequenza di caratteri lunga `n` (da parametro in input) separati da virgola secondo le seguenti regole:

## Regole Iniziali:
- Nelle posizioni multiple di 3, il numero è sostituito da "Tre"
- Nelle posizioni multiple di 5, il numero è sostituito da "Cinque"
- Nelle restanti posizioni ci deve essere il numero della posizione

Esempio:
```java
SequenceGenerator sequenceGenerator = new SequenceGenerator();
String result = sequenceGenerator.generate(10);
// Output: "1,2,Tre,4,Cinque,Tre,7,8,Tre,Cinque"
```

## Requisiti Aggiuntivi:

1. **Aggiungere valore**: Nelle posizioni multiple sia di 3 che 5, il numero è sostituito da "Quindici".

   Esempio:
   ```java
   String result = generator.generate(15);
   // Output: "1,2,Tre,4,Cinque,Tre,7,8,Tre,Cinque,11,Tre,13,14,Quindici"
   // Domanda: che problema c'è nel modificare il metodo preesistente? 
   ```
   
2. **Test**: Scrivere dei test JUnit per verificare la correttezza dell'algoritmo `generateSequence(100)`.

3. **Parametrizzazione**: Il metodo deve accettare un oggetto `Map<Integer, String>` come configurazione opzionale che permetta di personalizzare le regole.

   Per esempio:
   ```java
   Map<Integer, String> config = new HashMap<>();
   config.put(3, "Fizz");
   config.put(5, "Buzz");
   config.put(7, "Zazz");

   SequenceGenerator sequenceGenerator = new SequenceGenerator(config);
   String result = generator.generate(10);
   // Output: "1,2,Fizz,4,Buzz,Fizz,Zazz,8,Fizz,Buzz"
   ```

4. **Salvare su file**: Implementare un metodo per salvare la stringa generata su un file.

## Requisiti Generali:
1. **Efficienza**: L'implementazione deve essere efficiente per grandi valori di n (esempio, genera una sequenza di 1.000.000 di elementi).

2. **Gestione degli Errori**: Il metodo deve gestire correttamente input non validi, lanciando eccezioni appropriate.

3. **Formato di Output**: Aggiungere un parametro opzionale per specificare il formato di output (String o List<String>).

4. **Test**: Scrivere una suite di test JUnit completa per garantire la robustezza dell'implementazione.

## Bonus:
- Implementare una versione del generatore che utilizzi gli Stream di Java per la generazione della sequenza.
- Creare una versione concorrente del generatore per sfruttare i multi-core dei processori moderni.