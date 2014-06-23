package com.manpower.services.metier.rest;

import com.manpower.services.metier.domain.FamillePro;
import com.manpower.services.metier.domain.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sbert on 22/06/2014.
 */
@Controller
public class MetierController {

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping("/metier/libelle/{libelle}")
    public @ResponseBody List<Metier> findMetierByLibelle(@PathVariable String libelle) {
        Query query = new Query();
        query.addCriteria(Criteria.where("libelle").regex(".*" + libelle + ".*", "i"));

        return mongoTemplate.find(query, Metier.class);
    }

    @RequestMapping("/metier/qualif/libelle/{libelle}")
    public @ResponseBody List<Metier> findMetierByLibelleQualif(@PathVariable String libelle) {
        Query query = new Query();
        query.addCriteria(Criteria.where("qualification.libelle").regex(".*" + libelle + ".*", "i"));

        return mongoTemplate.find(query, Metier.class);
    }

    @RequestMapping("/metier/qualif/code/{code}")
    public @ResponseBody List<Metier> findMetierByCodeQualif(@PathVariable String code) {
        Query query = new Query();
        query.addCriteria(Criteria.where("qualification.code").is(code));

        return mongoTemplate.find(query, Metier.class);
    }

    @RequestMapping("/appellation/{codeMetier}")
    public @ResponseBody Metier findAppellationMetier(@PathVariable String codeMetier) {
        Query query = new Query();
        query.addCriteria(Criteria
                .where("code").is(codeMetier)
                .and("appellationPrincipale").is(true));

        return mongoTemplate.findOne(query, Metier.class);
    }

    @RequestMapping("/famille")
    public @ResponseBody List<FamillePro> getFamillePro() {
        return mongoTemplate.getCollection("metiers").distinct("famille");
    }

    @RequestMapping(value = "/appellation", method = RequestMethod.POST)
    public @ResponseBody List<Metier> findAppellationMetier(@RequestBody List<String> codeMetiers) {
        Query query = new Query();
        query.addCriteria(Criteria
            .where("code").in(codeMetiers)
            .and("appellationPrincipale").is(true)
        );

        return mongoTemplate.find(query, Metier.class);
    }

}
