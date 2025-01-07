package dotComFinal;

import java.util.*;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

    private void setUpGame() {
        // Создадим несколько "сайтов" и присвоим им адреса
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        // Вводим краткие инструкции для пользователей
        System.out.println("Ваша цель - потопить три \"сайта\".");
        System.out.println("Pet.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");
        // Запрашиваем у каждого вспомогательного объекта адрес сайта
        for (DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation); // передаем местоположение, которое только что получили
        }
    }

    private void startPlaying() {

        while (!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Сделай ход: ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {

        numOfGuesses++;
        String result = "Мимо";

        for (DotCom dotComToTest : dotComsList) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Попал(а)")) {
                break;
            }
            if (result.equals("Потопил(a)")) {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {

        System.out.println("Все \"сайты\" ушли ко дну! Ваши акции теперь ничего не стоят!");
        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у вас всего" + numOfGuesses + " попыток.");
            System.out.println("Вы успели добраться до того, как ваши вложения утонули.");
        } else {
            System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений.");
        }
    }
}