package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.SessionContext;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Client;
import ch.hevs.businessobject.Developer;
import ch.hevs.businessobject.Game;
import ch.hevs.businessobject.Person;
import ch.hevs.service.VideoGames;

public class VideoGameBean {

	private VideoGames videoGameRental;
	private HashMap<String, Long> allGames;
	private List<Game> allGameObjects;
	private List<Category> allCategoryObjects;
	private List<Developer> allDeveloperObjects;
	private List<Client> allClientObjects;
	//welcome Page
	private String clientName;
	private List<String> clientNames;
	//overview
	private List<Game> ownGames;
	//confirmation
	private String resultString;

	//rent game
	private String gameToRent;
	private Game gameToRentObject;
	private List<Game> gamesToRent;
	
	//give back game
	private List<String> ownGamesString;
	private String gameback;
	private Game gamebackObject;
	
	//Games
	private String gameName;
	private String gameDifficultyLevel;
	private int gameAgeLimit;
	private Game gameSelected;
	private Game newGame;
	private String newGameName;
	private String newGameDifficultyLevel;
	private int newGameAgeLimit;
	private Category newGameCategory;
	private String newGameCategoryString;
	private Developer newGameDeveloper;
	private String newGameDeveloperString;
	
	//Person
	private String firstname;
	private String lastname;
	
	//Client
	private int clientAge;
	private String clientDescription;
	
	//Developers
	private String developerEmail;
	
	//Categories
	private String categoryName;
	private String categoryDescription;
	private int categoryRating;
	private Category categorySelected;
	
	private Boolean isaClient;
	private Person personSelected;
	private Boolean isAdmin;

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
		
		allClientObjects = videoGameRental.getAllClients();
		
