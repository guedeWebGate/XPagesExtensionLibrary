package com.ibm.xsp.theme.bootstrap.renderkit.html.extlib;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.ibm.xsp.component.UIViewRootEx;
import com.ibm.xsp.renderkit.FacesRenderer;
import com.ibm.xsp.resource.ScriptResource;
import com.ibm.xsp.theme.bootstrap.components.UIAngluar;
import com.ibm.xsp.theme.bootstrap.resources.Resources;

public class AngularJSRenderer extends FacesRenderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		if (!component.isRendered()) {
			return;
		}
		if (!(component instanceof UIAngluar)) {
			return;
		}
		UIAngluar angularJS = (UIAngluar) component;
		String version = angularJS.getAngularVersion();
		ScriptResource resource = Resources.getAngularScriptLibrary(version);
		if (resource == null) {
			throw new FacesException("Angular JS Library with version " + version + " not found!");
		}
		UIViewRootEx rootEx = (UIViewRootEx) context.getViewRoot();
		rootEx.addEncodeResource(resource);
		
	}
}
