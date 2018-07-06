package _07_StreamAPI_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13_OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Company> statistics = new LinkedHashMap<>();
        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().replace("|", "").split(" - ");
            String company = tokens[0];
            int count = Integer.parseInt(tokens[1]);
            String product = tokens[2];

            statistics.putIfAbsent(company, new Company(company));
            statistics.get(company).add(product, count);
        }

        statistics.values().stream()
                .sorted()
                .forEach(System.out::println);

    }
}

class Company implements Comparable<Company> {
    private String name;
    private Map<String, Product> products;

    Company(String name) {
        this.name = name;
        this.products = new LinkedHashMap<>();
    }

    void add(String product, int count) {
        this.products.putIfAbsent(product, new Product(product));
        this.products.get(product).add(count);
    }

    String getName() {
        return this.name;
    }

    private Collection<Product> getProducts() {
        return this.products.values();
    }

    @Override
    public int compareTo(Company other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.getName(), this.getProducts().toString().replaceAll("[\\[\\]]", ""));
    }
}

class Product {
    private String name;
    private int count;

    Product(String name) {
        this.name = name;
        this.count = 0;
    }

    String getName() {
        return this.name;
    }

    private int getCount() {
        return this.count;
    }

    void add(int count) {
        this.count += count;
    }

    @Override
    public String toString() {
        return String.format("%s-%d", this.getName(), this.getCount());
    }
}
