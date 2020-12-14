package HW1;

public class RandomArray {
    int max = 9;
    int countMax = 0;

    public static void main(String[] args) {

        RandomArray instance = new RandomArray();
        int arrayLength = 15;
        int[] finalArray = instance.getRandomArray(arrayLength);
        instance.printArray(finalArray);
        instance.getMaxQuantity(finalArray);
        instance.sortArray(finalArray);
        instance.printArray(finalArray);
    }

    public   int rnd(int max){

        return (int) (Math.random() * max);
    }

    private int[] getRandomArray (int length){

        int[] tmp = new int[length];
        for (int i = 0; i < tmp.length;i++) {
            tmp[i] = rnd(max);

        }

        return tmp;
    }

    public void printArray (int[] array){
        for (int j : array) {
            System.out.println(j);
        }
    }

    public  void getMaxQuantity(int[] array) {

        for (int i = 0; i < array.length ;i++) {
            if (array[i] % 2 == 0 ) {
                countMax++;
                System.out.println("индекс "+ i + " : элемент " + array[i]); // вывод данных, убедиться в правильности логики
            }
        }
        System.out.println("Кол-во четных: " + countMax);
    }
    public void sortArray (int[] array){
        int tmp;
        for (int i= 0; i< array.length;i++){
            for (int j=1;j<array.length-i;j++){
                if (array[j-1]>array[j]){
                   tmp=array[j-1];
                   array[j-1]=array[j];
                   array[j] = tmp;
                }
            }
        }
    }


}


