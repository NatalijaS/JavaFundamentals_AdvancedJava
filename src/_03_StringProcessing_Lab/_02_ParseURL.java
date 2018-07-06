package _03_StringProcessing_Lab;

import java.util.Scanner;

public class _02_ParseURL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] protocolSplit = input.split("://");

        if (protocolSplit.length != 2) {
            System.out.println("Invalid URL");
            return;
        }

        String protocol = protocolSplit[0];
        String urlRemainder = protocolSplit[1];

        int index = urlRemainder.indexOf("/");

        String server = urlRemainder.substring(0, index);
        String resources = urlRemainder.substring(index + 1);

        System.out.println("Protocol = " + protocol);
        System.out.println("Server = " + server);
        System.out.println("Resources = " + resources);
    }
}
