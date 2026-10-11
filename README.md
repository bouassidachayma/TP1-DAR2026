# TP1 - Développement d'Applications Réparties (LSI3)

**Étudiant :** Chayma Bouassida  
**Matière :** Développement d'applications réparties  
**Année universitaire :** 2026 – 2027

Ce dépôt contient le travail réalisé pour le TP1 sur les sockets en mode connecté TCP.

---

# Activité 1-1 : Première connexion Client/Serveur

## Objectif
Établir une communication Client/Serveur en Java à l'aide de sockets en mode connecté TCP.

## Code Source
### Server.java
![Code serveur](screenshots/a11_server_code.png)

### Client.java
![Code client](screenshots/a11_client_code.png)

## Exécution et Résultats
### 1. Serveur en attente de connexion
Le serveur démarre, se met en écoute sur le port 1234 et bloque sur `accept()`.
![Serveur en attente](screenshots/a11_server_waiting.png)

### 2. Client connecté
Le client se connecte au serveur via `localhost:1234` et affiche son message.
![Client connecté](screenshots/a11_client_connected.png)

### 3. Serveur après connexion
Dès que le client se connecte, le serveur accepte la connexion et affiche le message correspondant.
![Serveur après connexion](screenshots/a11_server_after.png)

## Test avec une adresse IP
Nous avons remplacé `localhost` par l'adresse IP `127.0.0.1` dans le client. Le comportement reste identique.
![Test IP](screenshots/a11_ip_test.png)

## Interprétation
Le serveur démarre en premier et se bloque sur `accept()` en attendant un client.
Le client initie la connexion. Une fois la connexion TCP établie, les deux programmes affichent leurs messages respectifs, ferment les sockets et se terminent proprement.

---

# Activité 1-2 : Service de calculatrice (x * 5)

## Objectif
Étendre l'application pour que le serveur effectue une multiplication par 5 sur un entier envoyé par le client. Gérer les entiers négatifs et permettre plusieurs requêtes successives jusqu'à ce que l'utilisateur saisisse 0.

## Étape 1 : Version à une seule requête (Server2 / Client2)

### Code Source
#### Server2.java
![Server2 Code](screenshots/a12_server2_code.png)

#### Client2.java
![Client2 Code](screenshots/a12_client2_code.png)

### Tests et Résultats
#### Test avec un entier positif (x = 7)
![Client 7](screenshots/a12_client2_7.png)
![Serveur 7](screenshots/a12_server2_7.png)

#### Test avec un entier négatif (x = -3)
*Note : L'utilisation de `DataInputStream` et `DataOutputStream` permet de gérer correctement les entiers négatifs (4 octets, signe compris).*
![Client -3](screenshots/a12_client2_m3.png)
![Serveur -3](screenshots/a12_server2_m3.png)

#### Test avec zéro (x = 0)
![Client 0](screenshots/a12_client2_0.png)
![Serveur 0](screenshots/a12_server2_0.png)

---

## Étape 2 : Version avec boucle (Server3 / Client3)

### Code Source
#### Server3.java
![Server3 Code](screenshots/a12_server3_code.png)

#### Client3.java
![Client3 Code](screenshots/a12_client3_code.png)

### Test complet (Saisie de 7, puis -3, puis 0 pour quitter)
Le client peut saisir plusieurs entiers successivement. La communication s'arrête proprement lorsque l'utilisateur saisit 0.

![Client Boucle](screenshots/a12_client3_run.png)
![Serveur Boucle](screenshots/a12_server3_run.png)

## Interprétation
L'utilisation de `DataInputStream` et `DataOutputStream` permet de transporter correctement les entiers négatifs (4 octets, signe compris).
Dans la version avec boucle, le client peut envoyer plusieurs entiers successivement. Le serveur calcule `x * 5` et renvoie le résultat à chaque fois.
Lorsque le client envoie `0`, les deux boucles s'arrêtent et les sockets sont fermées proprement des deux côtés.