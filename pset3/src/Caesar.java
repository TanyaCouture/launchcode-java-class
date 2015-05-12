import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by tanyacouture on 5/11/15.
 */
public class Caesar implements Encodable {

    private int key;
    private char[] inputCharacters;

    public Caesar(int key, char[] inputCharacters) {
        // put in exception
        this.key = key;
        this.inputCharacters = inputCharacters;
       // this.totaluserInput = totaluserInput;
    }

    public char[] getinputCharacters() {
        return this.inputCharacters;
    }

    // public int getKey(){
    //   return this.key;
    // }

    @Override
    public void encode() {

            HashMap<Character, Character> encodeMap = createEncodeMap(this.key);
        for(int i = 0; i <this.inputCharacters.length; i++) {
            System.out.print(encodeMap.get(inputCharacters[i])); //key of 1, would print "b"
        }
    }

    //private HashMap<Character,Integer> createEncodeMap() {
    //}

//    @Override
    //  public String decode(){
    //
    //    return this.deCode;
    // }

    public HashMap<Character, Character> createEncodeMap(int key) {
        //int cipher = 0;
        // create a HashMap to translate each letter of the alphabet using the key
        HashMap<Character, Character> encodeMap = new HashMap<Character, Character>();

        // iterate through alphabet
        for(int i = 0; i < 26; i++){
            char lowerLetter = (char)('a'+ i);
            char cipher = (char)('a' + i + key);
            if(cipher > 'z'){
                cipher = (char)(cipher - 26);
            }
            encodeMap.put(lowerLetter,cipher);
        }
        for(int j = 0; j < 26; j++){
            char upperLetter = (char)('A' + j);
            char cipher = (char)('A' + j + key);
            if(cipher > 'Z'){
                cipher = (char)(cipher - 26);
            }
            encodeMap.put(upperLetter, cipher);
        }
        // put most punctuation in hashMap
        for(int k = 0; k < 16; k++){
            char punctuation = (char)(' ' + k);
            char cipher = (char)(' ' + k);
            if(cipher > '/'){
                cipher = (char)(cipher - 16);
            }
            encodeMap.put(punctuation, cipher);
        }
        return encodeMap;
    }

    // public String createDecodeMap(){

    //}

    public static int getKey() {
        // get key from user
        System.out.println("Please enter an integer:");
        Scanner in = new Scanner(System.in);
        int key = in.nextInt();
        key = key % 26;
        return key;
    }

    // get userSentence from user
    public static char[] getuserSentence() {
    System.out.println("Please enter characters:");
    Scanner in1 = new Scanner(System.in);
    String userSentence = in1.nextLine();

    // convert string userSentence to char array
    char[] inputCharacters = userSentence.toCharArray();
        return inputCharacters;
    }

    public static void main(String[] args){
        int key = getKey();

        char[] inputCharacters = getuserSentence();

        // encode
        Caesar totaluserInput = new Caesar(key, inputCharacters);

        // call method to cipher sentence
        totaluserInput.encode();

    }
}
