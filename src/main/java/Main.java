import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static long mem() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory()- runtime.freeMemory();
    }


    public static void main(String[] args) {
        long before = mem();

        Display display = new Display();

        Shell shell = new Shell(display);

        RowLayout rowLayout = new RowLayout();
        rowLayout.marginLeft = 10;
        rowLayout.marginTop = 10;
        rowLayout.spacing = 40;
        shell.setLayout(new GridLayout(1, false));

        ArrayList<Group> groups = new ArrayList<>();

        AddItemToComboBox first = new AddItemToComboBox(display,shell);
        groups.add(first.getGroup());
        display.update();
        RenameButton second = new RenameButton(display,shell);
        groups.add(second.getGroup());
        display.update();
        RadioButtonCheck third = new RadioButtonCheck(display,shell);
        groups.add(third.getGroup());
        display.update();
        CheckBoxCheck foth = new CheckBoxCheck(display,shell);
        groups.add(foth.getGroup());
        display.update();
        FillingInTable fifth = new FillingInTable(display,shell);
        groups.add(fifth.getGroup());
        display.update();


        HotKey hotKey = new HotKey(display,shell, groups);/*
        CreateCheckBox individualTask = new CreateCheckBox(display, shell);
        display.update();*/


        shell.setSize(700,650);
        shell.open();
        while (!shell.isDisposed()) {
            if (display.readAndDispatch()) {
                display.sleep();
                
            }
        }
        display.dispose();


    }

}


/* StackLayout stackLayout = new StackLayout();
        parent.setLayout(stackLayout);




        Button b1 = new Button(parent, SWT.NONE);
        b1.setText("B1");

        Button b2 = new Button(parent, SWT.NONE);
        b2.setText("B2");

        Button button3 = new Button(parent, SWT.NONE);
        button3.setText("Button 3");
        stackLayout.topControl =  button3;*/
// Windows back to natural size.
// shell.pack();