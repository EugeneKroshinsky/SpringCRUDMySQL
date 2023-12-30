package com.example.accessingdatamysql.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "contacts")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String name;

	private String number;
}
