/*
 * Created on 12.02.2004
 *
 */
package gnogitoprototype;

import org.eclipse.core.boot.IPlatformRunnable;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.WorkbenchAdvisor;

/**
 * @author matthias
 *
 * created first in project gnogitoprototype
 */
public class GnogitoPrototype implements IPlatformRunnable {
	public Object run(Object args) {
		WorkbenchAdvisor workbenchAdvisor = new GnogitoWorkbenchAdvisor();
		Display display = PlatformUI.createDisplay();
		int returnCode = PlatformUI.createAndRunWorkbench(display,
				workbenchAdvisor);
		if (returnCode == PlatformUI.RETURN_RESTART) {
			return IPlatformRunnable.EXIT_RESTART;
		} else {
			return IPlatformRunnable.EXIT_OK;
		}
	}
}