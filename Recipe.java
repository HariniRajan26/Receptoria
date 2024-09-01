package com.RecipeDatabase.demo.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Recipe {

	@Id
	private int recipeId;
	private int categoryId;
	private String recipeName;
	private String description;
	private String cuisine;
	private int prepTime;
	private int serving;
	private String img;
	

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
 	private List<Ingredients> ingredientsInfo;
	
	public Recipe() {
		super();
	}

	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public int getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}
	public int getServing() {
		return serving;
	}
	public void setServing(int serving) {
		this.serving = serving;
	}

	public List<Ingredients> getIngredientsInfo() {
		return ingredientsInfo;
	}

	public void setIngredientsInfo(List<Ingredients> ingredientsInfo) {
		this.ingredientsInfo = ingredientsInfo;
	} 

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	
	
	
}
