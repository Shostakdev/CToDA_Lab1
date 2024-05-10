import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String text = "Якщо ви гарячої літньої днини, коли й вітерець не шелесне, стомитесь у дорозі " +
                "та присядете десь на горбку відпочити, то відразу вдихнете гіркувато-приємний освіжаючий " +
                "дух деревію, що тут таки довкруж розсипав свої білі щитоподібні суцвіття на високих і " +
                "міцних внизу брунатних стеблах. Коли ж помнете в долонях один такий щиток або потрете " +
                "візерунчаті листки і глибоко вдихнете бальзамовий запах, то відчуєте, як стало вам легко, " +
                "приємно, як прибувають сили. Ось ви вже й готові бадьоріше продовжувати свою путь. " +
                "Ця багаторічна трав'яниста рослина надзвичайно поширена по всій Україні. Деревій можна " +
                "знайти практично скрізь: у лісах і чагарниках, на галявинах і узліссях, на вкритих травою " +
                "степових схилах і на високих берегах річок, у низинах і байраках, попід парканами і вздовж доріг, " +
                "у лісосмугах і на сухих луках.";
        text = text.toLowerCase();

        // Підрахунок кількості повторення кожної літери
        Map<Character, Integer> charCountMap = new TreeMap<>();
        int totalLetters = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
                totalLetters++;
            }
        }

        // Розрахунок частоти кожної літери відносно загальної кількості букв
        Map<Character, Double> charFrequencyMap = new TreeMap<>();
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            char character = entry.getKey();
            int count = entry.getValue();
            double frequency = (double) count / totalLetters * 100; // Розрахунок у відсотках
            charFrequencyMap.put(character, frequency);
        }

        // Пошук мінімальної та максимальної частоти літер
        Character minChar = null, maxChar = null;
        double minFrequency = Double.MAX_VALUE;
        double maxFrequency = Double.MIN_VALUE;

        for (Map.Entry<Character, Double> entry : charFrequencyMap.entrySet()) {
            char character = entry.getKey();
            double frequency = entry.getValue();

            if (frequency < minFrequency) {
                minFrequency = frequency;
                minChar = character;
            }

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                maxChar = character;
            }
        }

        // Виведення мінімальної та максимальної частоти
        System.out.println("\nЕкстремуми частот:");
        System.out.println("Мінімальна частота: " + minChar + " - " + String.format("%.2f", minFrequency) + "%");
        System.out.println("Максимальна частота: " + maxChar + " - " + String.format("%.2f", maxFrequency) + "%");

        // Виведення даних у табличній формі
        System.out.println("\nЛітера | Частота (%)");
        System.out.println("--------------------");
        for (Map.Entry<Character, Double> entry : charFrequencyMap.entrySet()) {
            char character = entry.getKey();
            double frequency = entry.getValue();
            System.out.printf("'%c'    | %.2f%%\n", character, frequency);
        }
    }
}