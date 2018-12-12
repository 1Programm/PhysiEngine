package com.github.testarea.githubWiki.rendering.game;

import java.awt.Color;

import com.github.helperclasses.controll.Input;
import com.github.helperclasses.debug.Debug;
import com.github.helperclasses.math.Vector2;
import com.github.physiengine.components.collision.AABB;
import com.github.physiengine.components.collision.Collider;
import com.github.physiengine.components.collision.CollisionInfo;
import com.github.physiengine.components.controllers.Controller_Keyboard;
import com.github.physiengine.components.gfx.Image;
import com.github.physiengine.components.model.Model_Rectangle;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.GameStats;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.object.GameObject;

public class GameTest {

	public static void main(String[] args) {
		Debug.IgnoreLog(Input.class);
		
		
		
		GameStats stats = GameStats.SimpleGame(60, "GameTest", 600, 500);
		
		GamePlayer game = new GamePlayer(stats);
		
		ObjectSpace space = new ObjectSpace(true);
		
		GameObject o1 = new GameObject("testImage1", 0, 0, 1, 1);
		o1.addComponent(new Model_Rectangle(null, new Vector2(1, 1)));
		o1.addComponent(new Image("/images/crystals/19.png"));
		o1.getComponent(Image.class).setColor(new Color(255, 255, 255, 255)); // Alters the image color
		o1.addComponent(new AABB());
		
		GameObject o = new GameObject("testImage", 0, 0, 1f, 1f);
		o.addComponent(new Model_Rectangle(null, new Vector2(1, 1)));
		o.addComponent(new Image("/images/crystals/11.png"));
		o.addComponent(new Controller_Keyboard("W,A,S,D", 0.05f));
		o.addComponent(new AABB());
		
		new GameObject("Updater") {
			@Override
			public void update() {
				Collider c2 = o1.getComponent(Collider.class);
				Collider c1 = o.getComponent(Collider.class);
				
				CollisionInfo info = c1.resolveCollision(c2);
				
				if(info != null) {
					o.getTransform().getPos().add(-info.penetrateX, -info.penetrateY);
				}
			}
		};
		
		
		game.addSpace(space);
		game.startGame();
	}
	
}
