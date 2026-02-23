import java.security.MessageDigest;

/**
 * La classe Block rappresenta un singolo blocco della blockchain.
 * Ogni blocco contiene dati, il riferimento al blocco precedente
 * e un hash crittografico che lo identifica in modo univoco.
 */
public class Block {

    // Hash del blocco corrente
    public String hash;

    // Hash del blocco precedente nella catena
    public String previousHash;

    // Contenuto informativo del blocco
    public String data;

    // Timestamp di creazione del blocco
    public long timestamp;

    // Numero usato nel processo di mining
    public int nonce;

    /**
     * Costruttore del blocco
     * @param data contenuto del blocco
     * @param previousHash hash del blocco precedente
     */
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;

        // Memorizza il momento di creazione
        this.timestamp = System.currentTimeMillis();

        // Calcola l'hash iniziale
        this.hash = calculateHash();
    }

    /**
     * Calcola l'hash SHA-256 del blocco.
     * L'hash dipende da:
     * previousHash + timestamp + nonce + data
     */
    public String calculateHash() {

        String input = previousHash + timestamp + nonce + data;

        return applySha256(input);
    }

    /**
     * Processo di mining.
     * Continua a modificare il nonce fino a ottenere
     * un hash che inizia con un certo numero di zeri.
     *
     * @param difficulty numero di zeri richiesti all'inizio dell'hash
     */
    public void mineBlock(int difficulty) {

        // Stringa target composta da N zeri
        String target = new String(new char[difficulty]).replace('\0', '0');

        // Continua finché l'hash non soddisfa la difficoltà
        while (!hash.substring(0, difficulty).equals(target)) {

            nonce++; // incrementa il nonce
            hash = calculateHash(); // ricalcola l'hash
        }

        System.out.println("Blocco minato: " + hash);
    }

    /**
     * Applica l'algoritmo SHA-256 a una stringa.
     */
    public static String applySha256(String input) {

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Calcolo dell'hash
            byte[] hash = digest.digest(input.getBytes("UTF-8"));

            // Conversione in formato esadecimale
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {

                String hex = Integer.toHexString(0xff & b);

                if (hex.length() == 1) {
                    hexString.append('0');
                }

                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}