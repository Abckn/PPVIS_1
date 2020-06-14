import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.*;

public class RenameButton {
    private Button button1;
    private Button button2;
    private Text text;

    private Group group;

    public Group getGroup() {
        return group;
    }

    RenameButton(Display dysplay, Shell shell){

         group = new Group(shell, SWT.NONE);
        group.setLayoutData(new GridData(SWT.HORIZONTAL, SWT.HORIZONTAL, true, true));
        group.setLayout(new GridLayout(2, true));
        group.setText("Group2");

        button1 = new Button(group,SWT.NONE);
        button1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        button1.setText("Set Name");

        button2 = new Button(group,SWT.NONE);
        button2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        button2.setText("Swap");


        text = new Text(group, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        text.setText("");

/* Scale scale = new Scale(shell, SWT.HORIZONTAL);

        scale.setMaximum(400);
        scale.setMinimum(0);
        scale.setIncrement(1);
        scale.setPageIncrement(5);*/


        button1.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                button2.setText(text.getText());

            }

        });

        button2.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                String temp = new String();
                temp = button1.getText();
                button1.setText(button2.getText());
                button2.setText(temp);
                dysplay.update();
            }

        });

      /*  scale.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                int value = scale.getMaximum() - scale.getSelection() + scale.getMinimum();
                RowData layoutData1 = new RowData();
                layoutData1.width = value;
                text.setLayoutData(layoutData1);
                shell.layout();
                dysplay.update();

            }
        });*/
    }
}
