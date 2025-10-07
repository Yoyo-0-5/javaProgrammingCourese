package javaHomework.hw0318;

public class C6 {
    public static void c6()
    {
        Client[] client = new Client[]{
            new Client(1),
            new Client(2),
            new Client(3),
            new Client(4),
            new Client(5),
            new Client(6),
            new Client(7),
            new Client(8),
            new Client(9),
            new Client(10)
        };

        for (int i = 1; i <= client.length; i++) {
            System.out.println("Client " + i + " cost: " + client[i - 1].getCost());
        }
    }
    
    private static class Client {
        private int timers;
        private int cost;

        public Client(int timers) {
            this.timers = timers;
        }

        public int getCost() {
            cost = timers * 3 + (timers == 1 ? 2 : 4);
            if (timers >= 5){
                cost = (int)((double)cost * 0.9);
            }
            return cost;
        }
    }

    public static void main(String[] args) {
        c6();
    }
}
