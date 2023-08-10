package BlockChain_fundementals;

import java.util.HashMap;


public class Blockchain {
    private static Blockchain instance = new Blockchain();
    private block recentBlock;
    private HashMap<Long, block> storage = new HashMap<Long, block>();

    private Blockchain() {
        String[] transaction = new String[]{"This is genesis block .So,there is no transaction in it."};
        this.recentBlock = new block(0l, transaction);
        storage.put(recentBlock.getBlockHash(), recentBlock);
    }
    static public Blockchain getInstance(){

        if(instance==null){
            instance = new Blockchain();
        }
        return instance;
    }

    private String[] createTransaction(String[] sender, String[] receiver, int[] amount) {
        String[] transactions = new String[sender.length];
        for (int i = 0; i < sender.length; i++) {
            transactions[i] = sender[i] + " send " + receiver[i] +
                    " " + amount[i] + " BITCOIN";
        }
        return transactions;
    }
    public boolean addBlock(String[] sender, String[] receiver, int[] amount) {
        if ((sender.length == receiver.length) && (receiver.length == amount.length)) {
            String[] transactions = createTransaction(sender, receiver, amount);
            block newBlock = new block(recentBlock.getBlockHash(), transactions);
            storage.put(newBlock.getBlockHash(), newBlock);
            recentBlock = newBlock;
            return true;
        } else {
            System.out.println("size of senders ,receivers & amount are not same");
            return false;
        }
    }
    private void printBlock(block current){
        System.out.println("\t\t-----------------------------");
        System.out.println("This block have "+
                current.getTransactions().length+" number of transactions");
        System.out.println("Block Hash is "+current.getBlockHash());
        System.out.println("Previous Block Hash is "+current.getPreviousHash());
        System.out.println("Transactions are as follow");
        String[] transactions=current.getTransactions();
        for (int i=0;i<transactions.length;i++){
            System.out.println("Transaction no. "+(i+1)+ " : "+transactions[i]);
        }
        System.out.println("\t\t-----------------------------");
    }
    public void printBlockchain(){
        block temp=recentBlock;
        while(true){
            printBlock(temp);
            if(temp.getPreviousHash()==0)
                break;
            temp=storage.get(temp.getPreviousHash());
        }
    }
}


