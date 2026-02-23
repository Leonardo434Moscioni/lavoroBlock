import java.util.ArrayList;

/**
 * La classe Blockchain gestisce l'intera catena di blocchi.
 * Si occupa di:
 * - aggiungere nuovi blocchi
 * - mantenere l'ordine della catena
 * - verificare l'integrità dei dati
 */
public class Blockchain {

    // Lista che contiene tutti i blocchi
    public ArrayList<Block> chain = new ArrayList<>();

    // Livello di difficoltà del mining
    public int difficulty = 4;

    /**
     * Costruttore della blockchain.
     * Crea automaticamente il Genesis Block.
     */
    public Blockchain() {

        chain.add(createGenesisBlock());
    }

    /**
     * Il primo blocco della catena.
     * Non ha un blocco precedente.
     */
    private Block createGenesisBlock() {

        return new Block("Genesis Block", "0");
    }

    /**
     * Restituisce l'ultimo blocco della catena.
     */
    public Block getLatestBlock() {

        return chain.get(chain.size() - 1);
    }

    /**
     * Aggiunge un nuovo blocco alla blockchain.
     */
    public void addBlock(Block newBlock) {

        // Collega il blocco al precedente
        newBlock.previousHash = getLatestBlock().hash;

        // Esegue il mining
        newBlock.mineBlock(difficulty);

        // Inserisce il blocco nella catena
        chain.add(newBlock);
    }

    /**
     * Verifica che l'intera blockchain sia valida.
     */
    public boolean isChainValid() {

        Block currentBlock;
        Block previousBlock;

        // Si parte dal secondo blocco
        for (int i = 1; i < chain.size(); i++) {

            currentBlock = chain.get(i);
            previousBlock = chain.get(i - 1);

            // Verifica che l'hash salvato sia corretto
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {

                System.out.println("Errore: hash del blocco non valido");
                return false;
            }

            // Verifica il collegamento tra blocchi
            if (!currentBlock.previousHash.equals(previousBlock.hash)) {

                System.out.println("Errore: collegamento tra blocchi compromesso");
                return false;
            }
        }

        return true;
    }
}