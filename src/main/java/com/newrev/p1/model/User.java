package com.newrev.p1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
		@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;

	private String password;
	
	private Role role;

	@JsonIgnore
	@OneToMany(mappedBy = "user",
			fetch = FetchType.LAZY)
	private List<Order> orders;


	/*@JsonIgnore
	@OneToOne(mappedBy = "user",
			fetch = FetchType.LAZY)
	private Cart cart;*/


	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Cart cart;
}
