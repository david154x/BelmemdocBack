package com.drr.BelmemdocApiRest.business.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "menu")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_menu")
	private Integer idMenu;
	
	@OneToMany
	@JoinTable(name = "menu_roles",
			   joinColumns = @JoinColumn(name = "id_menu"),
			   inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private List<RolesEntity> rolesEntity;

    @Column(name = "de_nomb", nullable = false)
	private String nombre;
    
    @Column(name = "url", nullable = false)
	private String rutaURL;
    
    @Column(name = "id_acti", columnDefinition = "varchar(1)", nullable = false)
	private String idActivo;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="fe_crea", nullable = false)
	private Date fechaCreacion;
    
}