		// is the user a admin
		isAdmin=videoGameRental.isAdmin();
	}
	
	//Getter und Setter

	public String getResultString() {
		return resultString;
	}


	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	public String getNewGameName() {
		return newGameName;
	}


	public void setNewGameName(String newGameName) {
		this.newGameName = newGameName;
	}


	public String getNewGameDifficultyLevel() {
		return newGameDifficultyLevel;
	}


	public void setNewGameDifficultyLevel(String newGameDifficultyLevel) {
		this.newGameDifficultyLevel = newGameDifficultyLevel;
	}


	public int getNewGameAgeLimit() {
		return newGameAgeLimit;
	}


	public void setNewGameAgeLimit(int newGameAgeLimit) {
		this.newGameAgeLimit = newGameAgeLimit;
	}


	public Game getNewGame() {
		return newGame;
	}


	public void setNewGame(Game newGame) {
		this.newGame = newGame;
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
		if (gameSelected != null) {
			setNewGameCategoryString(gameSelected.getCategory().toString());
			setNewGameDeveloperString(gameSelected.getDeveloper().toString());
		}
		return gameSelected;
	}

	public void setGameSelected(Game gameSelected) {
		this.gameSelected = gameSelected;
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
		List<Game> gamesToRentObject = new ArrayList<Game>(getAllGameObjects());
		gamesToRentObject.removeAll(ownGames);
		System.out.println("games to Rentbefore: "+gamesToRentObject.size());
		//if it is allready given to a client
		Iterator<Game> itr = gamesToRentObject.iterator();
	      
		while(itr.hasNext()) {
			Game g = itr.next();
			if (g.getClient()!=null) {
				itr.remove();
		    }
	    }
		System.out.println("games to Rentafter: "+gamesToRentObject.size());
		gamesToRent= gamesToRentObject;
		if(gamesToRentObject.size()!=0) {
			this.gameSelected=gamesToRent.get(0);
		}
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
	
	public String getGameName() {
		return gameName;
	}


	public void setGameName(String gameName) {
		this.gameName = gameName;
	}


	public String getGameDifficultyLevel() {
		return gameDifficultyLevel;
	}


	public void setGameDifficultyLevel(String gameDifficultyLevel) {
		this.gameDifficultyLevel = gameDifficultyLevel;
	}


	public int getGameAgeLimit() {
		return gameAgeLimit;
	}


	public void setGameAgeLimit(int gameAgeLimit) {
		this.gameAgeLimit = gameAgeLimit;
	}
	
	//Categories
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

	public int getCategoryRating() {
		return categoryRating;
	}

	public void setCategoryRating(int categoryRating) {
		this.categoryRating = categoryRating;
	}
	
	//Person
	
	public String managedPersonsView(String view) {
		if(view.equals("client")) {
			isaClient = true;
		}
		if(view.equals("developer")) {
			isaClient = false;
		}
		return "managePersonOverview";
	}
	
	public List<Client> getAllClientObjects() {
		return allClientObjects;
	}

	public void setAllClientObjects(List<Client> allClientObjects) {
		this.allClientObjects = allClientObjects;
	}

	public Boolean getIsaClient() {
		return isaClient;
	}

	public void setIsaClient(Boolean isaClient) {
		this.isaClient = isaClient;
	}

	public Person getPersonSelected() {
		return personSelected;
	}

	public void setPersonSelected(Person personSelected) {
		this.personSelected = personSelected;
	}

	//Developers
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDeveloperEmail() {
		return developerEmail;
	}

	public void setDeveloperEmail(String developerEmail) {
		this.developerEmail = developerEmail;
	}

	public int getClientAge() {
		return clientAge;
	}

	public void setClientAge(int clientAge) {
		this.clientAge = clientAge;
	}

	public String getClientDescription() {
		return clientDescription;
	}

	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}

	public String rentTheGame() {
		String[] split = clientName.split(" ");
		Client client = videoGameRental.getClient(Long.parseLong(split[0]));
		System.out.println("##rentTheGame###" + client.getLastname() + gameSelected.getName());
		videoGameRental.rent(client, gameSelected);
		updateOwnGames();
		this.resultString = "You have rented the game: "+gameSelected.getName();
		return "showClientResult";
	}
	
	public String giveGameBack() {
		System.out.println("##giveGameBack###");
		String[] split = clientName.split(" ");
		Client client = videoGameRental.getClient(Long.parseLong(split[0]));
		
		/*Long gameId = allGames.get(gameToRent);
		Game back = videoGameRental.getGame(gameId);*/
		System.out.println(client.getFristname()+" "+gamebackObject.getName() + " " + client.getGames());
		videoGameRental.giveBack(client, gamebackObject);
		updateOwnGames();
		this.resultString = "You gave back the game: "+gamebackObject.getName();
		return "showClientResult";
	}
	
	public String addGame () {
		Game game = new Game(newGameName, newGameDifficultyLevel, newGameAgeLimit);
		videoGameRental.insertGame(game, newGameCategory, newGameDeveloper);
		this.resultString = "The game is added: "+game.getName();
		return "showAdminResult";
	}
	
	public String modifyGame () {
		this.resultString = "The game is updated: "+gameSelected.getName();
		videoGameRental.updateGame(gameSelected, newGameCategory, newGameDeveloper);
		return "showAdminResult";
	}
	
	public String deleteGame () {
		videoGameRental.deleteGame(gameSelected);
		this.resultString = "The game is deleted: "+gameSelected.getName();
		return "showAdminResult";
	}
	
	//Category
	public String addCategory () {
		Category category = new Category(categoryName, categoryDescription, categoryRating);
		videoGameRental.insertCategory(category);
		this.resultString = "The category is added: "+category.getName();
		return "showAdminResult";
	}
	
	public String modifyCategory () {
		this.resultString = "The category is updated: "+categorySelected.getName();
		videoGameRental.updateCategory(categorySelected);
		return "showAdminResult";
	}
	
	public String deleteCategory () {
		videoGameRental.deleteCategory(categorySelected);
		this.resultString = "The category is deleted: "+categorySelected.getName();
		return "showAdminResult";
	}
	
	public void updateClient() {
		allClientObjects = videoGameRental.getAllClients();
	}
	
	//Person
	public String addPerson () {
		if(!isaClient) {
			Developer developer = new Developer(firstname, lastname, developerEmail);
			videoGameRental.insertDeveloper(developer);
			this.resultString = "The developer is added: "+developer.getFristname() + " " + developer.getLastname();
		}
		if(isaClient) {
			Client client = new Client(firstname, lastname, clientDescription, clientAge);
			videoGameRental.insertClient(client);
			updateClient();
			this.resultString = "The client is added: "+client.getFristname() + " " + client.getLastname();
		}
		return "showAdminResult";
	}
	
	public String modifyPerson () {
		if(!isaClient) {
			videoGameRental.updateDeveloper((Developer)personSelected);
			this.resultString = "The developer is deleted: "+personSelected.getFristname() + " " + personSelected.getLastname();
		}
		if(isaClient) {
			videoGameRental.updateClient((Client)personSelected);
			this.resultString = "The client is deleted: "+personSelected.getFristname() + " " + personSelected.getLastname();
		}
		return "showAdminResult";
	}
	
	public String deletePerson () {
		if(!isaClient) {
			videoGameRental.deleteDeveloper((Developer)personSelected);
			this.resultString = "The developer is deleted: "+personSelected.getFristname() + " " + personSelected.getLastname();
		}
		if(isaClient) {
			videoGameRental.deleteClient((Client)personSelected);
			updateClient();
			this.resultString = "The client is deleted: "+personSelected.getFristname() + " " + personSelected.getLastname();
		}
		return "showAdminResult";
	}

}
