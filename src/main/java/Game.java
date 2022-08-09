import java.util.*;

public class Game {

        public void createMemoryGame() {
            System.out.println("Welcome in Memory Game");
            System.out.println("Chose difficulty level of the game:\n1. Easy \n2. Hard ");
            Scanner scanner = new Scanner(System.in);
            String difficultyLevel = scanner.nextLine().toLowerCase();

            FileReaders fileReaders = new FileReaders();
            List<String> allWords = fileReaders.readWordsFile();

            Random random = new Random();
            List<String> wordsInGame = new ArrayList<>();

            int amountOfWords = 0;
            int chances = 0;

            if (difficultyLevel.equals("easy")) {
                amountOfWords = 4;
                chances = 10;
            }

            else if (difficultyLevel.equals("hard")) {
                amountOfWords = 8;
                chances = 15;
            } else {
                System.out.println("You wrote wrong option");
            }

            while (wordsInGame.size() < amountOfWords) {
                String word = allWords.get(random.nextInt(allWords.size()));
                if (!wordsInGame.contains(word)) {
                    wordsInGame.add(word);
                }
            }

            wordsInGame.addAll(wordsInGame);
            Collections.shuffle(wordsInGame);

        for (String s:wordsInGame){
            System.out.println(s);
        }

        List<Field> fields = Field.createFields(wordsInGame);

        while (chances > 0) {
            if (difficultyLevel.equals("easy")){
                int y = (int) fields.stream()
                        .filter(field -> field.getActualvalue()!="X")
                        .count();
                if (y == fields.size()){
                    System.out.println("You won the game! Congratulations!");
                    return;
                }
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s%n", "", "1", "2", "3", "4");
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s%n", "A", fields.get(0).getActualvalue(), fields.get(1).getActualvalue(), fields.get(2).getActualvalue(), fields.get(3).getActualvalue());
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s%n", "B", fields.get(4).getActualvalue(), fields.get(5).getActualvalue(), fields.get(6).getActualvalue(), fields.get(7).getActualvalue());
                System.out.println("Choose coordinate of the word (ex. A1)");
                Scanner scanner1 = new Scanner(System.in);
                String numberOfWord1 = scanner1.nextLine();
                int index1 = Integer.parseInt(String.valueOf(numberOfWord1.charAt(1)))-1;
                if (numberOfWord1.charAt(0) == 'B'){
                    index1 = index1 + 4;
                }
                fields.get(index1).setActualvalue(fields.get(index1).getValue());
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s%n", "", "1", "2", "3", "4");
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s%n", "A", fields.get(0).getActualvalue(), fields.get(1).getActualvalue(), fields.get(2).getActualvalue(), fields.get(3).getActualvalue());
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s%n", "B", fields.get(4).getActualvalue(), fields.get(5).getActualvalue(), fields.get(6).getActualvalue(), fields.get(7).getActualvalue());

                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Choose coordinate of second word");
                String numberOfWord2 = scanner2.nextLine();
                int index2 = Integer.parseInt(String.valueOf(numberOfWord2.charAt(1)))-1;
                if (numberOfWord2.charAt(0) == 'B'){
                    index2 = index2 + 4;
                }
                fields.get(index2).setActualvalue(fields.get(index2).getValue());
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s%n", "", "1", "2", "3", "4");
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s%n", "A", fields.get(0).getActualvalue(), fields.get(1).getActualvalue(), fields.get(2).getActualvalue(), fields.get(3).getActualvalue());
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s%n", "B", fields.get(4).getActualvalue(), fields.get(5).getActualvalue(), fields.get(6).getActualvalue(), fields.get(7).getActualvalue());

                if (!wordsInGame.get(index1).equals(wordsInGame.get(index2))) {
                    chances--;
                    fields.get(index1).setActualvalue("X");
                    fields.get(index2).setActualvalue("X");
                    System.out.println("You didn't guess! You still have " + chances + " chances.");
                } else if (wordsInGame.get(index1).equals(wordsInGame.get(index2))){
                    amountOfWords--;
                    System.out.println("You guessed pair of the words. You still have " + amountOfWords + " words to guess");
                }

            } if (difficultyLevel.equals("hard")){
                int y = (int) fields.stream()
                        .filter(field -> field.getActualvalue()!="X")
                        .count();
                if (y == fields.size()){
                    System.out.println("You won the game! Congratulations!");
                    return;
                }
                System.out.println("Choose coordinate of the word (ex. A1)");
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s%n", "", "1", "2", "3", "4", "5", "6", "7", "8");
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s%n", "A", fields.get(0).getActualvalue(), fields.get(1).getActualvalue(), fields.get(2).getActualvalue(), fields.get(3).getActualvalue(), fields.get(4).getActualvalue(),fields.get(5).getActualvalue(), fields.get(6).getActualvalue(),fields.get(7).getActualvalue());
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s%n", "B", fields.get(8).getActualvalue(), fields.get(9).getActualvalue(), fields.get(10).getActualvalue(), fields.get(11).getActualvalue(), fields.get(12).getActualvalue(),fields.get(13).getActualvalue(), fields.get(14).getActualvalue(), fields.get(15).getActualvalue());

                Scanner scanner1 = new Scanner(System.in);
                String numberOfWord1 = scanner1.nextLine();
                int index1 = Integer.parseInt(String.valueOf(numberOfWord1.charAt(1)))-1;
                if (numberOfWord1.charAt(0) == 'B'){
                    index1 = index1 + 8;
                }
                fields.get(index1).setActualvalue(fields.get(index1).getValue());
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s%n", "", "1", "2", "3", "4", "5", "6", "7", "8");
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s%n", "A", fields.get(0).getActualvalue(), fields.get(1).getActualvalue(), fields.get(2).getActualvalue(), fields.get(3).getActualvalue(), fields.get(4).getActualvalue(),fields.get(5).getActualvalue(), fields.get(6).getActualvalue(),fields.get(7).getActualvalue());
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s%n", "B", fields.get(8).getActualvalue(), fields.get(9).getActualvalue(), fields.get(10).getActualvalue(), fields.get(11).getActualvalue(), fields.get(12).getActualvalue(),fields.get(13).getActualvalue(), fields.get(14).getActualvalue(), fields.get(15).getActualvalue());

                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Choose coordinate of second word");
                String numberOfWord2 = scanner2.nextLine();
                int index2 = Integer.parseInt(String.valueOf(numberOfWord2.charAt(1)))-1;
                if (numberOfWord2.charAt(0) == 'B'){
                    index2 = index2 + 8;
                }
                fields.get(index2).setActualvalue(fields.get(index2).getValue());
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s%n", "", "1", "2", "3", "4", "5", "6", "7", "8");
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s%n", "A", fields.get(0).getActualvalue(), fields.get(1).getActualvalue(), fields.get(2).getActualvalue(), fields.get(3).getActualvalue(), fields.get(4).getActualvalue(),fields.get(5).getActualvalue(), fields.get(6).getActualvalue(),fields.get(7).getActualvalue());
                System.out.printf("%2s  %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s   %-12s%n", "B", fields.get(8).getActualvalue(), fields.get(9).getActualvalue(), fields.get(10).getActualvalue(), fields.get(11).getActualvalue(), fields.get(12).getActualvalue(),fields.get(13).getActualvalue(), fields.get(14).getActualvalue(), fields.get(15).getActualvalue());

                if (!wordsInGame.get(index1).equals(wordsInGame.get(index2))) {
                    chances--;
                    fields.get(index1).setActualvalue("X");
                    fields.get(index2).setActualvalue("X");
                    System.out.println("You didn't guess! You still have " + chances + " chances.");
                } else if (wordsInGame.get(index1).equals(wordsInGame.get(index2))){
                    amountOfWords--;
                    System.out.println("You guessed pair of the words. You still have " + amountOfWords + " words to guess");
                }
            }
            }
            if (chances == 0){
                System.out.println("You losed the game. No more chances");
                return;
            }


    }
}




