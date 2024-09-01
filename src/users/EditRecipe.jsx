import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import RecipeForm from './RecipeForm';
import '../css/ExistUser.css';

export default function EditRecipe() {
  const navigate = useNavigate();
  const { recipeId } = useParams();

  const [recipe, setRecipe] = useState(null);

  
  const loadRecipe = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/fetchbyid/${recipeId}`);
      setRecipe(response.data);
    } catch (error) {
      console.error(error);
    }
  };
  
  useEffect(() => {
    loadRecipe();
  });

  const updateRecipe = async (updatedRecipe) => {
    try {
      await axios.put(`http://localhost:8080/updateRecipe/${recipeId}`, updatedRecipe);
      navigate("/recipe");
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className='style'>
    <div className="styling container ">
      <div className="row">
        <div className="col-md-6 offset-md-3 ">
          {recipe ? (
            <>
              <h2 className="text-center m-3 fs-1">Edit Recipe</h2>
              <RecipeForm recipe={recipe} onUpdate={updateRecipe} />
              {/* <Link to="/recipe" className="btn btn-secondary mt-3">Cancel</Link> */}
            </>
          ) : (
            <p>Loading recipe...</p>
          )}
        </div>
      </div>
    </div>
    </div>
  );
}
