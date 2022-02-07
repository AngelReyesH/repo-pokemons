package com.example.demo.controller;



import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.pokemonModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

@Controller
public class RestPokemonsController {
	
	@ResponseBody
	@GetMapping(value = "/pokemons/name/")
	public String getPokemonsByNameee() throws JsonMappingException, JsonProcessingException  {
	
           
		return "El Nombre del Pokemon es: plolpl";
	}
	
	@ResponseBody
	@GetMapping(value = "/pokemons/name/{name}")
	public Object getPokemonsByName(@PathVariable(value = "name") String name) throws JsonMappingException, JsonProcessingException {
	    RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/"+name,String.class,name); 
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pok1);
        Object ob = new ObjectMapper().readValue(json, Object.class);//con los /
        
        Map jsonJavaRootObject = new Gson().fromJson(pok1, Map.class);
		
		return "El Nombre del Pokemon es: "+jsonJavaRootObject.get("name");
         
	}
	
	
	@ResponseBody
	@GetMapping(value = "/pokemons/id/{name}")
	public Object getPokemonsById(@PathVariable(value = "name") String name) throws JsonMappingException, JsonProcessingException {
		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
	    RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject(url,String.class); 
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pok1);
        Object ob = new ObjectMapper().readValue(json, Object.class);
	    JSONObject rot= new JSONObject(pok1);
		return "Id del Pokemon "+name+" es: "+rot.toMap().get("id");
	}
	
	@ResponseBody
	@GetMapping(value = "/pokemons/abilities/{name}")
	public  Object getPokemonsByAbilities(@PathVariable(value = "name") String name) throws JsonMappingException, JsonProcessingException {
		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
	    RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject(url,String.class); 
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pok1);
        Object ob = new ObjectMapper().readValue(json, Object.class);
	    JSONObject rot= new JSONObject(pok1);  
		return ResponseEntity.status(HttpStatus.OK).body(rot.toMap().get("abilities"));
	}
	
	@GetMapping(value = "/pokemons/base-experiences/{name}")
	public  Object getPokemonsByBase(@PathVariable(value = "name") String name) throws JsonMappingException, JsonProcessingException {
		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
	    RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject(url,String.class); 
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pok1);
        Object ob = new ObjectMapper().readValue(json, Object.class);
	    JSONObject rot= new JSONObject(pok1);
		return "La base-experiences del Pokemon "+name+" es "+rot.toMap().get("base_experience");
	}
	
	@ResponseBody
	@GetMapping(value = "/pokemons/held-items/{name}")
	public  Object getPokemonsByHeld(@PathVariable(value = "name") String name) throws JsonMappingException, JsonProcessingException {
		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
	    RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject(url,String.class); 
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pok1);
        Object ob = new ObjectMapper().readValue(json, Object.class);
	    JSONObject rot= new JSONObject(pok1);
	    return ResponseEntity.status(HttpStatus.OK).body(rot.toMap().get("held_items"));
	}
	
	@ResponseBody
	@GetMapping(value = "/pokemons/location-area-encounters/{name}")
	public  Object getPokemonsByLocation(@PathVariable(value = "name") String name) throws JsonMappingException, JsonProcessingException {
		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
	    RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject(url,String.class); 
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pok1);
        Object ob = new ObjectMapper().readValue(json, Object.class);
	    JSONObject rot= new JSONObject(pok1);
	    String l = (String) rot.toMap().get("location_area_encounters");
	    String pok11 = resTemplate.getForObject(l,String.class);
	    return pok11;
	}
	
	
	
	
}
