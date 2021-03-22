public class UnpackingString {



    public static String unpackString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        recursiveUnpacking(str, 0, stringBuilder);
        return stringBuilder.toString();
    }

    private static int recursiveUnpacking(String str, int start, StringBuilder stringBuilder) {
        int i = start;
        while (i < str.length()) {

            StringBuilder numberOfRepeats = new StringBuilder();
            StringBuilder repeatingStr = new StringBuilder();

            while (Character.isDigit(str.charAt(i))) {
                numberOfRepeats.append(str.charAt(i));
                i++;
            }

            if (str.charAt(i) == '[') {
                i = recursiveUnpacking(str, i+1, repeatingStr);

                for (int j = 1; j <= Integer.parseInt(numberOfRepeats.toString()); j++) {
                    stringBuilder.append(repeatingStr);
                }

            } else if (str.charAt(i) == ']') {
                return i+1;
            } else {
                stringBuilder.append(str.charAt(i));
                i++;
            }
        }
        return i;
    }



    public static void main(String[] args) {
        System.out.println(unpackString("15[zx]"));
        System.out.println(unpackString("3[xyz]4[xy]z"));
        System.out.println(unpackString("2[3[x]y]z"));
        System.out.println(unpackString("rt2[3[x4[tt]]y]z"));

    }
}
