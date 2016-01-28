package de.rwth.swc.oosc.group111.domainobjs;

import java.io.File;

public class Chair extends FurnitureFigure {

	final static File chair = new File("img" + File.separator + "chair.png");

	public Chair() {
		super(chair);
	}

}
