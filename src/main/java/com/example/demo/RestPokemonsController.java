package com.example.demo;


import java.util.List;

import org.json.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController

public class RestPokemonsController {
	

	@RequestMapping(value = "/pokemons/name/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object getPokemonsByName(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException  {
		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
	    RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject(url,String.class); 
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pok1);
        Object ob = new ObjectMapper().readValue(json, Object.class);
	    JSONObject rot= new JSONObject(pok1);
           
		return "El Nombre del Pokemon es: "+rot.toMap().get("name");
	}
	
	
	
	@RequestMapping(value = "/pokemons/id/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object getPokemonsById(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException {
		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
	    RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject(url,String.class); 
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pok1);
        Object ob = new ObjectMapper().readValue(json, Object.class);
	    JSONObject rot= new JSONObject(pok1);
		return "Id del Pokemon "+name+" es: "+rot.toMap().get("id");
	}
	
	@RequestMapping(value = "/pokemons/abilities/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object getPokemonsByAbilities(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException {
		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
	    RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject(url,String.class); 
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pok1);
        Object ob = new ObjectMapper().readValue(json, Object.class);
	    JSONObject rot= new JSONObject(pok1);  
		return ResponseEntity.status(HttpStatus.OK).body(rot.toMap().get("abilities"));
	}
	@RequestMapping(value = "/pokemons/base-experiences/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object getPokemonsByBase(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException {
		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
	    RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject(url,String.class); 
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pok1);
        Object ob = new ObjectMapper().readValue(json, Object.class);
	    JSONObject rot= new JSONObject(pok1);
		return "La base-experiences del Pokemon "+name+" es "+rot.toMap().get("base_experience");
	}
	
	@RequestMapping(value = "/pokemons/held-items/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object getPokemonsByHeld(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException {
		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
	    RestTemplate resTemplate = new RestTemplate();
        String pok1 = resTemplate.getForObject(url,String.class); 
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pok1);
        Object ob = new ObjectMapper().readValue(json, Object.class);
	    JSONObject rot= new JSONObject(pok1);
	    return ResponseEntity.status(HttpStatus.OK).body(rot.toMap().get("held_items"));
	}
	
	@RequestMapping(value = "/pokemons/location-area-encounters/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object getPokemonsByLocation(@PathVariable("name") String name) throws JsonMappingException, JsonProcessingException {
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
