package com.RecipeDatabase.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RecipeDatabase.demo.model.Login;
import com.RecipeDatabase.demo.model.Recipe;
import com.RecipeDatabase.demo.model.Registration;
import com.RecipeDatabase.demo.service.RecipeService;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin //("http://localhost:3000")
@RestController
public class RecipeController {

	@Autowired
	RecipeService recipeService;
	
	@Tag(name= "Get", description="get data")
	@GetMapping(value="/fetchRecipe")
	public List<Recipe> getAllRecipe()
	{
		List<Recipe> studList=recipeService.getAllRecipe();
		return studList;
	}
	
	@GetMapping(value="/fetchbyid/{recipeId}")
	public Recipe getById(@PathVariable int recipeId)
	{
		return recipeService.getById(recipeId);
	}
	
	//http://localhost:9080/saveStudent
	
	@Tag(name= "Post", description="post data")
	@PostMapping(value="/saveRecipe")
	public Recipe saveRecipe(@RequestBody Recipe r)
	{
		return recipeService.saveRecipe(r);
		
	}
	
	@Tag(name= "Put", description="update data")
	@PutMapping(value="/updateRecipe/{recipeId}")
	public Recipe updateRecipe(@RequestBody Recipe r, @PathVariable int recipeId)
	{
		return recipeService.updateRecipe(r,recipeId);
		
	}
	
	@Tag(name= "Delete", description="delete Recipe")
	@DeleteMapping("/deleteRecipe/{recipeId}")
	public void deleteRecipe(@PathVariable("recipeId") int recipeId)
	{
		recipeService.deleteRecipe(recipeId);
		
	}
	
	@GetMapping(value="/sortRecipe/{field}")
	public List<Recipe> sortRecipe(@PathVariable String field)
	{
		return recipeService.sortRecipe(field);
	}

	
	@GetMapping("/pagingRecipes/{offset}/{pageSize}")
	public List<Recipe> pagingRecipes(@PathVariable int offset, @PathVariable int pageSize)
	{
		return recipeService.pagingRecipes(offset,pageSize);
	}
	
	@GetMapping("/pagingRecipe/{offset}/{pageSize}")
	public Page<Recipe> pagingRecipe(@PathVariable int offset, @PathVariable int pageSize)
	{
		return recipeService.pagingRecipe(offset,pageSize);
	}
	
	@GetMapping("/pagingAndSortingRecipe/{offset}/{pageSize}/{field}")
	public List<Recipe> pagingAndSortingRecipe(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return recipeService.pagingAndSortingRecipe(offset,pageSize,field);
	}
	
	

	//derived queries
	@GetMapping("/getBycategory/{categoryId}")
	public List<Recipe> findByCategoryId(@PathVariable int categoryId)
	{
		return recipeService.findByCategoryId(categoryId);
	}
		
		
	//Query positional
	@GetMapping("/getRecipeByCuisine/{cuisine}/{recipeName}")
	public List<Recipe> getRecipeByCuisine(@PathVariable String cuisine,@PathVariable String recipeName)
	{
		return recipeService.getRecipeByCuisine(cuisine, recipeName);
	}
		

		

	//Named
	@GetMapping("/getByCuisine/{cuisine}")
	public List<Recipe> getRecipeByCuisine(@PathVariable String cuisine)
	{
		return recipeService.getRecipeByCuisine(cuisine);
	}
		
		
	//native
	@GetMapping("/getByServing/{serving}")
	public List<Recipe> fetchRecipeByServing(@PathVariable int serving)
	{
		return recipeService.fetchRecipeByServing(serving);
	}
		
		
	//DML
	@DeleteMapping("/deleteRecipeByName/{recipeName}")
	public String deleteRecipeByName(@PathVariable String recipeName)
	{
		int result=recipeService.deleteRecipeByName(recipeName);
		if(result>0)
		{
			return "Recipe record deleted";
		}
		else
		{
			return "Problem occured while deleting";
		}
	}
		
//		@DeleteMapping("/deleteIngreByName/{ingredientName}")
//		public String deleteIngreByName(@PathVariable String ingredientName)
//		{
//			int result=recipeService.deleteIngreByName(ingredientName);
//			if(result>0)
//			{
//				return "Ingredient record deleted";
//			}
//			else
//			{
//				return "Problem occured while deleting";
//			}
//		}

	@PutMapping("/updateRecipeByName/{cuisine}/{recipeName}")
	public String updateRecipeByName(@PathVariable String cuisine,@PathVariable String recipeName)
	{
		int result=recipeService.updateRecipeByName(cuisine,recipeName);
		if(result>0)
		{
			return "Recipe record updated";
		}
		else
		{
			return "Problem occured while updating";
		}
	}
	
	
	
	
	
	
	
	
	//For Login
	@GetMapping(value="/getLogin")
	public List<Login> getUser()
	{
		return recipeService.getUser();
	}
	
	@GetMapping(value="/users/{userId}")
	public Login getByUser(@PathVariable int userId)
	{
		return recipeService.getByUser(userId);
	}
	
	@PostMapping(value="/addUserLogin")
	public Login saveUser(@RequestBody Login l)
	{
		return recipeService.saveUser(l);
	}
	
//	@PostMapping(value="/checkLogin")
//	public String validateUserLogin(@RequestBody Login l)
//	{
//		System.out.println(l.getUsername());
//		return recipeService.validateUserLogin(l.getUsername(),l.getPassword());
//	}
	
	@PostMapping("/login")
	private String validateUser(@RequestBody Map<String, String> l)
	{
		String username=l.get("username");
		String password=l.get("password");
		String res=recipeService.validateUser(username,password);
		return res;
		
	}
	
	@PutMapping(value="/user/{userId}")
	public Login updateUser(@RequestBody Login l, @PathVariable int userId)
	{
		return recipeService.updateUser(l,userId);
		
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable int userId)
	{
		recipeService.deleteUser(userId);
		
	}
	
	
	
	
	
	//For Registration
	@GetMapping(value="/getReg")
	public List<Registration> getReg()
	{
		List<Registration> regList = recipeService.getReg();
		return regList;
	}
	
	@PostMapping(value="/addUserReg")
	public Registration saveReg(@RequestBody Registration r)
	{
		return recipeService.saveReg(r);
	}
	
	@GetMapping("/pagingRegs/{offset}/{pageSize}")
	public List<Registration> pagingRegs(@PathVariable int offset, @PathVariable int pageSize)
	{
		return recipeService.pagingRegs(offset,pageSize);
	}
	
	@GetMapping("/pagingReg/{offset}/{pageSize}")
	public Page<Registration> pagingReg(@PathVariable int offset, @PathVariable int pageSize)
	{
		return recipeService.pagingReg(offset,pageSize);
	}
	
	@GetMapping("/pagingAndSortingReg/{offset}/{pageSize}/{field}")
	public List<Registration> pagingAndSortingReg(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return recipeService.pagingAndSortingReg(offset,pageSize,field);
	}
	
	

	
	
}
