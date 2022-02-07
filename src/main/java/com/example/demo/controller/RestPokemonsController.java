package com.example.demo.controller;



import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/api/v1")
public class RestPokemonsController {
	
	@ResponseBody
	@GetMapping(value = "/pokemons/name/")
	public String getPokemonsByNameee() {
	
           
		return "El Nombre del Pokemon es: plolpl";
	}
	
	@ResponseBody
	@GetMapping(value = "/pokemons/name/{name}")
	public Object getPokemonsByName(@PathVariable(value = "name") String name) {
	    RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/"+name,String.class,name); 
        @SuppressWarnings("rawtypes")
		Map jsonJavaRootObject = new Gson().fromJson(pok1, Map.class);
		Object value = jsonJavaRootObject.get("name");
		return "El Nombre del Pokemon es: "+value;
         
	}
	
	
	@ResponseBody
	@GetMapping(value = "/pokemons/id/{name}")
	public Object getPokemonsById(@PathVariable(value = "name") String name){
		RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/"+name,String.class,name); 
        @SuppressWarnings("rawtypes")
		Map jsonJavaRootObject = new Gson().fromJson(pok1, Map.class);
		Object value = jsonJavaRootObject.get("id");
		return "Id del Pokemon "+name+" es: "+value;
	}
	
	@ResponseBody
	@GetMapping(value = "/pokemons/abilities/{name}")
	public  Object getPokemonsByAbilities(@PathVariable(value = "name") String name) {
		RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/"+name,String.class,name); 
        @SuppressWarnings("rawtypes")
		Map jsonJavaRootObject = new Gson().fromJson(pok1, Map.class);
        Object value = jsonJavaRootObject.get("abilities");
		return ResponseEntity.status(HttpStatus.OK).body(value);
	}
	
	@GetMapping(value = "/pokemons/base-experiences/{name}")
	public  Object getPokemonsByBase(@PathVariable(value = "name") String name) {
		RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/"+name,String.class,name); 
        @SuppressWarnings("rawtypes")
		Map jsonJavaRootObject = new Gson().fromJson(pok1, Map.class);
        Object value = jsonJavaRootObject.get("base_experience");
		return "La base-experiences del Pokemon "+name+" es "+value;
	}
	
	@ResponseBody
	@GetMapping(value = "/pokemons/held-items/{name}")
	public  Object getPokemonsByHeld(@PathVariable(value = "name") String name) {
		RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/"+name,String.class,name); 
        @SuppressWarnings("rawtypes")
		Map jsonJavaRootObject = new Gson().fromJson(pok1, Map.class);
        Object value = jsonJavaRootObject.get("held_items");
	    return ResponseEntity.status(HttpStatus.OK).body(value);
	}
	
	@ResponseBody
	@GetMapping(value = "/pokemons/location-area-encounters/{name}")
	public  Object getPokemonsByLocation(@PathVariable(value = "name") String name){
		RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/"+name,String.class,name); 
        @SuppressWarnings("rawtypes")
		Map jsonJavaRootObject = new Gson().fromJson(pok1, Map.class);
        Object valueT = jsonJavaRootObject.get("location_area_encounters");
	    String value = resTemplate.getForObject((String)valueT,String.class);
	    return value;
	}
	
	
	
	
}
