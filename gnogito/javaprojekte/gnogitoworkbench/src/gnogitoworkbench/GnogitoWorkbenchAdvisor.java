/*
 * Created on 12.02.2004
 *
 */
package gnogitoworkbench;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
/**
 * @author matthias
 * 
 * created first in project gnogitoworkbench
 */
public class GnogitoWorkbenchAdvisor extends WorkbenchAdvisor {
	public String getInitialWindowPerspectiveId() {
		return "gnogitoworkbench.GnogitoPerspective"; //$NON-NLS-1$
	}
	public void preWindowOpen(IWorkbenchWindowConfigurer configurer) {
		super.preWindowOpen(configurer);
		configurer.setShowCoolBar(true);
		configurer.setShowStatusLine(true);
		configurer.setShowMenuBar(true);
	}
	public void postWindowOpen(IWorkbenchWindowConfigurer configurer) {
		super.postWindowOpen(configurer);
		configurer.setTitle(Messages
				.getString("GnogitoWorkbenchAdvisor.WindowTitle")); //$NON-NLS-1$
	}
	public void fillActionBars(IWorkbenchWindow window,
			IActionBarConfigurer configurer, int flags) {
		super.fillActionBars(window, configurer, flags);
		if ((flags & FILL_MENU_BAR) != 0) {
			fillMenuBar(window, configurer);
		}
	}
	private void fillMenuBar(IWorkbenchWindow window,
			IActionBarConfigurer configurer) {
		IMenuManager menuBar = configurer.getMenuManager();
		menuBar.add(createFileMenu(window));
		menuBar.add(createEditMenu(window));
		menuBar.add(createWindowMenu(window));
		menuBar.add(createHelpMenu(window));
	}
	private MenuManager createFileMenu(IWorkbenchWindow window) {
		MenuManager menu = new MenuManager(Messages.getString("File"), //$NON-NLS-1$
				IWorkbenchActionConstants.M_FILE);
		menu.add(new GroupMarker(IWorkbenchActionConstants.FILE_START));
		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menu.add(ActionFactory.QUIT.create(window));
		menu.add(new GroupMarker(IWorkbenchActionConstants.FILE_END));
		return menu;
	}
	private MenuManager createEditMenu(IWorkbenchWindow window) {
		MenuManager menu = new MenuManager(Messages.getString("Edit"), //$NON-NLS-1$
				IWorkbenchActionConstants.M_EDIT);
		menu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_START));
		menu.add(ActionFactory.UNDO.create(window));
		menu.add(ActionFactory.REDO.create(window));
		menu.add(new GroupMarker(IWorkbenchActionConstants.UNDO_EXT));
		menu.add(new Separator());
		menu.add(ActionFactory.CUT.create(window));
		menu.add(ActionFactory.COPY.create(window));
		menu.add(ActionFactory.PASTE.create(window));
		menu.add(new GroupMarker(IWorkbenchActionConstants.CUT_EXT));
		menu.add(new Separator());
		menu.add(ActionFactory.DELETE.create(window));
		menu.add(ActionFactory.SELECT_ALL.create(window));
		menu.add(new Separator());
		menu.add(new GroupMarker(IWorkbenchActionConstants.ADD_EXT));
		menu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		return menu;
	}
	private MenuManager createWindowMenu(IWorkbenchWindow window) {
		MenuManager menu = new MenuManager(Messages.getString("Window"), //$NON-NLS-1$
				IWorkbenchActionConstants.M_WINDOW);
		menu.add(ActionFactory.OPEN_NEW_WINDOW.create(window));
		menu.add(new Separator());
		MenuManager perspectiveMenu = new MenuManager(Messages
				.getString("Open_Perspective"),
				IWorkbenchActionConstants.M_VIEW); //$NON-NLS-1$
		IContributionItem perspectiveList = ContributionItemFactory.PERSPECTIVES_SHORTLIST
				.create(window);
		perspectiveMenu.add(perspectiveList);
		menu.add(perspectiveMenu);
		MenuManager viewMenu = new MenuManager(Messages.getString("Show_View")); //$NON-NLS-1$
		IContributionItem viewList = ContributionItemFactory.VIEWS_SHORTLIST
				.create(window);
		viewMenu.add(viewList);
		menu.add(viewMenu);
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		menu.add(ActionFactory.PREFERENCES.create(window));
		menu.add(ContributionItemFactory.OPEN_WINDOWS.create(window));
		return menu;
	}
	private MenuManager createHelpMenu(IWorkbenchWindow window) {
		MenuManager menu = new MenuManager(Messages.getString("Help"), //$NON-NLS-1$
				IWorkbenchActionConstants.M_HELP);
		menu.add(new GroupMarker(IWorkbenchActionConstants.HELP_START));
		menu.add(new GroupMarker(IWorkbenchActionConstants.HELP_END));
		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		return menu;
	}
}