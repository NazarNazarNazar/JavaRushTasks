package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
Id=5, name='User-5', description=Got by executing 'SELECT * FROM USER'
Id=1, name='Location-1', description=Got by executing 'SELECT * FROM LOCATION'
*/
public class Solution {
    public List<User> getUsers() {
        return new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return String.format("SELECT * FROM %S",User.class.getSimpleName());
            }
        }.execute();
    }
    public List<Location> getLocations() {
        return new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return String.format("SELECT * FROM %S",Location.class.getSimpleName());
            }
        }.execute();
    }
    public List<Server> getServers() {
        return new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                return String.format("SELECT * FROM %S",Server.class.getSimpleName());
            }
        }.execute();
    }
    public List<Subject> getSubjects() {
        return new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return String.format("SELECT * FROM %S",Subject.class.getSimpleName());
            }
        }.execute();
    }
    public List<Subscription> getSubscriptions() {
        return new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return String.format("SELECT * FROM %S",Subscription.class.getSimpleName());
            }
        }.execute();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}
