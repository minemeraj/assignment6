package de.rwth.swc.oosc.group111.domainobjs;

import java.io.File;
import java.io.IOException;

import org.jhotdraw.draw.ImageFigure;

public class FurnitureFigure extends ImageFigure {
	
	public FurnitureFigure(){
		super();
	}

	public FurnitureFigure(File imgpath) {
		super();
		try {
			this.loadImage(imgpath);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
