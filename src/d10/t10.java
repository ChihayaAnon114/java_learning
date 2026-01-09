package d10;
import java.util.*;
import java.util.Scanner;
//编写程序实现将一个字符串中包含某些字母的单词分类列举出来。
/*
1、将句子中的单词分离出来，存入数组（可以简单的以空格为单词的分隔符）
2、创建4个List，分别存储包含4种英文字母的单词
3、创建1个Map，存储的键值对分别为英文字母和匹配的List
4、遍历Map，显示结果
注意有的单词同时包括多个搜索的字母，需要都显示出来，如图中红色方框的单词
 */
public class t10 {
    public static void main(String[] args) {
        String temp=null;
        List<String> lst_a=new ArrayList<>();
        List<String> lst_s=new ArrayList<>();
        List<String> lst_j=new ArrayList<>();
        List<String> lst_y=new ArrayList<>();
        Map<Character,List> res=new HashMap<>();
        List<String> words = getWords();
        for (String word : words) {
            if (word.contains("a"))
                lst_a.add(word);
            if (word.contains("s")) {
                lst_s.add(word);
            }
            if (word.contains("j")) {
                lst_j.add(word);
            }
            if (word.contains("y")) {
                lst_y.add(word);
            }
        }
        res.put('a',lst_a);res.put('s',lst_s);res.put('j',lst_j);res.put('y',lst_y);
        for (Map.Entry<Character, List> entry : res.entrySet()){
            System.out.println(entry.getKey().toString()+ Arrays.toString(entry.getValue().toArray()));
        }
    }

    private static List<String> getWords() {
//        String sentence="Do you fear a love fool who is loving you so deeply?" +
//                "First impression of you is most lasting. Love understands love; it needs no talk." +
//                "Your smiling at me is my daily dose of magic. Love warms more than a thousand fires." +
//                " The heart that once truly loves never forgets. In love folly is always sweet. " +
//                "First love is unforgettable all ones life. Where there is love, there are always wishes. " +
//                "Being with you is like walking on a very clear morning. Why do the good girls, " +
//                "always want the bad boys? The road to a lovers house is never long. " +
//                "No words are necessary between two loving hearts.";
        Scanner inp=new Scanner(System.in);
        String sentence=inp.nextLine();
        return new ArrayList<>(Arrays.asList(sentence.split("[^A-Za-z]+")));
    }
}