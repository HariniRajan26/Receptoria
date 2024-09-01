import axios from 'axios';
import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
// import '../css/EditRecipe.css';
import RecipeAdd from './RecipeAdd';
import '../css/Form.css';

export default function AddRecipe() {
  const navigate = useNavigate();

  const [recipe, setRecipe] = useState({
    recipeName: '',
    description: '',
    cuisine: '',
    prepTime: 0,
    serving: 0,
  });

  const addRecipe = async () => {
    try {
      await axios.post('http://localhost:8080/saveRecipe', recipe);
      navigate('/recipe');
    } catch (error) {
      console.error(error);
    }
  };

  const handleInputChange = (e) => {
    setRecipe({ ...recipe, [e.target.name]: e.target.value });
  };

    
  const {recipeId}=recipe;
  
  const onSubmit = async (e) => {
    e.preventDefault();
    try {
        
      if (recipeId===0) {
        console.log('Please enter Recipe details');
        alert("Please enter Recipe details");
        return;
      }
    } catch (error) {
      console.error('error:', error);
    }
  };


  return (
    <div className='style'>
    <div  className="styling container mt-5">
      <div className="row ">
        <div className="col-md-6 offset-md-3 pr-6">
          <h2 className="text-center m-3 fs-1">Add🙃Recipe</h2>
          <RecipeAdd recipe={recipe} onInputChange={handleInputChange} onSubmit={onSubmit} />
          <div className="form-row">
            <button type="submit" className="btn btn-outline-primary center m-4 fs-5" onClick={addRecipe}>
              Add Recipe
            </button>
            <Link to="/recipe" className="btn btn-outline-danger m-4 fs-5">
              Cancel
            </Link>
          </div>
        </div>
      </div>
    </div>
   </div>
  );
}
