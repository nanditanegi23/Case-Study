package com.ibm.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

	private static final long serialVersionUID = 4887904943282174032L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NaturalId
    @NotEmpty
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private boolean active;
    private String role;

}
