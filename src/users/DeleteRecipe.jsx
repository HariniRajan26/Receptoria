import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import '../css/Form.css';

export default function DeleteRecipe() {
  const navigate = useNavigate();
  const { recipeId } = useParams();

  const [recipe, setRecipe] = useState({
    recipeName: "",
    // image: "",
    // ingredientsName: "",
    // type: "",
    cuisine: "",
  });

  const { recipeName, cuisine } = recipe;

  const onInputChange = (e) => {
    setRecipe({ ...recipe, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    loadRecipe();
  });

  const onSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.delete(`http://localhost:8080/deleteRecipe/${recipeId}`, recipe);
      navigate("/recipe");
    } catch (error) {
      console.error(error);
    }
  };

  const loadRecipe = async () => {
    try {
      const result = await axios.get(`http://localhost:8080/fetchbyid/${recipeId}`);
      setRecipe(result.data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="style">
    <div className="styling container">
      <div className="row">
        <div className="col-md-6 offset-md-3">
          <h2 className="text-center m-3 fs-1">Delete Recipe 😞</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-4 fs-5">
              <label htmlFor="userId" className="form-label">
                Recipe Id
              </label>
              <input
                type="number"
                className="form-control"
                placeholder="Enter your Id"
                name="recipeId"
                value={recipeId}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3 fs-5">
              <label htmlFor="username" className="form-label">
                Recipe Name
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Enter your Name"
                name="recipeName"
                value={recipeName}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3 fs-5">
              <label htmlFor="username" className="form-label">
                Cuisine
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Enter your Name"
                name="cuisine"
                value={cuisine}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <button type="submit" className="btn btn-outline-primary m-4 fs-5">
              Delete
            </button>
            <Link className="btn btn-outline-danger m-4 fs-5" to={"/recipe"}>
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
    </div>
  );
}
