-La versione finale dell'esercizio si trova nella cartella 'EsercizioVersioneFinale'.

-NOTE 1: 
    --> ConfigRepo.rar contiene i file di configurazione. Estrarre la cartella prima di runnare il progetto.
    --> Cambiare ConfigService .yaml file per puntare alla cartella corretta di ConfigRepo.
    
-NOTE 2: 
    --> richiede RabbitMQ server in funzione sulla porta di default ( 5672 )
    --> richiede ZipKin in funzione sulla porta 9411

-Descrizione generale della comunicazione tra microservizi:

    --> RestaurantService usa OpenFeign e CircuitBreaker per richiedere servizi in modo sincrono verso PizzaService.
    
    --> PizzaService comunica in modo asincrono ( attraverso rabbitmq message broker ) l'avvenuto inserimento di pizze in un ristorante.
        Qunado viene chiamato il metodo per l'inserimento, 
        1) Invia un messaggio sulla coda 'q.notify-pizzas-added-to-restauranti' di avvenuto inserimento.
        2) Invia un messaggio sulla coda 'q.pizzas-added-to-restaurant' contenente la lista delle pizze inserite.
        
    --> NotificationService è in ascolto sulla coda 'q.notify-pizzas-added-to-restauranti' per notificare l'inserimento.
    
    --> RestaurantService è in ascolto sulla coda 'q.pizzas-added-to-restaurant' per ricevere la lista delle pizze inserite.
