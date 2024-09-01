package com.RecipeDatabase.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RecipeDatabase.demo.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer> {

	
	//Derived queries
	public List<Recipe> findByCategoryId(int categoryId);
	
	
	//Positional
	@Query("select r from Recipe r where r.cuisine=?1 and r.recipeName=?2")
	public List<Recipe> getRecipeByCuisine(String cuisine,String recipeName);
	
	
	//Named
	@Query("select r from Recipe r where r.cuisine=:cuisine")
	public List<Recipe> getRecipeByCuisine(String cuisine);
	
	//Native
	@Query(value="select * from Recipe r where r.serving=?1",nativeQuery=true)
	public List<Recipe> fetchRecipeByServing(int serving);

	//DML
	@Modifying
	@Query("delete from Recipe r where r.recipeName=?1" )
	public int deleteRecipeByName(String recipeName);
	
//	@Modifying
//	@Query("delete from Recipe r where r.ingretientName=?1" )
//	public int deleteIngreByName(String ingretientName);
	
	@Modifying
	@Query("update Recipe r set r.cuisine=?1 where r.recipeName=?2")
	public int updateRecipeByName(String cuisine,String recipeName);
	
	

}
