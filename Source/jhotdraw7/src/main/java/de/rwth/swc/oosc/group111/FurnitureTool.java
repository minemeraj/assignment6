
package de.rwth.swc.oosc.group111;

import java.awt.FileDialog;
import java.awt.Frame;
import java.util.Map;

import javax.annotation.Nullable;
import javax.swing.JFileChooser;

import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.ImageHolderFigure;
import org.jhotdraw.draw.tool.CreationTool;

public class FurnitureTool extends CreationTool {

    @Nullable protected FileDialog fileDialog;
    @Nullable protected JFileChooser fileChooser;
    protected boolean useFileDialog;
    protected Thread workerThread;

    /** Creates a new instance. */
    public FurnitureTool(ImageHolderFigure prototype) {
        super(prototype);
    }

    /** Creates a new instance. */
    public FurnitureTool(ImageHolderFigure prototype, Map<AttributeKey, Object> attributes) {
        super(prototype, attributes);
    }

    public void setUseFileDialog(boolean newValue) {
        useFileDialog = newValue;
        if (useFileDialog) {
            fileChooser = null;
        } else {
            fileDialog = null;
        }
    }

    public boolean isUseFileDialog() {
        return useFileDialog;
    }

    @Override
    public void activate(DrawingEditor editor) {
        super.activate(editor);

    }

    private JFileChooser getFileChooser() {
        if (fileChooser == null) {
            fileChooser = new JFileChooser();
        }
        return fileChooser;
    }

    private FileDialog getFileDialog() {
        if (fileDialog == null) {
            fileDialog = new FileDialog(new Frame());
        }
        return fileDialog;
    }
}
