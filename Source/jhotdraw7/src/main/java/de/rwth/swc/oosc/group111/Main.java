package de.rwth.swc.oosc.group111;

import org.jhotdraw.app.Application;
import org.jhotdraw.app.OSXApplication;
import org.jhotdraw.app.SDIApplication;
import org.jhotdraw.util.ResourceBundleUtil;

public class Main {
	/** Creates a new instance. */
	public static void main(String[] args) {
		// Debug resource bundle
		ResourceBundleUtil.setVerbose(true);

		Application app;
		String os = System.getProperty("os.name").toLowerCase();
		if (os.startsWith("mac")) {
			app = new OSXApplication();
		} else if (os.startsWith("win")) {
			app = new SDIApplication();
		} else {
			app = new SDIApplication();
		}
		SWCArchitectApplicationModel model = new SWCArchitectApplicationModel();
		model.setName("SWCArchitect");
		model.setVersion(Main.class.getPackage().getImplementationVersion());
		model.setCopyright("Copyright 2016 (c) by group111");
		model.setViewClassName("org.jhotdraw.samples.svg.SVGView");
		app.setModel(model);
		app.launch(args);
	}
}
