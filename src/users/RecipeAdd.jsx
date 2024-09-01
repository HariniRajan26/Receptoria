import React from 'react';
import '../css/EditRecipe.css';

export default function RecipeForm({ recipe, onInputChange, onSubmit }) {

  return (
    <form onSubmit={onSubmit}>
      <div className="form-row mb-2 fs-5">
        <label className="form-label">Recipe Id</label>
        <input
          type="number"
          name="recipeId"
          value={recipe.recipeId}
          onChange={onInputChange}
        />
      </div>
      <div className="form-row mb-2 fs-5">
        <label className="form-label">Recipe Name</label>
        <input
          type="text"
          name="recipeName"
          value={recipe.recipeName}
          onChange={onInputChange}
        />
      </div>
      <div className="form-row mb-2 fs-5">
        <label className="form-label">Description</label>
        <input
          type="text"
          name="description"
          value={recipe.description}
          onChange={onInputChange}
          className="box"
        />
      </div>
      <div className="form-row mb-2 fs-5">
        <label className="form-label">Cuisine</label>
        <input
          type="text"
          name="cuisine"
          value={recipe.cuisine}
          onChange={onInputChange}
          className="box"
        />
      </div>
      <div className="form-row mb-2 fs-5">
        <label className="form-label">Preparation Time (minutes)</label>
        <input
          type="number"
          name="prepTime"
          value={recipe.prepTime}
          onChange={onInputChange}
          className="box"
        />
      </div>
      <div className="form-row mb-4 fs-5">
        <label className="form-label">Serving</label>
            <input
            type="number"
            name="serving"
            value={recipe.serving}
            onChange={onInputChange}
            className="box"
          />
        </div>
      </form>
    );
}
