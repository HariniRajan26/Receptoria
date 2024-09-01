import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import '../css/EditRecipe.css';

export default function RecipeForm({ recipe, onUpdate }) {
  const [updatedRecipe, setUpdatedRecipe] = useState(recipe);

  const handleChange = (e) => {
    setUpdatedRecipe({ ...updatedRecipe, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onUpdate(updatedRecipe);
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="form-row mb-2 fs-5">
        <label className="form-label">Recipe Name</label>
        <input
          type="text"
          name="recipeName"
          value={updatedRecipe.recipeName}
          onChange={handleChange}
        />
      </div>
      <div className="form-row mb-2 fs-5">
        <label className="form-label">Description</label>
        <input
          type="text"
          name="description"
          value={updatedRecipe.description}
          onChange={handleChange}
          className="box"
        />
      </div>
      <div className="form-row mb-2 fs-5">
        <label className="form-label">Cuisine</label>
        <input
          type="text"
          name="cuisine"
          value={updatedRecipe.cuisine}
          onChange={handleChange}
          className="box"
        />
      </div>
      <div className="form-row mb-2 fs-5">
        <label className="form-label">Preparation Time (minutes)</label>
        <input
          type="number"
          name="prepTime"
          value={updatedRecipe.prepTime}
          onChange={handleChange}
          className="box"
        />
      </div>
      <div className="form-row mb-2 fs-5">
        <label className="form-label">Serving</label>
        <input
          type="number"
          name="serving"
          value={updatedRecipe.serving}
          onChange={handleChange}
          className="box"
        />
      </div>
      <div className="form-row center">
        <button type="submit" className="btn btn-outline-primary m-4 fs-5">Update Recipe</button>
        <Link to="/recipe" className="btn btn-outline-danger m-4 fs-5">Cancel</Link>
      </div>
    </form>
  );
}
