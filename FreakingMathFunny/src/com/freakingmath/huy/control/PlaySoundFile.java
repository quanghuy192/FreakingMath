package com.freakingmath.huy.control;

import java.io.File;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlaySoundFile {

	public static void playSoundButton() {

		JFXPanel fxPanel = new JFXPanel();

		String soundFile = new File("button-09.mp3").toURI().toString();

		Media sound = new Media(soundFile);
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * PlaySoundFile.playSoundButton(); }
	 */
}
