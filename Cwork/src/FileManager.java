import javax.swing.*;
import java.awt.*;
import java.io.File;
public class FileManager extends JFrame {

    private JFileChooser fileChooser;
    private JTextField filePathTextField;
    private JButton browseButton, createButton, renameButton, deleteButton, editButton;
    private FileOperationManager fileOperationManager;

    public FileManager() {
        setTitle("File Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 120);
        setLayout(new FlowLayout());

        filePathTextField = new JTextField(30);
        browseButton = new JButton("Browse");
        createButton = new JButton("Create");
        renameButton = new JButton("Rename");
        deleteButton = new JButton("Delete");
        editButton = new JButton("Edit");

        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        fileOperationManager = new FileOperationManager();

        browseButton.addActionListener(e -> {
            int result = fileChooser.showOpenDialog(FileManager.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                filePathTextField.setText(selectedFile.getAbsolutePath());
            }
        });

        createButton.addActionListener(e -> fileOperationManager.createFolder(filePathTextField.getText()));

        renameButton.addActionListener(e -> fileOperationManager.renameFile(filePathTextField.getText()));

        deleteButton.addActionListener(e -> fileOperationManager.deleteFile(filePathTextField.getText()));

        editButton.addActionListener(e -> showEditDialog());

        add(filePathTextField);
        add(browseButton);
        add(createButton);
        add(renameButton);
        add(deleteButton);
        add(editButton);
    }

    private void showEditDialog() {
        JPopupMenu editMenu = new JPopupMenu();
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");

        copyMenuItem.addActionListener(e -> fileOperationManager.copyFile(filePathTextField.getText()));

        pasteMenuItem.addActionListener(e -> fileOperationManager.pasteFile(filePathTextField.getText()));

        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        editMenu.show(editButton, 0, editButton.getHeight());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FileManager().setVisible(true));
    }
}