package com.github.testarea.asteroidFall;

import java.awt.Color;

import com.github.helperclasses.math.MathHelp;
import com.github.helperclasses.math.Vector2;
import com.github.physiengine.components.collision.detection.AABBCollider;
import com.github.physiengine.components.collision.detection.Collider;
import com.github.physiengine.components.collision.detection.CollisionInfo;
import com.github.physiengine.components.collision.resolution.Resolver;
import com.github.physiengine.components.controllers.Controller;
import com.github.physiengine.components.controllers.Controller_Keyboard;
import com.github.physiengine.components.gfx.Image;
import com.github.physiengine.components.model.Model_Rectangle;
import com.github.physiengine.engine.GamePlayer;
import com.github.physiengine.engine.GameStats;
import com.github.physiengine.engine.ObjectSpace;
import com.github.physiengine.object.GameObject;

public class Game {
	
	private GamePlayer game;
	private GameObject player;
	
	public Game() {
		game = new GamePlayer(GameStats.SimpleGame(60, "Asteroid Fall", 600, 500));
		
		ObjectSpace space = new ObjectSpace(true);
		
		init();
		
		game.addSpace(space);
		
		game.startGame();
	}
	
	private int timer = 120;
	
	private void init() {
		player = new GameObject("Player", 0, -2, 0.5f, 0.5f);
		player.addComponent(new Model_Rectangle());
		player.addComponent(new Image(Color.WHITE));
		player.addComponent(new Controller_Keyboard(0.05f));
		player.addComponent(new AABBCollider());
		
		
		
		new GameObject("Spawner") {
			@Override
			public void update() {
				timer--;
				if(timer == 0) {
					timer = 120;
					createAsteroid();
				}
			}
		};
	}
	
	private void createAsteroid() {
		float size = getRandom(0.5f, 0.7f);
		float rot = getRandom(- 0.5f, 0.5f) * 3;
		float speedY = getRandom(-0.02f, -0.04f);
		
		GameObject asteroid = new GameObject("asteroid", 0, 3, size, size);
		asteroid.addComponent(new Model_Rectangle(null, new Vector2(1.7f, 1.7f)));
		asteroid.addComponent(new Image("/images/crystals/5.png"));
		asteroid.addComponent(new Controller() {
			
			@Override
			public Vector2 updatePos() {
				parent.getTransform().setRotation(parent.getTransform().getRotation() + rot);
				
				if(parent.getTransform().getPos().y < MathHelp.getGamePosY(500)) {
					setRandomPos(parent);
					parent.getTransform().getPos().y = MathHelp.getGamePosY(-100);
				}
				
				parent.getComponent(Collider.class).detectCollision(player.getComponent(Collider.class));
				
				return new Vector2(0, speedY);
			}
		});
		asteroid.addComponent(new AABBCollider());
		asteroid.addComponent(new Resolver() {
			
			@Override
			protected void resolveCollision(CollisionInfo info) {
				parent.getComponent(Image.class).setColor(1, 1, 1, 0.5f);
			}
		});
		
		setRandomPos(asteroid);
	}
	
	private void setRandomPos(GameObject obj) {
		float x = getRandom(MathHelp.getGamePosX(0), MathHelp.getGamePosX(600));
		
		obj.getTransform().setPos(x, MathHelp.getGamePosY(-100));
	}
	
	
	private float getRandom(float min, float max) {
		return (float)(Math.random()*(max - min) + min);
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
