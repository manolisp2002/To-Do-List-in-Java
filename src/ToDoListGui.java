package src;

import javax.swing.*;


public class ToDoListGui extends JFrame {

    //taskPanel and taskComponentPanel will have the same behavior
    private JPanel taskPanel, taskComponentPanel;



    public ToDoListGui(){
        super("To Do List App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(ConstantConfigs.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addGuiComponents();
    }
    private void addGuiComponents(){
        //banner text on the top
        JLabel bannerLabel = new JLabel("To Do List");

        bannerLabel.setFont(ConstantConfigs.BANNER_FONT);
        bannerLabel.setBounds(
                (ConstantConfigs.GUI_SIZE.width - bannerLabel.preferredSize().width)/2,
                15,
                ConstantConfigs.BANNER_SIZE.width,
                ConstantConfigs.BANNER_SIZE.height
        );

        taskPanel = new JPanel();
        taskComponentPanel = new JPanel();
        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel,BoxLayout.Y_AXIS));

        //add scroll to the panel
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(8,70, ConstantConfigs.TASKPANEL_SIZE.width, ConstantConfigs.TASKPANEL_SIZE.height);
        scrollPane.setMaximumSize(ConstantConfigs.TASKPANEL_SIZE);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setBounds(
                -5,
                ConstantConfigs.GUI_SIZE.height- 88,
                ConstantConfigs.ADDTASKBUTTON_SIZE.width,
                ConstantConfigs.ADDTASKBUTTON_SIZE.height);




        //add banner to the frame
        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(addTaskButton);




    }
}

