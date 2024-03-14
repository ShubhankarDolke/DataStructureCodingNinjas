public class TestFileHelloWorld {

    public static void main(String[] args) {
        int [] array = new int[10];
        for(int i = 0; i < array.length; i++) {
            array[i] = i * i;
        }

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " -> ");
        }

    }
}
