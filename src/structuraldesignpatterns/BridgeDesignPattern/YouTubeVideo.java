package structuraldesignpatterns.BridgeDesignPattern;

public class YouTubeVideo extends Video {

	public YouTubeVideo(VideoProcessor processor) {
		super(processor);
		// TODO Auto-generated constructor stub
	}

	@Override
	void play() {
		System.out.println("Inside YouTubeVideo - play() ...");
		processor.process();
	}

}
