package prac;
/*
将一个字符串中的空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */
public class t4 {
    public static void main(String[] args) {
        String str="a bcd e";
        System.out.print(reverse(str));
    }
    public static String reverse(String str){
        StringBuilder buff=new StringBuilder();
        for (int i = 0; i <str.length() ; i++) {
            if (String.valueOf(str.charAt(i)).equals(" "))
                buff.append("%20");
            else buff.append(str.charAt(i));
        }
        return String.valueOf(buff);
    }
}
