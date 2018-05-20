package entidades;

import enums.HotelEnum;

import java.util.Objects;

public class TotalHotel {

    private Long total;
    private HotelEnum hotel;

    public TotalHotel(Long total, HotelEnum hotel) {
        this.total = total;
        this.hotel = hotel;
    }

    public Long getTotal() {
        return total;
    }

    public HotelEnum getHotel() {
        return hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalHotel that = (TotalHotel) o;
        return Objects.equals(total, that.total) &&
                hotel == that.hotel;
    }

    @Override
    public int hashCode() {

        return Objects.hash(total, hotel);
    }

    @Override
    public String toString() {
        return "entidades.TotalHotel{" +
                "total=" + total +
                ", core=" + hotel +
                '}';
    }
}
