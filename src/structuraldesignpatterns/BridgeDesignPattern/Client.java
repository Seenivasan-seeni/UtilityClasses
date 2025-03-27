package structuraldesignpatterns.BridgeDesignPattern;

import java.sql.SQLException;

public class Client {

	public static void main(String[] args) throws SQLException {
		Video youTubeVideo = new YouTubeVideo(new HDProcessor());
		youTubeVideo.play();

		Video netFlixVideo = new NetFlixVideo(new UHDProcessor());
		netFlixVideo.play();
		
	}

}
