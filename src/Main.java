import BlockChain_fundementals.Blockchain;

public class Main {
    public static void main(String[] args) {

        Blockchain b  = Blockchain.getInstance();

        String[] s={"Satoshi", "Mike"};
        String[] r= {"Moeez", "Umer"};
        int[] a= {1000000, 999999};
        b.addBlock(s,r,a);
        b.addBlock(r,s, new int[]{120, 500});
        b=Blockchain.getInstance();
        b.printBlockchain();
    }
}