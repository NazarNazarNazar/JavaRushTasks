package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    //    Entry<String> root = new Entry<String>("root");
    Entry<String> root;
    Queue<Entry<String>> queue = new LinkedList<>();
    {
        queue.add(root);
    }

    public CustomTree() {
        this.root = new Entry<String>("0");
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public void checkChildren() {
            if (leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (rightChild != null) {
                availableToAddRightChildren = false;
            }
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

    }

    //метод ищет указанный элемент в графе и взвращает его или null, если его нет
    public Entry<String> findElement(Entry<String> root, String findElement){
        Entry<String> elementOut = null;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while(queue.size() != 0){
            Entry<String> currentElement = queue.remove();
            if (currentElement.elementName.equals(findElement)) {
                elementOut = currentElement;
                break;
            }
            else {
                if (currentElement.leftChild != null)
                    queue.add(currentElement.leftChild);
                if (currentElement.rightChild != null)
                    queue.add(currentElement.rightChild);
            }
        }
        return elementOut;
    }

    @Override
    public boolean remove(Object o) {
        String s = "";
        boolean deleted = false;
        try {
            s = (String) o;
        } catch (ClassCastException e) {
            throw new UnsupportedOperationException();
        }

        //ищем нужный элемент в графе и если он не null, удаляем
        Entry<String> removeElement = findElement(root, s);
        if (removeElement != null) {
            if (removeElement.parent.leftChild != null && removeElement.parent.leftChild.elementName.equals(removeElement.elementName))
                removeElement.parent.leftChild = null;
            else removeElement.parent.rightChild = null;
            removeElement.parent = null;
        }
        return true;
    }

    public String getParent(String s) {
        if (root == null) {
            return null;
        }
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        String parentName = null;
        while (parentName == null && !queue.isEmpty()) {
            Entry<String> currentEntry = queue.remove();
            if (currentEntry.leftChild != null ) {
                if (!currentEntry.leftChild.elementName.equals(s)) {
                    queue.add(currentEntry.leftChild);
                } else {
                    parentName = currentEntry.elementName;
                }
            }
            if (currentEntry.rightChild != null) {
                if (!currentEntry.rightChild.elementName.equals(s)) {
                    queue.add(currentEntry.rightChild);
                } else {
                    parentName = currentEntry.elementName;
                }
            }
        }
        return parentName;

    }

    @Override
    public int size() {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            Entry<String> leaf = queue.poll();
            size++;
            if(leaf.leftChild != null) {
                queue.offer(leaf.leftChild);
            }
            if(leaf.rightChild != null) {
                queue.offer(leaf.rightChild);
            }
        }
        return size-1;
    }

    public boolean notAvailableToAdd(Entry x){
        boolean result = true;
        ArrayDeque<Entry> deque = new ArrayDeque<>();
        deque.add(x);
        do {
            if (!deque.isEmpty()) x = deque.poll();
            if (x.leftChild != null) deque.add(x.leftChild);
            else if (x.availableToAddLeftChildren) {
                result = false;
            }
            if (x.rightChild != null) deque.add(x.rightChild);
            else if (x.availableToAddRightChildren) {
                result = false;
            }
        } while (!deque.isEmpty());
        return result;
    }

    public void makeAvailableToAdd(Entry entry){
        ArrayDeque<Entry> deque = new ArrayDeque<>();
        Entry x = root;
        deque.add(x);
        do {
            if (!deque.isEmpty()) x = deque.poll();
            if (x.leftChild == null) x.availableToAddLeftChildren = true;
            else deque.add(x.leftChild);
            if (x.rightChild == null) x.availableToAddRightChildren = true;
            else deque.add(x.rightChild);
        } while (!deque.isEmpty());
    }

    @Override
    public boolean add(String s) {
        if (notAvailableToAdd(root)) {
            makeAvailableToAdd(root);
        }
        Queue<Entry<String>> queue = new LinkedList<>();
        Entry<String> newElement = new Entry<>(s);
        queue.add(root);

        while (!queue.isEmpty()) {
            Entry<String> leaf = queue.poll();
            leaf.checkChildren();
            if(leaf.isAvailableToAddChildren()) {
                if(leaf.availableToAddLeftChildren) {
                    leaf.leftChild = newElement;
                    leaf.leftChild.parent = leaf;
                    return true;
                }
                if(leaf.availableToAddRightChildren) {
                    leaf.rightChild = newElement;
                    leaf.rightChild.parent = leaf;
                    return true;
                }
            } else {
                if(leaf.leftChild != null) {
                    queue.offer(leaf.leftChild);
                    leaf.availableToAddLeftChildren = true;
                }
                if(leaf.rightChild != null) {
                    queue.offer(leaf.rightChild);
                    leaf.availableToAddRightChildren = true;
                }
            }
        }
        return false;
    }

    @Override
    public String get(int index) {
//        return null;
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
//        super.add(index, element);
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
//        return super.set(index, element);
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
//        return super.remove(index);
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
//        return super.subList(fromIndex, toIndex);
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
//        super.removeRange(fromIndex, toIndex);
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
//        return super.addAll(index, c);
        throw new UnsupportedOperationException();
    }

}
