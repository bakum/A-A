package ua.bakum.aa.view.beans;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import ua.bakum.aa.view.inform.Statistics;

public class InformBean {
    private RichTable table;

    public InformBean() {
    }

    public void setTable(RichTable table) {
        this.table = table;
    }

    public RichTable getTable() {
        return table;
    }
    
    public void refresh() {
        /* BindingContainer bd = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding oper = bd.getOperationBinding("findAllInform");
        if (oper != null) {
            oper.execute();
        } */
        Statistics.findAllInform();
        AdfFacesContext.getCurrentInstance().addPartialTarget(getTable());
    }

    public void onValueChange(ValueChangeEvent valueChangeEvent) {
        AdfFacesContext.getCurrentInstance().addPartialTarget(getTable());
    }

    public void onRefresh(ActionEvent actionEvent) {
        refresh();
    }

    public void onClear(ActionEvent actionEvent) {
        /* BindingContainer bd = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding oper = bd.getOperationBinding("clearBase");
        if (oper != null) {
            oper.execute();
        } */
        Statistics.clearBase();
        refresh();
        //Statistics.findAllInform();
        //AdfFacesContext.getCurrentInstance().addPartialTarget(getTable());
    }
}
