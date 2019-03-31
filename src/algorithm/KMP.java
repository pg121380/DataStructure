package algorithm;

public class KMP {

    public static int[] getPrefixTable(String pattern){
        int[] prefixTable = new int[pattern.length()];
        int len = 0;
        int i = 1;
        prefixTable[0] = 0;
        while(i < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                prefixTable[i] = len;
                i++;
            } else {
                if(len > 0) {
                    len = prefixTable[len - 1];
                } else {
                    prefixTable[i] = len;
                    i++;
                }
            }
        }

        for (int j = prefixTable.length - 1; j > 0 ; j--) {
            prefixTable[j] = prefixTable[j - 1];
        }
        prefixTable[0] = -1;

        return prefixTable;
    }

    public static void kmpSearch(String text, String pattern){
        int[] prefixTable = getPrefixTable(pattern);

        int i = 0;
        int j = 0;

        while(i < text.length()){
            System.out.println("i=" + i + ", j=" + j);
            if(j == pattern.length() - 1 && text.charAt(i) == text.charAt(j)){
                System.out.println(String.format("在第%d", i - j));
                j = prefixTable[j];
            }
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            } else {
                j = prefixTable[j];
                if(j == -1) {
                    i++;
                    j++;
                }
            }

        }

    }

    public static void main(String[] args) {
        String text = "ababcaababcabaaabaabaabcababcabaa";
        String pattern = "ababcabaa";
        kmpSearch(text, pattern);
    }
}
