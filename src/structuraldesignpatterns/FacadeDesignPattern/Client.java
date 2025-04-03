package structuraldesignpatterns.FacadeDesignPattern;

import java.io.FileNotFoundException;

public class Client {
	
	public static void main(String[] args) throws FileNotFoundException {
		DVDPlayer dvdPlayer= new DVDPlayer();
		Speaker speaker = new Speaker();
		Projector projector = new Projector();
		Lights lights = new Lights();
		
		HomeTheatreFacade facade = new HomeTheatreFacade(dvdPlayer, speaker, projector, lights);
		
		facade.watchMovie();
		
		System.out.println("************************************************");
		
		facade.endMovie();
		
	}

}
