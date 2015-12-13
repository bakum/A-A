package ua.bakum.aa.view.inform;

import java.math.BigDecimal;

public class Inform {
    private String Name;
    private BigDecimal Value;
    private BigDecimal price;
    private BigDecimal VarZatr;
    private BigDecimal ConstZatr;
    private BigDecimal Viruch;
    private BigDecimal Marga;
    private BigDecimal profit;
    private BigDecimal oper;

    public Inform(String Name, BigDecimal Value, BigDecimal Viruch, BigDecimal VarZatr, BigDecimal ConstZatr) {
        this.Name = Name;
        this.Value = Value;
        this.Viruch = Viruch;
        this.price = Viruch.divide(Value, 2, BigDecimal.ROUND_HALF_UP);
        this.VarZatr = VarZatr;
        this.ConstZatr = ConstZatr;
        this.Marga = Viruch.subtract(VarZatr);
        this.profit = this.Marga.subtract(ConstZatr);
        this.oper = this.Marga.divide(this.profit, 2, BigDecimal.ROUND_HALF_UP);
    }

    public final BigDecimal getOper() {
        return oper;
    }

    public final BigDecimal getProfit() {
        return profit;
    }

    public final BigDecimal getMarga() {
        return Marga;
    }

    public final void setViruch(BigDecimal Viruch) {
        this.Viruch = Viruch;
        recalcAll();
    }

    public final BigDecimal getViruch() {
        return Viruch;
    }

    public final void setPrice(BigDecimal price) {
        this.price = price;
        recalcAll();
    }

    public final BigDecimal getPrice() {
        return price;
    }

    public final void setName(String Name) {
        this.Name = Name;
    }

    public final String getName() {
        return Name;
    }

    public final void setValue(BigDecimal Value) {
        this.Value = Value;
        recalcAll();
    }

    public final BigDecimal getValue() {
        return Value;
    }

    public final void setVarZatr(BigDecimal VarZatr) {
        this.VarZatr = VarZatr;
        recalcAll();
    }

    public final BigDecimal getVarZatr() {
        return VarZatr;
    }

    public final void setConstZatr(BigDecimal ConstZatr) {
        this.ConstZatr = ConstZatr;
        recalcAll();
    }

    public final BigDecimal getConstZatr() {
        return ConstZatr;
    }

    private final void recalcAll() {
        this.price = Viruch.divide(Value, 2, BigDecimal.ROUND_HALF_UP);
        this.Marga = Viruch.subtract(VarZatr);
        this.profit = this.Marga.subtract(ConstZatr);
        this.oper = this.Marga.divide(this.profit, 2, BigDecimal.ROUND_HALF_UP);
    }

}
