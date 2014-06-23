package com.manpower.services.metier.repository;

import com.manpower.services.metier.domain.Metier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by sbert on 21/06/2014.
 */
@RepositoryRestResource(collectionResourceRel = "metiers", path = "metiers")
public interface MetierRepository extends MongoRepository<Metier, String> {

    @RestResource(path = "code", rel = "metier.code")
    Page<Metier> findByCode(@Param("code") String code, Pageable pageable);

    List<Metier> findByLibelle(@Param("libelle") String libelle);

    @Override
    @RestResource(exported = false)
    <S extends Metier> List<S> save(Iterable<S> entites);

    @Override
    @RestResource(exported = false)
    <S extends Metier> S save(S entity);

    @Override
    @RestResource(exported = false)
    void delete(String s);

    @Override
    @RestResource(exported = false)
    void delete(Metier entity);

    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends Metier> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
