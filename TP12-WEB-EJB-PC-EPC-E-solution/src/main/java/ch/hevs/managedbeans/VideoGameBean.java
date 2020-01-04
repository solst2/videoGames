package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Client;
import ch.hevs.businessobject.Developer;
import ch.hevs.businessobject.Game;
import ch.hevs.service.VideoGames;

public class VideoGameBean {

	private VideoGames videoGameRental;
	private HashMap<String, Long> allGames;
	private List<Game> allGameObjects;
	//welcome Page
	private String clientName;
	private List<String> clientNames;
	//overview
	private List<Game> ownGames;
	//rent game
	private String gameToRent;
	private Game gameToRentObject;
	private List<String> gamesToRent;
	private String rentGameName;
	private String rentGamedifficultyLevel;
	private int rentGameAgeLimit;
	private String rentGameDeveloperName;
	private String rentGameDeveloperMail;
	private String rentGameCategoryName;
	private String rentGameCategoryDescription;
	
	//give back game
	private List<String> ownGamesString;
	private String gameback;
	
	//Games
	private Game gameSelected;
	

	@PostConstruct
	public void initialize() throws NamingException {
		InitialContext ctx = new InitialContext();
		videoGameRental = (VideoGames) ctx
				.lookup("java:global/TP12-WEB-EJB-PC-EPC-E-0.0.1-SNAPSHOT/VideoGamesBean!ch.hevs.service.VideoGames");

		// get clients with format id firstname lastname
		List<Client> clients = videoGameRental.getAllClients();
		this.clientNames = new ArrayList<String>();
		for (Client c : clients) {
			this.clientNames.add(c.getId() + " " + c.getFristname() + " " + c.getLastname());
		}
		//greate ownGames and get all games
		this.ownGames = new ArrayList<Game>();
		allGames = new HashMap<String, Long>();
		allGameObjects = videoGameRental.getAllGames();
		for(Game g : allGameObjects) {
			allGames.put(g.getName(),g.getId());
		}
		

	}

	public String getRentGameName() {
		return rentGameName;
	}

	public void setRentGameName(String rentGameName) {
		this.rentGameName = rentGameName;
	}

	public String getRentGamedifficultyLevel() {
		return rentGamedifficultyLevel;
	}

	public void setRentGamedifficultyLevel(String rentGamedifficultyLevel) {
		this.rentGamedifficultyLevel = rentGamedifficultyLevel;
	}

	public int getRentGameAgeLimit() {
		return rentGameAgeLimit;
	}

	public void setRentGameAgeLimit(int rentGameAgeLimit) {
		this.rentGameAgeLimit = rentGameAgeLimit;
	}

	public String getRentGameDeveloperName() {
		return rentGameDeveloperName;
	}

	public void setRentGameDeveloperName(String rentGameDeveloperName) {
		this.rentGameDeveloperName = rentGameDeveloperName;
	}

	public String getRentGameDeveloperMail() {
		return rentGameDeveloperMail;
	}

	public void setRentGameDeveloperMail(String rentGameDeveloperMail) {
		this.rentGameDeveloperMail = rentGameDeveloperMail;
	}

	public String getRentGameCategoryName() {
		return rentGameCategoryName;
	}

	public void setRentGameCategoryName(String rentGameCategoryName) {
		this.rentGameCategoryName = rentGameCategoryName;
	}

	public String getRentGameCategoryDescription() {
		return rentGameCategoryDescription;
	}

	public void setRentGameCategoryDescription(String rentGameCategoryDescription) {
		this.rentGameCategoryDescription = rentGameCategoryDescription;
	}

	public List<String> getOwnGamesString() {
		ownGamesString= new ArrayList<String>();
		for(Game g:ownGames) {
			ownGamesString.add(g.getName());
		}
		return ownGamesString;
	}

	public void setOwnGamesString(List<String> ownGamesString) {
		this.ownGamesString = ownGamesString;
	}

	public VideoGames getVideoGameRental() {
		return videoGameRental;
	}

	public void setVideoGameRental(VideoGames videoGameRental) {
		this.videoGameRental = videoGameRental;
	}

	public HashMap<String,Long> getAllGames() {
		return allGames;
	}

	public void setAllGames(HashMap<String,Long> allGames) {
		this.allGames = allGames;
	}

	public String getGameToRent() {
		return gameToRent;
	}

	public void setGameToRent (String gameToRent) {
		this.gameToRent = gameToRent;
	}

	public List<String> getGamesToRent() {
		gamesToRent = new ArrayList<String>();
		List<Game> gamesToRentObject = new ArrayList<Game>(allGameObjects);
		gamesToRentObject.removeAll(ownGames);
		for(Game g:gamesToRentObject) {
			gamesToRent.add(g.getName());
		}
		return gamesToRent;
	}

	public void setGamesToRent(List<String> gamesToRent) {
		this.gamesToRent = gamesToRent;
	}

	public String getGameback() {
		return gameback;
	}

	public void setGameback(String gameback) {
		this.gameback = gameback;
	}

	public List<Game> getOwnGames() {
		updateOwnGames();
		//ownGames = videoGameRental.getGamesFromClient(11);
		return ownGames;
	}
	
	public void updateOwnGames(){
		String[] split = clientName.split(" ");
		ownGames = videoGameRental.getGamesFromClient(Long.parseLong(split[0]));
	}

	public void setOwnGames(List<Game> ownGames) {
		this.ownGames = ownGames;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public List<String> getClientNames() {
		return clientNames;
	}

	public void setClientNames(List<String> clientNames) {
		this.clientNames = clientNames;
	}
	
	public void updateDetailsGameRent() {
		Long gameId = allGames.get(gameToRent);
		gameToRentObject=videoGameRental.getGame(gameId);
		
		rentGameName=gameToRentObject.getName();
		rentGamedifficultyLevel=gameToRentObject.getDifficultyLevel();
		rentGameAgeLimit=gameToRentObject.getAgeLimit();
		Developer dev= gameToRentObject.getDeveloper();
		rentGameDeveloperName=dev.getFristname()+" "+dev.getLastname();
		rentGameDeveloperMail=dev.getMail();
		Category cat = gameToRentObject.getCategory();
		rentGameCategoryName = cat.getName();
		rentGameCategoryDescription = cat.getDescription();
	}
	
	public void rentTheGame() {
		String[] split = clientName.split(" ");
		Client client = videoGameRental.getClient(Long.parseLong(split[0]));
		videoGameRental.rent(client, gameToRentObject);
		updateOwnGames();
	}
	
	public void giveGameBack() {
		String[] split = clientName.split(" ");
		Client client = videoGameRental.getClient(Long.parseLong(split[0]));
		
		Long gameId = allGames.get(gameToRent);
		Game back = videoGameRental.getGame(gameId);
		
		videoGameRental.giveBack(client, back);
		updateOwnGames();
	}
	
	public void updateIdGameEdit(ValueChangeEvent event) {
		gameSelected = videoGameRental.getGame((Long)event.getNewValue());
	}

}
