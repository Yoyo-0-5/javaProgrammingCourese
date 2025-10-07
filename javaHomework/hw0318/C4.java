package javaHomework.hw0318;

public class C4 {
    public static void c4()
    {
        ShoppingCart c1 = new ShoppingCart();
        c1.putInCart(1);
        c1.putInCart(2);
        c1.putInCart(4);
        System.out.println("Total: " + c1.getTotal());
    }

    private static class ShoppingCart {
        private final int prosuctList[] = {10, 20, 30, 40, 50};
        private int shoppingList[] = new int[99];
        private int shoppingIndex = 0;
        private int total = 0;
        
        public void putInCart(int productIndex) {
            shoppingList[shoppingIndex] = productIndex;
            shoppingIndex++;
        }
        
        public int getTotal() {
            for (int i = 0; i < shoppingIndex; i++) {
                total += prosuctList[shoppingList[i]];
            }
            if (total >= 80) {
                total = (int)((double)total * 0.8);
            }
            return total;
        }
    }
    
    public static void main(String[] args) {
        c4();
    }
}
