package gnogitoprototype;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;

public class GnogitoWorkbenchAdvisor extends WorkbenchAdvisor {

	public String getInitialWindowPerspectiveId() {
		return "gnogitoprototype.GnogitoPerspective";
	}
	
	public void postWindowOpen(IWorkbenchWindowConfigurer configurer) {
		super.postWindowOpen(configurer);
		configurer.setTitle("GnogitoPrototype");
	}
}