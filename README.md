TH-GameEngine
=============
### Description

A simple game engine for java programming. A light librairy without any required dependencies.

### How to install

Copy all files from src/ to your project and compile !

Doc
=============

### Basic Game

Here is a basic example of how to start a basic program with TH-GameEngine
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
```

And the menu class
```java
public class MenuState extends State {
	public MenuState(AppContainer ac) {
		super(ac);
	}
	
	public void update(AppContainer app, State state) {
		
	}
	
	public void draw(AppContainer container, State state, Graphics g) {
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

	public void drawCentered(String s, int y, Graphics g) {
		g.drawString(s, (int) (container.window.getWidth()/2 - g.getFontMetrics().getStringBounds(s, g).getWidth()/2),y);
	}
}
```

### Events
THGE has a events Engine
When a event is fired with the FireEvent() method, the onEvent() method is called.

```java
public class Exemple extends State {
	private Entity player;

	public Exemple(AppContainer ac) {
		super(ac);
		// TODO Auto-generated constructor stub
	}
	
	public void update(AppContainer ac, State st) {
		// Logic stuff
		
		if(!player.isAlive()) {
			this.fireEvent("death", player.getName());
		}
	}
	
	public void onEvent(String name, Object param) {
		if(name.equals("death")) {
			String player_name = (String) param;
			System.out.println(player_name+" is dead");
		}
	}
}

```

This system is also used for Key and Mouse events

```java
/**
	 * Method called every time a key event is received
	 * @param type The type of the event
	 * Can Be
	 * - typed
	 * - released
	 * - pressed
	 * @param evt
	 * The KeyEvent associated
	 */
	public void onKeyEvent(String type, KeyEvent evt) {
		
	}
	
	/**
	 * Method called every time a mouse event is received
	 * @param type The type of the event
	 * Can Be
	 * - clicked
	 * - exited
	 * - entered
	 * - released
	 * - pressed
	 * @param evt
	 * The KeyEvent associated
	 */
	public void onMouseEvent(String type, MouseEvent evt) {
		
	}
```

To be continued ...