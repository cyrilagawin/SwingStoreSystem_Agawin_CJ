public class StoreData {
    // Parallel arrays for inventory
    public String[] products = {"Rice", "Sugar", "Coffee", "Milk"};
    public double[] prices = {50.0, 30.0, 150.0, 80.0};
    public int[] stock = {20, 20, 20, 20};

    // Fixed size arrays for transaction logs
    public final int MAX_TRANSACTIONS = 100;
    public String[] logProducts = new String[MAX_TRANSACTIONS];
    public int[] logQuantities = new int[MAX_TRANSACTIONS];
    public double[] logTotals = new double[MAX_TRANSACTIONS];
    
    // Keeps track of how many purchases have been made
    public int transactionCount = 0;

    // The method that processes a purchase
    public boolean processTransaction(int productIndex, int quantity) {
        // Check if there is enough stock
        if (stock[productIndex] >= quantity) {
            // Deduct the stock
            stock[productIndex] -= quantity;
            
            // Calculate the total price
            double totalCost = prices[productIndex] * quantity;
            
            // Save the details to our log arrays
            if (transactionCount < MAX_TRANSACTIONS) {
                logProducts[transactionCount] = products[productIndex];
                logQuantities[transactionCount] = quantity;
                logTotals[transactionCount] = totalCost;
                transactionCount++; 
            }
            return true; // Purchase was successful
        }
        return false; // Purchase failed (not enough stock)
    }
}