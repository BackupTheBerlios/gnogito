package gnogitoprototype;
import org.eclipse.core.boot.IPlatformRunnable;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.WorkbenchAdvisor;

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