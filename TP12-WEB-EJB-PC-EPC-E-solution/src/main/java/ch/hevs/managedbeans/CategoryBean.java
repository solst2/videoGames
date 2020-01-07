package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Client;
import ch.hevs.businessobject.Developer;
import ch.hevs.businessobject.Game;
import ch.hevs.service.VideoGames;

public class CategoryBean {
	private VideoGames videoGameRental;
	private List<Category> allCategoryObjects;
	private String categoryName;
	private String categoryDescription;
	private Category categorySelected;
	
	@PostConstruct
	public void initialize() throws NamingException {
		InitialContext ctx = new InitialContext();
		System.out.println("#############");
		videoGameRental = (VideoGames) ctx
				.lookup("java:global/TP12-WEB-EJB-PC-EPC-E-0.0.1-SNAPSHOT/VideoGamesBean!ch.hevs.service.VideoGames");
		allCategoryObjects = videoGameRental.getAllCategories();
		System.out.println("-----------the client size"+allCategoryObjects.size());
	}

	public List<Category> getAllCategoryObjects() {
		return allCategoryObjects;
	}

	public void setAllCategoryObjects(List<Category> allCategoryObjects) {
		this.allCategoryObjects = allCategoryObjects;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Category getCategorySelected() {
		return categorySelected;
	}

	public void setCategorySelected(Category categorySelected) {
		this.categorySelected = categorySelected;
	}

	public VideoGames getVideoGameRental() {
		return videoGameRental;
	}

	public void setVideoGameRental(VideoGames videoGameRental) {
		this.videoGameRental = videoGameRental;
	}
	
	public void updateIdCategoryEdit(ValueChangeEvent event) {
		categorySelected = videoGameRental.getCategory((Long)event.getNewValue());
	}
	
	public void addCategory () {
		System.out.println("####" + categoryName + " " + categoryDescription);
		Category c = new Category(categoryName, categoryDescription);
		videoGameRental.insertCategory(c);
	}
	
	public void modifyCategory () {
		videoGameRental.updateCategory(categorySelected);
	}
	
	public void deleteCategory () {
		videoGameRental.deleteCategory(categorySelected);
	}

}
