package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader =
            new LevelLoader(Paths.get(
                    "D:\\JavaRush_Tasks\\JavaRushTasks\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task34\\task3410\\res\\levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();

        if (checkWallCollision(player, direction)) {
            return;
        }

        if (checkBoxCollisionAndMoveIfAvaliable(direction)) {
            return;
        }

        switch (direction) {
            case LEFT:
                player.move(-FIELD_CELL_SIZE, 0);
            case RIGHT:
                player.move(FIELD_CELL_SIZE, 0);
            case UP:
                player.move(0, -FIELD_CELL_SIZE);
            case DOWN:
                player.move(0, FIELD_CELL_SIZE);
        }
        checkCompletion();
    }

    public void checkCompletion() {
        boolean yes = true;

        for (Home home : gameObjects.getHomes()) {
            boolean currentyes = false;

            for (Box box : gameObjects.getBoxes()) {
                if ((box.getX() == home.getX()) && (box.getY() == home.getY()))
                    currentyes = true;
            }

            if (!currentyes) yes = false;
        }

        if (yes)
            eventListener.levelCompleted(currentLevel);
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
        Player player = gameObjects.getPlayer();

        // найдем во что уперся игрок
        GameObject stoped = null;
        for (GameObject gameObject : gameObjects.getAll()) {
            if (!(gameObject instanceof Player) && !(gameObject instanceof Home) && player.isCollision(gameObject, direction)) {
                stoped = gameObject;
            }
        }

        //свободное место или дом
        if ((stoped == null)) {
            return false;
        }
        if (stoped instanceof Box) {
            Box stopedBox = (Box) stoped;
            if (checkWallCollision(stopedBox, direction)) {
                return true;
            }
            for (Box box : gameObjects.getBoxes()) {
                if (stopedBox.isCollision(box, direction)) {
                    return true;
                }
            }
            switch (direction) {
                case LEFT:
                    stopedBox.move(-FIELD_CELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_CELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_CELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_CELL_SIZE);
                    break;
            }
        }
        return false;
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction))
                return true;
        }
        return false;
    }

    // должен возвращать все игровые объекты
    public GameObjects getGameObjects() {
        return gameObjects;
    }

    // должен получать новые игровые объекты для указанного уровня у загрузчика уровня levelLoader и
    // сохранять их в поле gameObjects
    public void restartLevel(int level) {
        this.gameObjects = levelLoader.getLevel(level);
    }


    // должен перезапускать текущий уровень, вызывая restartLevel с нужным параметром
    public void restart() {
        restartLevel(currentLevel);
    }


    // должен увеличивать значение переменной currentLevel,
    // хранящей номер текущего уровня и выполнять перезапуск нового уровня
    public void startNextLevel() {
        currentLevel = currentLevel + 1;
        restartLevel(currentLevel);
    }
}
