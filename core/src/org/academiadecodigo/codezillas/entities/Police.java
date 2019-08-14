package org.academiadecodigo.codezillas.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import org.academiadecodigo.codezillas.directions.Directions;
import org.academiadecodigo.codezillas.map.GameMap;

import java.util.ArrayList;

public class Police implements Entity {
    private float amount = 150;
    private Rectangle policeRect;
    private Texture img;
    private GameMap gameMap;
    private Directions lastDirection = Directions.LEFT;
    private Directions movingDirection;
    private ArrayList<Rectangle> polices = new ArrayList<>();

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }


    public void create() {
        img = new Texture("cop2.png");

        policeRect = new Rectangle();
        policeRect.x = 400;
        policeRect.y = 420;
        policeRect.height = img.getHeight();
        policeRect.width = img.getWidth();
    }

    public Rectangle getPoliceRect() {
        return policeRect;
    }

    public ArrayList<Rectangle> getPolices() {
        return polices;
    }

    public Texture getImg() {
        return img;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public void moveX(float amount) {
        policeRect.y -= amount * Gdx.graphics.getDeltaTime();

    }


    @Override
    public void moveY(float amount) {

    }

    public void moveDirection() {
        double rng = Math.random();

        if (rng <= 0.90) {
            movingDirection = lastDirection;
        }

        if (rng > 0.910 && rng <= 0.925) {
            movingDirection = Directions.UP;
        }

        if (rng > 0.926 && rng <= 0.950) {
            movingDirection = Directions.DOWN;
        }

        if (rng > 0.951 && rng <= 0.975) {
            movingDirection = Directions.LEFT;
        }

        if (rng > 0.976 && rng <= 1.000) {
            movingDirection = Directions.RIGHT;
        }

        switch (movingDirection) {
            case UP:
                if (!gameMap.doesRectCollideWithMap
                        (policeRect.getX()
                                , policeRect.getY()
                                , (int) policeRect.getWidth()
                                , (int) policeRect.getHeight())) {
                    policeRect.y += amount *
                            Gdx.graphics.
                                    getDeltaTime();
                    lastDirection = Directions.UP;
                    break;
                }
                policeRect.y -= amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.DOWN;
                break;
            case DOWN:
                if (!gameMap.doesRectCollideWithMap(policeRect.getX(), policeRect.getY(), (int) policeRect.getWidth(), (int) policeRect.getHeight())) {
                    policeRect.y -= amount * Gdx.graphics.getDeltaTime();
                    lastDirection = Directions.DOWN;
                    break;
                }
                policeRect.y += amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.UP;
                break;
            case LEFT:
                if (!gameMap.
                        doesRectCollideWithMap
                                (policeRect.getX()
                                        , policeRect.getY()
                                        , (int) policeRect.getWidth()
                                        , (int) policeRect.getHeight())) {
                    policeRect.x -= amount * Gdx.graphics.getDeltaTime();
                    lastDirection = Directions.LEFT;
                    break;
                }
                policeRect.x += amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.RIGHT;
                break;
            case RIGHT:
                if (!gameMap.doesRectCollideWithMap(policeRect.getX(), policeRect.getY(), (int) policeRect.getWidth(), (int) policeRect.getHeight())) {
                    policeRect.x += amount * Gdx.graphics.getDeltaTime();
                    lastDirection = Directions.RIGHT;
                    break;
                }
                policeRect.x -= amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.LEFT;
                break;
            default:
                if (!gameMap.doesRectCollideWithMap(policeRect.getX(), policeRect.getY(), (int) policeRect.getWidth(), (int) policeRect.getHeight())) {
                    policeRect.y += amount * Gdx.graphics.getDeltaTime();
                    lastDirection = Directions.UP;
                    break;
                }
                policeRect.y -= amount * Gdx.graphics.getDeltaTime();
                lastDirection = Directions.DOWN;
        }


    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public Vector2 getPos() {
        return null;
    }

    @Override
    public float getX() {
        return 400;
    }

    @Override
    public float getY() {
        return 420;
    }

    @Override
    public EntityType getType() {
        return EntityType.POLICE;
    }

    @Override
    public int getWidth() {
        return getType().getWeith();
    }

    @Override
    public int getHeight() {
        return getType().getHeight();
    }


}
