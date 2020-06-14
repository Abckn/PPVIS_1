import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.util.concurrent.atomic.AtomicInteger;

public class FillingInTable {
    private Button button;
    private Button button2;
    private Button button3;
    private Label label;
    private Text text;
    private Table table;
    private Group group;

    public Group getGroup() {
        return group;
    }

    FillingInTable(Display display , Shell shell){

         group = new Group(shell, SWT.NONE);
        group.setLayoutData(new GridData(SWT.HORIZONTAL, SWT.HORIZONTAL, true, true));
        group.setLayout(new GridLayout(2, true));
        group.setText("Group5");

        label = new Label(group, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        label.setText("Your Text: ");

        // Text
        text = new Text(group, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        text.setText("");

        button = new Button(group,SWT.NONE);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        button.setText("Enter");

        button2 = new Button(group,SWT.NONE);
        button2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        button2.setText("SecondCol");

        button3 = new Button(group,SWT.NONE);
        button3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        button3.setText("FirstCol");

        table = new Table(group, SWT.NONE | SWT.BORDER);
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        table.setHeaderVisible(true);
        String[] titles = { "Col 1", "Col 2"};

        for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
            TableColumn column = new TableColumn(table, SWT.NULL);
            column.setText(titles[loopIndex]);
        }


        for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
            table.getColumn(loopIndex).pack();
        }

        table.setBounds(50, 50, 230, 200);
        TableItem item = new TableItem(table, SWT.NULL);





        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                item.setText(0,text.getText());
                display.update();

            }

        });
        button2.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                if(table.getItem(0).getText() == ""){

                }else {
                    String str = table.getItem(0).getText();
                    table.getItem(0).setText(new String[]{"", str});
                }
                display.update();

            }

        });
        button3.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                if(table.getItem(0).getText(1) == ""){

                }else {
                    String str = table.getItem(0).getText(1);

                    table.getItem(0).setText(new String[]{str, ""});
                }
                display.update();
            }

        });
    }
}
