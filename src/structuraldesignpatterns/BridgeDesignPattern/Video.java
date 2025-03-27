package structuraldesignpatterns.BridgeDesignPattern;

public abstract class Video {

	// In bridge pattern it used Has-A relationship(Composition) to connect the two
	// independent bridges. Otherwise, we need to create multiple subclasses
	VideoProcessor processor;

	public Video(VideoProcessor processor) {
		this.processor = processor;
	}

	abstract void play();

}
