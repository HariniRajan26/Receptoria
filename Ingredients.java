package com.RecipeDatabase.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ingredients {

	@Id
	private int id;
	private String IngredientName;
	private float quantity;
	private String type;
	private String unit;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getIngredientName() {
		return IngredientName;
	}
	public void setIngredientName(String ingredientName) {
		IngredientName = ingredientName;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
//	public List<Recipe> getRecipe() {
//		return recipe;
//	}
//	public void setRecipe(List<Recipe> recipe) {
//		this.recipe = recipe;
//	}
	
	
	
}
