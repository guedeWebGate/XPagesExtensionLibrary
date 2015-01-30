package com.ibm.xsp.theme.bootstrap.components;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

public class UIAngluar extends UIComponentBase {

	public static final String COMPONENT_TYPE = "ch.christianguedemann.demoplugin.uiangular"; //$NON-NLS-1$
	public static final String COMPONENT_FAMILY = "ch.christianguedemann.demoplugin.uiangular"; //$NON-NLS-1$
	public static final String RENDERER_TYPE = "ch.christianguedemann.demoplugin.uiangular"; //$NON-NLS-1$

	private String m_AngularVersion;

	public UIAngluar() {
		setRendererType(RENDERER_TYPE);
	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getAngularVersion() {
		return m_AngularVersion;
	}

	public void setAngularVersion(String angularVersion) {
		m_AngularVersion = angularVersion;
	}
	

	@Override
	public void restoreState(FacesContext context, Object value) {
		Object[] values = (Object[]) value;
		super.restoreState(context, values[0]);
		m_AngularVersion = (String) values[1];
	}

	@Override
	public Object saveState(FacesContext context) {
		Object[] values = new Object[2];
		values[0] = super.saveState(context);
		values[1] = m_AngularVersion;
		return values;
	}

}
