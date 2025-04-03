package structuraldesignpatterns.FacadeDesignPattern;

public class HomeTheatreFacade {
	
	private DVDPlayer dvdPlayer;
	
	private Speaker speaker;
	
	private Projector projector;
	
	private Lights lights;
	
	
	
	public HomeTheatreFacade(DVDPlayer dvdPlayer, Speaker speaker, Projector projector, Lights lights) {
		this.dvdPlayer = dvdPlayer;
		this.speaker = speaker;
		this.projector = projector;
		this.lights = lights;
	}

	void watchMovie() {
		System.out.println("\nGetting ready to watch a movie...");
        lights.dimLights();
        projector.turnOn();
        projector.setMode();
        speaker.turnOn();
        speaker.setSurroundSound();
        dvdPlayer.turnOn();
        dvdPlayer.playMovie();
        System.out.println("Enjoy your movie!\n");
	}

	void endMovie() {
		System.out.println("\nShutting down the home theater...");
		dvdPlayer.turnOff();
		speaker.turnOff();
        projector.turnOff();
        lights.turnOnLights();
        System.out.println("Home theater turned off.\n");
	}
}
