import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileOperationManager {

    private File copiedFile;

    public void createFolder(String path) {
        String folderName = JOptionPane.showInputDialog("Enter the name of the new folder:");
        File newFolder = new File(path, folderName);
        if (folderName != null && !folderName.isEmpty()) {
            if (newFolder.mkdir()) {
                JOptionPane.showMessageDialog(null, "Folder created successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Error creating folder.");
            }
        }
    }

    public void renameFile(String path) {
        String newName = JOptionPane.showInputDialog("Enter the new name:");
        File oldItem = new File(path);
        File newItem = new File(oldItem.getParent(), newName);
        if (newName != null && !newName.isEmpty()) {
            if (oldItem.renameTo(newItem)) {
                JOptionPane.showMessageDialog(null, "File renamed successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Error renaming folder.");
            }
        }
    }

    public void deleteFile(String path) {
        File itemToDelete = new File(path);
        int result = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete this folder?",
                "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            if (itemToDelete.isDirectory()) {
                deleteDirectory(itemToDelete);
            } else {
                itemToDelete.delete();
            }
            JOptionPane.showMessageDialog(null, "Folder deleted successfully.");
        }
    }

    public void copyFile(String path) {
        File sourceFile = new File(path);
        copiedFile = sourceFile;
    }

    public void pasteFile(String destinationPath) {
        if (copiedFile != null) {
            File destinationFolder = new File(destinationPath);
            if (destinationFolder.isDirectory()) {
                File destinationFile = new File(destinationFolder, copiedFile.getName());
                try {
                    Files.copy(copiedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(null, "File pasted successfully.");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error pasting file.");
                }
            }
        }
    }


    private void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        directory.delete();
    }
}
