package src.com.github.helperclasses.strings;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class StringUtils {
	private static HashMap<String, Integer> keyboardKeys = new HashMap<>();
	
	static {
		keyboardKeys.put("Q", KeyEvent.VK_Q),
		keyboardKeys.put("W", KeyEvent.VK_W),
	};
	
	public static int KeyCharToKeyCode(String keyChar) {
		return keyboardKeys.get(keyChar);
	}
}
