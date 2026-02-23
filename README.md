# lavoroBlock
Minimalist Blockchain V1.0
Descrizione

Questo progetto è un semplice esempio di blockchain scritta in Java.
Serve per capire i concetti base di questa tecnologia, come:

collegamento tra blocchi

hash crittografici

Proof of Work (mining)

verifica dell’integrità dei dati

La blockchain viene simulata in locale e i risultati vengono mostrati nella console.

Obiettivo del progetto

Lo scopo è dimostrare che:

ogni blocco contiene l’hash del blocco precedente

se un dato viene modificato la catena diventa non valida

il mining richiede lavoro computazionale

l’hash garantisce l’integrità dei dati

Tecnologie usate

Java

Librerie standard:

java.security

java.util

Non vengono utilizzati database o framework esterni.

Struttura del progetto
project
│
├── Main.java
├── Blockchain.java
└── Block.java

Block.java
Definisce la struttura di un blocco e il calcolo dell’hash.

Blockchain.java
Gestisce la catena dei blocchi e controlla che sia valida.

Main.java
Avvia il programma e mostra un esempio di utilizzo.

Struttura di un blocco

Ogni blocco contiene:

hash → identificatore del blocco

previousHash → hash del blocco precedente

data → informazione salvata

timestamp → momento di creazione

nonce → numero usato nel mining

L’hash viene calcolato con:

SHA-256(previousHash + timestamp + nonce + data)
Mining (Proof of Work)

Per aggiungere un blocco alla blockchain bisogna trovare un hash valido.

L’hash deve iniziare con un certo numero di zeri, definito dalla difficulty.

Il programma prova molti valori di nonce finché trova un hash valido.

Esempio di output
Mining blocco 1...
Blocco minato: 0000ab12c9...

Mining blocco 2...
Blocco minato: 0000f91ad3...

Mining blocco 3...
Blocco minato: 000034bc12...

Blockchain valida: true
Dimostrazione della sicurezza

Se qualcuno modifica i dati di un blocco:

blockchain.chain.get(1).data = "dato modificato";

la verifica fallisce:

Errore: hash del blocco non valido
Blockchain valida: false

Questo dimostra che la blockchain rende evidente qualsiasi modifica ai dati.

Questo progetto è stato realizzato solo per imparare come funziona una blockchain.

Non è pensato per uso reale o produzione.
