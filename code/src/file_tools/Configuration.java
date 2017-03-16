package file_tools;

public class Configuration {
	private static String pathFont ="configuration/font.txt";
	private static String pathpathWorkspaceApp ="configuration/pathWorkspace.txt";
	private static String openTabsPath ="configuration/openTabs.txt";
	private static String syntaxErrorPath ="configuration/syntaxError.txt";
	
	public static String getPathFont() {
		return pathFont;
	}
	public static String getPathpathWorkspaceApp() {
		return pathpathWorkspaceApp;
	}
	public static String getOpenTabsPath() {
		return openTabsPath;
	}
	public static String getSyntaxErrorPath() {
		return syntaxErrorPath;
	}

}
