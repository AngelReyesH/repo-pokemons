package com.example.demo.model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class pokemonModel {
	private Array[] abilities;
	private Integer base_experience;
	private Array[] forms;
	private Array[] game_indices;
	private Integer height;
	private Array[] held_items;
	private Integer id;
	private boolean is_default;
	private String location_area_encounters;
	private Array[] moves;
	private String name;
	private Integer order;
	private Array[] past_types;
	private Array species;
	private Array sprites;
	private Array[] stats;
	private Array[] types;
	private Integer weight;
	
	
	
	
	
	
	public pokemonModel(Array[] abilities, Integer base_experience, Array[] forms, Array[] game_indices, Integer height,
			Array[] held_items, Integer id, boolean is_default, String location_area_encounters, Array[] moves,
			String name, Integer order, Array[] past_types, Array species, Array sprites, Array[] stats, Array[] types,
			Integer weight) {
		super();
		this.abilities = abilities;
		this.base_experience = base_experience;
		this.forms = forms;
		this.game_indices = game_indices;
		this.height = height;
		this.held_items = held_items;
		this.id = id;
		this.is_default = is_default;
		this.location_area_encounters = location_area_encounters;
		this.moves = moves;
		this.name = name;
		this.order = order;
		this.past_types = past_types;
		this.species = species;
		this.sprites = sprites;
		this.stats = stats;
		this.types = types;
		this.weight = weight;
	}
	public Array[] getAbilities() {
		return abilities;
	}
	public void setAbilities(Array[] abilities) {
		this.abilities = abilities;
	}
	public Integer getBase_experience() {
		return base_experience;
	}
	public void setBase_experience(Integer base_experience) {
		this.base_experience = base_experience;
	}
	public Array[] getForms() {
		return forms;
	}
	public void setForms(Array[] forms) {
		this.forms = forms;
	}
	public Array[] getGame_indices() {
		return game_indices;
	}
	public void setGame_indices(Array[] game_indices) {
		this.game_indices = game_indices;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Array[] getHeld_items() {
		return held_items;
	}
	public void setHeld_items(Array[] held_items) {
		this.held_items = held_items;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isIs_default() {
		return is_default;
	}
	public void setIs_default(boolean is_default) {
		this.is_default = is_default;
	}
	public String getLocation_area_encounters() {
		return location_area_encounters;
	}
	public void setLocation_area_encounters(String location_area_encounters) {
		this.location_area_encounters = location_area_encounters;
	}
	public Array[] getMoves() {
		return moves;
	}
	public void setMoves(Array[] moves) {
		this.moves = moves;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Array[] getPast_types() {
		return past_types;
	}
	public void setPast_types(Array[] past_types) {
		this.past_types = past_types;
	}
	public Array getSpecies() {
		return species;
	}
	public void setSpecies(Array species) {
		this.species = species;
	}
	public Array getSprites() {
		return sprites;
	}
	public void setSprites(Array sprites) {
		this.sprites = sprites;
	}
	public Array[] getStats() {
		return stats;
	}
	public void setStats(Array[] stats) {
		this.stats = stats;
	}
	public Array[] getTypes() {
		return types;
	}
	public void setTypes(Array[] types) {
		this.types = types;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "pokemonModel [abilities=" + Arrays.toString(abilities) + ", base_experience=" + base_experience
				+ ", forms=" + Arrays.toString(forms) + ", game_indices=" + Arrays.toString(game_indices) + ", height="
				+ height + ", held_items=" + Arrays.toString(held_items) + ", id=" + id + ", is_default=" + is_default
				+ ", location_area_encounters=" + location_area_encounters + ", moves=" + Arrays.toString(moves)
				+ ", name=" + name + ", order=" + order + ", past_types=" + Arrays.toString(past_types) + ", species="
				+ species + ", sprites=" + sprites + ", stats=" + Arrays.toString(stats) + ", types="
				+ Arrays.toString(types) + ", weight=" + weight + "]";
	}
	
	
	
}
