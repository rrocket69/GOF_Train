package Iterator;

public class IteratorController {
    public void startAction() {
        Aggregate c = new ConcreteAggregate();
        Iterator it = c.getIterator();

        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }

    interface Iterator<T> {
        boolean hasNext();

        T next();
    }

    interface Aggregate {
        Iterator getIterator();
    }

    class ConcreteAggregate implements Aggregate {
        String[] tasks = {"build walls", "build roof", "build doors"};

        @Override
        public Iterator getIterator() {
            return new TaskIterator();
        }

        private class TaskIterator implements Iterator {
            int index = 0;

            @Override
            public boolean hasNext() {
                if (index < tasks.length)
                    return true;
                return false;
            }

            @Override
            public Object next() {
                return tasks[index++];
            }
        }
    }
}
