public class Max {
    private String message1;

    public Max(String message2) {
        this.message1 = message2;
    }

    public void printMessage(){
        System.out.println(message1);
    }

    /*
    public void main() {

        /*args = new String[]{"12", "24", "11"};
        int max = Integer.MIN_VALUE;
        for (String arg : args) {
            int value = Integer.parseInt(arg);
            if (value > max) {
                max = value;
            }
        }
        System.out.println(Arrays.toString(args));
        System.out.println(max);
        }
     */
}
