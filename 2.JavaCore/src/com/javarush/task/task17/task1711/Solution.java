package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u - обновляет соответствующие данные людей с заданными id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о всех людях с заданными id: name sex bd
id соответствует индексу в списке

Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
       String name;
       Sex sex;
       Date bd;
       Person p;
       int id;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            switch (args[0]) {
                case "-c": {
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i+=3) {
                            name = args[i];
                            sex = args[i+1] == "м" ? Sex.MALE : Sex.FEMALE;
                            bd = sdf.parse(args[i+2]);
                            if(sex == Sex.MALE){
                                p = Person.createMale(name, bd);
                            }else p = Person.createFemale(name, bd);
                            allPeople.add(p);
                            System.out.println(allPeople.indexOf(p));
                        }
                    }
                }break;
                case "-u": {
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length ; i+=4) {
                            id = Integer.parseInt(args[i]);
                            name = args[i+1];
                            sex = args[i+2] == "м" ? Sex.MALE : Sex.FEMALE;
                            bd = sdf.parse(args[i+3]);
                            p = allPeople.get(id);
                            p.setName(name);
                            p.setSex(sex);
                            p.setBirthDay(bd);
                        }
                    }
                }break;
                case "-d": {
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length ; i++) {
                            id = Integer.parseInt(args[i]);
                            p = allPeople.get(id);
                            p.setName(null);
                            p.setSex(null);
                            p.setBirthDay(null);
                        }
                    }
                } break;
                case "-i": {
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length ; i++) {
                            id = Integer.parseInt(args[i]);
                            p = allPeople.get(id);
                            String sx = (p.getSex() == Sex.MALE) ? "м" : "ж";
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                            System.out.println(p.getName() +" "+ sx +" "+ simpleDateFormat.format(p.getBirthDay()));
                        }
                    }
                }break;
            }
        }
}
