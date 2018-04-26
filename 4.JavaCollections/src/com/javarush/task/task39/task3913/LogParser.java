package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.*;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery {
    private Path logDir;
    private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    public List<String> getLinesFromLogFile(Path path) throws IOException {
        File[] dir = logDir.toFile().listFiles((dir1, name) -> {
            if (name.endsWith(".log")) return true;
            return false;
        });
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path.toString()));

        String line = "";
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> getUiqueIPs = new HashSet<>();
        try {
            for (String s : getLinesFromLogFile(logDir)) {
                String[] lines = s.split("\\t");
                Date d = dateFormat.parse(lines[2]);


            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }
}