package com.example.demo.controller;



import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RestPokemonsController {
	
	@ResponseBody
	@GetMapping(value = "/pokemons/name/{name}")
	public Object getPokemonsByName(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException  {
		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
	    RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject(url,String.class); 
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pok1);
        Object ob = new ObjectMapper().readValue(json, Object.class);
	    JSONObject rot= new JSONObject(pok1);
           
		return "El Nombre del Pokemon es: "+rot.toMap().get("name");
	}
	
	
	@ResponseBody
	@GetMapping(value = "/pokemons/id/{name}")
	public Object getPokemonsById(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException {
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
	public  Object getPokemonsByAbilities(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException {
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
	public  Object getPokemonsByBase(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException {
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
	public  Object getPokemonsByHeld(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException {
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
	public  Object getPokemonsByLocation(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException {
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
