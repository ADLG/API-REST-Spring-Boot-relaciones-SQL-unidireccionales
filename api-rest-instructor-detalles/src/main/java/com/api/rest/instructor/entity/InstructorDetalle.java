package com.api.rest.instructor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor_detalles")
public class InstructorDetalle
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "canal_youtube")
	private String canalYoutube;

	@Column(name = "pasa_tiempo")
	private String pasaTiempo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCanalYoutube() {
		return canalYoutube;
	}

	public void setCanalYoutube(String canalYoutube) {
		this.canalYoutube = canalYoutube;
	}

	public String getPasaTiempo() {
		return pasaTiempo;
	}

	public void setPasaTiempo(String pasaTiempo) {
		this.pasaTiempo = pasaTiempo;
	}
	
}
