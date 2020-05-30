import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.*;

import java.util.Date;

public class AddItemToComboBox  {
    private Button button;
    private Label label;
    private Text text;
    private Label label_combo;
    private Combo combo;
    private String[] items;
    private Group group;

    public Group getGroup() {
        return group;
    }

    AddItemToComboBox(Display display, Shell shell){

         group = new Group(shell, SWT.NONE);
        group.setLayoutData(new GridData(SWT.HORIZONTAL, SWT.HORIZONTAL, true, true));
        group.setLayout(new GridLayout(2, true));
        group.setText("Group1");

        label = new Label(group, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        label.setText("Your Text: ");



        // Text
        text = new Text(group, SWT.BORDER);
        RowData layoutData = new RowData();
        layoutData.width = 150;


        text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        text.setText("");
        text.setLocation(20,20);


        button = new Button(group,SWT.NONE);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        button.setText("Add word");



        label_combo = new Label(group,SWT.NONE );

        label_combo.setText("Select word:");
        label_combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));


        // Create a dropdown Combo
        combo = new Combo(group, SWT.DROP_DOWN);
        combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));


        items = new String[] {};

        combo.setItems(items);
        final Label a = new Label(group, SWT.NONE);
        a.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        a.setText("");
        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                boolean check = false;
                for (int i = 0; i<combo.getItemCount();i++){
                    if (combo.getItem(i).equals(text.getText())){
                        check= true;
                    }
                }
                if (check){
                    MessageBox messageBox = new MessageBox(shell,SWT.CANCEL);
                    messageBox.setMessage("Error");
                    messageBox.setText("Something went wrong");
                    int response = messageBox.open();
                    display.update();


                }else {
                    combo.add(text.getText());
                    a.setText(text.getText());
                    a.pack();
                    display.update();
                }
            }

        });
    }


}
