/*
 * Created on 12.02.2004
 *
 */
package gnogitoprototype;

import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;

/**
 * @author matthias
 *
 * created first in project gnogitoprototype
 */
public class GnogitoWorkbenchAdvisor extends WorkbenchAdvisor {

	public String getInitialWindowPerspectiveId() {
		return "gnogitoprototype.GnogitoPerspective"; //$NON-NLS-1$
	}
	public void preWindowOpen(IWorkbenchWindowConfigurer configurer) {
		super.preWindowOpen(configurer);
		configurer.setShowCoolBar(false);
		configurer.setShowShortcutBar(false);
		configurer.setShowStatusLine(false);
	}
	
	public void postWindowOpen(IWorkbenchWindowConfigurer configurer) {
		super.postWindowOpen(configurer);
		configurer.setTitle(Messages.getString("GnogitoWorkbenchAdvisor.WindowTitle")); //$NON-NLS-1$
	}

}