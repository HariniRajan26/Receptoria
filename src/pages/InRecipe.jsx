import React, { useEffect, useState } from 'react';
import '../css/Recipe.css';
import InRecipes from './InRecipes';
import { useParams } from 'react-router-dom';

export default function InRecipe() {
  const [recipes, setRecipes] = useState([]);
  const { recipeId } = useParams();

  useEffect(() => {
    console.log('Calling getRecipes...');
    getRecipes(recipeId);
  }, [recipeId]);

  const getRecipes = async (recipeId) => {
    console.log('Recipe ID:', recipeId);
    try {
      const response = await fetch(`http://localhost:8080/fetchbyid/${recipeId}`);
      if (response.ok) {
        const data = await response.json();
        console.log('API Response:', data);
        setRecipes(data);
        console.log('Recipes:', data);
      } else {
        console.error('Error response:', response);
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <div>
      <div>
        {recipes && recipes.length > 0 ? (
          recipes.map((recipe) => (
            <InRecipes
              key={recipe.recipeId}
              recipeId={recipe.recipeId}
              title={recipe.recipeName}
              cuisine={recipe.cuisine}
              image={recipe.img}
              ingredients={recipe.ingredientsInfo}
            />
          ))
        ) : (
          <p>No recipes found.</p>
        )}
      </div>
    </div>
  );
}
