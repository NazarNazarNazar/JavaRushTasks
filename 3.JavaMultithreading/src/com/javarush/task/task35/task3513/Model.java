package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score;
    protected int maxTile;
    //для реализации возврата хода
    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
        this.previousScores = new Stack<Integer>();
        this.previousStates = new Stack<Tile[][]>();
    }

    // проверка эфеективности хода
    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else moveEfficiency = new MoveEfficiency(-1, 0, move);
        rollback();

        return moveEfficiency;
    }

    // проверка изменения поля
    public boolean hasBoardChanged() {
        boolean result = false;
        int sumNow = 0;
        int sumPrevious = 0;
        Tile[][] tmp = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                sumNow += gameTiles[i][j].getValue();
                sumPrevious += tmp[i][j].getValue();
            }
        }
        return sumNow != sumPrevious;
    }

    // делаем ход в случайном направлении
    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                up();
                break;
            case 2:
                right();
                break;
            case 3:
                down();
                break;
        }
    }

    // сохраняет состояние в стек
    private void saveState(Tile[][] tiles) {
        Tile[][] fieldToSave = new Tile[tiles.length][tiles[0].length];
        isSaveNeeded = false;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                fieldToSave[i][j] = new Tile(tiles[i][j].getValue());
            }
        }
        previousStates.push(fieldToSave);
        int scoreToSave = score;
        previousScores.push(scoreToSave);
    }

    // откат на один ход назад
    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    // геттер для поля
    public Tile[][] getGameTiles() {
        return gameTiles;
    }


    // проверка возможности хода
    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
                if (gameTiles[j][i].value == gameTiles[j - 1][i].value)
                    return true;
            }
        }
        return false;
    }


    // методы для сдвига в четырех направлениях
    public void left() {
        if (isSaveNeeded) saveState(gameTiles);
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) addTile();
    }


    // сжатие одного ряда влево
    private boolean compressTiles(Tile[] tiles) {
        boolean change = false;
        for (int i = 0; i < gameTiles.length - 1; i++) {
            for (int j = 0; j < gameTiles.length - 1; j++) {
                if (tiles[j].isEmpty() && !tiles[j + 1].isEmpty()) {
                    change = true;
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = new Tile();
                }
            }
        }
        return change;
    }

    // поворот матрицы на 90 градусов
    private void rotateToRight() {
        Tile tmp;
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - 1 - i; j++) {
                tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH - j - 1][i];
                gameTiles[FIELD_WIDTH - j - 1][i] = gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1];
                gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1] = gameTiles[j][FIELD_WIDTH - i - 1];
                gameTiles[j][FIELD_WIDTH - i - 1] = tmp;
            }
        }
    }

    void right() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
    }

    void up() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
    }

    void down() {
        saveState(gameTiles);
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
        rotateToRight();
    }

    // сложение клеток
    private boolean mergeTiles(Tile[] tiles) {
        boolean change = false;
        for (int i = 0; i < gameTiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && !tiles[i].isEmpty() && !tiles[i + 1].isEmpty()) {
                change = true;
                tiles[i].value *= 2;
                tiles[i + 1] = new Tile();
                maxTile = maxTile > tiles[i].value ? maxTile : tiles[i].value;
                score += tiles[i].value;
                compressTiles(tiles);
            }
        }

        return change;
    }

    // сброс всех клеток
    public void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        score = 0;
        maxTile = 2;
        addTile();
        addTile();
    }

    // вовзращает лист пустых клеток
    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == 0) {
                    list.add(gameTiles[i][j]);
                }
            }
        }
        return list;
    }


    // добавляет рандомно клетку 2 или 4 (соотношение 1 к 9)
    private void addTile() {
        List<Tile> list = getEmptyTiles();
        if (list.size() > 0) {
            list.get((int) (list.size() * Math.random())).value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    // реализация выбора эффективного хода из возможных
    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::down));
        Move move = queue.peek().getMove();
        move.move();
    }

}
