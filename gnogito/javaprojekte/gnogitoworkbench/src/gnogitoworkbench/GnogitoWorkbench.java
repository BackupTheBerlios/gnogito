/*
 * Created on 12.02.2004
 *
 */
package gnogitoworkbench;
import org.eclipse.core.runtime.IPlatformRunnable;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.WorkbenchAdvisor;
/**
 * @author matthias
 * 
 * created first in project gnogitoworkbench
 */

/* ok, hier erzeugen wir die Laufzeitplatform */
public class GnogitoWorkbench implements IPlatformRunnable {
	public Object run(Object args) {
		/* wir erzeugen einen Workbench-Aufpasser und ein Display */
		
		WorkbenchAdvisor workbenchAdvisor = new GnogitoWorkbenchAdvisor();
		Display display = PlatformUI.createDisplay();
		
		/* verschiedene Möglichkeiten, je nach vorherigem Erfolg */
		int returnCode = PlatformUI.createAndRunWorkbench(display,
				workbenchAdvisor);
		if (returnCode == PlatformUI.RETURN_RESTART) {
			return IPlatformRunnable.EXIT_RESTART;
		} else {
			return IPlatformRunnable.EXIT_OK;
		}
	}
}