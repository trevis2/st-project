package main;

import java.util.*;

class Network
{
    private int numUsers; // Numero di utenti nel network
    private List<Utente> listaUtenti;
    private HashMap<Utente, List<Utente>> friendshipsNetwork; // Lista amicizie degli utenti

    public Network()
    {
        this.numUsers = 0;
        this.friendshipsNetwork = new HashMap<>();
    }

    public void addUser(Utente user)
    {
        this.numUsers += 1;
        getListaUtenti().add(user);
    }

    public List<Utente> getListaUtenti()
    {
        if (listaUtenti == null || listaUtenti.isEmpty())
        {
            listaUtenti = new ArrayList<Utente>();
        }
        return listaUtenti;
    }

    public void addFriendshipsNetwork(List<Utente> list)
    {
        for (Utente user : list)
        {
            friendshipsNetwork.put(user, user.getAmicizie());
        }
    }

    public Utente getUtente(Integer id)
    {
        return getListaUtenti().stream().filter(utente -> utente.getId() == id).findAny().orElse(null);
    }

    // estrazione albero di amicizie di un utente nel social network
    void DFS(Utente user)
    {
        HashMap<Utente, Boolean> visited = new HashMap<Utente, Boolean>(numUsers); // Array per tenere traccia degli utenti visitati
        DFSUtil(user, visited, 0);
    }

    // Funzione di supporto per l'algoritmo DFS (ricorsiva)
    private void DFSUtil(Utente user, HashMap<Utente, Boolean> visited, int level)
    {
        visited.put(user, true);
        System.out.print(user.getNome() + ":" + level + " "); // Stampa l'utente corrente
        level++;
        // Esplora gli utenti amici non ancora visitati
        for (Utente amico : user.getAmicizie())
        {
            if (visited.get(amico) == null)
            {
                DFSUtil(amico, visited, level);
            }
        }
    }

    void BFS(Utente user)
    {
        HashMap<Utente, Boolean> visited = new HashMap<Utente, Boolean>(numUsers); // Array per tenere traccia degli utenti visitati
        BFSUtil(user, visited);
    }

    // Funzione di supporto per l'algoritmo DFS (ricorsiva)
    private void BFSUtil(Utente user, HashMap<Utente, Boolean> visited)
    {
        Queue<Utente> queue = new LinkedList<Utente>();
        queue.add(user);
        visited.put(user, true);
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        while (!queue.isEmpty())
        {
            Utente currUser = queue.poll();
            distance.put(currUser.getNome(), 0);
            System.out.print(currUser.getNome() + " ");
            // Esplora gli utenti amici non ancora visitati
            for (Utente amico : currUser.getAmicizie())
            {
                if (!distance.containsKey(amico.getNome()))
                {
                    distance.put(amico.getNome(), distance.get(currUser.getNome()) + 1);
                }

                if (visited.get(amico) == null)
                {
                    queue.add(amico);

                }
            }
        }
        System.out.print(distance);
    }
}

class Utente
{
    private Integer id;
    private String nome;
    private List<Utente> amicizie;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void addAmico(Utente utente)
    {
        getAmicizie().add(utente);
    }

    public List<Utente> getAmicizie()
    {
        if (amicizie == null || amicizie.isEmpty())
        {
            amicizie = new ArrayList<Utente>();
        }
        return amicizie;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    @Override
    public String toString()
    {
        return "Utente [id=" + id + ", nome=" + nome + ", amicizie=" + amicizie + "]";
    }

}

public class Main
{
    public static void main(String[] args)
    {
        Network socialNetwork = new Network();
        // inserisco utenti nel social
        for (int i = 0; i < 10; i++)
        {
            Utente utente = new Utente();
            utente.setId(i);
            utente.setNome("Utente" + i);
            socialNetwork.addUser(utente);
        }

        // Aggiungiamo le amicizie
        socialNetwork.getUtente(1).addAmico(socialNetwork.getUtente(2));
        socialNetwork.getUtente(2).addAmico(socialNetwork.getUtente(1));
        socialNetwork.getUtente(3).addAmico(socialNetwork.getUtente(4));
        socialNetwork.getUtente(2).addAmico(socialNetwork.getUtente(5));
        socialNetwork.getUtente(3).addAmico(socialNetwork.getUtente(7));
        socialNetwork.getUtente(3).addAmico(socialNetwork.getUtente(8));
        socialNetwork.getUtente(6).addAmico(socialNetwork.getUtente(9));
        socialNetwork.getUtente(1).addAmico(socialNetwork.getUtente(6));
        socialNetwork.getUtente(4).addAmico(socialNetwork.getUtente(5));
        socialNetwork.getUtente(5).addAmico(socialNetwork.getUtente(8));

        socialNetwork.addFriendshipsNetwork(socialNetwork.getListaUtenti());

        System.out.print("Albero amicizie utente secondo DFS \n");
        // estrae albero dell'utente
        socialNetwork.DFS(socialNetwork.getUtente(2));
        System.out.print("\n");
        System.out.print("Albero amicizie utente secondo BFS \n");
        socialNetwork.BFS(socialNetwork.getUtente(2));
    }
}
