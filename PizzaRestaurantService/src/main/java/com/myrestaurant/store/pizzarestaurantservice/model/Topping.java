package com.myrestaurant.store.pizzarestaurantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//getter e setter
@Getter
@Setter
//costrututtori
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
//entita su db
@Entity
@Table(name = "toppings")
public class Topping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topping_id")
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "toppings")
    @JsonIgnore
    private Set<Pizza> pizzas = new HashSet<Pizza>();

}
