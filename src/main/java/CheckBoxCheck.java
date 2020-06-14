import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class CheckBoxCheck {
    private Button button;
    private Label label;
    private Text text;
    private Group group;

    public Group getGroup() {
        return group;
    }

    CheckBoxCheck(Display display, Shell shell){

         group = new Group(shell, SWT.NONE);
        group.setLayoutData(new GridData(SWT.HORIZONTAL, SWT.HORIZONTAL, true, true));
        group.setLayout(new GridLayout(2, true));
        group.setText("Group4");

        label = new Label(group, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        label.setText("Your Text: ");

        // Text
        text = new Text(group, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        text.setText("");

        button = new Button(group,SWT.NONE);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        button.setText("Enter: ");

        Group chezkButtonGroup = new Group(group, SWT.NONE);
        chezkButtonGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        chezkButtonGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
        chezkButtonGroup.setText("Chose");

        Button checkButton1 = new Button(chezkButtonGroup, SWT.CHECK);
        checkButton1.setText("First");

        Button checkButton2 = new Button(chezkButtonGroup, SWT.CHECK);
        checkButton2.setText("Second");

        Button checkButton3 = new Button(chezkButtonGroup, SWT.CHECK);
        checkButton3.setText("Third");




        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                if(text.getText().equals(checkButton1.getText())){
                    if(checkButton1.getSelection()){
                        checkButton1.setSelection(false);
                        display.update();
                    }else{
                        checkButton1.setSelection(true);
                        display.update();
                    }

                }else{
                    if(text.getText().equals(checkButton2.getText())){
                        if(checkButton2.getSelection()){
                            checkButton2.setSelection(false);
                            display.update();
                        }else{
                            checkButton2.setSelection(true);
                            display.update();
                        }

                    }else{
                        if(text.getText().equals(checkButton3.getText())){

                            if(checkButton3.getSelection()){
                                checkButton3.setSelection(false);
                                display.update();
                            }else{
                                checkButton3.setSelection(true);
                                display.update();
                            }
                        }else{
                            MessageBox messageBox = new MessageBox(shell,SWT.CANCEL);
                            messageBox.setMessage("Error");
                            messageBox.setText("Something went wrong");
                            int response = messageBox.open();
                            display.update();
                        }
                    }}

            }

        });
    }
}
