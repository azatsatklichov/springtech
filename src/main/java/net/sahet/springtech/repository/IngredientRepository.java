package net.sahet.springtech.repository;

import org.springframework.data.repository.CrudRepository;

import net.sahet.springtech.domain.Ingredient;
 

public interface IngredientRepository 
         extends CrudRepository<Ingredient, String> {

}
