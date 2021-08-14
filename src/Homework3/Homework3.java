package Homework3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework3 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //gogame();
        guessWords();
    }

    public static void gogame() {
/* Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */
        int answer;
        do {
            game();
            System.out.println("Повторить игру еще раз? Да - 1. Нет - 0.");
            answer = scanner.nextInt();
            if (answer > 2) {   //проверка, если игрок введет числа не "1" и не "0"
                System.out.println("Пожалуйста, введите 1 чтобы продолжить игру, 0 чтобы закончить игру.");
                answer = scanner.nextInt();
            }
        } while (answer == 1);
    }

    public static void game() {
        Random random = new Random();
        int digit = random.nextInt(10);
//        System.out.println("Random number is " + digit); // строка для проверки какое число загадано
        System.out.println("Угадайте число от 0 до 9. У вас есть 3 попытки.");

        for (int i = 1; i <= 3; i++) {
            System.out.println(i + "-я попытка:");
            int userNumb = scanner.nextInt();

            if (userNumb < digit) {
                System.out.println("Загаданное число больше");
            } else if (userNumb > digit) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Вы угадали!!!");
                break;
            }
            if (i == 3 && userNumb != digit) { //Если на3ей попытке не угадал, выходит сообщение, что неудача...
                System.out.println("Вы не угадали. Было загадано число " + digit);
            }
        }
        System.out.println();
    }


/* * Создать массив из слов
String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
"grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
"pumpkin", "potato"}.
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом
и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на
своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно можно пользоваться:
String str = "apple";
char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы.
 */
    public static void guessWords() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        int index = new Random().nextInt(words.length);
        String randWord = words[index];   // случайное слово из массива words

        String compareWord = "###############";
        String end1 = compareWord.substring(randWord.length()); //создаю хвост из решеток для добивки до 15 символов
        String pcWord = randWord.concat(end1);   //собираю слово из 2х слов: рандом-слово + "#" до 15 символов
    //        System.out.println(pcWord + "randomWord");    // можно потом удалить (для проверки)
        String userWord;
        do {
            System.out.println("Угадайте, какое из этих слов загадает компьютер:");
            System.out.println(Arrays.toString(words));
            System.out.println("");

            System.out.println("Введите ваше слово: ");
            userWord = scanner.next();  //узнаю слово пользователя
            if (userWord.length() > compareWord.length()) {
                System.out.println("Вы ввели слишком длинное слово, введите другое слово:");
                userWord = scanner.next();  //узнаю слово пользователя
            }
            String end2 = compareWord.substring(userWord.length()); //создаю хвост из решеток для добивки до 15 символов
            userWord = userWord.concat(end2);   //собираю слово из 2х слов: юзер-слово + "#" до 15 символов

            if (pcWord.equals(userWord)) {
                System.out.println("Вы угадали слово - " + randWord);
                break;
            } else {
                for (int i = 0; i < 14; i++) {  //посимвольная проверка 2х слов
                    char a = pcWord.charAt(i);
                    if (a == userWord.charAt(i)) {
                        System.out.print(a);
                    } else {
                        System.out.print("#");  // печатается #, если символы не совпадают
                    }
                }
                System.out.println("");
                System.out.println("Вы не угадали, попробуйте снова!");
            }
        } while (pcWord != userWord);
    }
}