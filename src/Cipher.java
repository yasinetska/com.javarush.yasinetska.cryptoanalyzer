
public class Cipher {

    public static String encrypt(String text, int shift) {

        char[] charArray = text.toCharArray();
        char[] newChars = new char[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < Alphabet.ALPHABET.length; j++) {
                if (Character.toLowerCase(charArray[i]) == Alphabet.ALPHABET[j]) {
                     try {
                        int index = j + shift;
                        if (index > Alphabet.ALPHABET.length) {
                            int newIndex = (index % Alphabet.ALPHABET.length);
                            newChars[i] = Alphabet.ALPHABET[newIndex];

                        } else {
                            newChars[i] = Alphabet.ALPHABET[index];
                       }
                    } catch (IndexOutOfBoundsException e){
                     }
                    break;
                }
            }
        }
        return new String(newChars);
    }

    public static String decrypt(String encryptedText, int shift) {

        char[] charArray = encryptedText.toCharArray();
        char[] newChars = new char[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < Alphabet.ALPHABET.length; j++) {
                if (Character.toLowerCase(charArray[i]) == Alphabet.ALPHABET[j]) {
                    int index = j - shift;
                    if (index < 0) {
                        int newIndex = Alphabet.ALPHABET.length + index;
                        newChars[i] = Alphabet.ALPHABET[newIndex];

                    } else {
                        newChars[i] = Alphabet.ALPHABET[index];
                    }
                    break;
                }
            }
        }
        return new String(newChars);
       }
}
