GameTime è un'applicazione progettata per la gestione del tempo dedicato ai videogiochi e al monitoraggio degli utenti. Il sistema consente di registrare le sessioni di gioco, associare i videogiochi agli utenti e salvare tutte le informazioni su un database MySQL strutturato.
L'obiettivo principale del progetto è offrire uno strumento semplice per tracciare il tempo di utilizzo dei videogiochi e organizzare i dati in modo efficiente tramite un database relazionale.

Tecnologie Utilizzate

Linguaggio di programmazione: Java, HTML

Database: MySQL

IDE utilizzato: Eclipse

Struttura del Database

Il progetto utilizza un database MySQL composto da tre tabelle principali:

Tabella utenti

Contiene le informazioni relative agli utenti registrati nel sistema.

Campi tipici:

        id_utente (PK)

        nome

        cognome

        email (unique)

        username (unique)

        password

        admin (se l'utente è un admin master, admin slave o user)

Tabella videogiochi

Contiene l'elenco dei videogiochi disponibili.

Campi tipici:

        id_videogioco (PK)

        titolo

        genere

        casa

Tabella tempo

Registra il tempo di gioco associando utenti e videogiochi.

Campi tipici:

        id_tempo (PK)

        id_utente (FK)

        id_videogioco (FK)

        inizio_sessione

        fine_sessione

        data_sessione

Questa tabella rappresenta la relazione tra utenti e videogiochi e consente di tracciare le sessioni di gioco.

Configurazione del Database

Creare un database (es. gametime).

Creare le tre tabelle (utenti, videogiochi, tempo).

Configurare le credenziali di accesso nel file di connessione del progetto.

Clonare o scaricare il progetto.

Configurare il database MySQL.

Eseguire l'applicazione dal proprio IDE.

Autore

Andrea Vendetti

Progetto sviluppato per finalità didattiche.
