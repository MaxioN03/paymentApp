package entities;

/**
 * Created by Егор on 03.04.17.
 */
public class Account {
    private int id;
    private int cardId;
    private int userId;
    private int blockStatus;
    private int sum;

    public Account(int id, int cardId, int userId, int blockStatus, int sum) {
        this.id = id;
        this.cardId = cardId;
        this.userId = userId;
        this.blockStatus = blockStatus;
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(int blockStatus) {
        this.blockStatus = blockStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (cardId != account.cardId) return false;
        if (userId != account.userId) return false;
        return blockStatus == account.blockStatus;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cardId;
        result = 31 * result + userId;
        result = 31 * result + (int) blockStatus;
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", cardId=" + cardId +
                ", userId=" + userId +
                ", blockStatus=" + blockStatus +
                ", sum=" + sum +
                '}';
    }
}
