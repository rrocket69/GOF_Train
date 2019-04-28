package Strategy;

import java.util.Arrays;

public class StrategyController {
    public void startAction() {
        int[] arr = {2, 4, 7, 2, 1, 4, 5};
        System.out.println(Arrays.toString(arr));
        StrategyClient c = new StrategyClient();

        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr.clone());

        c.setStrategy(new SelectionSort());
        c.executeStrategy(arr.clone());

        c.setStrategy(new InsertingSort());
        c.executeStrategy(arr.clone());

    }

    class StrategyClient {
        Sorting strategy;

        public void setStrategy(Sorting strategy) {
            this.strategy = strategy;
        }

        public void executeStrategy(int[] arr) {
            strategy.sort(arr);
        }
    }

    interface Sorting {
        void sort(int[] arr);
    }

    class BubbleSort implements Sorting {
        public void sort(int[] arr) {
            for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
                for (int i = 0; i < barrier; i++) {
                    if (arr[i] > arr[i + 1]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }
            }
            System.out.println("BubbleSort: ");
            System.out.println(Arrays.toString(arr));
        }
    }

    class SelectionSort implements Sorting {

        public void sort(int[] arr) {

            for (int barrier = 0; barrier < arr.length - 1; barrier++) {
                for (int i = barrier; i < arr.length; i++) {
                    if (arr[i] < arr[barrier]) {
                        int temp = arr[i];
                        arr[i] = arr[barrier];
                        arr[barrier] = temp;
                    }

                }

            }
            System.out.println("SelectionSort");
            System.out.println(Arrays.toString(arr));
        }
    }

    class InsertingSort implements Sorting {
        public void sort(int[] arr) {
            for (int barrier = 1; barrier < arr.length; barrier++) {
                int index = barrier;
                while (index - 1 >= 0 && arr[index] < arr[index - 1]) {
                    int temp = arr[index];
                    arr[index] = arr[index - 1];
                    arr[index - 1] = temp;
                    index--;
                }
            }
            System.out.println("InsertingSort");
            System.out.println(Arrays.toString(arr));
        }
    }

}
