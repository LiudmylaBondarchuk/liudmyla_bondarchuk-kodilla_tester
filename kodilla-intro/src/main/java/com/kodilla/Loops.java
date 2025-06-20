public class Loops {
    public static void main(String[] args) {

        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
        int a = 0;
        while (a <= 10) {
            System.out.println(a);
            a++;
        }

        String[] names = new String[]{"Zygfryd", "Gwidon", "Florentyna"};

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        for (int i = names.length - 1; i >= 0; i--) {
            System.out.println(names[i]);
        }

        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = i + 1;
        }

        int sum = sumNumbers(numbers);
        System.out.println(sum);
    }

    public static int sumNumbers(int[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result = result + numbers[i];
        }
        return result;
    }
}







