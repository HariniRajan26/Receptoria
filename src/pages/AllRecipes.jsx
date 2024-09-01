import React from 'react';
import '../css/AllRecipes.css';
import { Link } from 'react-router-dom';

export default function AllRecipes({ recipeId, title, description, cuisine, image, ingredients }) {
  return (
    // <Link className='recipe' to={`/inrecipe/${recipeId}`}>
    
    <div className='recipe' >
      <div><h3>{title}</h3></div>
      <div><h6>{description}</h6></div>
      <div><img className='recipe-image' src={image} alt={title} /></div>
      <div > <h4>Ingredients with type :</h4>
        {ingredients && Array.isArray(ingredients) && (
          <ol className="list-unstyled">
            {ingredients.map((ingredient) => (
              <React.Fragment key={ingredient.id}>
              <li className='m-2'>{ingredient.ingredientName} : {ingredient.type}</li>
            </React.Fragment>
            ))}
          </ol>
        )}
      </div>
      <div > <h4>Cuisine :</h4><h5>{cuisine}</h5></div>
      <div>
        
        <Link 
          className='btn btn-info mx-2'
          to={`/editRecipe/${recipeId}`}
          >
            Edit</Link>
          <Link className='btn btn-danger mx-2'
          to={`/deleteRecipe/${recipeId}`}
          >
            Delete</Link></div>
    </div>
    // </Link>
  );
}
