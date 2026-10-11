# Activité 1-1 : Première connexion Client/Serveur

## Objectif
Établir une connexion TCP entre un client et un serveur en Java.

## Code
### Server.java
![Code serveur](screenshots/a11_server_code.png)

### Client.java
![Code client](screenshots/a11_client_code.png)

## Exécution
### 1. Serveur en attente
![Serveur en attente](screenshots/a11_server_waiting.png)

### 2. Client connecté
![Client connecté](screenshots/a11_client_connected.png)

### 3. Serveur après connexion
![Serveur après connexion](screenshots/a11_server_after.png)

## Interprétation
Le serveur démarre, se met en écoute sur le port 1234 et bloque sur `accept()`.
Le client se connecte au serveur via `localhost:1234`.
Dès que la connexion est acceptée, les deux programmes affichent leur message, puis ferment les sockets proprement.

## Test avec une adresse IP
Nous avons remplacé `localhost` par `127.0.0.1`.
![Test IP](screenshots/a11_ip_test.png)
Le comportement reste identique : la connexion s'établit correctement.
