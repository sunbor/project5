package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="digimon")
@Component
public class Digimon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="digimon_seq_gen")
	@SequenceGenerator(name="digimon_seq_gen", sequenceName="digimon_id_seq")
	@Column(name = "digimon_id")
	private int digimonId;
	
	@Column(nullable=false)
	private String digimonName;
	
	@Column(nullable=false)
	private String imgUrl;
	
	@Column(nullable=false)
	private String digimonLevel;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="User_FK")
	private User partner;

	public Digimon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Digimon(int digimonId, String digimonName, String imgUrl, String digimonLevel, User partner) {
		super();
		this.digimonId = digimonId;
		this.digimonName = digimonName;
		this.imgUrl = imgUrl;
		this.digimonLevel = digimonLevel;
		this.partner = partner;
	}

	public int getDigimonId() {
		return digimonId;
	}

	public void setDigimonId(int digimonId) {
		this.digimonId = digimonId;
	}

	public String getDigimonName() {
		return digimonName;
	}

	public void setDigimonName(String digimonName) {
		this.digimonName = digimonName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDigimonLevel() {
		return digimonLevel;
	}

	public void setDigimonLevel(String digimonLevel) {
		this.digimonLevel = digimonLevel;
	}

	public User getPartner() {
		return partner;
	}

	public void setPartner(User partner) {
		this.partner = partner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + digimonId;
		result = prime * result + ((digimonLevel == null) ? 0 : digimonLevel.hashCode());
		result = prime * result + ((digimonName == null) ? 0 : digimonName.hashCode());
		result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
		result = prime * result + ((partner == null) ? 0 : partner.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Digimon other = (Digimon) obj;

		if (digimonId != other.digimonId)
			return false;
		if (digimonLevel == null) {
			if (other.digimonLevel != null)
				return false;
		} else if (!digimonLevel.equals(other.digimonLevel))
			return false;
		if (digimonName == null) {
			if (other.digimonName != null)
				return false;
		} else if (!digimonName.equals(other.digimonName))
			return false;
		if (imgUrl == null) {
			if (other.imgUrl != null)
				return false;
		} else if (!imgUrl.equals(other.imgUrl))
			return false;
		if (partner == null) {
			if (other.partner != null)
				return false;
		} else if (!partner.equals(other.partner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Digimon [digimonId=" + digimonId + ", digimonName=" + digimonName + ", imgUrl=" + imgUrl
				+ ", digimonLevel=" + digimonLevel + ", partner=" + partner + "]";
	}
}
