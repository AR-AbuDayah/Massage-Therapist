
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validator {
    public static boolean isEmpty(JTextField field,String massage){
        if(field.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, massage);
            field.requestFocus();
            return true;
        }
        return false;
    }
    
    public static boolean isComboBoxSelected(JComboBox comboBox, String massage){
        if(comboBox.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, massage);
            comboBox.requestFocus();
            return true;
        }
        return false;
    }
    
   
    
    
    
}
