import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class HuffmanNode {
char character;
int frequency;
HuffmanNode left;
HuffmanNode right;

HuffmanNode(char character, int frequency) {
    this.character = character;
    this.frequency = frequency;
    this.left = null;
    this.right = null;
}
}

class HuffmanCodes {
private ArrayList<Character> characters;
private ArrayList<Integer> frequencies;

public HuffmanCodes() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of characters: ");
    int numCharacters = scanner.nextInt();
    characters = new ArrayList<>();
    frequencies = new ArrayList<>();

    System.out.println("Enter the characters and their frequencies:");
    for (int i = 0; i < numCharacters; i++) {
        char character = scanner.next().charAt(0);
        int frequency = scanner.nextInt();
        characters.add(character);
        frequencies.add(frequency);
    }
}

public void generateHuffmanCodes() {
    PriorityQueue<HuffmanNode> pq = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);

    // Create leaf nodes and add them to the priority queue
    for (int i = 0; i < characters.size(); i++) {
        pq.offer(new HuffmanNode(characters.get(i), frequencies.get(i)));
    }

    // Build the Huffman tree
    while (pq.size() > 1) {
        HuffmanNode left = pq.poll();
        HuffmanNode right = pq.poll();
        HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
        parent.left = left;
        parent.right = right;
        pq.offer(parent);
    }

    HuffmanNode root = pq.poll();

    // Generate Huffman codes
    HashMap<Character, String> huffmanCodes = new HashMap<>();
    generateCodes(root, "", huffmanCodes);

    // Print the Huffman codes
    System.out.println("Huffman Codes:");
    for (int i = 0; i < characters.size(); i++) {
        System.out.println(characters.get(i) + ": " + huffmanCodes.get(characters.get(i)));
    }
}

private void generateCodes(HuffmanNode node, String code, HashMap<Character, String> huffmanCodes) {
    if (node.left == null && node.right == null) {
        huffmanCodes.put(node.character, code);
        return;
    }

    generateCodes(node.left, code + "0", huffmanCodes);
    generateCodes(node.right, code + "1", huffmanCodes);
}
}