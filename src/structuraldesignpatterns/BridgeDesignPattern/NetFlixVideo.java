package structuraldesignpatterns.BridgeDesignPattern;

public class NetFlixVideo extends Video {

	public NetFlixVideo(VideoProcessor processor) {
		super(processor);
		// TODO Auto-generated constructor stub
	}

	@Override
	void play() {
		System.out.println("Inside NetFlixVideo - play()...");
		processor.process();
	}

}
