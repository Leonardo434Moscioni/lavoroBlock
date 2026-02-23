/**
 * Classe principale del programma.
 * Simula il funzionamento di una blockchain.
 */
public class Main {

    public static void main(String[] args) {

        // Creazione della blockchain
        Blockchain blockchain = new Blockchain();

        System.out.println("Mining blocco 1...");
        blockchain.addBlock(new Block("Primo blocco di dati", ""));

        System.out.println("Mining blocco 2...");
        blockchain.addBlock(new Block("Secondo blocco di dati", ""));

        System.out.println("Mining blocco 3...");
        blockchain.addBlock(new Block("Terzo blocco di dati", ""));

        // Verifica della validità della catena
        System.out.println("\nBlockchain valida: " + blockchain.isChainValid());
    }
}