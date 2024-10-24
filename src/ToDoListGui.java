package src;

import javax.swing.*;


public class ToDoListGui extends JFrame {
    public ToDoListGui(){
        super("To Do List src.App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(FrameConfigs.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
    }
}
