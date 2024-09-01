import React from 'react';
import '../css/Recipe.css';

export default function InRecipes({ title, cuisine, image, ingredients }) {
  return (
    <div>
      <div className='recipe'>
        <h4>{title}</h4>
      </div>
      <div>
        {ingredients && Array.isArray(ingredients) && (
          <ol>
            {ingredients.map((ingredient) => (
              <li key={ingredient.id}>{ingredient.ingredientName}</li>
            ))}
          </ol>
        )}
      </div>
      <div>
        <img className='recipe-image' src={image} alt={title} />
      </div>
      <div>
        <p>{cuisine}</p>
      </div>
    </div>
  );
}
