import java.util.Scanner;
import java.util.ArrayList;


public class caesarCipher {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        Caesar message = new Caesar();

        while (true) {
            System.out.print("""
                     1. Encrypt a message
                     2. Decrypt a message
                     3. Quit
                    """);

            int userChoice = scan.nextInt();

            if (userChoice == 1){
                System.out.println("What is the message to encrypt?");
                scan.nextLine();
                String text = scan.nextLine();
                System.out.println("Encrypted: " + message.encrypt(text.toLowerCase()));
            }
            else if (userChoice == 2) {
                System.out.println("What is the message to decrypt?");
                scan.nextLine();
                String text = scan.nextLine();
                System.out.println("Decrypted: " + message.decrypt(text.toLowerCase()));
            }
            else if (userChoice == 3) {
                break;
            }

        }
    }


}

class Caesar {
    ArrayList<Character> alphabet = new ArrayList<>();

    public Caesar() {
        for(char letter = 'a'; letter <= 'z'; letter++){
            alphabet.add(letter);
        }
    }

    public int position_of_char(char letter){
        int letterPosition = 0;
        for (int index=0; index< alphabet.size(); index++){
            if(alphabet.get(index) == letter){
                letterPosition = index;
                break;
            }
        }
        return letterPosition;
    }

    public char letter_at_pos (int letterPosition) {
        return alphabet.get(letterPosition);
    }

    public char encrypt_char(char letter){
        int position = position_of_char(letter);
        int newPosition = position + 3;
        if (newPosition >= 26){
            newPosition = newPosition - 26;
        }
        return letter_at_pos(newPosition);
    }

    public char decrypt_char (char letter){
        int position = position_of_char(letter);
        int newPosition = position - 3;
        if(newPosition < 0){
            newPosition = newPosition + 26;
        }
        return letter_at_pos(newPosition);
    }

    public String encrypt (String message){
        StringBuilder ciphertext = new StringBuilder();
        for(int i=0; i< message.length(); i++){
            ciphertext.append(encrypt_char(message.charAt(i)));
        }
        return ciphertext.toString();
    }

    public String decrypt (String message) {
        StringBuilder plaintext = new StringBuilder();
        for(int i=0; i< message.length(); i++){
            plaintext.append(decrypt_char(message.charAt(i)));
        }
        return plaintext.toString();
    }
}