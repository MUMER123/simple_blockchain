package BlockChain_fundementals;


public class block {
    private  Long blockHash;
    private  Long previousHash;
    private  String[] transactions;

    public Long getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(Long blockHash) {
        this.blockHash = blockHash;
    }

    public Long getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(Long previousHash) {
        this.previousHash = previousHash;
    }

    public String[] getTransactions() {
        return transactions;
    }

    public void setTransactions(String[] transactions) {
        this.transactions = transactions;
    }

    public block(Long previousHash, String[] transactions) {
        this.previousHash = previousHash;
        this.transactions = transactions;

        Object[] arr={transactions,previousHash};
        this.blockHash = (long) arr.hashCode();
    }

}
