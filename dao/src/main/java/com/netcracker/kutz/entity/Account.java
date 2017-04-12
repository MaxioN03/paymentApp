package com.netcracker.kutz.entity;

import com.netcracker.kutz.enums.BlockStatus;

/**
 * Created by Егор on 07.04.17.
 */
public class Account {
    private int id;
    private int user_id;
    private int card_id;
    private int sum;
    private BlockStatus blockStatus;

    public Account() {
    }

    public Account(int user_id, int card_id, int sum, BlockStatus blockStatus) {
        this.user_id = user_id;
        this.card_id = card_id;
        this.sum = sum;
        this.blockStatus = blockStatus;
    }

    public Account(int id, int user_id, int card_id, int sum, BlockStatus blockStatus) {
        this.id = id;
        this.user_id = user_id;
        this.card_id = card_id;
        this.sum = sum;
        this.blockStatus = blockStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public BlockStatus getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(BlockStatus blockStatus) {
        this.blockStatus = blockStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (user_id != account.user_id) return false;
        if (card_id != account.card_id) return false;
        if (sum != account.sum) return false;
        return blockStatus == account.blockStatus;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user_id;
        result = 31 * result + card_id;
        result = 31 * result + sum;
        result = 31 * result + blockStatus.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id=").append(id);
        sb.append(", user_id=").append(user_id);
        sb.append(", card_id=").append(card_id);
        sb.append(", sum=").append(sum);
        sb.append(", blockStatus=").append(blockStatus);
        sb.append('}');
        return sb.toString();
    }
}
