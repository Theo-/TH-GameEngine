TH-GameEngine
=============

A simple game engine for java programming. A light librairy without any dependencies.

How to install
=============

Copy all files from src/ to your project and compile !

Doc
=============

Here is a basic example of how to start a basic program with TH-GameEngine with a Menu
```java
public class Main {
	public static String version = "1.0r7";

	public static void main(String[] args) {
		// AppContainer is the .. container of your program
		AppContainer app = new AppContainer();
		// We add a possible state. So the menu
		app.addState(0, Menu.class)
		// Enter the menu, so display the Menu
		app.enterState(0);
		
		// Start application logic
		app.startApp();
	}
}
``

And the menu class
```java
public class MenuState extends State {
	public MenuState(AppContainer ac) {
		super(ac);
	}
	
	public void update(AppContainer app) {
		
	}
	
	public void draw(AppContainer container, Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, container.window.getWidth(), container.window.getHeight());

		g.setColor(Color.black);
		
		String fontName = "Castellar";
		g.setFont(new Font(fontName, Font.PLAIN, 50)); 
		this.drawCentered("My super game", 100, g);
		 
		this.drawCentered("Press a key", 300, g); 
		this.drawCentered("to start", 400, g);
		
		g.setFont(new Font(fontName, Font.PLAIN, 20));
		this.drawCentered("Copyright Me", 500, g);
	}
	
	// Appel�e lorsque une touche est press�e
	public void keyPressed(KeyEvent evt) {
		container.enterState(container.GAME);
	}
	
	public void drawCentered(String s, int y, Graphics g) {
		g.drawString(s, (int) (container.window.getWidth()/2 - g.getFontMetrics().getStringBounds(s, g).getWidth()/2),y);
	}
}
```

To be continued ...