import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.List;

/**
 * Main GUI Application for MHT-CET Merit List Generator
 * Provides an interactive interface for uploading CSV files and processing student data
 */
public class MHTCETGuiApp extends JFrame {
    private JLabel statusLabel;
    private JButton uploadButton;
    private JButton processButton;
    private JButton clearButton;
    private JTextArea logArea;
    private JProgressBar progressBar;
    private File selectedFile;
    private List<Detail> studentList;
    private JPanel mainPanel;
    
    public MHTCETGuiApp() {
        setTitle("MHT-CET Merit List Generator");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Force button text rendering
        UIManager.put("Button.select", new Color(70, 130, 180));
        
        initializeComponents();
        setupLayout();
        
        setVisible(true);
    }
    
    private void initializeComponents() {
        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(41, 128, 185));
        headerPanel.setPreferredSize(new Dimension(900, 80));
        JLabel titleLabel = new JLabel("MHT-CET Merit List Generator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        
        // Main Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 40, 20, 40));
        
        // Upload Section
        JPanel uploadPanel = createUploadPanel();
        
        // Status Section
        JPanel statusPanel = createStatusPanel();
        
        // Log Section
        JPanel logPanel = createLogPanel();
        
        // Button Panel
        JPanel buttonPanel = createButtonPanel();
        
        // Add all sections to main panel
        mainPanel.add(uploadPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(statusPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(logPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(buttonPanel);
        
        // Add components to frame
        add(headerPanel, BorderLayout.NORTH);
        add(new JScrollPane(mainPanel), BorderLayout.CENTER);
    }
    
    private JPanel createUploadPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(52, 152, 219), 2),
            "Step 1: Upload CSV File",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 16),
            new Color(52, 152, 219)
        ));
        
        JLabel instructionLabel = new JLabel("<html><p style='margin:10px'>Upload a CSV file containing student details. " +
            "Make sure the CSV follows the required format.</p></html>");
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        
        uploadButton = new JButton("Choose CSV File");
        uploadButton.setFont(new Font("Arial", Font.BOLD, 14));
        uploadButton.setBackground(new Color(52, 152, 219));
        uploadButton.setForeground(Color.WHITE);
        uploadButton.setOpaque(true);
        uploadButton.setBorderPainted(false);
        uploadButton.setContentAreaFilled(true);
        uploadButton.setFocusPainted(false);
        uploadButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        uploadButton.addActionListener(e -> handleFileUpload());
        
        JButton templateButton = new JButton("Download Template");
        templateButton.setFont(new Font("Arial", Font.PLAIN, 12));
        templateButton.setBackground(new Color(46, 204, 113));
        templateButton.setForeground(Color.WHITE);
        templateButton.setOpaque(true);
        templateButton.setBorderPainted(false);
        templateButton.setContentAreaFilled(true);
        templateButton.setFocusPainted(false);
        templateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        templateButton.addActionListener(e -> downloadTemplate());
        
        JPanel buttonGroup = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonGroup.add(uploadButton);
        buttonGroup.add(templateButton);
        
        panel.add(instructionLabel, BorderLayout.NORTH);
        panel.add(buttonGroup, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createStatusPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(52, 152, 219), 2),
            "Status",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 16),
            new Color(52, 152, 219)
        ));
        
        statusLabel = new JLabel("No file selected");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        statusLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setVisible(false);
        
        panel.add(statusLabel, BorderLayout.NORTH);
        panel.add(progressBar, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createLogPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(52, 152, 219), 2),
            "Processing Log",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 16),
            new Color(52, 152, 219)
        ));
        
        logArea = new JTextArea(10, 50);
        logArea.setEditable(false);
        logArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        logArea.setBackground(new Color(245, 245, 245));
        logArea.setText("Ready to process student data...\n");
        
        JScrollPane scrollPane = new JScrollPane(logArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        processButton = new JButton("Process & Generate Merit List");
        processButton.setFont(new Font("Arial", Font.BOLD, 14));
        processButton.setBackground(new Color(46, 204, 113));
        processButton.setForeground(Color.WHITE);
        processButton.setOpaque(true);
        processButton.setBorderPainted(false);
        processButton.setContentAreaFilled(true);
        processButton.setFocusPainted(false);
        processButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        processButton.setEnabled(false);
        processButton.addActionListener(e -> processData());
        
        clearButton = new JButton("Clear & Reset");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 14));
        clearButton.setBackground(new Color(231, 76, 60));
        clearButton.setForeground(Color.WHITE);
        clearButton.setOpaque(true);
        clearButton.setBorderPainted(false);
        clearButton.setContentAreaFilled(true);
        clearButton.setFocusPainted(false);
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(e -> clearAll());
        
        panel.add(processButton);
        panel.add(clearButton);
        
        return panel;
    }
    
    private void setupLayout() {
        // Additional layout setup if needed
    }
    
    private void handleFileUpload() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Student Data CSV File");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".csv");
            }
            public String getDescription() {
                return "CSV Files (*.csv)";
            }
        });
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            statusLabel.setText("Selected: " + selectedFile.getName());
            statusLabel.setForeground(new Color(46, 204, 113));
            logArea.append("\n[INFO] File selected: " + selectedFile.getAbsolutePath() + "\n");
            processButton.setEnabled(true);
            
            // Validate CSV structure
            validateCSV();
        }
    }
    
    private void validateCSV() {
        logArea.append("[INFO] Validating CSV structure...\n");
        try {
            List<String> validationErrors = CSVParser.validateCSVStructure(selectedFile);
            if (validationErrors.isEmpty()) {
                logArea.append("[SUCCESS] CSV structure is valid!\n");
                statusLabel.setText("✓ Valid CSV - Ready to process: " + selectedFile.getName());
            } else {
                logArea.append("[WARNING] CSV validation warnings:\n");
                for (String error : validationErrors) {
                    logArea.append("  - " + error + "\n");
                }
            }
        } catch (Exception e) {
            logArea.append("[ERROR] Validation failed: " + e.getMessage() + "\n");
            statusLabel.setText("❌ Invalid CSV file");
            statusLabel.setForeground(new Color(231, 76, 60));
            processButton.setEnabled(false);
        }
    }
    
    private void processData() {
        if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, 
                "Please select a CSV file first!", 
                "No File Selected", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Disable buttons during processing
        processButton.setEnabled(false);
        uploadButton.setEnabled(false);
        progressBar.setVisible(true);
        progressBar.setValue(0);
        
        // Process in background thread
        SwingWorker<List<Detail>, String> worker = new SwingWorker<>() {
            @Override
            protected List<Detail> doInBackground() throws Exception {
                publish("[INFO] Starting data processing pipeline...\n");
                progressBar.setValue(10);
                
                // Step 1: Parse CSV
                publish("[STEP 1/5] Parsing CSV file...\n");
                studentList = CSVParser.parseCSV(selectedFile);
                publish("[SUCCESS] Parsed " + studentList.size() + " student records\n");
                progressBar.setValue(30);
                
                // Step 2: Validate Data
                publish("[STEP 2/5] Validating student data...\n");
                DataProcessor.validateStudentData(studentList);
                publish("[SUCCESS] Data validation complete\n");
                progressBar.setValue(50);
                
                // Step 3: Calculate Percentages and Totals
                publish("[STEP 3/5] Calculating percentages and totals...\n");
                DataProcessor.calculatePercentagesAndTotals(studentList);
                publish("[SUCCESS] Calculations complete\n");
                progressBar.setValue(70);
                
                // Step 4: Calculate Percentiles
                publish("[STEP 4/5] Calculating percentiles...\n");
                DataProcessor.calculatePercentiles(studentList);
                publish("[SUCCESS] Percentiles calculated\n");
                progressBar.setValue(85);
                
                // Step 5: Generate Rankings
                publish("[STEP 5/5] Generating merit list rankings...\n");
                DataProcessor.generateRankings(studentList);
                publish("[SUCCESS] Merit list generated successfully!\n");
                progressBar.setValue(100);
                
                return studentList;
            }
            
            @Override
            protected void process(List<String> chunks) {
                for (String message : chunks) {
                    logArea.append(message);
                }
                logArea.setCaretPosition(logArea.getDocument().getLength());
            }
            
            @Override
            protected void done() {
                try {
                    List<Detail> results = get();
                    statusLabel.setText("✓ Processing complete! " + results.size() + " students ranked.");
                    statusLabel.setForeground(new Color(46, 204, 113));
                    
                    // Show results
                    showResults(results);
                    
                } catch (Exception e) {
                    logArea.append("[ERROR] Processing failed: " + e.getMessage() + "\n");
                    statusLabel.setText("❌ Processing failed");
                    statusLabel.setForeground(new Color(231, 76, 60));
                    JOptionPane.showMessageDialog(MHTCETGuiApp.this, 
                        "Error processing data: " + e.getMessage(), 
                        "Processing Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
                
                // Re-enable buttons
                processButton.setEnabled(true);
                uploadButton.setEnabled(true);
                progressBar.setVisible(false);
            }
        };
        
        worker.execute();
    }
    
    private void showResults(List<Detail> students) {
        // Create and show result window
        ResultPanel resultPanel = new ResultPanel(students);
        resultPanel.setVisible(true);
        
        logArea.append("\n[INFO] Results displayed in new window\n");
        logArea.append("[INFO] You can export the results from the result window\n");
    }
    
    private void clearAll() {
        selectedFile = null;
        studentList = null;
        statusLabel.setText("No file selected");
        statusLabel.setForeground(Color.BLACK);
        logArea.setText("Ready to process student data...\n");
        processButton.setEnabled(false);
        progressBar.setValue(0);
        progressBar.setVisible(false);
    }
    
    private void downloadTemplate() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save CSV Template");
        fileChooser.setSelectedFile(new File("student_data_template.csv"));
        
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File templateFile = fileChooser.getSelectedFile();
            try {
                CSVParser.createTemplate(templateFile);
                logArea.append("[SUCCESS] Template downloaded: " + templateFile.getAbsolutePath() + "\n");
                JOptionPane.showMessageDialog(this, 
                    "Template saved successfully!\n" + templateFile.getAbsolutePath(), 
                    "Template Saved", 
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                logArea.append("[ERROR] Failed to create template: " + e.getMessage() + "\n");
                JOptionPane.showMessageDialog(this, 
                    "Error creating template: " + e.getMessage(), 
                    "Template Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void main(String[] args) {
        // Set look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create and show GUI
        SwingUtilities.invokeLater(() -> new MHTCETGuiApp());
    }
}
