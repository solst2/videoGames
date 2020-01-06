package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
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
	private List<Category> allCategoryObjects;
	private List<Developer> allDeveloperObjects;
	//welcome Page
	private String clientName;
	private List<String> clientNames;
	//overview
	private List<Game> ownGames;
	//rent game
	private String gameToRent;
	private Game gameToRentObject;
	private List<Game> gamesToRent;
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
	private Game gamebackObject;
	
	
	//Games
	private Game gameSelected;
	private Game newGame;
	private Category newGameCategory;
	private String newGameCategoryString;
	private Developer newGameDeveloper;
	private String newGameDeveloperString;
	
	@PostConstruct
	public void initialize() throws NamingException {
		InitialContext ctx = new InitialContext();
		videoGameRental = (VideoGames) ctx
				.lookup("java:global/TP12-WEB-EJB-PC-EPC-E-0.0.1-SNAPSHOT/VideoGamesBean!ch.hevs.service.VideoGames");
		
		// get clients with format id firstname lastname
		List<Client> clients = videoGameRental.getAllClients();
		System.out.println("-----------the client size"+clients.size());
		this.clientNames = new ArrayList<String>();
		for (Client c : clients) {
			this.clientNames.add(c.getId() + " " + c.getFristname() + " " + c.getLastname());
		}

		this.ownGames = new ArrayList<Game>();
		allGames = new HashMap<String, Long>();
		allGameObjects = videoGameRental.getAllGames();
		for(Game g : allGameObjects) {
			allGames.put(g.getName(),g.getId());
		}
		/*
		// test to add a game
		Game g  = new Game ("Solange","easy",2);
		Category c = videoGameRental.getCategory(31);
		Developer d = videoGameRental.getDeveloper(13);
		videoGameRental.insertGame(g, c, d);
		*/

	}


	public String getNewGameCategoryString() {
		return newGameCategoryString;
	}


	public void setNewGameCategoryString(String newGameCategoryString) {
		String idString = newGameCategoryString.substring(newGameCategoryString.indexOf("=") + 1);
		idString=idString.substring(0, idString.indexOf(","));
		System.out.println("----------id Cate "+idString);
		newGameCategory = videoGameRental.getCategory(Long.parseLong(idString));  
		this.newGameCategoryString = newGameCategoryString;
	}


	public String getNewGameDeveloperString() {
		return newGameDeveloperString;
	}


	public void setNewGameDeveloperString(String newGameDeveloperString) {
		String idString = newGameDeveloperString.substring(newGameDeveloperString.indexOf("=") + 1);
		idString=idString.substring(0, idString.indexOf(","));
		System.out.println("----------id dev "+idString);
		newGameDeveloper = videoGameRental.getDeveloper(Long.parseLong(idString));
		this.newGameDeveloperString = newGameDeveloperString;
	}


	public Category getNewGameCategory() {
		return newGameCategory;
	}


	public void setNewGameCategory(Category newGameCategory) {
		this.newGameCategory = newGameCategory;
	}


	public Developer getNewGameDeveloper() {
		return newGameDeveloper;
	}


	public void setNewGameDeveloper(Developer newGameDeveloper) {
		this.newGameDeveloper = newGameDeveloper;
	}


	public List<Category> getAllCategoryObjects() {
		allCategoryObjects = videoGameRental.getAllCategories();
		return allCategoryObjects;
	}


	public void setAllCategoryObjects(List<Category> allCategoryObjects) {
		this.allCategoryObjects = allCategoryObjects;
	}


	public List<Developer> getAllDeveloperObjects() {
		allDeveloperObjects = videoGameRental.getAllDevelopers();
		return allDeveloperObjects;
	}


	public void setAllDeveloperObjects(List<Developer> allDeveloperObjects) {
		this.allDeveloperObjects = allDeveloperObjects;
	}


	public Game getNewGame() {
		newGame = new Game();
		return newGame;
	}

	public void setNewGame(Game newGame) {
		this.newGame = newGame;
	}
	
	public Game getGamebackObject() {
		return gamebackObject;
	}

	public void setGamebackObject(Game gamebackObject) {
		this.gamebackObject = gamebackObject;
	}

	public List<Game> getAllGameObjects() {
		allGameObjects = videoGameRental.getAllGames();
		return allGameObjects;
	}

	public void setAllGameObjects(List<Game> allGameObjects) {
		this.allGameObjects = allGameObjects;
	}

	public Game getGameToRentObject() {
		return gameToRentObject;
	}

	public void setGameToRentObject(Game gameToRentObject) {
		this.gameToRentObject = gameToRentObject;
	}

	public Game getGameSelected() {
		setNewGameCategoryString(gameSelected.getCategory().toString());
		setNewGameDeveloperString(gameSelected.getDeveloper().toString());
		return gameSelected;
	}

	public void setGameSelected(Game gameSelected) {
		this.gameSelected = gameSelected;
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

	public List<Game> getGamesToRent() {
		gamesToRent = new ArrayList<Game>();
		List<Game> gamesToRentObject = new ArrayList<Game>(allGameObjects);
		gamesToRentObject.removeAll(ownGames);/*
		//if it is allready given to a client
		for (Game g:gamesToRentObject) {
			if (g.getClient()!=null) {
				gamesToRentObject.remove(g);
			}
		}*/
		System.out.println("games to Rent: "+gamesToRentObject.size());
		gamesToRent= gamesToRentObject;
		this.gameSelected=gamesToRent.get(0);
		return gamesToRent;
	}

	public void setGamesToRent(List<Game> gamesToRent) {
		this.gamesToRent = gamesToRent;
	}

	public String getGameback() {
		return gameback;
	}

	public void setGameback(String gameback) {
		String idString = gameback.substring(gameback.indexOf("=") + 1);
		idString=idString.substring(0, idString.indexOf(","));
		System.out.println("----------id gameback "+idString);
		gamebackObject = videoGameRental.getGame(Long.parseLong(idString));  
		this.gameback = gameback;
	}

	public List<Game> getOwnGames() {
		updateOwnGames();
		return ownGames;
	}
	
	public void updateOwnGames(){
		String[] split = clientName.split(" ");
		Long id = Long.parseLong(split[0]);
		ownGames = videoGameRental.getGamesFromClient(id);
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
	/*
	public void updateDetailsGameRent() {
		long gameId = allGames.get(gameToRent);
		gameToRentObject=videoGameRental.getGame(gameId);
		gameSelected = gameToRentObject;
		
		rentGameName=gameToRentObject.getName();
		rentGamedifficultyLevel=gameToRentObject.getDifficultyLevel();
		rentGameAgeLimit=gameToRentObject.getAgeLimit();
		Developer dev= gameToRentObject.getDeveloper();
		rentGameDeveloperName=dev.getFristname()+" "+dev.getLastname();
		rentGameDeveloperMail=dev.getMail();
		Category cat = gameToRentObject.getCategory();
		rentGameCategoryName = cat.getName();
		rentGameCategoryDescription = cat.getDescription();
		
	}*/
	
	public void rentTheGame() {
		String[] split = clientName.split(" ");
		Client client = videoGameRental.getClient(Long.parseLong(split[0]));
		videoGameRental.rent(client, gameToRentObject);
		updateOwnGames();
	}
	
	public void giveGameBack() {
		String[] split = clientName.split(" ");
		Client client = videoGameRental.getClient(Long.parseLong(split[0]));
		
		/*Long gameId = allGames.get(gameToRent);
		Game back = videoGameRental.getGame(gameId);*/
		System.out.println(client.getFristname()+" "+gamebackObject.getName());
		videoGameRental.giveBack(client, gamebackObject);
		updateOwnGames();
	}
	
	public void updateIdGameEdit(ValueChangeEvent event) {
		gameSelected = videoGameRental.getGame((Long)event.getNewValue());
	}
	
	public void addGame () {
		videoGameRental.insertGame(newGame, newGameCategory, newGameDeveloper);
	}
	
	public void modifyGame () {
		videoGameRental.updateGame(gameSelected, newGameCategory, newGameDeveloper);
	}
	
	public void deleteGAme () {
		videoGameRental.deleteGame(gameSelected);
	}

}
