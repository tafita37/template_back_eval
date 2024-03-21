-- Database
    -- Mikolo
        create database mikolo;
        \c mikolo

-- Tables
    -- magasin_user
        create table magasin_user(
            id_magasin_user serial primary key,
            nom_magasin_user varchar(30) unique not null,
            mdp text not null,
            role text
        );

    -- Marque
        create table marque(
            id_marque serial primary key,
            nom_marque varchar(30) unique not null
        );

    -- Processeur
        create table processeur(
            id_processeur serial primary key,
            nom_processeur varchar(30) unique not null,
            frequence double precision,
            nb_coeur double precision
        );

    -- Type de ram
        create table type_ram(
            id_type_ram serial primary key,
            nom_type_ram varchar(30) unique not null
        );

    -- Ram
        create table ram(
            id_ram serial primary key,
            capacite double precision,
            frequence double precision,
            id_type_ram int references type_ram(id_type_ram)
        );

    -- Type de disque dur
        create table type_disque(
            id_type_disque serial primary key,
            nom_type_disque varchar(30) unique not null
        );

    -- Disque dur
        create table disque(
            id_disque serial primary key,
            capacite double precision,
            vitesse double precision,
            id_type_disque int references type_disque(id_type_disque)
        );

    -- Laptop
        create table laptop(
            id_laptop serial primary key,
            model varchar(20) unique not null,
            id_marque int references marque(id_marque),
            id_processeur int references processeur(id_processeur),
            id_ram int references ram(id_ram),
            taille_ecran double precision,
            id_disque int references disque(id_disque),
            prix_achat double precision not null default 0,
            prix_vente double precision not null default 0
        );

    -- User
        create table users(
            id_users serial primary key,
            nom_users varchar(30) not null,
            prenom_users varchar(30) not null,
            email_users varchar(30) not null unique,
            dtn_users date not null,
            mdp_users text not null,
            role text,
            unique(nom_users, prenom_users)
        );

    -- Point de vente
        create table point_vente(
            id_point_vente serial primary key,
            nom_point_vente varchar(30) unique not null
        );

    -- User et point de vente
        create table point_vente_users(
            id_point_vente_users serial primary key,
            id_point_vente int references point_vente(id_point_vente) not null,
            id_users int references users(id_users) not null,
            date_debut_affectation date not null,
            date_fin_affectation date,
            unique(id_point_vente, id_users, date_debut_affectation)
        );

    -- Stock du magasin centrale
        create table stock_laptop_magasin(
            id_stock_laptop_magasin serial primary key,
            id_laptop int references laptop(id_laptop) not null,
            quantite_laptop_entrant double precision not null,
            quantite_laptop_sortant double precision not null,
            date_mouvement date not null,
            prix_achat double precision not null,
            prix_vente double precision not null
        );

    -- Transfert de laptop
        create table transfert_laptop(
            id_transfert_laptop serial primary key,
            id_point_vente int references point_vente(id_point_vente) not null,
            id_laptop int references laptop(id_laptop) not null,
            quantite_laptop double precision not null,
            date_transfert date not null,
            etat_transfert int default 0
        );

    -- Reception de laptop
        create table reception_laptop(
            id_reception_laptop serial primary key,
            id_transfert_laptop int references transfert_laptop(id_transfert_laptop),
            quantite_recu int,
            date_reception date not null
        );

    -- Renvoie de laptop
        create table renvoie_laptop(
            id_renvoie_laptop serial primary key,
            id_laptop int references laptop(id_laptop) not null,
            id_point_vente int references point_vente(id_point_vente) not null,
            quantite_laptop int not null,
            date_renvoie_laptop date not null,
            etat_renvoie_laptop int not null default 0
        );

    -- Reception de renvoie laptop
        create table reception_renvoie_laptop(
            id_reception_renvoie_laptop serial primary key,
            id_renvoie_laptop int references renvoie_laptop(id_renvoie_laptop),
            quantite_recu int,
            date_reception date not null
        );

    -- Stock d'un point de vente
        create table stock_point_vente(
            id_stock_point_vente serial primary key,
            id_point_vente int references point_vente(id_point_vente) not null,
            id_laptop int references laptop(id_laptop) not null,
            quantite_laptop_entrant double precision not null,
            quantite_laptop_sortant double precision not null,
            date_mouvement date not null,
            prix_achat double precision not null,
            prix_vente double precision not null
        );

    -- Vente de laptop
        create table vente_laptop(
            id_vente_laptop serial primary key,
            id_laptop int references laptop(id_laptop) not null,
            id_point_vente int references point_vente(id_point_vente),
            date_vente_laptop date not null,
            quantite_laptop int not null,
            prix_vente double precision not null
        );