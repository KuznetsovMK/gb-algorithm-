package lesson5;

import java.util.List;

//2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
public class Bag {

    private int maxWeight;
    private List<Subject> subjectList;
    private Subject[] subjects;
    private int currentWeight = 0;
    private int maxCost = 0;

    public Bag(int maxWeight, List<Subject> subjectList) {
        this.maxWeight = maxWeight;
        this.subjectList = subjectList;
        subjects = subjectList.toArray(new Subject[0]);
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getCurrentCost() {
        return maxCost;
    }

    public int[] putSubject() {
        return find(subjectList.size());
    }

    private int[] find(int length) {

        int resWeight = 0;
        int resCost = 0;

        if (length == 1) {
            return new int[]{resWeight, resCost};
        }

        for (int i = 0; i < length; i++) {
            int[] arr = find(length - 1);
            int tempWeight = arr[0];
            int tempCost = arr[1];
            if (tempCost > maxCost) {
                currentWeight = tempWeight;
                maxCost = tempCost;
            }
            rotate(length);
        }

        for (int i = 0; i < length; i++) {
            if ((resWeight + subjects[i].getWeight() <= maxWeight)) {
                resWeight += subjects[i].getWeight();
                resCost += subjects[i].getCost();
            }
        }
        return new int[]{resWeight, resCost};
    }

    private void rotate(int length) {
        int first = subjects.length - length;
        Subject temp = subjects[first];
        for (int i = first + 1; i < subjects.length; i++) {
            subjects[i - 1] = subjects[i];
        }
        subjects[subjects.length - 1] = temp;
    }
}
