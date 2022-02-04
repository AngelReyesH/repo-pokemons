package com.example.demo;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Pokemons1Application extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(Pokemons1Application.class, args);
	}
	
	

    @RestController
    public static class WarInitializerController {
    	
    
    	    
    	    
    	@GetMapping("/test")
        public String handler2(@RequestParam(required = true) final String name) {
           return "Proyecto Iniciado! "+ name;
        }
    	  @GetMapping("/")
          public String handler(@RequestParam(required = true) final String name)  {
    		 String url = "https://pokeapi.co/api/v2/pokemon/"+name;
    		 try {
				 RestTemplate resTemplate = new RestTemplate();
             String pok1 = resTemplate.getForObject(url,String.class); 
      	     JSONObject rot= new JSONObject(pok1);
      	     return "El Nombre del Pokemon es: "+rot.toMap().get("name");
			} catch (Exception e) {
				return "No se puede Procesar la ur: "+url;
			}
            
		
    	  }
    	  

    	  @GetMapping("/pokemons/name")
    	public String getPokemonsByName(@RequestParam(required = true) final String name) throws JsonMappingException, JsonProcessingException  {
    		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
    	    RestTemplate resTemplate = new RestTemplate();
            String pok1 = resTemplate.getForObject(url,String.class); 
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(pok1);
            Object ob = new ObjectMapper().readValue(json, Object.class);
    	    JSONObject rot= new JSONObject(pok1);
               
    		return "El Nombre del Pokemon es: "+rot.toMap().get("name");
    	}

      	
    	  @GetMapping("/pokemons/id")
      	public String getPokemonsById(@RequestParam(required = true) final String name) throws JsonMappingException, JsonProcessingException {
      		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
      	    RestTemplate resTemplate = new RestTemplate();
              String pok1 = resTemplate.getForObject(url,String.class); 
              ObjectMapper objectMapper = new ObjectMapper();
              String json = objectMapper.writeValueAsString(pok1);
              Object ob = new ObjectMapper().readValue(json, Object.class);
      	    JSONObject rot= new JSONObject(pok1);
      		return "Id del Pokemon "+name+" es: "+rot.toMap().get("id");
      	}
      	
    	  @GetMapping("/pokemons/abilities")
      	public Object getPokemonsByAbilities(@RequestParam(required = true) final String name) throws JsonMappingException, JsonProcessingException {
      		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
      	    RestTemplate resTemplate = new RestTemplate();
              String pok1 = resTemplate.getForObject(url,String.class); 
              ObjectMapper objectMapper = new ObjectMapper();
              String json = objectMapper.writeValueAsString(pok1);
              Object ob = new ObjectMapper().readValue(json, Object.class);
      	    JSONObject rot= new JSONObject(pok1);  
      		return ResponseEntity.status(HttpStatus.OK).body(rot.toMap().get("abilities"));
      	}
    	  @GetMapping("/pokemons/base-experiences")
      	public String  getPokemonsByBase(@RequestParam(required = true) final String name) throws JsonMappingException, JsonProcessingException {
      		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
      	    RestTemplate resTemplate = new RestTemplate();
              String pok1 = resTemplate.getForObject(url,String.class); 
              ObjectMapper objectMapper = new ObjectMapper();
              String json = objectMapper.writeValueAsString(pok1);
              Object ob = new ObjectMapper().readValue(json, Object.class);
      	    JSONObject rot= new JSONObject(pok1);
      		return "La base-experiences del Pokemon "+name+" es "+rot.toMap().get("base_experience");
      	}
      	
    	  @GetMapping("/pokemons/held-items")
      	public Object getPokemonsByHeld(@RequestParam(required = true) final String name) throws JsonMappingException, JsonProcessingException {
      		String url = "https://pokeapi.co/api/v2/pokemon/"+name;
      	    RestTemplate resTemplate = new RestTemplate();
              String pok1 = resTemplate.getForObject(url,String.class); 
              ObjectMapper objectMapper = new ObjectMapper();
              String json = objectMapper.writeValueAsString(pok1);
              Object ob = new ObjectMapper().readValue(json, Object.class);
      	    JSONObject rot= new JSONObject(pok1);
      	    return ResponseEntity.status(HttpStatus.OK).body(rot.toMap().get("held_items"));
      	}
      	
    	  @GetMapping(value = "/pokemons/location-area-encounters")
      	public String getPokemonsByLocation(@RequestParam(required = true) final String name) throws JsonMappingException, JsonProcessingException {
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
    	
}
