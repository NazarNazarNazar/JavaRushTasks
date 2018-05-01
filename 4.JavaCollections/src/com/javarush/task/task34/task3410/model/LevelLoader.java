package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        Set<Wall> setWall = new HashSet<>();
        Set<Box> setBox = new HashSet<>();
        Set<Home> setHome = new HashSet<>();
        Player player = null;

//        setWall.add(new Wall(200, 200));
//        setWall.add(new Wall(180, 180));
//        setWall.add(new Wall(220, 220));
//        setBox.add(new Box(240, 240));
//        setHome.add(new Home(80, 80));
//        player = new Player(40, 40);

        int loopLevel;
        if (level > 60) {
            loopLevel = level % 60;
        } else {
            loopLevel = level;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(levels.toFile()))) {
            int readLevel = 0;
            int x;
            int y = Model.FIELD_CELL_SIZE / 2;
            boolean isLevelMap = false;

            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.contains("Maze")) {
                    readLevel = Integer.parseInt(line.split(" ")[1]);
                    continue;
                }

                if (readLevel == loopLevel) {
                    if (line.length() == 0) {
                        boolean isEnd = isLevelMap;

                        isLevelMap = !isLevelMap;

                        if (isEnd && !isLevelMap) {
                            break;
                        } else continue;
                    }

                    if (isLevelMap) {
                        x = Model.FIELD_CELL_SIZE / 2;

                        char[] chars = line.toCharArray();
                        for (char c : chars) {
                            switch (c) {
                                case 'X':
                                    setWall.add(new Wall(x, y));
                                    break;
                                case '*':
                                    setBox.add(new Box(x, y));
                                    break;
                                case '.':
                                    setHome.add(new Home(x, y));
                                    break;
                                case '&':
                                    setBox.add(new Box(x, y));
                                    setHome.add(new Home(x, y));
                                    break;
                                case '@':
                                    player = new Player(x, y);
                            }
                            x += Model.FIELD_CELL_SIZE;
                        }
                        y += Model.FIELD_CELL_SIZE;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return new GameObjects(setWall, setBox, setHome, player);
    }
}
