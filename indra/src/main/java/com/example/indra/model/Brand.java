package com.example.indra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Builder
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brand")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "El nombre no puede estar vacio")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 1, max = 250, message = "El tamaño del nombre debe estar entre 1 y 250")
    @Column(name = "name")
    private String name;

}
