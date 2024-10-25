package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToDoListGui extends JFrame implements ActionListener {

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


        bannerLabel.setBounds(
                (ConstantConfigs.GUI_SIZE.width - bannerLabel.preferredSize().width)/2,
                15,
                ConstantConfigs.BANNER_SIZE.width,
                ConstantConfigs.BANNER_SIZE.height
        );

        taskPanel = new JPanel();

        taskComponentPanel = new JPanel();
        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel,BoxLayout.Y_AXIS));
        taskPanel.add(taskComponentPanel);

        //add scroll to the panel
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(8,70, ConstantConfigs.TASKPANEL_SIZE.width, ConstantConfigs.TASKPANEL_SIZE.height);
        scrollPane.setMaximumSize(ConstantConfigs.TASKPANEL_SIZE);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setBounds(
                -5,
                ConstantConfigs.GUI_SIZE.height- 88,
                ConstantConfigs.ADDTASK_BUTTON_SIZE.width,
                ConstantConfigs.ADDTASK_BUTTON_SIZE.height);

        addTaskButton.addActionListener(this);


        //add banner to the frame
        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(addTaskButton);






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equalsIgnoreCase("Add Task")){
            // create a task component
            TaskComponent taskComponent = new TaskComponent(taskComponentPanel);
            taskComponentPanel.add(taskComponent);

            // make the previous task appear disabled
            if(taskComponentPanel.getComponentCount() > 1){
                TaskComponent previousTask = (TaskComponent) taskComponentPanel.getComponent(
                        taskComponentPanel.getComponentCount() - 2);
                previousTask.getTaskField().setBackground(null);
            }

            // make the task field request focus after creation
            taskComponent.getTaskField().requestFocus();

            // Ensure panel updates after adding the task
            revalidate(); // Required for layout managers to refresh
            repaint();    // Ensure visual refresh of new component
        }
    }
}

