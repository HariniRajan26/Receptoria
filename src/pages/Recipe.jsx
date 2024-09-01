import React, { useEffect, useState } from 'react'
import AllRecipes from './AllRecipes';
import '../css/Recipe.css';
import { Link } from 'react-router-dom';

export default function Recipe() {

   const [recipes, setRecipes] = useState([]);

   useEffect(() => {
    getRecipes();
   }, []);


   const getRecipes = async () => {
    try {
      const response = await fetch('http://localhost:8080/fetchRecipe');
      if (response.ok) {
        const data = await response.json();
        setRecipes(data);
        console.log(data)
        // console.log(recipes)
      } else {
        console.error('Error response:', response);
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };

  

  return (
    <div className='color'>
            <Link 
          className='btn mt-5 search-button'
          to={'/addRecipe'}
          >
            <h5 className='center'>Add New Recipes </h5></Link>
        <form className='search-form'>
            {/* <input className='search-bar' type='text'/>
            <button className='search-button' type='submit'>
                Search
            </button> */}
            <div className='recipes'>
            {recipes && recipes.length > 0 && recipes.map((recipe) => (
            <AllRecipes
            key={recipe.recipeId}
            recipeId={recipe.recipeId}
            description={recipe.description}
            title={recipe.recipeName}
            cuisine={recipe.cuisine}
            image={recipe.img}
            ingredients={recipe.ingredientsInfo}
            />
            ))}

              </div>
        </form>
    </div>
  )
}
