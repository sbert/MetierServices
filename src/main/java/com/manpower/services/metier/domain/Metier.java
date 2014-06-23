package com.manpower.services.metier.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author 0027125
 */
@Document(collection = "metiers")
public class Metier {

    @Id
    private String id;

	private String code;

	private String libelle;

	private Qualification qualification;

	private FamillePro famille;

	private String division;

	private boolean appellationPrincipale;

	public Metier() {
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelleMetier) {
		this.libelle = libelleMetier;
	}

	public FamillePro getFamille() {
		return famille;
	}

	public void setFamille(FamillePro famille) {
		this.famille = famille;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String divisionMetier) {
		this.division = divisionMetier;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isAppellationPrincipale() {
		return appellationPrincipale;
	}

	public void setAppellationPrincipale(boolean appellationPrincipale) {
		this.appellationPrincipale = appellationPrincipale;
	}
}
