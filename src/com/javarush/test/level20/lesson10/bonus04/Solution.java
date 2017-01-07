package com.javarush.test.level20.lesson10.bonus04;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution  extends AbstractList<String> implements List<String>, Cloneable, Serializable
{

    transient int size = 0;
    transient Node<String> first;
    transient Node<String> last;

    public static void main(String[] args) {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));
    }
    public Solution() {
    }

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Solution.Node<String> x = first; x != null; x = x.next) {
            if (o.equals(x.item)) return true;
        }
        return false;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Solution.Node<String> x = first; x != null; x = x.next) {
                if(x.item == null) {
                    final Solution.Node<String> next = x.next;
                    final Solution.Node<String> prev = x.prev;
                    final Solution.Node<String> parent = x.parent;
                    final Solution.Node<String> firstCh = x.firstChild;
                    final Solution.Node<String> secondCh = x.secondChild;

                    if (prev == null) {
                        first = next;
                    } else {
                        prev.next = next;
                        x.prev = null;
                    }

                    if (next == null) {
                        last = prev;
                    } else {
                        next.prev = prev;
                        x.next = null;
                    }


                    if (parent != null) {
                        if (parent.firstChild.item == null) {
                            parent.firstChild = parent.secondChild;
                        }
                        parent.secondChild = null;
                    }

                    x = null;

                    if (firstCh != null) remove(firstCh.item);
                    if (secondCh != null) remove(secondCh.item);

                    size--;
                    remove(o);
                    return true;
                }
            }
            return false;
        }
        else {
            for (Solution.Node<String> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    final Solution.Node<String> next = x.next;
                    final Solution.Node<String> prev = x.prev;
                    final Solution.Node<String> parent = x.parent;
                    final Solution.Node<String> firstCh = x.firstChild;
                    final Solution.Node<String> secondCh = x.secondChild;

                    if (prev == null) {
                        first = next;
                    } else {
                        prev.next = next;
                        x.prev = null;
                    }

                    if (next == null) {
                        last = prev;
                    } else {
                        next.prev = prev;
                        x.next = null;
                    }

                    if (parent != null) {
                        if (parent.firstChild.item.equals(o)) {
                            parent.firstChild = parent.secondChild;
                        }
                        parent.secondChild = null;
                    }

                    x = null;

                    if (firstCh != null) remove(firstCh.item);
                    if (secondCh != null) remove(secondCh.item);

                    size--;
                    remove(o);
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public boolean add(String s) {
        if (first == null) {
            first = new Node<>(null, s, null);
            first.parent = new Node<>(null, null, null);
            last = first;
        }
        else if (last.equals(first)) {
            last = new Node<>(null, s, first);
            first.next = last;
        }
        else if (last.parent == null) {
            first.firstChild = new Node<>(first, s, last);
            last.next = first.firstChild;
            last = first.firstChild;
        }
        else if (last.parent.secondChild == null) {
            last.parent.secondChild = new Node<>(last.parent, s, last);
            last = last.parent.secondChild;
            last.parent.firstChild.next = last;
        }
        else {
            for (Solution.Node<String> x = last.parent.next; x != null; x = x.next) {
                if (x.firstChild == null) {
                    x.firstChild = new Node<>(x, s, last);
                    last.next = x.firstChild;
                    last = x.firstChild;
                    break;
                }
            }
        }
        size++;
        return true;
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution clone = new Solution();
        for (Solution.Node<String> x = first; x != null; x = x.next) {
            clone.add(x.item);
        }
        return clone;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public String getParent(String value) {
        for (Solution.Node<String> x = first; x != null; x = x.next) {
            if (value == null && x.item == null) {
                return x.parent.item;
            }
            if (x.item.equals(value)) {
                return x.parent.item;
            }
        }
        return null;
    }

    private static class Node<E> implements Serializable {
        String item;
        Solution.Node<String> prev;
        Solution.Node<String> next;
        Solution.Node<String> parent;
        Solution.Node<String> firstChild;
        Solution.Node<String> secondChild;

        Node(Solution.Node<String> parent, String element, Solution.Node<String>prev) {
            this.item = element;
            this.parent = parent;
            this.prev = prev;
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iter(this);
    }

    private class Iter implements Iterator<String> {
        private Solution context;
        private Node<String> node;

        private Iter(Solution s) {
            this.context = s;
        }

        @Override
        public void remove() {
            if (node != null) {
                node = node.next;
                context.remove(node.prev.item);
                node = node.prev;
            }
        }

        @Override
        public boolean hasNext() {
            if (node != null) return node.next != null;
            return first != null;
        }

        @Override
        public String next() {
            if (node != null) {
                node = node.next;
                return node.item;
            }
            else if (first != null) {
                node = first;
                return first.item;
            }
            return null;
        }
    }
}
