public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr1; // 정석 ㅇ방법
        int arr2[]; // 가능하나 권장하지 않음
        int[] arr3 = new int[3]; // 배열 생성하여 대입
        System.out.println(arr3[0]); 
        System.out.println(arr3[1]);

        int[] num1 = {10, 20, 30};
        int[] num2 = new int[]{10, 20, 30};
        int[] num3;

        int[] data = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        System.out.println(sum);

        int[] x = {1, 2, 3};
        int[] y = new int[3];
        for(int i=0;i<x.length;i++) {
            y[i] = x[i];
        }

        double[] dArr = new double[3];
        dArr[0] = 1.0;
        System.out.println(dArr[0]);
        System.out.println(dArr, length);
        System.out.println(dArr[dArr.length - 1]);
    String[] strs = new String[3];
    strs[0] = "Hello";
    strs[1] = "World!!!";
    strs[2] = "Mirim Meister School";
    int[][] a;
    
    }   
}
