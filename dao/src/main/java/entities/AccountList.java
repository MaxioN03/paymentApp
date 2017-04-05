package entities;

import java.util.List;

/**
 * Created by Егор on 03.04.17.
 */
public class AccountList {
    private List<Account> accountList;

    public AccountList() {
    }

    public AccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountList)) return false;

        AccountList that = (AccountList) o;

        return accountList != null ? accountList.equals(that.accountList) : that.accountList == null;
    }

    @Override
    public int hashCode() {
        return accountList != null ? accountList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AccountList{" +
                "accountList=" + accountList +
                '}';
    }
}
