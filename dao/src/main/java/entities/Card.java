package entities;

/**
 * Created by Егор on 03.04.17.
 */
public class Card {
    private int id;
    private String number;
    private String validThru;

    public Card(int id, String number, String validThru) {
        this.id = id;
        this.number = number;
        this.validThru = validThru;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getValidThru() {
        return validThru;
    }

    public void setValidThru(String validThru) {
        this.validThru = validThru;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        if (id != card.id) return false;
        if (!number.equals(card.number)) return false;
        return validThru.equals(card.validThru);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + number.hashCode();
        result = 31 * result + validThru.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", validThru='" + validThru + '\'' +
                '}';
    }
}
