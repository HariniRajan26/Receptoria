package com.RecipeDatabase.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.RecipeDatabase.demo.model.Login;
import com.RecipeDatabase.demo.model.Recipe;
import com.RecipeDatabase.demo.model.Registration;
import com.RecipeDatabase.demo.repository.LoginRepository;
import com.RecipeDatabase.demo.repository.RecipeRepository;
import com.RecipeDatabase.demo.repository.RegistrationRepository;

import jakarta.transaction.Transactional;

@Service
public class RecipeService {

	@Autowired
	RecipeRepository recipeRepository;
	@Autowired
	RegistrationRepository regRepository;
	@Autowired
	LoginRepository loginRepository;
	
	public List<Recipe> getAllRecipe()
	{
		List <Recipe> studList=recipeRepository.findAll();
		return studList;
	}

	public Recipe getById(int recipeId) 
	{
		return recipeRepository.findById(recipeId).get();
	}
	
	public Recipe saveRecipe(Recipe r) 
	{
		Recipe obj = recipeRepository.save(r);
		return obj;
	}
	
//	public Recipe updateRecipe(Recipe r, @PathVariable int regno) 
//	{
//		return recipeRepository.save(r);
//	}
	
	public Recipe updateRecipe(Recipe r, int recipeId) 
	{
		Optional<Recipe> optional=recipeRepository.findById(recipeId);
		Recipe obj=null;
		if(optional.isPresent())
		{
			obj=optional.get();
			obj.setRecipeId(r.getRecipeId());
			obj.setCategoryId(r.getCategoryId());
			obj.setRecipeName(r.getRecipeName());
			obj.setDescription(r.getDescription());
			obj.setCuisine(r.getCuisine());
			obj.setPrepTime(r.getPrepTime());
			obj.setServing(r.getServing());
			obj.setIngredientsInfo(r.getIngredientsInfo());
			obj.setImg(r.getImg());
			recipeRepository.saveAndFlush(r);
		}
		return obj;
	}

	public void deleteRecipe(int recipeId) 
	{
		recipeRepository.deleteById(recipeId);
	}

	public Recipe getRecipe(int recipeId) 
	{
		return recipeRepository.findById(recipeId).get();
	}

	public List<Recipe> sortRecipe(String field) {
		
		return recipeRepository.findAll(Sort.by(field));
//		return recipeRepository.findAll(Sort.by(Direction.DESC,field));
	}
	
	public List<Recipe> pagingRecipes(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset, pageSize);
		Page<Recipe> recipeData=recipeRepository.findAll(paging);
		List<Recipe> recipeList=recipeData.getContent();//show the List of page
		return recipeList;
		
	}

	public Page<Recipe> pagingRecipe(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset, pageSize);
		Page<Recipe> recipeData=recipeRepository.findAll(paging);
		return recipeData;
	}
	
	public List<Recipe> pagingAndSortingRecipe(int offset,int pageSize,String field) 
	{
//		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(field));
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(Direction.DESC,field));
		Page<Recipe> recipes=recipeRepository.findAll(paging);
		return recipes.getContent();
	}
	
	//Derived queries
	public List<Recipe> findByCategoryId(int categoryId)
	{
		return recipeRepository.findByCategoryId(categoryId);
	}
	
	
	//Query positional
	public List<Recipe> getRecipeByCuisine(String cuisine, String recipeName)
	{
		return recipeRepository.getRecipeByCuisine(cuisine, recipeName);
	}

	
	//named
	public List<Recipe> getRecipeByCuisine(String cuisine)
	{
		return recipeRepository.getRecipeByCuisine(cuisine);
	}
	
	
	//native
	public List<Recipe> fetchRecipeByServing(int serving)
	{
		return recipeRepository.fetchRecipeByServing(serving);
	}
	
	
	//DML
	@Transactional
	public int deleteRecipeByName(String recipeName)
	{
		return recipeRepository.deleteRecipeByName(recipeName);
	}
	
//	@Transactional
//	public int deleteIngreByName(String ingredientName)
//	{
//		return recipeRepository.deleteIngreByName(ingredientName);
//	}
	
	@Transactional
	public int updateRecipeByName(String cuisine, String recipeName)
	{
		return recipeRepository.updateRecipeByName(cuisine,recipeName);
	}
	

	
	
	
	
	//For Login
	public List<Login> getUser() 
	{
		return loginRepository.findAll();
	}
	
	public Login getByUser(int userId) 
	{
		return loginRepository.findById(userId).get();
	}
	
	public Login saveUser(Login l)
	{
		return loginRepository.save(l); 
	}
	
	public String validateUser(String username,String password)
	{
//		String result="";
		Login l=loginRepository.findByUsername(username);
		if(l==null)
		{
			return "Invalid user";
		}
		else
		{
			if(l.getPassword().equals(password))
			{
				return "Login success";
			}
			else
			{
				return "Login failed";
			}
		}
//		return "Invalid";
	}
	
	public Login updateUser(Login l, int userId) 
	{
		Optional<Login> optional=loginRepository.findById(userId);
		Login obj=null;
		if(optional.isPresent())
		{
			obj=optional.get();
			obj.setUserId(l.getUserId());
			obj.setUsername(l.getUsername());
			obj.setPassword(l.getPassword());
			loginRepository.saveAndFlush(l);
		}
		return obj;
	}
	
	public void deleteUser(int userId) 
	{
		loginRepository.deleteById(userId);
		
	}
	
	
	
	
	
	
	//For registration
	public List<Registration> getReg() 
	{
		List<Registration> regList = regRepository.findAll();
		return regList;
	}

	public Registration saveReg(Registration r) 
	{
		return regRepository.save(r);
	}
	
    public List<Registration> sortReg(String field) {
		
		return regRepository.findAll(Sort.by(field));
//		return regRepository.findAll(Sort.by(Direction.DESC,field));
	}
	
	public List<Registration> pagingRegs(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset, pageSize);
		Page<Registration> regData=regRepository.findAll(paging);
		List<Registration> regList=regData.getContent();//show the List of page
		return regList;
		
	}

	public Page<Registration> pagingReg(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset, pageSize);
		Page<Registration> regData=regRepository.findAll(paging);
		return regData;
	}
	
	public List<Registration> pagingAndSortingReg(int offset,int pageSize,String field) 
	{
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(Direction.DESC,field));
		Page<Registration> recipes=regRepository.findAll(paging);
		return recipes.getContent();
	}



	
}
