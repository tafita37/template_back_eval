-- Etat de stock du magasin centrale
    create or replace view v_etat_stock_magasin 
        as
            select 
                laptop.*,
                sum(quantite_laptop_entrant)-sum(quantite_laptop_sortant) as reste_stock,
                date_mouvement
            from
                stock_laptop_magasin
            join 
                laptop
                    on 
                        laptop.id_laptop=stock_laptop_magasin.id_laptop
            group by
                laptop.id_laptop,
                date_mouvement;

-- Etat de stock du point de vente
    create or replace view v_etat_stock_point_vente 
        as
            select 
                laptop.*,
                coalesce(sum(quantite_laptop_entrant)-sum(quantite_laptop_sortant), 0) as reste_stock,
                date_mouvement
            from
                stock_point_vente
            right join 
                laptop
                    on 
                        laptop.id_laptop=stock_point_vente.id_laptop
            group by
                laptop.id_laptop,
                date_mouvement;

-- Reste en stock 
    create or replace view v_reste_stock_magasin   
        as  
            select 
                laptop.*,
                sum(quantite_laptop_entrant)-sum(quantite_laptop_sortant) as reste_stock
            from
                stock_laptop_magasin
            join 
                laptop
                    on 
                        laptop.id_laptop=stock_laptop_magasin.id_laptop
            group by
                laptop.id_laptop;

-- Reste en stock au point de vente
    create or replace view v_reste_stock_laptop_point_vente 
        as
            select 
                id_laptop,
                sum(quantite_laptop_entrant)-sum(quantite_laptop_sortant) as reste_stock,
                date_mouvement
            from
                stock_point_vente
            group by
                id_laptop,
                date_mouvement;

-- Transfert en cours
    create or replace view v_transfert_laptop_en_cours 
        as
            select
                *
            from   
                transfert_laptop
            where 
                etat_transfert=0;

-- User et id point de vente
    create or replace view v_user_id_point_vente
        as 
            select 
                users.*,
                point_vente_users.id_point_vente_users,
                point_vente_users.id_point_vente
            from 
                users   
            join
                point_vente_users
            on 
                point_vente_users.id_users=users.id_users;

-- Nombre de pages d'une marque
    create or replace view v_nb_pages_marque
        as
            select 
                ceil(
                    (
                        select 
                            count(*)::decimal/5 
                        from 
                            marque
                    )
                    ) 
            as nb_page_marque;

-- Nombre de pages d'un processeur
    create or replace view v_nb_pages_processeur
        as
            select 
                ceil(
                        (
                            select 
                                count(*)::decimal/5 
                            from 
                                processeur
                        )
                    ) 
            as nb_page_processeur;

-- Nombre de pages d'un type de ram
    create or replace view v_nb_pages_type_ram
        as
            select 
                ceil(
                        (
                            select 
                                count(*)::decimal/5 
                            from 
                                type_ram
                        )
                    ) 
            as nb_page_type_ram;

-- Nombre de pages d'une ram
    create or replace view v_nb_pages_ram
        as
            select 
                ceil(
                        (
                            select 
                                count(*)::decimal/5 
                            from 
                                ram
                        )
                    ) 
            as nb_page_ram;

-- Nombre de pages d'une type disque
    create or replace view v_nb_pages_type_disque
        as
            select 
                ceil(
                        (
                            select 
                                count(*)::decimal/5 
                            from 
                                type_disque
                        )
                    ) 
            as nb_page_type_disque;

-- Nombre de pages d'un disque
    create or replace view v_nb_pages_disque
        as
            select 
                ceil(
                        (
                            select 
                                count(*)::decimal/5 
                            from 
                                disque
                        )
                    ) 
            as nb_page_disque;

-- Nombre de pages d'un laptop
    create or replace view v_nb_pages_laptop
        as
            select 
                ceil(
                        (
                            select 
                                count(*)::decimal/5 
                            from 
                                laptop
                        )
                    ) 
            as nb_page_laptop;

-- Statistique de vente total par mois par année
    create or replace view v_stat_vente_total_mois 
        as
            select 
                coalesce(sum(vl.quantite_laptop), 0)::integer as quantite_laptop, 
                m.num_mois::integer as num_mois,
                a.annee::integer as annee
            from 
                (
                    select 
                        generate_series(1, 12) as num_mois
                ) m
            cross join 
                (
                    select 
                        distinct extract(year from date_vente_laptop) as annee 
                    from vente_laptop
                ) a
            left join 
                vente_laptop vl 
            on 
                extract(month from vl.date_vente_laptop) = m.num_mois 
                    and 
                extract(year from vl.date_vente_laptop) = a.annee
            group by 
                m.num_mois, a.annee
            order by
                m.num_mois, a.annee;
