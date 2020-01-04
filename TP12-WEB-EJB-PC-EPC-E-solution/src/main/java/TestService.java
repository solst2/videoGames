import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Client;
import ch.hevs.service.*;

public class TestService {
	private static VideoGames video;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			video = (VideoGames) ctx.lookup("java:global/TP12-WEB-EJB-PC-EPC-E-0.0.1-SNAPSHOT/VideoGamesBean!ch.hevs.service.VideoGames");
			List<Client> clients;
			clients = video.getAllClients();
			for(Client c: clients) {
				System.out.println(c.toString());
			}
			Client client = video.getClient(10);
			System.out.println(client.toString());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
