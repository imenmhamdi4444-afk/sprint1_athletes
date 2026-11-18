# Sprint 1 - Application de Gestion des Athlètes (Architecture Microservices)

Projet complet basé sur une **architecture orientée services (Microservices)** et une interface client **Angular 20**, adapté du domaine **Produit/Catégorie** vers **Athlète/Équipe**.

---

## Architecture du Projet

```text
sprint1_athletes/
├── athletes-backend/     # Microservice Métier : Gestion des Athlètes & Équipes (Port 8084)
├── users-microservice/   # Microservice Sécurité : Authentification JWT & Utilisateurs (Port 8081)
├── athletes-frontend/    # Client Web : Application Angular 20 Standalone (Port 4200)
└── README.md             # Guide de démarrage de l'infrastructure
```

---

## Composants de l'Architecture

### 1. `athletes-backend` (Service Métier - Spring Boot)
- **Port** : `8084` | **Contexte** : `/athletes`
- **Base de données** : `athletes_DB` (MySQL)
- **Rôle** : Fournit les API REST pour la gestion CRUD des athlètes, des équipes et les recherches avancées.
- **Points d'accès clés** :
  - `GET /athletes/api/all` : Liste de tous les athlètes
  - `POST /athletes/api/addprod` : Ajout d'un athlète
  - `PUT /athletes/api/updateprod` : Modification d'un athlète
  - `DELETE /athletes/api/delprod/{id}` : Suppression d'un athlète
  - `GET /athletes/api/athletesByName/{nom}` : Recherche par nom
  - `GET /athletes/api/athletesequipe/{codeEquipe}` : Recherche par équipe
  - `GET /athletes/eq` : Liste des équipes (Spring Data REST)

### 2. `users-microservice` (Service d'Authentification - Spring Boot)
- **Port** : `8081` | **Contexte** : `/users`
- **Base de données** : `users_db` (MySQL)
- **Rôle** : Gère les utilisateurs, les rôles (`ADMIN`, `USER`) et l'émission des tokens JWT sécurisés (Auth0 `java-jwt`).
- **Points d'accès clés** :
  - `POST /users/login` : Authentification et génération du token JWT dans l'en-tête `Authorization: Bearer <token>`
  - `GET /users/all` : Liste des utilisateurs (réservé `ADMIN`)

### 3. `athletes-frontend` (Client Web - Angular 20)
- **Port** : `4200`
- **Rôle** : Interface utilisateur réactive avec composants Standalone.
- **Fonctionnalités** :
  - CRUD Athlètes et Équipes avec composants `@Input()` et `@Output()` (Atelier 08).
  - Filtres de recherche par nom (pipe personnalisé) et par équipe.
  - Page de connexion, gestion de session `localStorage`, Guards de navigation et contextualisation des actions selon les droits.

---

## Comptes Configurés

| Nom d'utilisateur | Mot de passe | Rôles | Permissions |
| :--- | :--- | :--- | :--- |
| **`admin`** | `123` | `ADMIN`, `USER` | Accès complet (Ajout, Modification, Suppression) |
| **`imen`** | `123` | `USER` | Consultation seule |

---

## Guide de Démarrage

### 1. Bases de données MySQL
Assurez-vous que MySQL est actif (XAMPP ou service local) et créez les deux bases :
```sql
CREATE DATABASE athletes_DB;
CREATE DATABASE users_db;
```

### 2. Démarrage de `users-microservice` (Port 8081)
```bash
cd users-microservice
mvn spring-boot:run
```

### 3. Démarrage de `athletes-backend` (Port 8084)
```bash
cd athletes-backend
mvn spring-boot:run
```

### 4. Démarrage du Client Angular (Port 4200)
```bash
cd athletes-frontend
npm install   # si nécessaire
ng serve
```
Accéder à l'application sur : **`http://localhost:4200`**