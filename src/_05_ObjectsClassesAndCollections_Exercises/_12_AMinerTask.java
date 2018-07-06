package _05_ObjectsClassesAndCollections_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _12_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Long> productsQuantities = new LinkedHashMap<>();

       String line = scanner.nextLine();
       while(!"stop".equals(line)){
           String name = line;
           long quantity = Long.parseLong(scanner.nextLine());

           if(!productsQuantities.containsKey(name)){
               productsQuantities.put(name, 0L);
           }
           productsQuantities.put(name, productsQuantities.get(name) + quantity);
           line = scanner.nextLine();
       }
        for (Map.Entry<String, Long> productQuantity : productsQuantities.entrySet()) {
            System.out.println(productQuantity.getKey() + " -> " + productQuantity.getValue());
        }
    }
}
