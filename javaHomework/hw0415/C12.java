package javaHomework.hw0415;
import java.util.Scanner;
import algorithm.HashTable;     // 演算法作業寫的
import algorithm.Entry;         // 演算法作業寫的

public class C12
{
    public C12()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入商品的種類數量: ");
        int totalTypes = scanner.nextInt();
        HashTable<String, Integer> item = new HashTable<>();
        
        for (int i = 1; i <= totalTypes; i++)
        {
            System.out.print("請輸入第 " + i + " 種商品名稱: ");
            String name = scanner.next();
            System.out.print("請輸入第 " + i + " 種商品的價格: ");
            Integer price = scanner.nextInt();
            item.insert(name, price);
        }
        scanner.close();

        System.out.println("最暢銷的商品編號是: " + findBestItem(item));
        System.out.println("最冷門的商品編號是: " + findLowItem(item));

    }

    private String findBestItem(HashTable<String, Integer> item)
    {
        int max = Integer.MIN_VALUE;
        String bestItem = "";
        for (Entry<String, Integer> entry : item)
        {
            if (entry.getValue() > max)
            {
                max = entry.getValue();
                bestItem = entry.getKey();
            }
        }
        return bestItem;
    }

    private String findLowItem(HashTable<String, Integer> item)
    {
        int min = Integer.MAX_VALUE;
        String lowItem = "";
        for (Entry<String, Integer> entry : item)
        {
            if (entry.getValue() < min)
            {
                min = entry.getValue();
                lowItem = entry.getKey();
            }
        }
        return lowItem;
    }


    public static void main(String[] args)
    {
        new C12();
    }
}
