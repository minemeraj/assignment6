package de.rwth.swc.oosc.group111;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.Action;
import javax.swing.JToolBar;

import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.ImageFigure;
import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.samples.svg.SVGApplicationModel;
import org.jhotdraw.samples.svg.SVGView;
import org.jhotdraw.util.ResourceBundleUtil;

import de.rwth.swc.oosc.group111.domainobjs.Chair;
import de.rwth.swc.oosc.group111.domainobjs.Table;

public class SWCArchitectApplicationModel extends SVGApplicationModel {
	@Override
	public List<JToolBar> createToolBars(Application app, View pr) {
		ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
		ResourceBundleUtil customlabels = ResourceBundleUtil.getBundle("de.rwth.swc.oosc.group111.Labels");
		SVGView p = (SVGView) pr;

		DrawingEditor editor;
		if (p == null) {
			editor = getSharedEditor();
		} else {
			editor = p.getEditor();
		}

		LinkedList<JToolBar> list = new LinkedList<JToolBar>();
		JToolBar tb;

		tb = new JToolBar();
		ButtonFactory.addAlignmentButtonsTo(tb, editor);
		tb.setName(labels.getString("window.alignmentToolBar.title"));
		list.add(tb);
		tb = new JToolBar();
		addFurnitureButtonsTo(tb, editor);
		tb.setName(customlabels.getString("window.furnitureToolBar.title"));
		list.add(tb);
		return list;
	}

	private void addFurnitureButtonsTo(JToolBar tb, DrawingEditor editor) {
		addDefaultFurnitureButtonsTo(tb, editor, ButtonFactory.createDrawingActions(editor),
				ButtonFactory.createSelectionActions(editor));
	}

	private void addDefaultFurnitureButtonsTo(JToolBar tb, final DrawingEditor editor,
			Collection<Action> drawingActions, Collection<Action> selectionActions) {
		ResourceBundleUtil labels = ResourceBundleUtil.getBundle("de.rwth.swc.oosc.group111.Labels");
		ButtonFactory.addSelectionToolTo(tb, editor, drawingActions, selectionActions);
		tb.addSeparator();

		Map<AttributeKey, Object> attributes;
		attributes = new HashMap<AttributeKey, Object>();
		attributes.put(AttributeKeys.FILL_COLOR, null);
		attributes.put(AttributeKeys.STROKE_COLOR, null);
		Chair chair = new Chair();
		ButtonFactory.addToolTo(tb, editor, new FurnitureTool(chair, attributes), "edit.createChair", labels);
		Table table = new Table();
		ButtonFactory.addToolTo(tb, editor, new FurnitureTool(table, attributes), "edit.createTable", labels);
		ButtonFactory.addToolTo(tb, editor, new ExportTool(new ImageFigure()), "file.export", labels);

	}

}
